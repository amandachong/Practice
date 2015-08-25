
/**
 * Design a data structure which should have following operations: insert, delete, random access
 */
public class GoogleHashMap {
  
  private Hashmap<Integer> hashMap;
  
  public GoogleHashMap() {
    hashMap = new Hashmap<Integer>();
  }
  
  public void insert(int x) {
    hashMap.put(x);
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

