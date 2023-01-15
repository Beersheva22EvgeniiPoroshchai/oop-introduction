package telran.util;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class TreeSet<T> extends AbstractCollection<T> implements Set<T> {
static private class Node <T> {
	
	T obj;
	Node<T> parent;
	Node<T> left;
	Node<T> right;
	Node(T obj) {
		this.obj = obj;
	}
}
	private class TreeSetIterator implements Iterator<T> {
		Node <T> current = root;

		int count_iterat;
		
		
		@Override
		public boolean hasNext() {
			return count_iterat < size;
			
		}

		@Override
		public T next() {
			T res;
			if (!hasNext()) {
		throw new NoSuchElementException();
			}
			res = current.obj;
			while (current.left != null) {
				current = current.left;
			if (current.right != null) {
				current = current.right;
			} 
		}
		
			current = current.parent;
		
			count_iterat++;	
			return res;
	}
	
	}
	
	private Node<T> root;
	private Comparator<T> comp;
	public TreeSet (Comparator<T> comp) {
		this.comp = comp;
	}
	
	public TreeSet() {
		this((Comparator<T>) Comparator.naturalOrder());
	}
	
	
		public boolean add(T element) {
		boolean res = false;
		Node<T> current = root;
		if (root == null) {
			root = newElem(null, element);
			res = true;
		}
		while (!res) {
		if (comp.compare(element, current.obj) == 0) {
				return res;
			} 
	
		else if (comp.compare(element, current.obj) < 0) {
			if (current.left == null) {					
					current.left = newElem (current, element);
					res = true;
				
			} else current = current.left;
				
			} else { 
				if (current.right == null) {
					current.right = newElem (current, element);
					res = true;
			} 
				else current = current.right;
			}
	}			
		return res;
	}
	
	private Node<T> newElem (Node <T> node, T elem) {
			Node<T> parNew = new Node<>(elem);
			parNew.parent = node;
			size++;
			return parNew;
	}
		
		
		@Override
	public boolean contains(T pattern) {
			boolean res = false;
			Node <T> current = root;
		while (!res && current != null) {
		if (comp.compare(pattern, current.obj) == 0) {
			res = true;
		
		} else if (comp.compare(pattern, current.obj) < 0) {
			current = current.left;
		} else {
			current = current.right;
		}
		
	}
		return res;
		}
		
			
	@Override
	public boolean remove(T pattern) {
		// Not implemented yet 
		return false;
	}

	
	@Override
	public Iterator<T> iterator() {
		return new TreeSetIterator();
	}

}
