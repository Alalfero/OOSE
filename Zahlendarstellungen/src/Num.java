record Num(long n) {
	//n is assumed to be a positive number
	String toBin() {
		return lookAtBase(2, n, "");
	}

	String toOct() {
		return lookAtBase(8, n, "");
	}

	String toBase(int b) {
		return lookAtBase(b, n, "");
	}

	static String lookAtBase(int b, long num, String newNum) {
		return num == 0 ? "0" + newNum : lookAtBase(b, num / b, Character.toString(getDigit(num % b)) + newNum);

	}

	static char getDigit(long d) {
		return (char) (d < 10 ? '0' + d : 'A' + d - 10);
	}
}