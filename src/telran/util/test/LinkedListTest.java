package telran.util.test;

import telran.util.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;

import telran.util.*;

public class LinkedListTest extends ListTest {

	LinkedList<Integer> linkedListCol;
	@BeforeEach
	@Override 
	void setUp() throws Exception {
		collection = new LinkedList<>();
		super.setUp();
		linkedListCol = (LinkedList<Integer>) collection;
	}
	
	
	@Test
	void loopTest() {
		assertFalse(linkedListCol.hasLoop());
		assertThrowsExactly(IllegalArgumentException.class, ()->linkedListCol.setNext(1,5));
		linkedListCol.setNext(5,1);
		assertTrue(linkedListCol.hasLoop());
	}
	
}








