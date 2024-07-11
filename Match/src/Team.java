class Team{
  String  name;
  int established;

  Team(String  name, int established){
    this.name = name;
    this.established = established;
  }
  public String toString(){
    return name+" ("+established+")";
  }
  public static void main(String[] args){
    var t = new Team("VfB Stuttgart",1893);
    System.out.println(t);
  }
}