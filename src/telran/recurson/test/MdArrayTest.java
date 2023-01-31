package telran.recurson.test;



import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.*;

import telran.recurson.MdArray;

public class MdArrayTest {

MdArray <Integer> array;

@BeforeEach
void setUp() {
	array = new MdArray<>(new int[]{10,5,7}, 50);

}



@Test
void forEachTest() {
	
	Integer[] sum = {0};
	array.forEach(num -> sum[0] += num);
	assertEquals(17500, sum[0]);
}


@Test
void forEachTestWithString() {
	
	MdArray<String> str = new MdArray<>(new int[] {3, 15, 7, 2, 10}, "hello");
	Integer[] len = {0};
	str.forEach(st -> len[0] += st.length());
	assertEquals(31500, len[0]);
	
}



@Test
void toArrayTest() {
	Integer[] expected = new Integer[350];
	for (int  i = 0; i < expected.length; i++) {
		expected[i] = 50;
	}
assertArrayEquals(expected, array.toArray(new Integer[1]));	
	
	
}
 
@Test
void getValueTest() {
	assertThrowsExactly(IllegalStateException.class,() -> array.getValue(new int[] {7,5}));
	assertThrowsExactly(NoSuchElementException.class,() -> array.getValue(new int[] {9,5,3,1}));
	assertThrowsExactly(IndexOutOfBoundsException.class,() -> array.getValue(new int[] {9,6,3}));
	assertEquals(50, array.getValue(new int[] {7,3,6}));
	assertEquals(50, array.getValue(new int[] {0,0,0}));
	
}


@Test
void setValueTest() {
	int[]ind = new int[] {1,2,3};
	array.setValue(ind, 25);
	assertEquals(25, array.getValue(ind));	
}
	
	
}
	
	
