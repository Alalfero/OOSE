class Endrek2It {
	int fib(int n) {
		return fib(0, 1, n);
	}

	static int fib(int n0, int n1, int n) {
		return n == 0 ? n0 : fib(n1, n0 + n1, n - 1);
	}

	static int fibIt(int n0, int n1, int n) {
		int fi = 0;
		if (n == 0) return n0;
		while (n != 0) {
			fi = n1 + n0;
			n0 = n1;
			n1 = fi;
			n--;
		}
		return n0;
	}
}