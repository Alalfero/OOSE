import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;

public interface Poly {

	abstract class PaintBoard extends JPanel {
		int width;
		int height;

		PaintBoard(int width, int height) {
			this.width = width;
			this.height = height;
		}

		abstract void paintWith(Graphics2D g);

		public void showMe() {
			var f = new JFrame();
			f.add(this);
			f.setResizable(false);
			f.pack();
			f.setVisible(true);
		}

		public void saveToPNG(String fileName) {
			var img
					= new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			var g2d = img.createGraphics();
			g2d.setColor(Color.WHITE);
			g2d.fillRect(0, 0, width, height);
			paintComponent(g2d);
			g2d.dispose();
			var file = new File(fileName);
			try {
				ImageIO.write(img, "png", file);
			} catch (Exception e) {
			}
		}

		@Override
		public Dimension getPreferredSize() {
			return new Dimension(width, height);
		}

		@Override
		protected void paintComponent(Graphics g) {
			setBackground(Color.WHITE);
			super.paintComponent(g);
			paintWith((Graphics2D) g);
		}
	}

	class PaintABit extends PaintBoard {

		PaintABit() {
			super(400, 400);
		}

		@Override
		void paintWith(Graphics2D g) {
			g.setColor(Color.RED);
			g.fillOval(100, 100, 50, 60);
			g.setColor(Color.BLUE);
			g.fillOval(200, 150, 70, 30);
			g.setColor(Color.GREEN);
			g.drawLine(0, 0, width, height / 2);
			g.setColor(Color.BLACK);
			g.setFont(new Font("Helvetica", Font.BOLD, 25));
			g.drawString("Hello World!", 100, 300);
		}
	}

	class PaintMe extends PaintBoard {

		PaintMe() {
			super(400, 400);
		}

		@Override
		void paintWith(Graphics2D g) {
			g.setColor(Color.lightGray);
			g.fillOval(80, 100, 50, 60);
			g.setColor(Color.pink);
			g.fillOval(150, 200, 70, 30);
			g.setColor(Color.lightGray);
			g.fillOval(250, 100, 50, 60);
			g.setColor(Color.BLACK);
			g.setFont(new Font("SansSerif", Font.BOLD, 25));
			g.drawString("Hi Manu :D - Albina", 80, 300);
		}
	}

	record Monom(double b, int e) {

		@Override
		public String toString() {
			return e < 0 ? b + "x^" + 0 : b + "x^" + e;
		}

		double eval(double x) {
			return e >= 0 ? b * Math.pow(x, e) : 0;
		}

		Monom derivation() {
			return e < 0 ? new Monom(0, 0) : new Monom(b * e, e - 1);
		}

	}

	record Polynom(Monom... ms) {
		@Override
		public String toString() {
			String result = ms[0].toString();

			for (int i = 1; i < ms.length; i++) result += " + " + ms[i];

			return "f(x)= " + result;
		}

		@Override
		public boolean equals(Object o) {
			if (o instanceof Polynom poly) return this.toString().equals(poly.toString());
			else return false;
		}

		double eval(double x) {
			double res = 0.0;
			for (Monom m : ms) res += m.eval(x);

			return res;
		}

		Polynom derivation() {
			Monom[] monoms = new Monom[ms.length];
			for (int i = 0; i < ms.length; i++) monoms[i] = ms[i].derivation();

			return new Polynom(monoms);
		}

	}

	class PolyBoard extends PaintBoard {

		Polynom poly;
		double minX;
		double maxX;
		double minY;
		double maxY;

		double xRes;
		double yRes;

		PolyBoard(int width, int height
				, double minX, double maxX, double minY, double maxY
				, Polynom poly) {
			super(width, height);
			this.minX = minX;
			this.maxX = maxX;
			this.minY = minY;
			this.maxY = maxY;
			this.poly = poly;
			this.xRes = (maxX - minX) / width;
			this.yRes = (maxY - minY) / height;

		}

		double pxToX(int px) {
			return minX + (px * xRes);
		}

		double pxToY(int py) {
			return minY + (py * yRes);
		}

		int yToPx(double y) {
			return (int) ((maxY - y) / yRes);
		}

		int xToPx(double x) {
			return (int) ((x - minX) / xRes);
		}

		void drawLinesY(Graphics2D g, int x, int y, long text) {
			g.drawLine(x - 5, y, x + 5, y);
			g.drawString("" + text, x + 10, y + 5);
		}

		void drawLinesX(Graphics2D g, int x, int y, long text) {
			g.drawLine(x, y - 5, x, y + 5);
			g.drawString("" + text, x - 10, y + 15);
		}

		@Override
		void paintWith(Graphics2D g) {
			g.setColor(Color.black);
			paintCoordinates(g);
			g.setColor(Color.BLUE);
			paintGraph(poly, g);
			g.drawString(String.valueOf(poly), 10, 10);
			var poly1 = poly.derivation();
			g.setColor(Color.RED);
			g.drawString(String.valueOf(poly1), 10, 30);
			paintGraph(poly1, g);
			var poly2 = poly1.derivation();
			g.setColor(Color.GREEN);
			g.drawString(String.valueOf(poly2), 10, 50);
			paintGraph(poly2, g);
		}

		void paintCoordinates(Graphics2D g) {
			g.drawLine(xToPx(minX), yToPx(0), xToPx(maxX), yToPx(0));
			g.drawLine(xToPx(0), yToPx(minY), xToPx(0), yToPx(maxY));

			for (int j = yToPx(0); j > yToPx(maxY); j -= 20) {
				drawLinesY(g, xToPx(0), j, Math.round(-pxToY(j)));
			}

			for (int j = yToPx(0); j < yToPx(minY); j += 20) {
				drawLinesY(g, xToPx(0), j, Math.round(-pxToY(j)));
			}

			for (int i = xToPx(0); i < xToPx(maxX); i += 20) {
				drawLinesX(g, i, yToPx(0), Math.round(pxToX(i)));
			}

			for (int i = xToPx(0); i > xToPx(minX); i -= 20) {
				drawLinesX(g, i, yToPx(0), Math.round(pxToX(i)));
			}
		}

		void paintGraph(Polynom p, Graphics2D g) {
			for (int i = xToPx(minX); i < xToPx(maxX); i++) {
				g.drawLine(i, yToPx(p.eval(pxToX(i))), i + 1, yToPx(p.eval(pxToX(i + 1))));
			}
		}

	}

}