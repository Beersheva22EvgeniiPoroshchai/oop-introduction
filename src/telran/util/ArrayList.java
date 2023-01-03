package telran.util;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class ArrayList<T> implements List<T> {
	
	static final int DEFAULT_CAPACITY = 16;
	
	private T[] array;
	private int size;
	private class ArrayListIterator implements Iterator <T> {

		int current=0;
		
		
		@Override
		public boolean hasNext() {
		
			return current < size;
		}

		@Override
		public T next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			return array[current++];
		}
		
	}

	@SuppressWarnings("unchecked")
	public ArrayList(int capacity) {
		
	array = (T[]) new Object[capacity];
	}
	
	public ArrayList() {
	this(DEFAULT_CAPACITY);
	}
	

	@Override
	public boolean add(T element) {
		if(size == array.length) {
			reallocate();
		}
		
		array[size++] = element;
		return true;
	}

	private void reallocate() {
		array = Arrays.copyOf(array, array.length * 2);
		
	}

	@Override
	public boolean remove(T pattern) {
		boolean res = false;
		int index = indexOf(pattern);
		if (index > -1) {
			res = true;
			remove(index);
		}	
		return res;
	}

	
	
	@Override
	public boolean removeIf(Predicate<T> predicate) {
	
		int oldSize = size;
		int targInd = 0;
		for (int i = 0; i < oldSize; i++) {
			if (predicate.test(array[i])) {
				size--;
				
			}
			else {
				array[targInd++] = array[i];
			}
		}
		Arrays.fill(array, size, oldSize, null);
		
		return oldSize > size;
	}


	
	@Override
	public boolean isEmpty() {
		return size == 0; 
		}
	

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean contains(T pattern) {
	
	return indexOf(pattern) > -1;
	
	}
	

	@Override
	public T[] toArray(T[] ar) {
		
		if (size > ar.length) {
			ar = Arrays.copyOf(array, size);
		}
		System.arraycopy(array, 0, ar, 0, size);
		Arrays.fill(ar, size, ar.length, null);
		return ar;
		
	}
	
	@Override
	public void add(int index, T element) {
		checkIndex (index, true);
		if (size == array.length) {
			reallocate();
		}
			System.arraycopy(array, index, array, index + 1, size - index);
			array[index] = element; 	
			size++;
	} 


	

	@Override
	public T remove(int index) {
		checkIndex (index, true);
		T res = array[index];
		size--;
		System.arraycopy(array, index + 1, array, index, size - index);
		array[size] = null;   
		return res;
	}

	
	@Override
	public int indexOf(T pattern) {
		int index = 0;
		while (index < size && !isEqual(array[index], pattern)) {
			index++;
		}
			return index < size ? index: -1;
			}
	
		private boolean isEqual(T element, T pattern) {
		
			return element == null? element == pattern : element.equals(pattern) ;
	}
	

	@Override
	public int lastIndexOf(T pattern) {
		int index = size - 1;
		while (0 <= index && !isEqual(array[index], pattern)) {
			index--;
		}
			return index;
			}
	
	

	@Override
	public T get(int index) {
		checkIndex(index, false);   
		return array[index];
			
}
	
	
	@Override
	public void set(int index, T element) {
		checkIndex(index, false);   
		    array[index] = element;
		
	}

	
	private void checkIndex(int index, boolean sizeIncluded) {
		int sizeDelta = sizeIncluded ? 0 : 1;
		if (index < 0 || index > size - sizeDelta) {
			throw new IndexOutOfBoundsException(index);
		}
		
	}
	
	
	
	@Override
	public Iterator<T> iterator() {
		
		
		
		return new ArrayListIterator();
	}
}

