package name.panitz.util;
import static name.panitz.util.List.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

public class ALTest {
  
  List<String> xs;
  List<String> ys;
  List<Integer> is;
  List<Integer> is2;
  int i = 0;

  
  @Before
  public void setUp() throws Exception {
    xs = of();
    ys = of();
    is = of();
    is2 = of();
    i = 0;
  }

  @Test
  public void testLength1() {
    assertEquals("of().size()",0,of().size());
  }

  @Test
  public void testLength2() {
    assertEquals("of(42).size()",1,of(42).size());
  }
  @Test
  public void testLength3() {
    assertEquals("of(1,2,3,4,5).size()",5,of(1,2,3,4,5).size());
  }

  @Test
  public void testAppen1() {
    assertEquals("of().append(of())",of(),of().append(of()));
  }

  @Test
  public void testAppend2() {
    assertEquals("of(1).append(of())",of(1),of(1).append(of()));
  }
  @Test
  public void testAppend3() {
    assertEquals("of(1).append(of(2,3,4))",of(1,2,3,4),of(1).append(of(2,3,4)));
  }
  @Test
  public void testAppend4() {
    assertEquals("of(1).append(of())",of(1),of(1).append(of()));
  }
  @Test
  public void testAppend5() {
    assertEquals("of(1,2,3,4).append(of(2,3,4))",of(1,2,3,4,2,3,4),of(1,2,3,4).append(of(2,3,4)));
  }

/*
  @Test
  public void testContainsWith1() {
    assertFalse("containsWith muss für leere Liste false ergeben.", xs.containsWith(x -> true));
    xs.add("freunde");
    assertFalse("containsWith muss für Prädikat (x->false) immer false ergeben.", xs.containsWith(x -> false));
    assertTrue("containsWith muss für Prädikat (x->true) immer true ergeben.", xs.containsWith(x -> true));
    assertTrue("containsWith falsch für Prädikat (x->x.equals(\"freunde\")), obwohl Wort in Liste ist.",
    xs.containsWith(x -> x.equals("freunde")));
    assertFalse("containsWith falsch für Prädikat (x->x.equals(\"friends\")), wenn Wort nicht in Liste ist.",
    xs.containsWith(x -> x.equals("friends")));
  }
*/
  @Test
  public void testContains1() {
    xs = of("A","B","C","D","E","F","G");
    assertTrue("contains findet erstes element nicht.", xs.contains("a".toUpperCase()+""));
    assertTrue("contains findet letztes element nicht.", xs.contains("G".toUpperCase()+""));
    assertTrue("contains findet mittleres element nicht.", xs.contains("D".toUpperCase()+""));
    assertFalse("contains findet element nicht.", xs.contains("a"));
  }
  @Test
  public void testContains2() {
    assertFalse("contains findet element in leerer Liste.", xs.contains("a"));
  }


  @Test
  public void testisPrefixOf1() {
    xs = of("A","B","C","D","E","F","G");
    ys = of("C","D","E");
    assertFalse("", xs.isPrefixOf(ys));
    assertFalse("", ys.isPrefixOf(xs));
    assertTrue("", ys.isPrefixOf(ys));
    assertTrue("", xs.isPrefixOf(xs));
  }

  @Test
  public void testisPrefixOf2() {
    xs = of("A","B","C","D","E","F","G");
    ys = of("A","B","C");
    assertTrue("", ys.isPrefixOf(xs));
    assertFalse("", xs.isPrefixOf(ys));
  }
  @Test
  public void testisPrefixOf3() {
    xs = of("A","B","C","D","E","F","G");
    assertTrue("", ys.isPrefixOf(xs));
    assertFalse("", xs.isPrefixOf(ys));
  }  

  @Test
  public void testisSuffixOf1() {
    xs = of("A","B","C","D","E","F","G");
    ys = of("C","D","E");
    assertFalse("", xs.isSuffixOf(ys));
    assertFalse("", ys.isSuffixOf(xs));
    assertTrue("", ys.isSuffixOf(ys));
    assertTrue("", xs.isSuffixOf(xs));
  }

  @Test
  public void testisSuffixOf2() {
    xs = of("A","B","C","D","E","F","G");
    ys = of("E","F","G");
    assertTrue("", ys.isSuffixOf(xs));
    assertFalse("", xs.isSuffixOf(ys));
  }
  @Test
  public void testisSuffixOf3() {
    xs = of("A","B","C","D","E","F","G");
    assertTrue("", ys.isSuffixOf(xs));
    assertFalse("", xs.isSuffixOf(ys));
  }  


