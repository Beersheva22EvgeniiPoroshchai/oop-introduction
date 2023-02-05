package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.util.Map;
import telran.util.Map.Entry;
import telran.util.Set;

class MapTest {
Map<Integer, String> map;
	
	
	@BeforeEach
	void setUp() throws Exception {
		map.put(1, "One");
		map.put(2, "Two");
		map.put(3, "Three");
	
	}
	
	@Test
	void getTest() {
		assertEquals("One", map.get(1));
		assertNull(map.get(1000));
		}
	
	@Test
	void putTest() {
		assertEquals ("One", map.put(1, "אחד"));
		assertEquals("אחד", map.get(1));
		assertNull(map.put(4, "Four"));
		assertEquals("Four", map.get(4));		
	}
	
	
	@Test
	void getOrDefaultTest() {
		assertEquals("Three", map.getOrDefault(3, "Three"));
		map.put(5, "Five");
		assertEquals("Five", map.getOrDefault(5, "Five"));
		
		
		
	}
	
	@Test
	void putIfAbsentTest() {
		assertNull (map.putIfAbsent(6, "Six"));
		map.put(6, "666");
		assertEquals(map.get(6), map.putIfAbsent(6, "666"));
		
	}
	
	@Test
	void containsKeyTest() {
		assertTrue(map.containsKey(1));
		assertTrue(map.containsKey(3));
		assertFalse(map.containsKey(7));
	}
	
	
	@Test
	void containsValueTest() {
		assertTrue(map.containsValue("One"));
		assertTrue(map.containsValue("Three"));
		assertFalse(map.containsValue("Seven"));
	}
	
	@Test
	void collectionValuesTest() {
		String exp[] = {"One", "Two", "Three", "Ten"};
		map.put(10, "Ten");
		String ar[] = {""};
		assertArrayEquals(exp, map.values().toArray(ar));
		
	}
	
	@Test
	void keySetTest() {
		map.put(10, "Ten");
		Integer exp[] = {1, 2, 3, 10};
		Integer ar[] = {0};
		Set<Integer> set = map.keySet();
		assertArrayEquals(exp, set.toArray(ar));
	}
	
	
	@Test
	void entrySetTest() {
		Set<Entry <Integer, String>> set = map.entrySet();
		set.forEach(k -> assertTrue(map.containsKey(k.getKey())));
		set.forEach(v -> assertTrue(map.containsValue(v.getValue())));
		
		
	}
	
	@Test
	void removeTest() {
		map.put(10, "Ten");
		String exp[] = {"One", "Two"};
		assertEquals("Ten", map.remove(10));
		assertEquals("Three", map.remove(3));
		String ar[] = {""};
		assertArrayEquals(exp, map.values().toArray(ar));
		
	}
	
}
	
	
