public final class SimpleArrayFuns {

	static boolean contains(int[] xs, int y) {
		for (int x : xs) {
			if (x == y) return true;
		}
		return false;
	}

	static long sum(int[] xs) {
		long sum = 0;
		for (int x : xs) {
			sum = sum + x;
		}
		return sum;
	}

	static int avg(int[] xs) {
		return xs.length != 0 ? (int) (sum(xs) / xs.length) : 0;
	}

	static boolean isSorted(int[] xs) {
		for (int x : xs) {
			if (x > x + 1) return false;
		}
		return true;
	}

	static int max(int[] xs) {
		int maxValue = Integer.MIN_VALUE;
		for (int x : xs) {
			if (x > maxValue) maxValue = x;
		}
		return xs.length > 0 ? maxValue : Integer.MIN_VALUE;
	}
}