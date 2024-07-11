record GameOfLife(boolean[][] field) {
	String show() {
		String result = "";
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[i].length; j++) {
				if (field[i][j]) result += "\u2588";
				else result = result + " ";
			}
			result = result + "\n";
		}

		return result;
	}

	int population() {
		int sum = 0;
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[i].length; j++) {
				if (field[i][j]) sum++;

			}
		}
		return sum;
	}

	boolean extinct() {
		return population() == 0;
	}

	static GameOfLife fromString(String m) {
		String[] rows = m.split("\n");
		String symbol = "";
		boolean[][] newField = new boolean[rows.length][rows[0].length()];
		for (int i = 0; i < rows.length; i++) {
			for (int j = 0; j < rows[i].length(); j++) {
				symbol = String.valueOf(rows[i].charAt(j));
				newField[i][j] = !symbol.equals(".");
			}
		}
		return new GameOfLife(newField);
	}

	static String ex1 = """
			..................
			..................
			..................
			..................
			......0....0......
			....00.0000.00....
			......0....0......
			..................
			..................
			..................
			..................""";


	int anzahlBelegterNachbarn(int x, int y) {
		int neighbors = 0;
		if (field[x][y]) neighbors--;
		for (int i = x - 1; i <= x + 1; i++) {
			for (int j = y - 1; j <= y + 1; j++) {
				if (i >= 0 && j >= 0 && i < field.length && j < field[0].length && (field[i][j])) {
					neighbors++;
				}

			}
		}
		return neighbors;
	}

	GameOfLife nextGeneration() {
		boolean newField[][] = new boolean[field.length][field[0].length];
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[i].length; j++) {
				if (field[i][j]) {
					newField[i][j] = (anzahlBelegterNachbarn(i, j) < 4 && anzahlBelegterNachbarn(i, j) > 1);
				} else {
					newField[i][j] = (anzahlBelegterNachbarn(i, j) == 3);
				}

			}
		}
		System.arraycopy(newField, 0, field, 0, newField.length);
		return new GameOfLife(field);
	}

	void waitAndClear() {
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	void play() {
		var current = this;
		while (!current.extinct()) {
			System.out.println(current.show());
			waitAndClear();
			current = nextGeneration();
		}

	}

	public static void main(String... args) {
		GameOfLife.fromString(GameOfLife.ex1).play();

	}
}