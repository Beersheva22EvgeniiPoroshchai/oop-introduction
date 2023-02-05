package telran.util;

import java.util.Objects;

import com.sun.jdi.Value;

public interface Map<K, V> {
	class Entry<K, V> implements Comparable <Entry <K, V>> {
	public V getValue() {
			return value;
		}
		public void setValue(V value) {
			this.value = value;
		}
		public K getKey() {
			return key;
		}
	@Override
		public int hashCode() {
			return Objects.hash(key);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Entry other = (Entry) obj;
			return Objects.equals(key, other.key);
		}
	private K key;
	private V value;
	@SuppressWarnings({ "unchecked" })
	@Override
	public int compareTo(Entry<K, V> o) {
	
		return ((Comparable<K>)key).compareTo(o.key);
	
	}
	public Entry(K key, V value) {
		super();
		this.key = key;
		this.value = value;
	}
	
	
	}
	/**
	 * 
	 * @param key
	 * @param value
	 * either adds new entry or updates value in the existing one
	 * @return null if new entry is added
	 * @return reference to old value if the value is updated with new value
	 */
	V put (K key, V value); 
	
	/***************************************/
	/**
	 * 
	 * @param key
	 * @param value
	 * adds new entry if entry doesn't exist 
	 * @return null if entry is added
	 * @return reference to value if entry exist
	 */
	V putIfAbsent (K key, V value);
	
	/**************************************/
	/**
	 * 
	 * @param key
	 * @return value matching a given key or null if no entry with the key 
	 */
	V get(K key);
	//return value == null ? null : value;
	
	/*****************************************/
	/**
	 * 
	 * @param key
	 * @param value
	 * @return value matching a given key or the given value (second parameter)
	 * if no entry with the key
	 */
	V getOrDefault(K key, V value);
	
	
	/*****************************************8/
	 * 
	 * @param key
	 * @return true if there is an entry with a given key otherwise false
	 */
	boolean containsKey (K key);
	
	
	/******************************************8/
	 * 
	 * @param value
	 * @return true if there is an entry with a given key otherwise false, complexity N
	 */
	boolean containsValue (V value);
	
	
	/******************************************/
	 /**
	  * 
	  * @return collection of values 
	  */
	 Collection<V> values();
	 
	 /****************************************8/
	  * 
	  * @return Set with key values 
	  */
	 Set<K> keySet(); 
	
	/*****************************************8/
	 * 
	 * @return set with entry objects (for treeMap - treeSet, for hashMap - hashSet)
	 */
	Set<Entry<K, V>> entrySet();
	
	/*****************************************8/
	 * 
	 * @param key
	 * removes entry with a given key value
	 * @return either reference to value of removed entry (removed) or null (not removed)  
	 */
	V remove(K key);
	
	
	
	
	
	
	
	
}
