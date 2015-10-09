import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Stack;

public class Uber {

	/**
	 * Find the kth smallest element in a BST.
	 */
	public int kthSmallestElement(TreeNode root, int k) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);

		TreeNode n = root;
		int result = 0;

		while (!stack.isEmpty() || n != null) {
			if (n != null) {
				stack.push(n);
				n = n.left;
			} else {
				TreeNode node = stack.pop();
				k--;
				if (k == 0) {
					result = node.getValue();
				}
				n = node.right;
			}
		}
		return result;
	}

	/**
	 * Search and delete nodes in BST. Delete operation is pretty tricky and you
	 * should review that.
	 */
	public TreeNode find(TreeNode root, int key) {
		if (root == null) {
			return null;
		}
		if (root.getValue() > key) {
			return find(root.left, key);
		} else if (root.getValue() < key) {
			return find(root.right, key);
		}
		return root;
	}

	public void delete(TreeNode root, int key) {

	}

	/**
	 * Given a restaurant menu and a budget, output all the possible ways to use
	 * up the budget.
	 */
	public ArrayList<Integer> budget(int[] prices, Integer budget) {
		Arrays.sort(prices);
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i <= budget; i++) {
			ArrayList<Integer> combinations = new ArrayList<Integer>();

			list.add(i, combinations);
		}

		return list.get(budget);
	}

	/**
	 * Pig latin encoding + decoding.
	 */
	public void pigLatinEncoding() {

	}

	/**
	 * Given a list of words, find whether a new word is anagram of word in
	 * list.
	 * 
	 * O(nlogn).
	 */
	public boolean isAnagram(ArrayList<String> words, String word) {
		char[] compare = word.toCharArray();
		Arrays.sort(compare);
		word = new String(compare);
		for (int i = 0; i < words.size(); i++) {
			char[] chars = words.get(i).toCharArray();
			Arrays.sort(chars);
			if (word.equals(new String(chars))) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Given a list of words, find whether a new word is anagram of word in
	 * list.
	 * 
	 * O(n).
	 */
	public boolean anagram(ArrayList<String> words, String word) {
		for (int i = 0; i < words.size(); i++) {
			Hashtable<Character, Integer> hashTable = new Hashtable<Character, Integer>();
			if (words.get(i).length() == word.length()) {
				for (char c : words.get(i).toCharArray()) {
					if (hashTable.containsKey(c)) {
						hashTable.put(c, hashTable.get(c) + 1);
					} else {
						hashTable.put(c, 1);
					}
				}
				for (char c : word.toCharArray()) {
					if (hashTable.containsKey(c)) {
						hashTable.put(c, hashTable.get(c) - 1);
					}
				}
				for (char c : hashTable.keySet()) {
					if (hashTable.get(c) != 0) {
						continue;
					}
				}
				return true;
			}
		}
		return false;
	}

	/**
	 * Input a string and output the number of words.
	 */
	public int numberOfWords(String s) {
		return 0;
	}

	/**
	 * Implement Boggle.
	 */
	public void boggle() {

	}

	/**
	 * Design a price surge system, both at a high level and the architecture.
	 */
	public int priceSurge() {
		return 0;
	}

	/**
	 * Given a regular expression pattern and a string, check to see if pattern
	 * matches the string.
	 */
	public boolean matches(String regex, String s) {
		return true;
	}

	/**
	 * Find the longest word in a grid of random letter, each consecutive
	 * letters has to be next to the previous one.
	 */
	public String longestWord(char[][] grid) {
		return null;
	}

	/**
	 * Pretend I am a 5 year old and explain what an NP-complete problem is.
	 */
}

/**
 * Using Object Oriented Design principles, design a method to check if a Sudoku
 * board is valid (skeleton code was provided which was initially passed in
 * through a 2-d array).
 */
class SudokuChecker {
	public boolean isValidSudoku(char[][] board) {
		if (board == null || board.length != 9 || board[0].length != 9)
			return false;
		// Check each column.
		for (int i = 0; i < 9; i++) {
			boolean[] m = new boolean[9];
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					if (m[(int) (board[i][j] - '1')]) {
						return false;
					}
					m[(int) (board[i][j] - '1')] = true;
				}
			}
		}
		// Check each row.
		for (int j = 0; j < 9; j++) {
			boolean[] m = new boolean[9];
			for (int i = 0; i < 9; i++) {
				if (board[i][j] != '.') {
					if (m[(int) (board[i][j] - '1')]) {
						return false;
					}
					m[(int) (board[i][j] - '1')] = true;
				}
			}
		}
		// Check each 3*3 matrix.
		for (int block = 0; block < 9; block++) {
			boolean[] m = new boolean[9];
			for (int i = block / 3 * 3; i < block / 3 * 3 + 3; i++) {
				for (int j = block % 3 * 3; j < block % 3 * 3 + 3; j++) {
					if (board[i][j] != '.') {
						if (m[(int) (board[i][j] - '1')]) {
							return false;
						}
						m[(int) (board[i][j] - '1')] = true;
					}
				}
			}
		}
		return true;
	}
}

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It
 * should support get and set operations in O(1) time.
 */
class LRUCache {
	int capacity;
	HashMap<Integer, Node> map;
	Node head = null;
	Node end = null;

	public LRUCache(int capacity) {
		map = new HashMap<Integer, Node>();
		this.capacity = capacity;
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			Node n = map.get(key);
			remove(n);
			setHead(n);
			return n.value;
		}
		return -1;
	}

	public void remove(Node n) {
		if (n.previous != null) {
			n.previous.next = n.next;
		} else {
			head = n.next;
		}

		if (n.next != null) {
			n.next.previous = n.previous;
		} else {
			end = n.previous;
		}
	}

	public void setHead(Node n) {
		n.next = head;
		n.previous = null;

		if (head != null) {
			head.previous = n;
		}

		head = n;

		if (end == null) {
			end = head;
		}
	}

	public void set(int key, int value) {
		if (map.containsKey(key)) {
			Node old = map.get(key);
			old.value = value;
			remove(old);
			setHead(old);
		} else {
			Node created = new Node(key, value);
			if (map.size() >= capacity) {
				map.remove(end.key);
				remove(end);
				setHead(created);

			} else {
				setHead(created);
			}
			map.put(key, created);
		}
	}
}

/**
 * Design an elevator - OOP.
 */
class Elevator {

	private int floor;
	private int max;
	private int min;
	private boolean closed;
	private boolean opened;

	/**
	 * Initialize an elevator with default values.
	 */
	public Elevator() {
		this.floor = 0;
		this.max = Integer.MAX_VALUE;
		this.min = Integer.MIN_VALUE;
		this.closed = true;
		this.opened = false;
	}

	public Elevator(int floor) {
		this.floor = floor;
		this.max = Integer.MAX_VALUE;
		this.min = Integer.MIN_VALUE;
		this.closed = true;
		this.opened = false;
	}

	public Elevator(int floor, int max, int min, boolean closed, boolean opened) {
		this.floor = floor;
		this.max = max;
		this.min = min;
		this.closed = closed;
		this.opened = opened;
	}

	public boolean close() {
		if (opened) {
			this.opened = false;
			this.closed = true;
			return true;
		}
		return false;
	}

	public boolean open() {
		if (closed) {
			this.closed = false;
			this.opened = true;
			return true;
		}
		return false;
	}

	public boolean up() {
		if (floor + 1 < max) {
			setFloor(this.floor + 1);
			return true;
		}
		return false;
	}

	public boolean up(int floor) {
		if (floor > min && floor < max) {
			setFloor(floor);
			return true;
		}
		return false;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}
}
