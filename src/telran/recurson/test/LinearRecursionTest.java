package telran.recurson.test;

import static org.junit.jupiter.api.Assertions.*;
import static telran.recurson.LinearRecursion.*;


import org.junit.jupiter.api.Test;

public class LinearRecursionTest {

	@Test
	void fTest () {
		f(6);
		
		}
	void f(int a) {
		if(a > 5) {
			f(a-1);
		}
	}
	

	@Test
	void factorialTest() {
		assertEquals(24, factorial(4));
		assertEquals(24 * 5 * 6, factorial(6));
		assertEquals(24, factorial(-4));
	}
	
	@Test
	void powerTest() {
		assertEquals(8, power(2, 3));
		assertThrowsExactly(IllegalArgumentException.class, ()-> power (1000, -1));
		assertEquals(1, power(1000, 0));
		assertEquals(-1000, power(-10, 3));
	}
	
	
	
	@Test
	void newPowerTest() {
		assertEquals(0, newPower(0, 33));
		assertEquals(9, newPower(3, 2));
		assertEquals(8, newPower(2, 3));
		assertEquals(27, newPower(3, 3));
		assertEquals(1024, newPower(4, 5));
		assertThrowsExactly(IllegalArgumentException.class, ()-> newPower (1000, -1));
		assertEquals(1, newPower(1000, 0));
		assertEquals(-1000, power(-10, 3));

		
	
		}
	
	
	@Test
	void isSubstringTest() {
	assertEquals(true, isSubstring("qwedcdsaww", "qwed", 0, 0));
	assertEquals(true, isSubstring("qwedcdsaww", "dcd", 0, 0));
	assertEquals(true, isSubstring("qwedcdsaww", "ww", 0, 0));
	assertEquals(false, isSubstring("qwedcdsaww", "trfg", 0, 0));
	
	
	}
	
	@Test
	void squareTest() {
		assertEquals(9, square(3));
		assertEquals(25, square(5));
		assertEquals(81, square(9));
		assertEquals(1, square(1));
		assertEquals(0, square(0));
		assertThrowsExactly(IllegalArgumentException.class, () -> square(-5));
		
	}
	
	
	@Test
	void sumNumArrTest() {
		
		int ar[] = {1,2,3,4,5,6};
		assertEquals(21, sum(ar));
		assertEquals(0, sum (new int[0]));
		
	}
	
	@Test
	void reverseTest() {
		int ar[] = {1,2,3,4,5,6};
		int expected[] = {6,5,4,3,2,1};
		int ar1[] = {1,2,3,4,5,6, 7};
		int expected1[] = {7, 6,5,4,3,2,1};
		reverse(ar);
		reverse(ar1);
		assertArrayEquals(expected, ar);
		assertArrayEquals(expected1, ar1);
		
		
	}
	
	
}
