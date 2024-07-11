import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NumTest {
  static {
     ClassLoader.getSystemClassLoader().setDefaultAssertionStatus(true);
   }

  @Before
  public void setUp() throws Exception {
  }
  @Test
  public void test1() {
    assertEquals("01",new Num(1).toBin());
  }
  @Test
  public void test2() {
    assertEquals("010",new Num(2).toBin());
  }

  @Test
  public void test3() {
    assertEquals("0101",new Num(5).toBin());
  }
  @Test
  public void test4() {
    assertEquals("0101010",new Num(42).toBin());
  }
  @Test
  public void test5() {
    assertEquals("010",new Num(8).toOct());
  }
  @Test
  public void test6() {
    assertEquals("077",new Num(63).toOct());
  }
  @Test
  public void test7() {
    assertEquals("052",new Num(42).toOct());
  }

  @Test
  public void test11() {
    assertEquals("01",new Num(1).toBase(2));
  }
  @Test
  public void test12() {
    assertEquals("010",new Num(2).toBase(2));
  }

  @Test
  public void test13() {
    assertEquals("0101",new Num(5).toBase(2));
  }
  @Test
  public void test14() {
    assertEquals("0101010",new Num(42).toBase(2));
  }
  @Test
  public void test15() {
    assertEquals("010",new Num(8).toBase(8));
  }
  @Test
  public void test16() {
    assertEquals("077",new Num(63).toBase(8));
  }
  @Test
  public void test17() {
    assertEquals("052",new Num(42).toBase(8));
  }
  @Test
  public void test18() {
    assertEquals("0FF",new Num(255).toBase(16));
  }
  @Test
  public void test19() {
    assertEquals("010",new Num(16).toBase(16));
  }
  @Test
  public void test20() {
    var n = new Num(42);
    assertEquals("02A",n.toBase(16));
    assertEquals("wiederholtes Aufrufen, darf das Ergebnis und das Num-Objekt nicht ändern","02A",n.toBase(16));
    assertEquals("052",n.toBase(8));
    assertEquals("0101010",n.toBase(2));
  }

}
