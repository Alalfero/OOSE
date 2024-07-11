class Euklid{
  public static long gcd(long a, long b){
    if (a == 0) return b;
    while (b != 0){
      var h = a % b;
      a = b;
      b = h;
    }
    return Math.abs(a);
  }

  static long gcdRec(long x1,long x2){
    return x2==0 ? x1 : gcd(x2, x1%x2);
  }

}