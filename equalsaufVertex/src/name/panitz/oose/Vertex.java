package name.panitz.oose;

public class Vertex {
	double x;
	double y;

	public Vertex(double x, double y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Vertex vert)) return false;
		return Math.abs(vert.x - this.x) <= 1.0 && Math.abs(vert.y - this.y) <= 1.0;
	}
}