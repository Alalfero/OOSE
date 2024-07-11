public final class MoreSimpleArrayFuns {


	static int firstIndex(int[] xs, int y) {
		for (int i = 0; i < xs.length; i++) {
			if (xs[i] == y) return i;
		}
		return -1;

	}

	static boolean startsWith(int[] prefix, int[] xs) {
		if (prefix.length == 0) return true;
		else if (xs.length == 0) return false;
		for (int i = 0; i < prefix.length; i++) {
			if (prefix[i] != xs[i]) return false;
		}
		return true;
	}

	static void replace(int[] xs, int oldI, int newI) {
		for (int i = 0; i < xs.length; i++) {
			if (xs[i] == oldI) xs[i] = newI;
		}
	}

	static void reverse(int[] xs) {
		int temp[] = new int[xs.length];
		for (int i = 0; i < xs.length; i++) {
			temp[temp.length - i - 1] = xs[i];
		}
		for (int i = 0; i < temp.length; i++) {
			xs[i] = temp[i];
		}
	}

	static int[] getSubArray(int[] xs, int startIndex, int length) {
		int[] subArray = new int[length];
		if (length > xs.length) subArray = new int[xs.length];
		for (int i = 0; i < subArray.length; i++) {
			subArray[i] = xs[startIndex + i];
		}
		return subArray;
	}
}