  @Test
  public void testisInfixOf1() {
    xs = of("A","B","C","D","E","F","G");
    ys = of("C","D","E");
    assertFalse("", xs.isInfixOf(ys));
    assertTrue("", ys.isInfixOf(xs));
    assertTrue("", ys.isInfixOf(ys));
    assertTrue("", xs.isInfixOf(xs));
  }

  @Test
  public void testisInfixOf2() {
    xs = of("A","B","C","D","E","F","G");
    ys = of("E","F","G");
    assertTrue("", ys.isInfixOf(xs));
    assertFalse("", xs.isInfixOf(ys));
  }
  @Test
  public void testisInfixOf3() {
    xs = of("A","B","C","D","E","F","G");
    assertTrue("", ys.isInfixOf(xs));
    assertFalse("", xs.isInfixOf(ys));
  }  
@Test
  public void testisInfixOf4() {
    xs = of("A","B","C","D","E","F","G");
    ys = of("X","Y","Z");
    assertFalse("", ys.isInfixOf(xs));
    assertFalse("", xs.isInfixOf(ys));
  }

@Test
  public void testisInfixOf5() {
    xs = of("A","B","C","X","Y","F","G");
    ys = of("X","Y","möck");
    assertFalse("", ys.isInfixOf(xs));
    assertFalse("", xs.isInfixOf(ys));
  }


  @Test
  public void last1() {
    xs = of("A","B","C","D","E","F","G");
    assertEquals("","G",xs.last());
  }

  @Test
  public void last2() {
    xs = of("A");
    assertEquals("","A",xs.last());
  }

  @Test
  public void last3() {
    xs = of();
    try{
      assertEquals("","A",xs.last());
      fail("es wurde keine Exception bei last leerer Liste geworfen");
    }catch(java.util.NoSuchElementException e) {}
  }


  @Test
  public void append1() {
    xs = of("A","B","C","D","E","F","G");
    assertEquals("",xs,xs.append(ys));
    assertEquals("",xs,ys.append(xs));
  }
  @Test
  public void append2() {
    xs = of("A","B","C");
    ys = of("D","E","F","G");
    assertEquals("",of("A","B","C","D","E","F","G"),xs.append(ys));
  }

  @Test
  public void testDrop1() {
    xs = of("A","B","C","D","E","F","G");
    ys = of("C","D","E","F","G");
    assertEquals("falsches Ergebnis für: " + xs + ".drop(2)", ys, xs.drop(2));
  }
  @Test
  public void testDrop42() {
    xs = of("A","B","C","D","E","F","G");
    ys = of("A","B","C","D","E","F","G");
    var rs = xs.drop(-1);
    assertEquals("falsches Ergebnis für: " + xs + ".drop(2)", ys, rs);
    assertFalse("Ergebnisliste muss neu sein",rs==xs);
  }


/*  @Test
  public void testDropWhile1() {
    assertEquals("of(1,2,3,4,1,5,6,7,8,1).dropWhile(x->x<5)", of(5,6,7,8,1), of(1,2,3,4,1,5,6,7,8,1).dropWhile(x->x<5));
  }
  @Test
  public void testDropWhile2() {
    assertEquals("of(1,2,3,4).dropWhile(x->false)", of(1,2,3,4), of(1,2,3,4).dropWhile(x->false));
  }
  @Test
  public void testDropWhile3() {
    assertEquals("of(1,2,3,4).dropWhile(x->true)", of(), of(1,2,3,4).dropWhile(x->true));
  }

  @Test
  public void testTakeWhile1() {
    assertEquals("of(1,2,3,4,1,5,6,7,8,1).takeWhile(x->x<5)", of(1,2,3,4,1), of(1,2,3,4,1,5,6,7,8,1).takeWhile(x->x<5));
  }
  @Test
  public void testTakeWhile2() {
    assertEquals("of(1,2,3,4).takeWhile(x->false)", of(), of(1,2,3,4).takeWhile(x->false));
  }
  @Test
  public void testTakeWhile3() {
    assertEquals("of(1,2,3,4).takeWhile(x->true)", of(1,2,3,4), of(1,2,3,4).takeWhile(x->true));
  }
*/

  @Test
  public void testDrop2() {
    xs = of("A","B","C","D","E","F","G");
    assertEquals("falsches Ergebnis für: " + xs + ".drop(0)", xs, xs.drop(0));
  }
  @Test
  public void testDrop3() {
    xs = of("A","B","C","D","E","F","G");
    assertEquals("falsches Ergebnis für: " + xs + ".drop(10)", ys, xs.drop(10));
  }

