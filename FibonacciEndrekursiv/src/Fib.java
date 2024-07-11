class Fib{
  static int fib(int n) {

    return fib(0,1,n);
  }
  static int fib(int n0, int n1, int n) {
    if(n<=0) return n0;
    return fib(n1,n0+n1,n-1);
  }
}