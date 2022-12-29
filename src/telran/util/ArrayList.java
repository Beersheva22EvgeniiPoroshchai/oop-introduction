package telran.util;

import java.util.Arrays;
import java.util.function.Predicate;

public class ArrayList<T> implements List<T> {
	
	static final int DEFAULT_CAPACITY = 16;
	
	private T[] array;
	private int size;

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
		if (indexOf(pattern) >= 0) {
		System.arraycopy(array, indexOf(pattern) + 1, array, indexOf(pattern), array.length - indexOf(pattern) - 1);
		res = true;
	}
		
		return res;
	}

	@Override
	public boolean removeIf(Predicate<T> predicate) {
		boolean res = false;
		int j = 0;
		for (int i = 0; i < array.length; i++) {
			if (predicate.test(array[i])) {
				array[i].equals(predicate);
				array[i] = array[j];
				System.arraycopy(array, j + 1, array, j, array.length - j - 1);
				res = true;
			}
		}
		
		return res;
	}


	
	@Override
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}
	

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean contains(T pattern) {
	boolean res = false;
		for (int i = 0; i < array.length; i++) {
		if (array[i].equals(pattern)) {
		res = true;
			}
	}
	return res;
	
	}
	

	@Override
	public T[] toArray(T[] ar) {
		
		if (size > ar.length) {
			reallocate();
			Arrays.fill(ar, size+1, ar.length, null);
			}
		if (size < ar.length) {
			ar[size] = null;
			
		}
		return ar;
		
	}
	

	@Override
	public void add(int index, T element) {
		if (index <= array.length - 1) {
			array[index] = element; 
			System.arraycopy(array, index, array, index + 1, array.length - index -1);
		}
		throw new IndexOutOfBoundsException();
	} 


	@Override
	public T remove(int index) {
		if (index >= 0) {
			System.arraycopy(array, index + 1, array, index, array.length - index - 1);
		}
		throw new IndexOutOfBoundsException();
	}

	@Override
	public int indexOf(T pattern) {
		int res = -1;
		int i = 0;
		while (i < array.length) {
			if (array[i] == null ? array[i] == pattern : array[i].equals(pattern)) {
			res = i;
				}
			i++;
			}
		return res; 
	}

	@Override
	public int lastIndexOf(T pattern) {
		int res = -1;
		int i = array.length;
		while (i >= 0) {
			if (array[i] == null ? array[i] == pattern : array[i].equals(pattern)) {
				res = i;
			}
			i--;
		}
		return res;
	}
	

	@Override
	public T get(int index) {
		if (index >= 0 || index <= size) {
			for (int i = 0; i < array.length; i++) {
				return (T)array[index];
			}
			
		}
	
		throw new IndexOutOfBoundsException();
	}

	@Override
	public void set(int index, T element) {
		if (index >= 0 || index <= size) {
			get(index);
		    array[index] = element;
		  
		}
		throw new IndexOutOfBoundsException();
	}
}


