import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SimpleArrayFunsTest {
  int[] xs1 = {};
  int[] xs2 = {1,2,3,4,5,6,7,8,9,10};
  int[] xs3 = {45764,657,2,323,-7686,-1,0,42,0,0,-111,5675765,Integer.MAX_VALUE};
  int[] xs4 = {-1,-2,-3,-4,-5,-6,-7,-8,-9,-10};
  int[] xs5 = {1,2,3,4,5,6,7,8,9,10,1,2};

  
  @Before
  public void setUp() throws Exception {
 }

  
  @Test
  public void test1() {
    assertFalse("contains auf leeren Array ist nicht false",SimpleArrayFuns.contains(xs1,42));
    assertFalse("contains true, obwohl Element nicht im Array.",SimpleArrayFuns.contains(xs2,42));
    assertTrue("contains findet Element nicht",SimpleArrayFuns.contains(xs3,42));
  }
  @Test
  public void test2() {
    assertEquals("Summe falsch.",0,SimpleArrayFuns.sum(xs1));
    assertEquals("Summe falsch.",55L,SimpleArrayFuns.sum(xs2));
    assertEquals("Summe falsch.",2153198402L,SimpleArrayFuns.sum(xs3));
  }
  @Test
  public void test3() {
    assertEquals("Durchschnitt falsch.",0,SimpleArrayFuns.avg(xs1));
    assertEquals("Durchschnitt falsch.",5L,SimpleArrayFuns.avg(xs2));
    assertEquals("Durchschnitt falsch.",165630646,SimpleArrayFuns.avg(xs3));
  }
  @Test
  public void test4() {
    assertTrue("isSorted auf leeren Array sollte true sein.",SimpleArrayFuns.isSorted(xs1));
    assertTrue("isSorted auf sortierten Array sollte true sein.",SimpleArrayFuns.isSorted(xs2));
    assertFalse("isSorted auf Array sollte false sein.",SimpleArrayFuns.isSorted(xs3));
  }
  @Test
  public void test5() {
    assertEquals("max falsch.",Integer.MIN_VALUE,SimpleArrayFuns.max(xs1));
    assertEquals("max falsch.",10L,SimpleArrayFuns.max(xs2));
    assertEquals("max falsch.",Integer.MAX_VALUE,SimpleArrayFuns.max(xs3));
    assertEquals("max falsch.",-1L,SimpleArrayFuns.max(xs4));
    assertEquals("max falsch.",10,SimpleArrayFuns.max(xs5));
  }
}
