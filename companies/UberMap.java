import java.util.TreeMap;

/**
 * Implement a map data structure using a binary search tree. It should have the
 * functions Get, Set, and Size.
 */
public class UberMap<K, V> {

	private TreeMap<K, V> treeMap;

	public UberMap() {
		treeMap = new TreeMap<K, V>();
	}

	public V get(K key) {
		return treeMap.get(key);
	}

	public void set(K key, V value) {
		treeMap.put(key, value);
	}

	public int size() {
		return treeMap.size();
	}
}
