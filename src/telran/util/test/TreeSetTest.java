package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.util.LinkedList;
import telran.util.Set;
import telran.util.TreeSet;

class TreeSetTest extends SetTest {

	TreeSet<Integer> tree;
	TreeSet <Integer> treeSet;
	@BeforeEach
	@Override 
	
	void setUp() throws Exception {
		collection = new TreeSet<>();
		super.setUp();
		
		tree = (TreeSet<Integer>) collection;
		treeSet = (TreeSet<Integer>) collection;
	}
	
	@Test
	void displayRotatedTest() {
		tree.displayTreeRotated();
	}
	
	@Test
	void heightTreeSet() {
		assertEquals(4, tree.height());
	}
	
	@Test
	void widthTreeSet() {
		assertEquals(4, tree.width());
	}
	
	
	@Test
	void inversionTest() {
	tree.inversion();
	Integer expected[] = {280, 134, 120, 100, 15, 10, -5};
	Integer actual[] = new Integer[expected.length];
	int index = 0;
	for (Integer num: tree) {
		actual[index++] = num;
	}
	assertArrayEquals(expected, actual);
	assertTrue(tree.contains(280));
		
	}
	
	
	
	@Test
	void testIterator() {
		
		Set<Integer> treeSet = new TreeSet<>();
		Integer[] array = new Integer[] {2, 2, 0, 7, 1, 3, 0, 19, 12, 37, 22};
	
		Arrays.sort(array);
		Iterator <Integer> iter = treeSet.iterator();
		for (Integer i : array) {

		}

		for (Integer i : array) { 
			treeSet.add(i);
		}
		assertTrue(treeSet.contains(37));
		assertTrue(treeSet.contains(0));
		assertFalse(treeSet.contains(4));
		assertFalse(treeSet.contains(25));
	}
	
	
	

}
