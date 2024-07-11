class RekursiveFunktionen{
  static long f1(long x){
    if(x<10) return x;
    return f1(x%10+f1(x/10));
  }

  static long f2(long x, long n){
    if(n<=0) return 1;
    if(n%2!=0) return x*f2(x,(n-1)/2)*f2(x,(n-1)/2);
    return f2(x,n/2)*f2(x,n/2);
  }

  static long f3(long result, long n){
    if(n<=0) return result;
    return f3(result*n,n-1);
  }
  static int fib(int n) {
    if(n<=1) return n;
    return fib(n-2)+fib(n-1);
  }

  static long fib2(int n) {
    return (long)((Math.pow((1+Math.sqrt(5))/2,n)-Math.pow((1-Math.sqrt(5))/2,n))/Math.sqrt(5));
  }
}