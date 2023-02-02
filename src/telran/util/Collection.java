package telran.util;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;
import java.util.function.*;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;


public interface Collection <T> extends Iterable <T>{

	boolean add (T element);
	boolean remove (T pattern);
	default boolean removeIf (Predicate<T> predicate) {
		Iterator<T> it = iterator();
		int oldSize = size();
		while(it.hasNext()) {
			T obj = it.next();
			if (predicate.test(obj)) {
				it.remove();
			}
			
		}
		return oldSize > size();
		
		
	}
	
	default T[] toArray (T[] array) {
		if (array.length < size()) {
			array = Arrays.copyOf(array, size());
		}
		Iterator<T> it = iterator();
		int index = 0;
		while(it.hasNext()) { 
			array[index++] = it.next();		
		}
		Arrays.fill(array, size(), array.length, null);
		return array;
	}
	
	
	
	boolean isEmpty();
	int size();
	boolean contains(T pattern);
	
	
	default Stream<T> stream() {
		return StreamSupport.stream(this.spliterator(), false);
		}
	
	default Stream<T> parallelSrteam() {
		return StreamSupport.stream(this.spliterator(), true);
		}

	
	default T[] toArrayShuffling(T[] array) {
		T[] ar1 = toArray(array);
		T[] res = Arrays.copyOf(ar1, ar1.length);
		int[] index = {0};
		new Random().ints(0, res.length).distinct().limit(res.length).forEach(i -> res[index[0]++] = ar1[i]);
		
		return res;
	}
}		
		
		

	
	


