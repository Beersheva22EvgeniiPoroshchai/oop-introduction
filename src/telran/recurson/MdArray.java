package telran.recurson;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class MdArray<T> {
	private int[] dimnsn;
	private MdArray<T>[] array;
	private T value;
	public MdArray(int dimensions[], T value) {
		
		this(dimensions, 0, value);
	}

	
	@SuppressWarnings("unchecked")
	public MdArray(int[] dimensions, int firstDim, T value) {
		dimnsn = dimensions;
		if (firstDim == dimensions.length) {
			this.value = value;
			array = null;
		} else {
			this.value = null;
			array = new MdArray[dimensions[firstDim]];
			for(int i = 0; i < array.length; i++) {
				array[i] = new MdArray<>(dimensions, firstDim + 1, value);
			}
		}
		
	}
	
	
	public void forEach (Consumer<T> consumer) {
		for (MdArray<T> ar: array) {
			if (ar.array == null) {
			consumer.accept(ar.value);
			} else {
			ar.forEach(consumer);
			}
		}
	}
	
	
	
	public T[] toArray(T[] ar) {
		
		List<T> list = new ArrayList<>();
		this.forEach(numb -> list.add(numb));
		return list.toArray(ar); 
		
		
	}
	
	public T getValue (int[] ind) {
		return findMdArray(ind).value;
	}

	private MdArray<T> findMdArray(int[] ind) {
		checkInd(ind);
		MdArray<T> tmp = this;
		int i = 0;
		while (tmp.value == null) {
			if (dimnsn[i] < ind [i]) 
				throw new IndexOutOfBoundsException();
			tmp = tmp.array[ind[i++]];
		}
		return tmp;
	}
	
	
	private void checkInd (int[] ind) {
		if (dimnsn.length > ind.length) 
			throw new IllegalStateException();
		if (dimnsn.length < ind.length) 
			throw new NoSuchElementException();
		}
	
	
	public void setValue (int[] ind, T setVal) {
		findMdArray(ind).value = setVal;
	}
	
	
}
