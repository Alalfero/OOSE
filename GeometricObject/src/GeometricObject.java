class GeometricObject {
	Vertex corner;
	double width;
	double height;
	Vertex velocity;

	GeometricObject(Vertex corner, double width, double height, Vertex velocity) {
		this.corner = corner;
		this.width = width;
		this.height = height;
		this.velocity = velocity;
	}

	public String toString() {
		return "Höhe " + height + " Breite " + width + " Ursprung " + corner + " Geschwindigkeit " + velocity;
	}

	public double size() {
		return this.height * this.width;
	}

	public boolean isLargerThan(GeometricObject that) {
		return this.size() > that.size();
	}

	public boolean isAbove(GeometricObject that) {
		return that.corner.y > this.corner.y + this.height;
	}

	public boolean isUnderneath(GeometricObject that) {
		return that.corner.y + that.height < this.corner.y;
	}

	public boolean isLeftOf(GeometricObject that) {
		return this.corner.x + this.width < that.corner.x;
	}

	public boolean isRightOf(GeometricObject that) {
		return that.corner.x + that.width < this.corner.x;
	}

	public boolean touches(GeometricObject that) {
		return !(isAbove(that) || isUnderneath(that) || isLeftOf(that) || isRightOf(that));
	}


}