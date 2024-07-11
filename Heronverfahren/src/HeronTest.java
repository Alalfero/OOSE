import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HeronTest {
  static {
     ClassLoader.getSystemClassLoader().setDefaultAssertionStatus(true);
   }

  @Before
  public void setUp() throws Exception {
  }
  @Test
  public void test1() {
    assertEquals(3,(int)Heron.sqrt(9));
  }
  @Test
  public void test2() {
    assertEquals(100,(int)Heron.sqrt(10000));
  }
  @Test
  public void test3() {
    assertEquals(141421,(int)(Heron.sqrt(2)*100000));
  }
  @Test(expected=AssertionError.class)
  public void test4() {
    assertEquals(141421,(int)(Heron.sqrt(-2)*100000));
  }
}
