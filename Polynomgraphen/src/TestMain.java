public class TestMain {
	public static void main(String[] args) {
		var m1 = new Poly.Monom(4, 2);
		var m2 = new Poly.Monom(-1, 2);
		var m3 = new Poly.Monom(1, 0);
		var p = new Poly.Polynom(m1);
		var p1 = new Poly.Polynom(m1, m2);
		var p2 = new Poly.Polynom(m2, m1, m3);

		var bild = new Poly.PaintMe();
		var bild1 = new Poly.PolyBoard(400, 400, -10, 10, -10, 10, p2);
		bild1.saveToPNG("graph4.png");
	}
}