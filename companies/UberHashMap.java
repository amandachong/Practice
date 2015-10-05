import java.util.HashMap;
import java.util.TreeMap;

/**
 * Add a third dimension of time to a hashmap so your hashmap will look
 * something like this - HashMap<K, t, V> where t is a float value. Implement
 * the get and put methods to this map. The get method should be something like
 * - map.get(K,t) which should give us the value. If t does not exists then map
 * should return the closest t' such that t' is smaller than t. For example, if
 * map contains (K,1,V1) and (K,2,V2) and the user does a get(k,1.5) then the
 * output should be v1 as 1 is the next smallest number to 1.5.
 */
public class UberHashMap<K, t, V> {

	private HashMap<K, TreeMap<t, V>> hashMap;

	public UberHashMap() {
		hashMap = new HashMap<K, TreeMap<t, V>>();
	}

	public V get(K key, t time) {
		TreeMap<t, V> treeMap = hashMap.get(key);
		if (treeMap != null) {
			return treeMap.floorEntry(time).getValue();
		}
		return null;
	}

	public void put(K key, t time, V value) {
		TreeMap<t, V> treeMap = hashMap.get(key);
		if (treeMap == null) {
			treeMap = new TreeMap<t, V>();
			treeMap.put(time, value);
			hashMap.put(key, treeMap);
		} else {
			treeMap.put(time, value);
			hashMap.put(key, treeMap);
		}
	}
}
