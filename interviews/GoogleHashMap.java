import java.util.HashMap;
import java.util.Random;

/**
 * Design a data structure which should have following operations: insert,
 * delete, random access
 */
public class GoogleHashMap {

	private HashMap<Integer, Integer> hashMap;

	public GoogleHashMap() {
		hashMap = new HashMap<Integer, Integer>();
	}

	public void insert(int x) {
		hashMap.put(hashMap.size(), x);
	}

	public void delete(int x) {
		hashMap.remove(x);
	}

	public Integer random() {
		if (!hashMap.isEmpty()) {
			Random random = new Random();
			hashMap.get(random.nextInt(hashMap.size() + 1));
		}
		return null;
	}
}
