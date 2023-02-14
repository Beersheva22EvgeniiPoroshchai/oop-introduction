package telran.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedHashSet<T> extends AbstractCollection<T> implements Set<T> {

	private HashMap <Integer, Value<T>> map;

	private Value<T> prev;
	private Value<T> head;
	
	public LinkedHashSet() {
		map = new HashMap<Integer, Value <T>>();
		
}
	private static class Value<T> {
		
		Integer firstHash;
		Integer secHash;
		T obj;
		
		Value (T obj) {
			this.obj = obj;
		}
	}
	
	private class LinkedHashSetIterator implements Iterator<T> {

		Value<T> cur = head;
		boolean flag = false;
		int count = 0;
		
		
		@Override
		public boolean hasNext() {
			return count < size;
		}

		@Override
		public T next() {
			Value<T> val;
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			if(count != 0) {
				val = map.get(cur.secHash);
			} else {
				val = cur;
				}
			cur = val;
			count++;
			return val.obj;
		}
	}
	
	
	@Override
	public boolean add(T element) {
		boolean res = false;
		Value<T> newVal = new Value<T>(element);
		if (map.putIfAbsent(element.hashCode(), newVal) == null) {
			if (prev != null) {
				newVal.firstHash = prev.obj.hashCode();
				prev.secHash = element.hashCode();
			} else head = newVal;
			prev = newVal;
			size++;
			res = true;
				}
		return res;
	}

	@Override
	public boolean remove(T pattern) {
		boolean res = false;
		Integer patHash = pattern.hashCode();
		Value<T> oldVal = map.get(patHash);
		if (oldVal != null) {
			map.get(oldVal.firstHash).secHash = oldVal.secHash;
			map.get(oldVal.secHash).firstHash = oldVal.firstHash;
			if (map.remove(patHash) != null) {
				res = true;
				size--;
			}
		}
		return res;
	}

	@Override
	public boolean contains(T pattern) {
		return map.containsKey(pattern.hashCode());
	}

	@Override
	public Iterator<T> iterator() {
		return new LinkedHashSetIterator();
	}

	@Override
	public T get(T pattern) {
		return map.get(pattern.hashCode()).obj;
	}

}
