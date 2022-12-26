package telran.util;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;



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
	
	

	public static <T> int binarySearch (T[] array, T searchedNumber, Comparator <T> comp) {
		

		int left = 0;
		int right = array.length-1;
		int middle = (left + right) /2;
		
		while (left <= right && !array[middle].equals(searchedNumber))  {
			if (comp.compare(searchedNumber, array[middle]) < 0) {
				right = middle - 1;
			} else { 
				left = middle + 1;
				
			} 	middle = (left + right) / 2;
				
			}
			return left > right ? - left -1 : middle;
		
		}

	
	public static <T> T[] filter (T[] array, Predicate<T> predicate) {
		
		int countPredicate = getCountPredicate(array, predicate);
		
		T[] res = Arrays.copyOf(array, countPredicate);
		int index = 0;
		for (int i = 0; i < array.length; i++) {
			if (predicate.test(array[i])) {
				res[index++] = array[i];
			}
		}
		
			return res;
	}

	private static <T> int getCountPredicate(T[] array, Predicate<T> predicate) {
		int res = 0;
		for (T element: array) {
			if (predicate.test(element)) {      // oto davar with previous for
				res++;
			}
		}
		return res;
	}
	
	
	public static <T> T[] removeIf(T[] array, Predicate<T> predicate) {
	return filter(array, predicate.negate());
			
}
	
	
		public static <T> T[] removeRepeated (T[] array) {
		int index = 0;
		int countSameElem = 0;
		T[] sameElem = Arrays.copyOf(array, countSameElem);
		while (sameElem.length > 0) {
			T element = sameElem[0];
			Predicate <T> predicate = t -> t == element;
			sameElem = removeIf(sameElem, predicate);
			countSameElem++;
		}
		T [] temp = Arrays.copyOf(array, array.length);
		T [] res = Arrays.copyOf(array, countSameElem);
		while (temp.length > 0) {
			T element = temp[0];
			res[index++] = temp [0];
			Predicate <T> predicate = t -> t == element;
			temp = removeIf(temp, predicate);
		}
		return res;
		
}
	
	
	public static <T> boolean contains (T[] array, T pattern) {
		for (int i=0; i< array.length; i++) {
			if (array[i] == pattern) {
				return true;
			}
		}
		return false;
	}


}

	
	
	
	
	
	
	
	
	
	
	
	
	
	

	




