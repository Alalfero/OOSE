

package name.panitz.oose;

import java.util.function.*;
import java.util.*;
import java.time.*;
import java.util.concurrent.*;

public interface Funktionsdaten {

	class AL<E> {
		private int theSize = 0;
		private Object[] store = new Object[10];

		public int size() {
			return theSize;
		}

		@SuppressWarnings("unchecked")
		public E get(int i) {
			if (i >= size() || i < 0) throw new IndexOutOfBoundsException();
			return (E) store[i];
		}

		public void add(E e) {
			if (theSize >= store.length) enlargeStore();
			store[theSize++] = e;
		}

		private void enlargeStore() {
			Object[] newStore = new Object[store.length + 10];
			for (int i = 0; i < theSize; i++) newStore[i] = store[i];
			store = newStore;
		}

		@Override
		public String toString() {
			var result = new StringBuffer("[");
			for (var i = 0; i < size(); i++) {
				if (i > 0) result.append(", ");
				result.append(store[i]);
			}
			result.append("]");
			return result.toString();
		}
	}

	static <E> AL<E> of(E... es) {
		var rs = new AL<E>();
		for (var e : es) rs.add(e);
		return rs;
	}

	static int twice1(Function<Integer, Integer> f, int i) {
		return f.apply(f.apply(i));
	}

	static AL<Integer> aufAlle(AL<Integer> xs, Function<Integer, Integer> f) {
		var rs = new AL<Integer>();
		for (var i = 0; i < xs.size(); i++) rs.add(f.apply(xs.get(i)));
		return rs;
	}

	static <A> A twice(Function<A, A> f, A i) {
		return f.apply(f.apply(i));
	}

	static <A, B, C> C nacheinander(Function<A, B> f1, Function<B, C> f2, A a) {
		return f2.apply(f1.apply(a));
	}

	static <A, B, C> Function<A, C> nach(Function<B, C> f2, Function<A, B> f1) {
		return (x) -> f2.apply(f1.apply(x));
	}

	static <A> A nTimes(Function<A, A> f, int n, A x) {
		return n == 0 ? x : nTimes(f, n - 1, f.apply(x));
	}


	static <A, B, C> AL<C> zipWith(BiFunction<A, B, C> f, AL<A> as, AL<B> bs) {
		var cs = new AL<C>();
		for (var i = 0; i < Math.min(as.size(), bs.size()); i++) cs.add(f.apply(as.get(i), bs.get(i)));
		return cs;
	}

	static int verknuepfe(AL<Integer> xs, int r, BinaryOperator<Integer> op) {
		for (var i = 0; i < xs.size(); i++) r = op.apply(r, xs.get(i));
		return r;
	}

	static <A> void fuerAlle(AL<A> xs, Consumer<A> c) {
		for (var i = 0; i < xs.size(); i++) c.accept(xs.get(i));
	}

	static <A> boolean exists(AL<A> xs, Predicate<A> p) {
		for (var i = 0; i < xs.size(); i++) if (p.test(xs.get(i))) return true;
		return false;
	}

	static <A> boolean all1(AL<A> xs, Predicate<A> p) {
		for (var i = 0; i < xs.size(); i++) if (!p.test(xs.get(i))) return false;
		return true;
	}

	static <A> boolean all(AL<A> xs, Predicate<A> p) {
		return !exists(xs, p.negate());
	}

	static <A> AL<A> filter(AL<A> xs, Predicate<A> p) {
		var rs = new AL<A>();
		for (var i = 0; i < xs.size(); i++) if (p.test(xs.get(i))) rs.add(xs.get(i));
		return rs;
	}

	record BT<E>(BT<E> left, E e, BT<E> right) {
	}

	static <E> BT<E> blatt(E e) {
		return new BT<>(null, e, null);
	}

	static <E> long size(BT<E> t) {
		return t == null ? 0 : 1 + size(t.left()) + size(t.right());
	}

	record Punkt(double x, double y) {
	}

