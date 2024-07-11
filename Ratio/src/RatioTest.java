import static org.junit.Assert.*;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.Before;
import org.junit.Test;

public class RatioTest {

  @Before
  public void setUp() throws Exception {
  }
  @Test
  public void test1() {
    var d = new Ratio(2, 5);
    assertTrue("Nenner darf nicht 0 sein.",d.nenner!=0);

    assertEquals("Zähler nach Konstruktion nicht korrekt gesetzt", 2,d.zaehler);
    assertEquals("Nenner nach Konstruktion nicht korrekt gesetzt", 5,d.nenner);
  }
  @Test
  public void test2a() {
    var d = new Ratio(2, 5);
    assertTrue("Nenner darf nicht 0 sein.",d.nenner!=0);

    assertEquals("toString nicht nach der Spezifikation", "\\frac{2}{5}",d.toString());
  }
  @Test
  public void test2b() {
    var d = new Ratio(7, 5);
    assertTrue("Nenner darf nicht 0 sein.",d.nenner!=0);

    assertEquals("toString nicht nach der Spezifikation", "1\\frac{2}{5}",d.toString());
  }
  @Test
  public void test2c() {
    var d = new Ratio(18, 5);
    assertTrue("Nenner darf nicht 0 sein.",d.nenner!=0);

    assertEquals("toString nicht nach der Spezifikation", "3\\frac{3}{5}",d.toString());
  }
  @Test
  public void test3() {
    var d = new Ratio(2, 5);
    assertTrue("Nenner darf nicht 0 sein.",d.nenner!=0);
  }
  @Test
  public void test4() {
    var d = new Ratio(3, 15);
    assertTrue("Nenner darf nicht 0 sein.",d.nenner!=0);

    assertEquals("Zähler falsch gekürzt", 1L,d.zaehler);
    assertEquals("Nenner falsch gekürzt", 5L,d.nenner);
  }
  @Test
  public void test5() {
    var d = new Ratio(-3, -15);
    assertTrue("Nenner darf nicht 0 sein.",d.nenner!=0);

    assertEquals("Zähler falsch gekürzt", 1L,d.zaehler);
    assertEquals("Nenner falsch gekürzt", 5L,d.nenner);
  }
    
  @Test
  public void test6() {
    var d = new Ratio(3, -15);
    assertTrue("Nenner darf nicht 0 sein.",d.nenner!=0);

    assertEquals("Zähler falsch gekürzt", -1L,d.zaehler);
    assertEquals("Nenner falsch gekürzt", 5L,d.nenner);
  }

  @Test
  public void test7() {
    var d = new Ratio(3, -15).mult(new Ratio(3,3));

    assertEquals("nach Multiplikation Zähler falsch gekürzt", -1L,d.zaehler);
    assertEquals("nach Multiplikation Nenner falsch gekürzt", 5L,d.nenner);
  }

  @Test
  public void test8() {
    var d = new Ratio(3, -15).mult(new Ratio(2,3));

    assertEquals("nach Multiplikation Zähler falsch gekürzt", -2L,d.zaehler);
    assertEquals("nach Multiplikation Nenner falsch gekürzt", 15L,d.nenner);
  }

  @Test
  public void test9() {
    var d = new Ratio(3, -15).mult(new Ratio(-15,3));

    assertEquals("nach Multiplikation Zähler falsch gekürzt", 1L,d.zaehler);
    assertEquals("nach Multiplikation Nenner falsch gekürzt", 1L,d.nenner);
  }

  @Test
  public void test10() {
    var d = new Ratio(1, 2).add(new Ratio(1,3));

    assertEquals("nach Addition Zähler falsch gekürzt", 5L,d.zaehler);
    assertEquals("nach Addition falsch Nenner gekürzt", 6L,d.nenner);
  }
  @Test
  public void test11() {
    var d = new Ratio(0, 2).add(new Ratio(1,3));

    assertEquals("nach Addition Zähler falsch gekürzt", 1L,d.zaehler);
    assertEquals("nach Addition falsch Nenner gekürzt", 3L,d.nenner);
  }  
  @Test
  public void test12() {
    var d = new Ratio(3, -15).div(new Ratio(-15,3));

    assertEquals("nach Division Zähler falsch gekürzt", 1L,d.zaehler);
    assertEquals("nach Division Nenner falsch gekürzt", 25L,d.nenner);
  }
  
}