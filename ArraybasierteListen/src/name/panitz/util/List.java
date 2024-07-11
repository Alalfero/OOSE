

package name.panitz.util;

import java.util.NoSuchElementException;

public interface List<E> {

	int size();

	E get(int i);

	void add(E el);

	class AL<E> implements List<E> {

		private int theSize = 0;
		private Object[] store = new Object[10];

		@Override
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
			StringBuffer result = new StringBuffer("[");
			for (var i = 0; i < size(); i++) {
				if (i > 0) result.append(", ");
				result.append(store[i]);
			}
			result.append("]");
			return result.toString();
		}

		@Override
		public boolean equals(Object o) {
			if (o instanceof List that) {
				if (this.size() != that.size()) return false;
				for (int i = 0; i < size(); i++) {
					if (!this.get(i).equals(that.get(i))) return false;
				}
				return true;
			}
			return false;
		}
	}

	static <E> List<E> of() {
		return new AL<>();
	}

	@SafeVarargs
	static <E> List<E> of(E... es) {
		List<E> r = of();
		for (var e : es) r.add(e);
		return r;
	}

	default boolean isEmpty() {
		return size() == 0;
	}

	default List<E> take(int i) {
		List<E> rs = of();
		if (i <= 0) return rs;
		if (i >= this.size()) rs.addAll(this);
		else for (int j = 0; j < i; j++) rs.add(this.get(j));

		return rs;
	}

	default List<E> append(List<E> that) {
		List<E> rs = of();
		for (int i = 0; i < this.size(); i++) rs.add(this.get(i));
		for (int j = 0; j < that.size(); j++) rs.add(that.get(j));
		return rs;
	}

	default List<E> reverse() {
		List<E> list = of();
		for (int i = 0; i < this.size(); i++) list.add(this.get(this.size() - i - 1));
		return list;
	}

	default boolean contains(E el) {
		for (int i = 0; i < this.size(); i++) if (this.get(i).equals(el)) return true;
		return false;
	}

	default E last() {
		if (this.isEmpty()) throw new NoSuchElementException();
		return this.get(this.size() - 1);
	}

	default void addAll(List<E> that) {
		for (int i = 0; i < that.size(); i++) this.add(that.get(i));
	}

	default List<E> drop(int i) {
		List<E> rs = of();
		if (i >= this.size()) return rs;
		if (i <= 0) rs.addAll(this);
		else for (int j = i; j < this.size(); j++) rs.add(this.get(j));

		return rs;
	}

	default List<E> sublist(int from, int length) {
		return this.drop(from).take(length);
	}

	default List<E> intersperse(E e) {
		List<E> rs = of();
		for (int i = 0; i < this.size() - 1; i++) {
			rs.add(get(i));
			rs.add(e);
		}
		if (this.isEmpty()) return rs;
		rs.add(this.last());
		return rs;
	}

	default boolean isPrefixOf(List<E> that) {
		return this.equals(that.take(this.size()));
	}

	default boolean isSuffixOf(List<E> that) {
		return this.equals(that.drop(that.size() - this.size()));
	}

	default boolean isInfixOf(List<E> that) {
		for (int i = 0; i < that.size(); i++)
			if (this.isPrefixOf(that.drop(i))) return true;
		return false;

	}

	default List<E> rotate() {
		if (this.isEmpty()) return of();
		List<E> rs = this.drop(1);
		rs.add(this.get(0));
		return rs;
	}

	default List<List<E>> tails() {
		List<List<E>> rs = of();
		for (int i = 0; i <= this.size(); i++) rs.add(this.drop(i));
		rs.add(of());
		return rs;
	}

	record Pair<A, B>(A fst, B snd) {
		@Override
		public String toString() {
			return "(" + fst() + ", " + snd() + ")";
		}
	}

	default <B> List<Pair<E, B>> zip(List<B> that) {
		List<Pair<E, B>> rs = of();
		if (this.size() == 0 || that.size() == 0) return rs;
		if (this.size() > that.size())
			for (int i = 0; i < that.size(); i++) rs.add(new Pair<>(this.get(i), that.get(i)));
		if (this.size() < that.size())
			for (int i = 0; i < this.size(); i++) rs.add(new Pair<>(this.get(i), that.get(i)));

		return rs;
	}

}