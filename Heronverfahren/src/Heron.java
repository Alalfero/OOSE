class Heron {
	static double sqrt(double x) {
		assert x >= 0;
		return sqrt(x, (x + 1) / 2);
	}

	static double sqrt(double x, double approx) {
		for (int i = 0; i < 10; i++) {
			approx = (approx + x / approx) / 2;
		}
		return approx;
	}
}