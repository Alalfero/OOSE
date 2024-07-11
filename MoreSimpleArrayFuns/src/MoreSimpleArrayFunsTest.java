import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;



public class MoreSimpleArrayFunsTest {
  int[] xs1;
  int[] xs2;
  int[] xs3;
  
  @Before
  public void setUp() throws Exception {
    xs1 = new int[]{};
    xs2 = new int[]{1,2,3,4,5,6,7,8,9,10};
    xs3 = new int[]{45764,657,2,323,-7686,-1,0,42,0,0,-111,5675765,Integer.MAX_VALUE};
  }

  
  @Test
  public void test1() {
    assertEquals(-1,MoreSimpleArrayFuns.firstIndex(xs1,42));
    assertEquals(0,MoreSimpleArrayFuns.firstIndex(xs2,1));
    assertEquals(8,MoreSimpleArrayFuns.firstIndex(xs2,9));
    assertEquals(9,MoreSimpleArrayFuns.firstIndex(xs2,10));
    assertEquals(-1,MoreSimpleArrayFuns.firstIndex(xs2,42));
  }
  @Test
  public void test2() {
    int[] ys1 = new int[]{};
    int[] ys2 = new int[]{1,2,3,4,5,6};
    int[] ys3 = new int[]{45764,657,2,323,-7686,-1,0,42,0,0,-111,5675765,Integer.MAX_VALUE};
    assertTrue("leerer Array startet mit leeren Array",MoreSimpleArrayFuns.startsWith(ys1,xs1));
    assertTrue("Präfix bei startsWith micht erkannt",MoreSimpleArrayFuns.startsWith(ys2,xs2));
    assertTrue("Präfix bei startsWith micht erkannt",MoreSimpleArrayFuns.startsWith(ys3,xs3));
    assertFalse("leerer Array startet nur mit leeren Array",MoreSimpleArrayFuns.startsWith(ys2,xs1));
    assertFalse("startsWith muss für Arrays mit unterschiedlichen ersten Element false ergeben",MoreSimpleArrayFuns.startsWith(ys3,xs2));
  }
  @Test
  public void testReplace1() {
    int[] ys1 = new int[]{};
    MoreSimpleArrayFuns.replace(xs1,1,2);
    assertArrayEquals(ys1,xs1);
  }
  @Test
  public void testReplace2() {
    int[] ys1 = new int[]{1,2,3,4,5,6,7,8,9,10};
    int[] ys2 = new int[]{1,2,3,42,5,6,7,8,9,10};
    MoreSimpleArrayFuns.replace(xs2,0,42);
    assertArrayEquals(ys1,xs2);
    
    MoreSimpleArrayFuns.replace(xs2,4,42);
    assertArrayEquals(ys2,xs2);
  }
  @Test
  public void testReplace3() {
    int[] ys1 = new int[]{45764,657,2,323,-7686,-1,0,42,0,0,-111,5675765,Integer.MAX_VALUE};
    int[] ys2 = new int[]{45764,657,2,323,-7686,-1,42,42,42,42,-111,5675765,Integer.MAX_VALUE};
    MoreSimpleArrayFuns.replace(xs3,700,42);
    assertArrayEquals(ys1,xs3);
    
    MoreSimpleArrayFuns.replace(xs3,0,42);
    assertArrayEquals(ys2,xs3);
  }

  @Test
  public void test4() {
    int[] ys1 = new int[]{};
    int[] ys2 = new int[]{10,9,8,7,6,5,4,3,2,1};
    int[] ys3 = new int[]{Integer.MAX_VALUE,5675765,-111,0,0,42,0,-1,-7686,323,2,657,45764};
    MoreSimpleArrayFuns.reverse(xs1);
    assertArrayEquals(ys1,xs1);
    MoreSimpleArrayFuns.reverse(xs2);
    assertArrayEquals(ys2,xs2);
    MoreSimpleArrayFuns.reverse(xs3);
    assertArrayEquals(ys3,xs3);
  }
  @Test
  public void testGetSubArray1() {
    int[] ys1 = new int[]{};
    int[] ys2 = new int[]{3,4,5,6,7};
    int[] ys3 = new int[]{45764,657,2,323,-7686,-1,0,42,0,0,-111,5675765,Integer.MAX_VALUE};
    var r1 = MoreSimpleArrayFuns.getSubArray(xs2,0,10);
    assertArrayEquals(xs2,r1);
  }
  @Test
  public void testGetSubArray2() {
    int[] ys2 = new int[]{3,4,5,6,7};
    var r2 = MoreSimpleArrayFuns.getSubArray(xs2,2,5);
    assertArrayEquals(ys2,r2);
  }
  @Test
  public void testGetSubArray3() {
    int[] ys1 = new int[]{};
    var r3 = MoreSimpleArrayFuns.getSubArray(xs2,2,0);
    assertArrayEquals(ys1,r3);
  }
  @Test
  public void testGetSubArray4() {
    var r4 = MoreSimpleArrayFuns.getSubArray(xs2,0,200);
    assertArrayEquals("Test bei zu grosser oberer Schranke ist falsch",xs2,r4);
  }
 @Test
  public void testGetSubArray5() {
    int[] ys2 = new int[]{1,2,3,4,5,6,7};
    var r2 = MoreSimpleArrayFuns.getSubArray(xs2,0,7);
    assertArrayEquals(ys2,r2);
  }
 }