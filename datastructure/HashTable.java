import java.util.ArrayList;
import java.util.Arrays;

public class HashTable {

	private final static int TABLE_SIZE = 128;
	HashTableEntry[] table;

	public HashTable() {
		table = new HashTableEntry[TABLE_SIZE];
	}

	public HashTable(int capacity) {
		table = new HashTableEntry[capacity];
		Arrays.fill(table, null);
	}

	public void put(int key, int value) {
		table[hash(key)] = new HashTableEntry(key, value);
	}

	public int get(int key) {
		int hash = hash(key);
		while (table[hash] != null && table[hash].getKey() != key) {
			hash = (hash + 1) % table.length;
		}
		if (table[hash] == null) {
			return -1;
		}
		return table[hash].getValue();
	}

	public int find(int key) {
		int hash = hash(key);
		while (table[hash] != null && table[hash].getKey() != key) {
			hash = (hash + 1) % table.length;
		}
		if (table[hash] == null) {
			return -1;
		}
		return hash;
	}

	public void remove(int key) {
		int hash = find(key);
		if (hash != -1) {
			table[hash] = null;
		}
	}

	public int[] keys() {
		ArrayList<Integer> keys = new ArrayList<Integer>();
		for (int i = 0; i < table.length; i++) {
			if (table[i] != null) {
				keys.add(table[i].getKey());
			}
		}
		int[] ret = new int[keys.size()];
		for (int i = 0; i < keys.size(); i++) {
			ret[i] = keys.get(i);
		}
		return ret;
	}

	public int[] values() {
		ArrayList<Integer> values = new ArrayList<Integer>();
		for (int i = 0; i < table.length; i++) {
			if (table[i] != null) {
				values.add(table[i].getValue());
			}
		}
		int[] ret = new int[values.size()];
		for (int i = 0; i < values.size(); i++) {
			ret[i] = values.get(i);
		}
		return ret;
	}

	private int hash(int key) {
		return key % table.length;
	}
}
