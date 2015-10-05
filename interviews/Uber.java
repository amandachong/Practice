import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class TimeTravelingHashTable<K, V> {

	private HashMap<K, TreeMap<Integer, V>> hashMap;

	public TimeTravelingHashTable() {
		hashMap = new HashMap<K, TreeMap<Integer, V>>();
	}

	public V get(K key) {
		TreeMap<Integer, V> treeMap = hashMap.get(key);
		if (treeMap != null) {
			return treeMap.lastEntry().getValue();
		}
		return null;
	}

	public V getAt(K key, int time) {
		TreeMap<Integer, V> treeMap = hashMap.get(key);
		if (treeMap != null) {
			Map.Entry<Integer, V> entry = treeMap.floorEntry(time);
			if (entry != null) {
				return entry.getValue();
			} else {
				return null;
			}
		}
		return null;
	}

	public void set(K key, V val, int time) {
		TreeMap<Integer, V> treeMap = hashMap.get(key);
		if (treeMap == null) {
			treeMap = new TreeMap<Integer, V>();
			treeMap.put(time, val);
			hashMap.put(key, treeMap);
		} else {
			treeMap.put(time, val);
			// hashMap.put(key, treeMap);
		}
	}
}

class Solution {
	public static void main(String[] args) {
		TimeTravelingHashTable<String, String> ttht = new TimeTravelingHashTable<String, String>();
		ttht.set("foo", "A", 0);
		ttht.set("foo", "B", 10);
		ttht.set("foo", "C", 20);
		ttht.set("bar", "Z", 15);
		ttht.set("bar", "Y", 18);
		ttht.set("bar", "X", 25);

		System.out.println(ttht.get("foo")); // Prints "C"
		System.out.println(ttht.get("bar")); // Prints "X"

		System.out.println(ttht.getAt("foo", 0)); // Prints "A"
		System.out.println(ttht.getAt("bar", 0)); // Prints nothing (null)

		System.out.println(ttht.getAt("foo", 5)); // Prints "A"
		System.out.println(ttht.getAt("bar", 5)); // Prints nothing (null)

		System.out.println(ttht.getAt("foo", 10)); // Prints "B"
		System.out.println(ttht.getAt("bar", 10)); // Prints nothing (null)

		System.out.println(ttht.getAt("foo", 15)); // Prints "B"
		System.out.println(ttht.getAt("bar", 15)); // Prints "Z"

		System.out.println(ttht.getAt("foo", 20)); // Prints "C"
		System.out.println(ttht.getAt("bar", 20)); // Prints "Y"

		System.out.println(ttht.getAt("foo", 25)); // Prints "C"
		System.out.println(ttht.getAt("bar", 25)); // Prints "X"
	}
}
