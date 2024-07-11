import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FunGraphTest {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void test1() {
    assertEquals("mkStringGraph(-5, 5, 0, 25)","*    |    *\n *   |   * \n *   |   * \n *   |   * \n *   |   * \n *   |   * \n *   |   * \n *   |   * \n *   |   * \n *   |   * \n  *  |  *  \n  *  |  *  \n  *  |  *  \n  *  |  *  \n  *  |  *  \n  *  |  *  \n  *  |  *  \n   * | *   \n   * | *   \n   * | *   \n   * | *   \n   * | *   \n    *|*    \n    *|*    \n    *|*    \n-----*-----\n",FunGraph.mkStringGraph(-5, 5, 0, 25));
  }

  @Test
  public void test2() {
    assertEquals("mkStringGraph(-2, 2, 0, 5)","* | *\n* | *\n *|* \n *|* \n *|* \n--*--\n",FunGraph.mkStringGraph(-2, 2, 0, 5));
  } 
}