import java.util.ArrayList;
import java.util.HashSet;

public class Sample {

	/**
	 * Java: You're given a very large array of char's. Write a method to remove
	 * duplicates in the array, in place. Optimize for space complexity, not
	 * time complexity.
	 */
	public void removeDuplicates(char[] array) {
		if (array == null || array.length <= 1) {
			return;
		}
	}

	/**
	 * Given a string (1-d array) , find if there is any sub-sequence that
	 * repeats itself. Here, sub-sequence can be a non-contiguous pattern, with
	 * the same relative order.
	 * 
	 * Eg:
	 * 
	 * 1. abab <------yes, ab is repeated 2. abba <---- No, a and b follow
	 * different order 3. acbdaghfb <-------- yes there is a followed by b at
	 * two places 4. abcdacb <----- yes a followed by b twice
	 * 
	 * The above should be applicable to ANY TWO (or every two) characters in
	 * the string and optimum over time.
	 * 
	 * In the sense, it should be checked for every pair of characters in the
	 * string.
	 */
	public boolean isSubSequence(char[] array) {
		HashSet<Integer> hashSet = new HashSet<Integer>();
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length - 1; j++) {
				if (hashSet.contains(array[i] + array[j])) {
					return true;
				} else {
					hashSet.add(array[i] + array[j]);
				}
			}
		}
		return false;
	}

	/**
	 * Given a start position and an target position on the grid. You can move
	 * up,down,left,right from one node to another adjacent one on the grid.
	 * However there are some walls on the grid that you cannot pass. Now find
	 * the shortest path from the start to the target.
	 * 
	 * (This is easy done by BFS)
	 * 
	 * Extend. If you can remove three walls, then what is the shortest path
	 * from start to the target.
	 */
	public void BFS(Vertex start, Vertex target) {
		// Assume all vertex.visited = false
		Queue queue = new Queue();
		start.distance = 0;
		queue.enqueue(start);
		while (!queue.isEmpty()) {
			Vertex vertex = (Vertex) queue.dequeue();
			if (vertex.visited == false) {
				vertex.visited = true;
				for (Vertex v : vertex.getAdjacentVertices()) {
					v.distance = vertex.distance + 1;
					v.previous = vertex;
					if (v == target) {
						break;
					}
					queue.enqueue(v);
				}
			}
		}
		while (target.previous != null) {
			System.out.println(target);
			target = target.previous;
		}
	}

	/**
	 * Given an array say of length 1000; Pick up every value from every 20th
	 * index and store it in a separate array. Make sure to loop through all the
	 * elements in the array. Example: newArray1 = {0, 20, 40, 60, ..};
	 * newArray2 = {1, 21,41, 61, ..};
	 */
	public int[] storeEvery20(int[] array) {
		int len = array.length;
		int[] newArray = new int[len / 20];
		for (int i = 1, j = 0; i < len; i += 20, j++) {
			newArray[j] = array[i];
		}
		return newArray;
	}

	/**
	 * Write a function to convert a string (char* that contains a number, e.g.
	 * "586") to int.
	 */
	public int stringToInt(char[] s) {
		if (s == null || s.length <= 0) {
			throw new IllegalArgumentException();
		}
		int number = 0;
		for (int i = 0; i < s.length; i++) {
			number += (s[i] - 48) * Math.pow(10, s.length - 1 - i);
		}
		return number;
	}

	// 2*45min interviews back-to-back. First interviewer asked two questions.
	//
	// Given n*m fields of O's and X's, where O=white, X=black, for example
	//
	// OOOXOOO
	// OOXXOXO
	// OXOOOXO
	//
	// Return the number of black shapes. A black shape consists of one or more
	// adjacent X's (diagonals not included). In the example, the answer is 3.
	//
	// Write code (I chose C++). What data structures would you use to store the
	// input, and what to use for the shapes? What is the runtime complexity?
	public int returnBlackShapes(int[][] fields) {
		return -1;
	}

	/**
	 * Given a keyword (ex: "abc") and a list of words (ex: "aabc", "cab",
	 * "ab"), write a function that will return all words in the list that are
	 * the same/anagrams of the keyword. In this case, "cab" would be the only
	 * word returned. Later changes to the function were added: numbers and
	 * symbols might be included in the words but were to be ignored ("ca2b"
	 * still matched "abc"), make the function not case sensitive ("A" == "a")
	 */
	public static void findSameOrAnagram(ArrayList<String> list, String keyword) {
		ArrayList<String> sameOrAnagrams = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			if (keyword.toLowerCase().equals(list.get(i).toLowerCase())) {
				sameOrAnagrams.add(keyword);
			} else if (keyword.length() == list.get(i).length()
					&& keyword.length() != 0) {
				boolean isAnagram = true;
				for (int j = 0, k = keyword.length() - 1; j < keyword.length(); j++, k--) {
					if (keyword.charAt(j) != list.get(i).charAt(k)) {
						isAnagram = false;
					}
				}
				if (isAnagram) {
					sameOrAnagrams.add(list.get(i));
				}
			}
		}
	}

	public static int maxDepth(TreeNode node) {
		if (node == null) {
			return 0;
		}
		return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
	}

	/**
	 * Reverse a linked list
	 * 
	 * Input: head -> 2 -> 3 -> 1
	 * 
	 * Output: 1 -> 3 -> 2 -> head
	 */
	public static Node reverseLinkedList(Node head, Node node) {
		if (head == null) {
			return null;
		}
		if (node == null) {
			return head;
		}
		Node n1 = head;
		Node n2 = node;
		Node temp = n2.next;
		n2.next = n1;
		n1.next = temp;
		return reverseLinkedList(n2, n1.next);
	}

	public int binarySearch(int[] array, int i, int j, int key) {
		if (j < i) {
			return -1;
		}
		int m = (i + j) / 2;
		if (key > array[m]) {
			return binarySearch(array, i, m - 1, key);
		} else if (key < array[m]) {
			return binarySearch(array, m + 1, j, key);
		} else {
			return m;
		}
	}

	/**
	 * Merge two sorted lists
	 */
	public void merge(int[] a, int n, int[] b, int m) {
		while (n > 0 && m > 0) {
			if (a[n - 1] > b[m - 1]) {
				a[n + m - 1] = a[n - 1];
				n--;
			} else {
				a[n + m - 1] = b[m - 1];
				m--;
			}
		}
		while (m > 0) {
			a[m + n - 1] = b[m - 1];
			m--;
		}
	}

	/**
	 * Find if a string is a palindrom
	 */
	public boolean isPalindrom(String s) {
		for (int i = 0, j = s.length() - 1; i < s.length() / 2; i++, j--) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * You have a sorted array containing the age of every person on Earth.
	 * 
	 * [0, 0, 0, 0, ..., 1, 1, ..., 28, 28, ..., 110, ...]
	 * 
	 * Find out how many people have each age.
	 */
	public static int bSearchAge(int[] array, int i, int j, int age) {
		if (j < i) {
			return -1;
		}
		int m = (i + j) / 2;
		if (array[m] == age && (array[m + 1] != age || m == j)) {
			return m;
		} else if (array[m] <= age) {
			return bSearchAge(array, i, m - 1, age);
		} else {
			return bSearchAge(array, m + 1, j, age);
		}
	}

	public static void main(String[] args) {
		// findFactors(20);
		// for (Integer primeFactor : findPrimeFactors(1092)) {
		// System.out.println(primeFactor);
		// }

		// int[] array = new int[] { 1, 2, 4, 0, 4, 0 };
		// int[] modified = moveZeroesLeft(array);
		// for (int i = 0; i < modified.length; i++) {
		// System.out.println(modified[i]);
		// }
	}
}
