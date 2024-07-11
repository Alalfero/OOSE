public final class FunGraph {
	private FunGraph() {
	}

	static String mkStringGraph(int xMin, int xMax, int yMin, int yMax) {
		String result = "";
		for (int y = yMin; y <= yMax; y++) {
			for (int x = xMin; x <= xMax; x++) {
				if ((int) Math.sqrt(y) == Math.abs(x)) result = "*" + result;
				else if (x == 0) result = "|" + result;
				else if (y == 0) result = "-" + result;
				else result = " " + result;
			}
			if (y == yMax) continue;
			result = "\n" + result;

		}
		return result + "\n";
	}

	public static void main(String[] args) {
		System.out.println(mkStringGraph(-4, 4, 0, 16));

	}

}