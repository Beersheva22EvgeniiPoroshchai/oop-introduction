package telran.util;
import java.lang.reflect.Array;
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
		T[] res = array;
		ArrayList <Integer> ind = new ArrayList<>();
		new Random().ints(0,array.length).distinct().limit(array.length).forEach(ind::add);
			for (int i = 0; i < array.length; i++) {
			T temp = res[i];
			res[i] = res[ind.get(i)];
			res[ind.get(i)] = temp;	
		}
		return res;	
	}

	
	}