	static Comparator<Punkt> pc = (p1, p2) ->
			(p1.x() < p2.x() ? -1 :
					p1.x() > p2.x() ? 1 :
							p1.y() < p2.y() ? -1 :
									p1.y() > p2.y() ? 1 :
											0);

	static <E> BT<E> add(BT<E> t, E e, Comparator<E> comp) {
		return
				t == null ? blatt(e) :
						comp.compare(e, t.e()) < 0
								? new BT<>(add(t.left(), e, comp), t.e(), t.right()) :
								comp.compare(e, t.e()) > 0
										? new BT<>(t.left(), t.e(), add(t.right(), e, comp)) :
										t;
	}

	static BT<Punkt> add(BT<Punkt> t, Punkt e) {
		return add(t, e, pc);
	}

	static <E> boolean contains(BT<E> t, E e, Comparator<E> comp) {
		return
				t == null ? false :
						comp.compare(e, t.e()) < 0 ? contains(t.left(), e, comp) :
								comp.compare(e, t.e()) > 0 ? contains(t.right(), e, comp) :
										true;
	}

	static <A> AL<A> toSortedList(BT<A> t) {
		return toSortedList(t, new AL<A>());
	}

	static <A> AL<A> toSortedList(BT<A> t, AL<A> rs) {
		if (t != null) {
			rs = toSortedList(t.left(), rs);
			rs.add(t.e());
			rs = toSortedList(t.right(), rs);

		}
		return rs;
	}

	record Pair<A, B>(A e1, B e2) {
	}

	@FunctionalInterface
	interface Getter<A> {
		A get();
	}

	static <A> Pair<A, Duration> timeMeasure(Getter<A> c) {
		var start = Instant.now();
		A r = c.get();
		var end = Instant.now();
		return new Pair<>(r, Duration.between(start, end));
	}

	static long fib(int n) {
		return n <= 1 ? n : fib(n - 2) + fib(n - 1);
	}

	static long prod(int from, int to) {
		var middle = (from + to) / 2;
		return from == to ? from
				: prod(from, middle) * prod(middle + 1, to);
	}

	static <A, B, C> C par(Callable<A> pA, Callable<B> pB, BiFunction<A, B, C> comb) {
		try (var executor = Executors.newFixedThreadPool(2)) {
			var p1 = executor.submit(pA);
			var p2 = executor.submit(pB);
			var r = comb.apply(p1.get(), p2.get());
			executor.shutdown();
			return r;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	static long prodP(int from, int to) {
		var middle = (from + to) / 2;
		return from == to
				? from
				: par(() -> prod(from, middle)
				, () -> prod(middle + 1, to)
				, (x, y) -> x * y);
	}

	static long fibP(int n, int d) {
		return d <= 0 || n <= 1
				? fib(n)
				: par(() -> fibP(n - 2, d - 1)
				, () -> fibP(n - 1, d - 1)
				, (x, y) -> x + y);
	}

	static <A> boolean containsWith(BT<A> t, Predicate<A> p) {
		if (t == null) return false;
		if (p.test(t.e())) return true;
		if (containsWith(t.left(), p)) return true;
		return containsWith(t.right(), p);
	}

	static <A> boolean containsWithPar(BT<A> t, Predicate<A> p) {
		if (t == null) return false;
		if (p.test(t.e())) return true;
		if (size(t) <= 2) return containsWith(t, p);
		return par(() -> containsWith(t.left(), p), () -> containsWith(t.right(), p), (x, y) -> x && y);
	}

	interface Lazy<A> {
		A eval();
	}

	static <A> A wenn(boolean b, Lazy<A> a1, Lazy<A> a2) {
		return b ? a1.eval() : a2.eval();
	}

	static <A> A wenn(boolean b, A a1, A a2) {
		return wenn(b, () -> a1, () -> a2);
	}

	static boolean implication(Lazy<Boolean> a1, Lazy<Boolean> a2) {
		return !a1.eval() || a2.eval();
	}

}