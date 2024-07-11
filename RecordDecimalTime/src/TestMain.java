import java.sql.SQLOutput;

public class TestMain {
	public static void main(String[] args){
	DecimalTime t1 = new DecimalTime(10,100,30);
	DecimalTime t2 = new DecimalTime(5,0, 56);

		System.out.println(t2.minutesLater(100));
	}
}