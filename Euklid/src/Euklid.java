class Euklid {
	public static long gcd(long a, long b) {
		if (a == 0) return b;
		long h;
		while (b != 0) {
			h = a % b;
			a = b;
			b = h;
		}
		return a < 0 ? a * (-1) : a;
	}
}