package telran.util;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class TreeSet<T> extends AbstractCollection<T> implements Sorted<T> {
	static private class Node<T> {
		T obj;
		Node<T> parent;
		Node<T> left;
		Node<T> right;

		Node(T obj) {
			this.obj = obj;
		}
	}

	private class TreeSetIterator implements Iterator<T> {
		Node<T> current = root;
		Node<T> prev;
		boolean flRemove = false;
		

		TreeSetIterator() {
			if (current != null) {
				current = getLeastNode(current);
			}
		}

		@Override
		public boolean hasNext() {

			return current != null;
		}

		@Override
		public T next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			flRemove = true;
			T res = current.obj;
			prev = current;
			current = getNextCurrent(current);
			return res;
		}
		
		@Override
		public void remove() {
			if(!flRemove) {
				throw new IllegalStateException();
			}
			flRemove = false;
			if(isJunction(prev)) {
				current = prev;
				
			}
			removeNode(prev);
			
			}
		
	}

	private static final String SYMBOL = " ";
	private static final int NUMBERS_SYMBOLS_PER_LEVEL = 4;

	private Node<T> root;
	private Comparator<T> comp;

	public TreeSet(Comparator<T> comp) {
		this.comp = comp;
	}

	private Node<T> getNextCurrent(Node<T> current) {

		return current.right == null ? getGreaterParent(current) : getLeastNode(current.right);
	}

	private Node<T> getGreaterParent(Node<T> current) {
		while (current.parent != null && current.parent.left != current) {
			current = current.parent;
		}
		return current.parent;
	}

	private Node<T> getLeastNode(Node<T> current) {
		while (current.left != null) {
			current = current.left;
		}
		return current;
	}

	@SuppressWarnings("unchecked")
	public TreeSet() {
		this((Comparator<T>) Comparator.naturalOrder());
	}

	@Override
	public boolean add(T element) {
		boolean res = false;
		Node<T> parent = getNode(element);
		int compRes = 0;
		if (parent == null || (compRes = comp.compare(element, parent.obj)) != 0) {
			res = true;
			size++;
			Node<T> node = new Node<>(element);
			node.parent = parent;
			if (parent == null) {
				root = node;
			} else {
				if (compRes < 0) {
					parent.left = node;
				} else {
					parent.right = node;
				}
			}
		}

		return res;
	}

	private Node<T> getNode(T element) {
		Node<T> current = root;
		Node<T> parent = null;
		int compRes;
		while (current != null && (compRes = comp.compare(element, current.obj)) != 0) {
			parent = current;
			current = compRes < 0 ? current.left : current.right;
		}
		return current == null ? parent : current;
	}

	
	
	public boolean remove(T pattern) {
		boolean res = false;
		Node<T> removed = getNode(pattern);
		if (removed != null && comp.compare(pattern, removed.obj) == 0) {
			res = true;
			removeNode(removed);
		}
		return res;
	}
			
			
			
	private void removeNode(Node<T> removed) {
		if(isJunction(removed)) {
			removeNodeJunction(removed);
			
		} else {
			removeNodeNonJunction(removed);
		}
		size--;
	}
	
		private void removeNodeNonJunction(Node<T> removed) {
		Node<T> parent = removed.parent;
		Node<T> child = removed.left == null ? removed.right : removed.left;
		if (parent == null) {
			root = child;
		} else {
			if (parent.left == removed) {
				parent.left = child;
			} else {
				parent.right = child;
			}
		}
		if (child != null) {
			child.parent = parent;
		}
		
	}

		private void removeNodeJunction(Node<T> removed) {
		Node<T> substitution = getLeastNode(removed.right);
		removed.obj = substitution.obj;
		removeNodeNonJunction(substitution);
		
	}

		private boolean isJunction(Node<T> removed) {
		return removed.left != null && removed.right != null;
	}

		
	
	@Override
	public boolean contains(T pattern) {
		Node<T> node = getNode(pattern);
		return node != null && comp.compare(pattern, node.obj) == 0;
	}

	@Override
	public Iterator<T> iterator() {

		return new TreeSetIterator();
	}

	@Override
	public T floor(T element) {
		
		return floorCeiling(element, true);
	}

	
	@Override
	public T ceiling(T element) {
		return floorCeiling(element, false);
	}
		
		
	private T floorCeiling(T element, boolean isFloor) {
		T res = null;
		int compRes = 0;
		Node<T> current = root;
		while (current != null && (compRes = comp.compare(element, current.obj)) != 0) {
			if ((compRes < 0 && !isFloor) || (compRes > 0 && isFloor)) {
				res = current.obj; 
			}
			current = compRes < 0 ? current.left : current.right; 
		}
		return current == null ? res : current.obj;
	}

	
	@Override
	public T first() {
		T res = null;
		if (root != null) {
			res = getLeastNode(root).obj;
		}
		return res; 
	}

	@Override
	public T last() {
		Node<T> current = root;
		while (current.right != null)
			current = current.right;
		return current.obj;
	}

	
	
	public void displayTreeRotated() {
		displayTreeRotated(root, 0);
	}

	private void displayTreeRotated(Node<T> root, int level) {
		if (root != null) {
			displayTreeRotated(root.right, level + 1);
			displayRoot(root, level);
			displayTreeRotated(root.left, level +1);
		}
	}

	private void displayRoot(Node<T> root, int level) {
		System.out.printf("%s%s\n", SYMBOL.repeat(NUMBERS_SYMBOLS_PER_LEVEL * level), root.obj);

		}
	
	public int height() {
		return height(root);
	}

	private int height(Node<T> root) {
		int res = 0;
		if (root != null) {
			int heightLeft = height(root.left);
			int heightRight = height(root.right);
			res = Math.max(heightLeft, heightRight) + 1;
		}
		return res;

	}
	
	
	
	public int width() {
		return width(root);
	}
	
	
	private int width(Node<T> root) {
		int res = 0;
		if (root != null) {
			if (root.left == null && root.right == null ) {
				res = 1;
			} else {
				res = width(root.left) + width(root.right);
			}
		}
		return res;
	}
		
		
	public void inversion() {
		inversion (root, 0);
		comp = comp.reversed();		
	}

	private void inversion(Node<T> current, int level) {
		if (current != null) {
			swap (current);
			inversion(current.left, level + 1);
			inversion(current.right, level + 1);
		}

		
		
	}

	private void swap(Node<T> current) {
		Node <T> tmp;
		tmp = current.left;
		current.left = current.right;
		current.right = tmp;
		
	}
	
}