  @Test
  public void testTake1() {
    xs = of("A","B","C","D","E","F","G");
    ys = of("A","B","C");
    assertEquals("falsches Ergebnis für: " + xs + ".take(3)", ys, xs.take(3));
  }
  
  @Test
  public void testTake2() {
    xs = of("A","B","C","D","E","F","G");
    assertEquals("falsches Ergebnis für: " + xs + ".take(0)", ys, xs.take(0));
  }
  @Test
  public void testTake3() {
    xs = of("A","B","C","D","E","F","G");
    var rs = xs.take(10);
    assertEquals("falsches Ergebnis für: " + xs + ".take(10)", xs, rs);
    assertFalse("Es muss eine neue Liste, ein neues Objekt erzeugt werden", xs==rs);    
  }
  
  
  @Test
  public void testSublist1() {
    xs = of("A","B","C","D","E","F","G");
    ys = of("C","D","E");
    assertEquals("falsches Ergebnis für: " + xs + ".sublist(2,3)", ys, xs.sublist(2, 3));
  }

  @Test
  public void testSublist2() {
    assertEquals("falsches Ergebnis für sublist auf leerer Liste", of(), xs.sublist(2, 4));
  }
/*
  @Test
  public void testForEach1() {
    xs = of("hallo","welt","hello","illja");
    xs.forEach((x) -> i++);
    assertEquals("forEach wird nicht für alle Elemente durchlaufen", 4, i);
  }

  @Test
  public void testForEach2() {
    is.forEach((x) -> i++);
    assertEquals("forEach darf für leere Liste nichts machen", 0, i);
  }

  @Test
  public void testMap1() {
    is = of(1,2,3,4);
    String isString = is.toString();
    xs = of("1","2","3","4");
    assertEquals(isString + ".map(x -> x.toString()) ist falsch", xs, is.map(x -> x.toString()));
  }

  @Test
  public void testMap2() {
    assertEquals("map auf leerer List ist falsch", of(), is.map(x -> x + ""));
  }

  @Test
  public void testMap3() {
    is = of(1,2,3,4);
    is2 = of(1,4,9,16);
    assertEquals("map rechnet falsch", is2, is.map(x->x*x));
  }

  @Test
  public void testFilter1() {
    is = of(1,2,3,4);
    is2 = of(2,4);
    String isString = is + "";
    assertEquals(isString + ".filter(x -> x%2 == 0)", is2, is.filter(x -> x % 2 == 0));
  }

  @Test
  public void testFilter2() {
    xs = of("A","B","C","D","E","F","G");
    // String xsString = xs+"";
    assertEquals("Prädikat, das immer false ist, muss leere Liste durch filter erzeugen", of(), xs.filter(x -> false));
  }

  @Test
  public void testFilter3() {
    xs = of("A","B","C","D","E","F","G");
    ys = of("A","B","C","D","E","F","G");

    assertEquals("Prädikat, das immer true ist, muss alle Listenelemente im Ergebnius haben.", ys,
        xs.filter(x -> true));
  }
*/
  @Test
  public void reverse1() {
    xs = of("A","B","C","D","E","F","G");
    ys = of("G","F","E","D","C","B","A");
    assertEquals("reverse geht nicht",ys,xs.reverse());
  }
  @Test
  public void reverse2() {
    assertEquals("reverse geht nicht",ys,xs.reverse());
  }


  @Test
  public void intersperse1() {
    assertEquals("intersperse geht nicht",ys,xs.intersperse(" "));
  }
  @Test
  public void intersperse2() {
    assertEquals("intersperse geht nicht",of("A"),of("A").intersperse(" "));
  }
  @Test
  public void intersperse3() {
    assertEquals("intersperse geht nicht",of("A"," ","B"),of("A","B").intersperse(" "));
  }
  @Test
  public void intersperse4() {
    assertEquals("intersperse geht nicht",of(1,42,2,42,3),of(1,2,3).intersperse(42));
  }
  
  @Test
  public void get1() {
    assertEquals("get geht nicht",42,of(1,2,3,42,5).get(3).intValue());
  }
  @Test
  public void get2() {
    try{
      assertEquals("get geht nicht",42,of(1,2,3,42,5).get(16).intValue());
      fail("Exception not thrown in get with wrong index");
    }catch(IndexOutOfBoundsException e){
    }
  }
  @Test
  public void get3() {
    assertEquals("get geht nicht",1,of(1,2,3,42,5).get(0).intValue());
  }

