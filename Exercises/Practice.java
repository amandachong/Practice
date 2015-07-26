import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Practice {

	/**
	 * You're given a dictionary of strings, and a key. Check if the key is
	 * composed of an arbitrary number of concatenations of strings from the
	 * dictionary. For example:
	 * 
	 * dictionary: "world", "hello", "super", "hell"
	 * 
	 * key: "helloworld" --> return true
	 * 
	 * key: "superman" --> return false
	 * 
	 * key: "hellohello" --> return true
	 */
	public boolean isConcatinationOfDictionary(String[] dictionary, String key) {
		return true;
	}

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

	// Given a string (1-d array) , find if there is any sub-sequence that
	// repeats itself.
	// Here, sub-sequence can be a non-contiguous pattern, with the same
	// relative order.
	//
	// Eg:
	//
	// 1. abab <------yes, ab is repeated
	// 2. abba <---- No, a and b follow different order
	// 3. acbdaghfb <-------- yes there is a followed by b at two places
	// 4. abcdacb <----- yes a followed by b twice
	//
	// The above should be applicable to ANY TWO (or every two) characters in
	// the string and optimum over time.
	//
	// In the sense, it should be checked for every pair of characters in the
	// string.
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public boolean isSubSequence(char[] array) {
		HashSet hashSet = new HashSet();
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
	 * Inorder traversal of binary tree recursively
	 */
	public void inOrderTraversal(Node node) {
		if (node == null)
			return;
		inOrderTraversal(node.left);
		System.out.println(node);
		inOrderTraversal(node.right);
	}

	/**
	 * Inorder traversal of binary tree iteratively
	 */
	public void traverseInorderIterative(Node node) {
		Stack stack = new Stack();
		while (node != null || !stack.isEmpty()) {
			if (node != null) {
				stack.push(node);
				node = node.left;
			} else {
				node = stack.pop();
				System.out.println(node.data);
				node = node.right;
			}
		}
	}

	// Given an integer, output all the prime factors of that integer, ex:
	// input: 6, output: 2, 3
	// input: 25, output: 5, 5
	public static ArrayList<Integer> findPrimeFactors(int number) {
		ArrayList<Integer> primeFactors = new ArrayList<Integer>();
		if (number < 2) {
			return primeFactors;
		}
		int n = number;
		for (int i = 2; i <= n; i++) {
			if (n % i == 0) {
				primeFactors.add(i);
				n /= i;
			}
		}
		if (primeFactors.size() == 0) {
			primeFactors.add(number);
		}
		return primeFactors;
	}

	public static void findFactors(int number) {
		int range = number;
		int i = 1;
		while (i < range) {
			if (number % i == 0) {
				System.out.println(i);
				if (i != number / i) {
					System.out.println(number / i);
				}
				range = number / i;
			}
			i++;
		}
	}

	/**
	 * FACEBOOK
	 * 
	 * Question: Given an integer array with distinct elements, Find/Print all
	 * triplets (a,b,c) such that a + b + c = target and a != b != c.
	 * 
	 * Example:
	 * 
	 * Array(2, -1, 0, -2, 1) Target: 0
	 * 
	 * Output: (2,0,-2) (exactly one such permutation) (-1,0,1)
	 */

	public static void findTripletsOfTarget(ArrayList<Integer> elements,
			int target) {
		HashSet elementsHashed = new HashSet<Integer>();
		elementsHashed.addAll(elements);

		HashSet triplets = new HashSet<Integer>();
		for (int i = 0; i < elements.size(); i++) {
			for (int j = i + 1; j < elements.size(); j++) {
				int k = target - elements.get(i) - elements.get(j);
				if (elementsHashed.contains(k) && k != elements.get(i)
						&& k != elements.get(j)) {
					triplets.add("" + i + j + k);
				}
			}
		}
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

	public static int maxDepth(Node node) {
		if (node == null) {
			return 0;
		}
		return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
	}

	/**
	 * Given a linked list, write a function to reverse every k nodes (where k
	 * is an input to the function).
	 * 
	 * Example:
	 * 
	 * Inputs: 1->2->3->4->5->6->7->8->NULL and k = 3
	 * 
	 * Output: 3->2->1->6->5->4->8->7->NULL.
	 * 
	 * Inputs: 1->2->3->4->5->6->7->8->NULL and k = 5
	 * 
	 * Output: 5->4->3->2->1->8->7->6->NULL.
	 */
	public static Node reverseEveryKNodes(Node head, int k) {
		if (head == null) {
			return head;
		}
		ArrayList<Node> splitNodes = new ArrayList<Node>();
		Node node = head;
		int count = 0;
		while (node.next != null) {
			node = node.next;
			if (count == k) {

			}
		}
		Node nextK = null;
		for (int i = 0; i < k; i++) {

		}
		return null;
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

	public void hanoi(int n, String src, String inter, String dest) {
		if (n == 1) {
			System.out.println("Move the disk from pole " + src + " to pole "
					+ dest + ".");
		}
		if (n >= 2) {
			hanoi(n - 1, src, dest, inter);
			System.out.println("Move the disk from pole " + src + " to pole "
					+ dest + ".");
			hanoi(n - 1, inter, src, dest);
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
	 * Assume vertices have distance initialized to INFINITE
	 */
	public void dijkstra(Vertex s) {

	}

	public boolean isTreeMirror(Node root) {
		return compareHelper(root.left, root.right);
	}

	public boolean compareHelper(Node left, Node right) {
		if (left == null && right == null) {
			return true;
		}
		if (left == right) {
			if (compareHelper(left.left, right.left)
					&& compareHelper(left.right, right.right))
				return true;
		}
		return false;
	}

	public boolean symmetric(Node root) {
		if (root == null) {
			return true;
		}
		return symmetricHelper(root.left, root.right);
	}

	public boolean symmetricHelper(Node left, Node right) {
		if (left == null && right == null) {
			return true;
		}
		if (symmetricHelper(left.left, right.right)
				&& symmetricHelper(left.right, right.left)) {
			return true;
		}
		return false;
	}

	/**
	 * Given an array of integers. Move all non-zero elements to the left of all
	 * zero elements.
	 */
	public static int[] moveZeroesLeft(int[] array) {
		for (int p = 0, i = 0; i < array.length; i++) {
			if (array[i] == 0) {
				int temp = array[i];
				array[i] = array[p];
				array[p] = temp;
				p++;
			}
		}
		return array;
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

	/**
	 * Given an array of consecutive numbers in any order with exactly one
	 * missing, find the missing number. E.g input: 2, 4, 3, 7, 6 output: 5
	 */
	public static int findMissingNumber(int[] array) {
		HashSet<Integer> set = new HashSet<Integer>();
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < array.length; i++) {
			set.add(array[i]);
			if (min > array[i]) {
				min = array[i];
			}
			if (max < array[i]) {
				max = array[i];
			}
		}

		for (int i = min; i < max; i++) {
			if (!set.contains(i)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Move the first n numbers in a 10 element array to the end.
	 * 
	 * I think the way to do it was to reverse the array and then reverse the
	 * first 10-n and then the last n.
	 */
	public static int[] reverseFirstNToEnd(int[] array, int n) {
		for (int i = 0, j = array.length - 1; i < n && i < array.length; i++, j--) {
			int temp = array[i];
			array[i] = array[j];
			array[j] = temp;
		}
		return array;
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

		int[] array = new int[] { 1, 2, 4, 0, 4, 0 };
		int[] modified = reverseFirstNToEnd(array, 3);
		for (int i = 0; i < modified.length; i++) {
			System.out.println(modified[i]);
		}
	}
}
