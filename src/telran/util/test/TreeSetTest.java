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

	TreeSet <Integer> treeSet;
	@BeforeEach
	@Override 
	
	void setUp() throws Exception {
		collection = new TreeSet<>();
		super.setUp();
		treeSet = (TreeSet<Integer>) collection;
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
