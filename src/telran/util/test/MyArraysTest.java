package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import telran.util.*;


class MyArraysTest {
	
	String strings[] = {
			"ab", "abm", "abmb", "abmbc"
	};
	
	static final int N_NUMBERS = 10000;
	static final int N_RUNS = 1000;
	
	Integer numbers[] = {13, 2, -8, 47, 100, 10, -7, 7};
	
	

	@Test
	@Disabled
	void sortTest() {
		String[] strings = {"abcd", "lmn", "xx", "y"};
		String[] expected = {"y", "xx", "lmn", "abcd"};
		
		Integer [] ar = {3, 2, 1};
		
		
		
		MyArrays.sort (strings, new StringsLengthComparator());
		assertArrayEquals(expected, strings);
		
		MyArrays.sort(ar, (a, b) -> a - b);
	}
		
		@Test
		@Disabled
		void evenOddTest() {
		Integer numbers[] = {13, 2, -8, 47, 100, 10, -7, 7};
		Integer expected[] = {-8, 2, 10, 100, 47, 13, 7, -7};
		MyArrays.sort(numbers, new EvenOddComparator());
		assertArrayEquals(expected, numbers);
				
	}
		
		
		@Test
		@Disabled
		void binarySearchTest() {
			String strings[] = {
					"ab", "abm", "abmb", "abmbc"
			};
		
		Comparator<String> comp = new StringsComparator();
		assertEquals(0, MyArrays.binarySearch(strings, "ab", comp));
		assertEquals(2, MyArrays.binarySearch(strings, "abmb", comp));
		assertEquals(3, MyArrays.binarySearch(strings, "abmbc", comp));
		assertEquals(-1, MyArrays.binarySearch(strings, "a", comp));
		assertEquals(-3, MyArrays.binarySearch(strings, "abma", comp));
		assertEquals(-5, MyArrays.binarySearch(strings, "lmn", comp));
		

}
		
		@Test
		@Disabled
		
		void filterTest() {
			
			int ifNo = 8;
			int dividor = 2;
			String subStr = "m";
			
			Predicate<Integer> predEven = t -> t % dividor == 0;
			Predicate<String> predSubStr = s -> s.contains(subStr);
			
			Predicate<Integer> predNum = f -> !f.equals(ifNo);
			
			String expectedStr[] = {
					"abm", "abmb", "abmbc"
					};
			Integer expectedNum[] = {2, -8, 100, 10};
			
			Integer expectedNum1[] = {13, 2, -8, 47, 100, 10, -7, 7};
			
			assertArrayEquals(expectedStr, MyArrays.filter(strings, predSubStr));
			assertArrayEquals(expectedNum, MyArrays.filter(numbers, predEven));
	
		}

		@Test
		@Disabled
		void containsTest() {
			String[] strings = {"qw","asz", "bcd", "rst", "xx"};
			Integer[] numbers =  {31, 34, 29, 2, 10, 5};
			assertTrue(MyArrays.contains(strings,"qw"));
			assertTrue(MyArrays.contains(strings, "asz"));
			assertFalse(MyArrays.contains(strings,"x"));
			assertTrue(MyArrays.contains(numbers,31));
			assertTrue(MyArrays.contains(numbers,34));
			assertFalse(MyArrays.contains(numbers,8));
		
		}
		
		
		@Test
		@Disabled
		void removeIfTest() {
			int divider = 2;
			String subStr = "s";
			Predicate<Integer> predEven = t -> t % divider == 0;
			Predicate<String> predSubstr = s -> s.contains(subStr);
			String strings1[] = {
					"sd", "dss", "wed", "acvc"
			};
			Integer numbers1[] = {4, 8, 3, 16, 11, 1};
			Integer expectedNumbers[] = { 3, 11, 1 };
			String expectedStr[] =  { "wed", "acvc" };
			assertArrayEquals(expectedStr, MyArrays.removeIf (strings1, predSubstr));
			assertArrayEquals(expectedNumbers, MyArrays.removeIf (numbers1, predEven));
		
		}
		
		@Test
		@Disabled
	
		void removeRepeatTest() {
			String[] expectedStr = {"ab","abb","abd","abm"};
			String[] strings = {"ab","abb","abd","ab","abb","abm"};
			Integer[] numbers =  {1, 1, 2, 2, 1, 3, 5, 5, 4, 4, 4, 9};
			Integer[] expectedNum =  {1, 2, 3, 5, 4, 9};
			assertArrayEquals(expectedStr, MyArrays.removeRepeated(strings));
			assertArrayEquals(expectedNum, MyArrays.removeRepeated(numbers));
		}
		
	
		@Test
		@Disabled
		void joinFunctionalTest () {
			
		String expected = "13, 2, -8, 47, 100, 10, -7, 7";
		assertEquals(expected, MyArrays.join(numbers, ", "));	
			
		}
		
		@Test
		@Disabled
		void joinPerfomanceTest() {
			
			Integer largeArray[] = getLargeNumbersArray();
			for (int i=0; i< N_RUNS; i++) {
				MyArrays.join(largeArray, ", ");
			}
		}	
			
		
		Integer[] getLargeNumbersArray() {
			Integer[] res = new Integer[N_NUMBERS];
			Arrays.fill(res, 1000);
			return res;
		}
		
		
		String[] stringsList = {"q","as","asxz", "sa", "deaq"};
		String[] expectedAr = {"q","as","asxz", "sa"};
		
		@Test
		void ArrayListMethodsTest() {
			
			
			ArrayList<String> array = new ArrayList<>();
			assertTrue(array.isEmpty());
		
			for (String string : stringsList) {
			array.add(string);
		
			String subStr = "as";
			Predicate<String> predSubStr = s -> s.contains(subStr);
			array.remove(subStr);
		
			
			
			}
		}
}
			
	
		


