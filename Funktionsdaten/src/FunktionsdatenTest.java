import static org.junit.Assert.*;
import static name.panitz.oose.Funktionsdaten.*;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.Before;
import org.junit.Test;

public class FunktionsdatenTest {
  AL<Integer> is;
  @Before
  public void setUp() throws Exception {
    is=of(1,2,3,4,5,6,7,8,9,10);
  }
  <A> boolean eq(AL<A> xs, AL<A> ys){
    if (xs.size()!=ys.size()) return false;
    for (var i=0;i<xs.size();i++) if (!xs.get(i).equals(ys.get(i))) return false;
    return true;
  }
  <A> void asserteq(String explain,AL<A> expected, AL<A> current){
    assertTrue(explain+ "Ergebnis: "+current + " statt "+expected,eq(current,expected));
  }

  boolean bot(){return bot();}
  
  @Test
  public void testNacheinander() {
    assertEquals("nacheinander((x)->x.length(),(x)->Math.pow(2,x),\"hallo\")", 32.0, nacheinander((x)->x.length(),(x)->Math.pow(2,x),"hallo"),0.01);
    assertEquals("nacheinander((x)->x*x, (x)->2*x, 5)",50,(long)nacheinander((x)->x*x, (x)->2*x, 5));
  }
  
  @Test
  public void testNTimes() {
    assertEquals("tt",(long)nTimes((x)->x+1,10,0),10L);
  }
  @Test
  public void testFilter() {
    var rs = of(3,6,9);
    var cu = filter(is,x->x%3==0);
    asserteq("filter("+is+",x->x%3==0)",rs,cu);
  }
  @Test
  public void testZip() {
    var rs = of(1,4,9,16,25,36,49,64,81,100);
    var cu = zipWith((x,y)->x*y,is,is);
    asserteq("zipWith("+is+","+is+"(x,y)->x*y)",rs,cu);
  }

  @Test
  public void testToSortedList() {
    var rs = of(1,4,9,16,25,36,49,64,81,100);
    var b = blatt(25);
    b=add(b,64,(x,y)->x-y);
    b=add(b,36,(x,y)->x-y);
    b=add(b,100,(x,y)->x-y);
    b=add(b,81,(x,y)->x-y);
    b=add(b,4,(x,y)->x-y);
    b=add(b,16,(x,y)->x-y);
    b=add(b,9,(x,y)->x-y);
    b=add(b,1,(x,y)->x-y);
    b=add(b,25,(x,y)->x-y);
    b=add(b,49,(x,y)->x-y);
    var cu = toSortedList(b);
    asserteq("Fehler bei toSortedList ",rs,cu);
  }

  @Test
  public void testContainsWith() {
    var b = blatt(25);
    b=add(b,64,(x,y)->x-y);
    b=add(b,36,(x,y)->x-y);
    b=add(b,100,(x,y)->x-y);
    b=add(b,81,(x,y)->x-y);
    b=add(b,4,(x,y)->x-y);
    b=add(b,16,(x,y)->x-y);
    b=add(b,9,(x,y)->x-y);
    b=add(b,1,(x,y)->x-y);
    b=add(b,25,(x,y)->x-y);
    b=add(b,49,(x,y)->x-y);
    try{
      var r = containsWithPar(b,x->x==4?true:x==81?bot():false);
      assertTrue("bist Du parallel in beide Bäume abgestiegen?",r);
    }catch(RuntimeException e){
    }
  }
  
  @Test
  public void testImplication() {
    try{
      assertTrue("ist die Prämisse falsch, braucht die Conclusio nicht angeschaut zu werden.",implication(()->false,()->bot()));
    }catch(StackOverflowError e){
      fail("ist die Prämisse falsch, braucht die Conclusio nicht angeschaut zu werden.");
    }
  }	
}
