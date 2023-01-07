package telran.util;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class LinkedList<T> extends AbstractCollection<T> implements List<T> {
	private static class Node<T> {
		T obj;
		Node<T> prev;
		Node<T> next;

		Node(T obj) {
			this.obj = obj;
		}
	}

	private Node<T> head;
	private Node<T> tail;


	private class LinkedListIterator implements Iterator<T> {
		Node<T> current = head;

		@Override
		public boolean hasNext() {
			return current != null;

		}

		@Override
		public T next() {
			if (!hasNext()) {
				throw new NoSuchElementException("Next element is none!");
			}
			T res = current.obj;
			current = current.next;
			return res;
		}

	}

	@Override
	public boolean add(T element) {
		Node<T> node = new Node<>(element);
		if (head == null) {
			head = tail = node;
		} else {
			tail.next = node;
			node.prev = tail;
			tail = node;
		}

		size++;
		return true;
	}

	
	@Override

	public boolean removeIf(Predicate<T> predicate) {
		Node<T> current = head;
		int oldSize = size;
		while (current != null) {
			if (predicate.test(current.obj)) {
				removeNode(current);
			}
			current = current.next;
		
		}
		return oldSize > size;

	}

	private void removeNode(Node<T> current) {
		if (current == head) {
			removeHead();
			}
		else if (current == tail) {
			removeTail();
		}
		else {
			removeMiddle(current);
			
		}
		size--;
		}


	private void removeMiddle(Node<T> current) {
		Node<T> prev = current.prev;
		Node<T> next = current.next;
		prev.next = next;
		next.prev = prev;
	}


	private void removeTail() {
		Node<T> prev = tail.prev;
		prev.next = null;
		tail = prev;
		
	}


	private void removeHead() {
		if (head.next == null) {
			head = tail = null;
			} else {
				Node <T> next = head.next;
				next.prev = null;
				head = next;
			}
		
	}


	

	@Override
	public T[] toArray(T[] ar) {
		if (ar.length < size) {
			ar = Arrays.copyOf(ar, size);
		}
		Node<T> current = head;
		for (int i = 0; i < size; i++) {
			ar[i] = current.obj;
			current = current.next;
		}
		Arrays.fill(ar, size, ar.length, null);
		return ar;
	}

	@Override
	public Iterator<T> iterator() {

		return new LinkedListIterator();
	}

	@Override
	public void add(int index, T element) {
		checkIndex(index, true);
		if (index == size) {
			add(element);
		} else if (index == 0) {
			addHead(element);
		} else {
			addMiddle(index, element);
		}

	}

	private void addMiddle(int index, T element) {
		Node<T> node = new Node<>(element);
		Node<T> nodeIndex = getNode(index);
		Node<T> nodePrev = nodeIndex.prev;
		nodePrev.next = node;
		node.prev = nodePrev;
		nodeIndex.prev = node;
		node.next = nodeIndex;
		size++;
	}

	private Node<T> getNode(int index) {

		return index < size / 2 ? getNodeFromLeft(index) : getNodeFromRight(index);
	}

	private Node<T> getNodeFromRight(int index) {
		Node<T> current = tail;
		for (int i = size - 1; i > index; i--) {
			current = current.prev;
		}
		return current;
	}

	private Node<T> getNodeFromLeft(int index) {
		Node<T> current = head;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		return current;
	}

	private void addHead(T element) {
		Node<T> node = new Node<>(element);
		node.next = head;
		head.prev = node;
		head = node;
		size++;

	}

	@Override
	public T remove(int index) {
		checkIndex(index, false);
		Node<T> removedNode = getNode(index);
		if (removedNode == null) {
			throw new IllegalStateException("removeNode in method remove is null");
		}
		removeNode(removedNode);
		return removedNode.obj;
		
	}

	
	@Override
	public int indexOf(T pattern) {
		int index = 0;
		Node<T> current = head;
		while (current != null && !isEqual(current.obj, pattern)) {
			index++;
			current = current.next;

		}
		return current != null ? index : -1;
	}

	@Override
	public int lastIndexOf(T pattern) {
		int index = size - 1;
		Node<T> current = tail;
		while (index >= 0 && !isEqual(current.obj, pattern)) {
			index--;
			current = current.prev;
		}
		return index;
	}

	@Override
	public T get(int index) {
		checkIndex(index, false);
		return getNode(index).obj;
	}

	@Override
	public void set(int index, T element) {
		checkIndex(index, false);
		Node<T> node = getNode(index);
		node.obj = element;

	}

}
