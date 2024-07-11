import java.math.BigInteger;

public class ggT {
	public static void main(String[] args) {
		BigInteger m = new BigInteger("533360");

		BigInteger sum1 = BigInteger.ZERO;
		BigInteger sum2 = BigInteger.ZERO;
		for (BigInteger n = BigInteger.ZERO; n.compareTo(m) < 0; n = n.add(BigInteger.ONE)) {
			sum1 = n.pow(5).add(BigInteger.valueOf(5));
			sum2 = n.add(BigInteger.ONE).pow(5).add(BigInteger.valueOf(5));
		}
		System.out.println(ggT(sum1, sum2));
	}

	static BigInteger ggT(BigInteger x, BigInteger y) {
		while (y.compareTo(BigInteger.ZERO) != 0) {
			BigInteger temp = y;
			y = x.mod(y);
			x = temp;
		}
		return x.abs();
	}

}




