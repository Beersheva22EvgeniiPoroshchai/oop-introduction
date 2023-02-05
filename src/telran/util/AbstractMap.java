package telran.util;

import java.util.Iterator;

public abstract class AbstractMap<K, V> implements Map<K, V> {
	protected Set<Entry <K, V>> set;
	
	@Override
	public V put(K key, V value) {
	V res = null;
		Entry<K, V> entry = set.get(new Entry<>(key, null));
		if (entry != null) {
			res = entry.getValue();
			entry.setValue(value); 
				} else {
				set.add(new Entry<>(key, value));
		}
		return res;
	}

	@Override
	public V putIfAbsent(K key, V value) {
		V res = null;
		Entry<K, V> entry = set.get(new Entry<>(key, null));
		if (entry != null) {
			res = entry.getValue();
		} else {
			set.add(new Entry<>(key, value));
			res = null;
		}
		return res;
	}

	@Override
	public V get(K key) {
		V res = null;
		Entry<K, V> entry = set.get(new Entry<>(key, null));
		if(entry != null){
			res = entry.getValue();
		}
		return res;
	}

	@Override
	public V getOrDefault(K key, V value) {
		V res = null;
		Entry<K, V> entry = set.get(new Entry<>(key, null));
		if(entry != null){
			res = entry.getValue();
		} else {
			res = value;
		}
		return res;
	}

	@Override
	public boolean containsKey(K key) {
		return set.contains(new Entry<>(key, null));
		
	}

	@Override
	public boolean containsValue(V value) {
		boolean res = false;
		Iterator <Entry<K, V>> it = set.iterator();
		while (it.hasNext()) {
			if (it.next().getValue().equals(value)) {
				res = true;
			}
		}
		return res;
	}
	
	@Override
	public Collection<V> values() {
		Collection <V> collect = new LinkedList<>();
		set.stream().forEach(col -> collect.add(col.getValue()));
		return collect;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<K> keySet() {
		try {
			Set<K> res = set.getClass().getConstructor().newInstance();
			set.forEach(set -> res.add(set.getKey()));
			return res;
		} catch (Exception e) {
			throw new IllegalStateException();
		
		}
			
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<Entry<K, V>> entrySet() {
		try {
			Set<Entry<K, V>> res = set.getClass().getConstructor().newInstance();
			set.forEach(set -> res.add(set));
			return res;
		} catch (Exception e) {
			throw new IllegalStateException();
		
		}
	}

	@Override
	public V remove(K key) {
		V res = null;
		Entry<K, V> valForRemove = set.get(new Entry<> (key, null));
		if (valForRemove != null) {
			set.remove(valForRemove);
			res = valForRemove.getValue();
		}
	return res;
	}

}
