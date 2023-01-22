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
			T res = current.obj;
			current = getNextCurrent(current);
			return res;
		}

	}

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
		if (removed != null && comp.compare(removed.obj, pattern) == 0) {
				if (removed.left != null && removed.right != null) {
				Node<T> youngNode = getLeastNode(removed.right);
				removed.obj = youngNode.obj;
				res = true;
				Node<T> young = youngNode.left;
				if (young == null) {
					young = youngNode.right;
				} else {
					young = youngNode.left;
				}
				Node<T> elder = youngNode.parent;
				if (elder == null) {
					root = young;
				} else {
					if (elder.left == youngNode) {
						elder.left = young;

					} else {
						elder.right = young;
					}
				}
				if (young != null) {
					young.parent = elder;
				}
			} else {
				Node<T> supYoung = removed.left;
				if (supYoung == null) {
					supYoung = removed.right;
				} else {
					supYoung = removed.left;
				}
				Node<T> supElder = removed.parent;
				if (supElder == null) {
					root = supYoung;
				} else {
					if (supElder.left == removed) {
						supElder.left = supYoung;

					} else {
						supElder.right = supYoung;
					}
				}
				if (supYoung != null) {
					supYoung.parent = supElder;
				}
			}
			size--;

		}

		return res;
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
		T res = null;
		Node<T> node = getNode(element);
		if (comp.compare(element, node.obj) != 0) {
			if (comp.compare(element, node.obj) < 0) {
				node = getYoungerPar(node);
			}
		}

		if (node != null) {
			res = node.obj;
		}

		return res;
	}

	private Node<T> getYoungerPar(Node<T> node) {
		Node<T> res = null;
		if (node.parent.right != node && node.parent != null) {
			node = node.parent;
			res = node.parent;

		}
		return res;
	}

	@Override
	public T ceiling(T element) {
		T res = null;
		Node<T> node = getNode(element);
		if (comp.compare(element, node.obj) != 0) {
			if (comp.compare(element, node.obj) > 0) {
				node = getGreaterParent(node);
			}
		}
		if (node != null) {
			res = node.obj;
		}

		return res;
	}

	@Override
	public T first() {
		return getLeastNode(root).obj;
	}

	@Override
	public T last() {
		Node<T> current = root;
		while (current.right != null)
			current = current.right;
		return current.obj;
	}

}