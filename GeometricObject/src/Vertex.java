class Vertex {
  double x;
  double y;

  Vertex(double x, double y) {
    this.x = x;
    this.y = y;
  }
  Vertex(double x) {
    this(x,x);
  }
  Vertex() {
    this(0);
  }    
  void move(Vertex v){
    x += v.x;
    y += v.y;
  }
  void moveTo(Vertex v){
    x = v.x;
    y = v.y;
  }
  public String toString() {
    return "("+x+","+y+")";
  }
  double betrag(){
    return Math.sqrt(x*x+y*y);
  }
}