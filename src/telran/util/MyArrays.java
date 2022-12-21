package telran.util;

import java.util.Comparator;

public class MyArrays {

	static public <T> void sort (T[] objects, Comparator <T> comparator) {
		
		int length = objects.length;
		do {
			length--;
		} while (moveMaxAtEnd(objects, length, comparator)); 
	
	}

	private static <T> boolean moveMaxAtEnd(T[] objects, int length, Comparator<T> comp) {
		boolean res = false;
		for (int i=0; i<length; i++) {
			if (comp.compare(objects[i], objects[i+1]) > 0) {
				swap(objects, i, i+1);
				res = true;
			}
		}
		return res;
	}

	private static <T> void swap(T[] objects, int i, int j) {
		T tmp = objects[i];
		objects [i] = objects [j];
		objects [j] = tmp;
		
	}
	
	

	public static <T> T binarySearch (T[] array, T searchedNumber, Comparator <T> comp) {
		

		int left = 0;
		int right = array.length-1;
		int middle = (left + right) /2;
		
		while (!searchedNumber.equals(array[middle]) && right !=0)  {
			if (searchedNumber.equals(array[middle])) {
				return searchedNumber;
				
			} else if (comp.compare(array[middle], searchedNumber) < 0) {
				right = middle - 1;
				middle = (left + right) / 2;
				
			} else if (comp.compare(array[middle], searchedNumber) > 0) {
				left = middle + 1;
				middle = (left + right) / 2;
			}
		}
		return searchedNumber;
		
		}
}

	




