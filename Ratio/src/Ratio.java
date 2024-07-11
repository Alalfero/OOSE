class Ratio {
	long zaehler;
	long nenner;

	Ratio(long zaehler, long nenner) {
		this.zaehler = zaehler;
		this.nenner = nenner;
		kuerzen();
	}

	public String toString() {
		int zahl = (int) (zaehler / nenner);
		zaehler = zaehler - zahl * nenner;
		if (zahl == 0) return "\\frac{" + zaehler + "}{" + nenner + "}";
		return zahl + "\\frac{" + zaehler + "}{" + nenner + "}";
	}

	public void kuerzen() {
		long ggT = Euklid.gcdRec(zaehler, nenner);
		if (nenner < 0 ) ggT = ggT * (-1);
		if (ggT != 1) {
			this.zaehler = zaehler / ggT;
			this.nenner = nenner / ggT;
		}

	}

	Ratio mult(Ratio that) {
		return new Ratio((this.zaehler * that.zaehler), (this.nenner * that.nenner));
	}

	Ratio div(Ratio that) {
		return new Ratio((this.zaehler * that.nenner), (this.nenner * that.zaehler));
	}

	Ratio add(Ratio that) {
		Ratio sumRatio;
		if (this.nenner == that.nenner) sumRatio = new Ratio((this.zaehler + that.zaehler), (this.nenner));
		else
			sumRatio = new Ratio((this.zaehler * that.nenner) + (that.zaehler * this.nenner), (this.nenner * that.nenner));
		return sumRatio;
	}

	double toDouble() {
		return (double) zaehler / nenner;
	}
}