  @Test
  public void zip1() {
    assertEquals("zip falsch", of(new Pair<>(1, "A"), new Pair<>(2, "B"), new Pair<>(3, "C"), new Pair<>(4, "D")),of(1,2,3,4,5,6).zip(of("A","B","C","D")));
  }

  @Test
  public void zip2() {
    assertEquals("zip falsch", of(),of(1,2,3,4,5,6).zip(of()));
  }
  @Test
  public void zip3() {
    assertEquals("zip falsch", of(),of().zip(of(1,2,3)));
  }
/*  @Test
  public void span1() {
     assertEquals("span falsch",new Pair<>(of(1,2,3),of(4,5,6,1,2,3)),of(1,2,3,4,5,6,1,2,3).span(x->x<4));
  }
  @Test
  public void span2() {
     assertEquals("span falsch",new Pair<>(of(1,2,3,4,5,6,1,2,3),of()),of(1,2,3,4,5,6,1,2,3).span(x->true));
  }
  @Test
  public void span3() {
     assertEquals("span falsch",new Pair<>(of(),of(1,2,3,4,5,6,1,2,3)),of(1,2,3,4,5,6,1,2,3).span(x->false));
  }

  @Test
  public void partition1() {
     assertEquals("partition falsch",new Pair<>(of(1,2,3,1,2,3),of(4,5,6)),of(1,2,3,4,5,6,1,2,3).partition(x->x<4));
  }
  @Test
  public void partition2() {
     assertEquals("partition falsch",new Pair<>(of(1,2,3,4,5,6,1,2,3),of()),of(1,2,3,4,5,6,1,2,3).partition(x->true));
  }
  @Test
  public void partition3() {
     assertEquals("partition falsch",new Pair<>(of(),of(1,2,3,4,5,6,1,2,3)),of(1,2,3,4,5,6,1,2,3).partition(x->false));
  }

  @Test
  public void isSorted1() {
     assertTrue("isSorted",of().isSorted((x,y)->0));
     assertTrue("isSorted",of(42).isSorted((x,y)->0));
  }
  @Test
  public void isSorte2() {
     assertTrue("isSorted",of(5,24,1,32,999).isSorted((x,y)->0));
     assertTrue("isSorted",of(5,24,1,32,999).isSorted((x,y)->-1));
     assertFalse("isSorted",of(5,24,1,32,999).isSorted((x,y)->x-y));
  }
  @Test
  public void isSorted3() {
     assertTrue("isSorted",of(5,24,111,321,999).isSorted((x,y)->x-y));
  }
  @Test
  public void qsort1() {
    assertEquals("sortieren falsch",of(0, 1, 2, 3, 4, 4, 5, 22, 33, 423, 435, 453, 2345),of(1,2,4,5,435,4,2345,33,3,453,423,22,0).qsort((x,y)->x-y));
  }
  @Test
  public void qsort2() {
    assertEquals("sortieren falsch",of(),of().qsort((x,y)->0));
  }
  @Test
  public void qsort3() {
    assertEquals("sortieren falsch",of(2345, 453, 435, 423, 33, 22, 5, 4, 4, 3, 2, 1, 0 ),of(1,2,4,5,435,4,2345,33,3,453,423,22,0).qsort((x,y)->y-x));
  }
*/
  @Test
  public void rotate1() {
    assertEquals("rotate falsch",of("A"),of("A").rotate());
  }
  @Test
  public void rotate2() {
    assertEquals("rotate falsch",of("B","C","A"),of("A","B","C").rotate());
  }
  @Test
  public void rotate3() {
    assertEquals("rotate falsch",of("A","B"),of("B","A").rotate());
  }
  @Test
  public void rotate4() {
    assertEquals("rotate falsch of()",of(),of().rotate());
  }
  @Test
  public void tails1() {
    assertEquals("tails falsch",of(of()),of().tails());
  }
  @Test
  public void tails2() {
    assertEquals("tails falsch",of(of(1),of()),of(1).tails());
  }
  @Test
  public void tails3() {
    assertEquals("tails falsch",of(of(1,2),of(2),of()),of(1,2).tails());
  }
  @Test
  public void tails4() {
    assertEquals("tails falsch",of(of(1,2,3),of(2,3),of(3),of()),of(1,2,3).tails());
  }
}