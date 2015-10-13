import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class Microsoft {

	/**
	 * Given string of digits like "72388" and int n, delete n characters from
	 * the sting such the resulting string contains minimal number
	 * representation. You must preserve relative position of digits.
	 * 
	 * Example: If s = "72388" and n = 2, the answer is 238.
	 */
	public String minimumValueString(String s, int n) {
		if (s == null || n < 0) {
			return null;
		}
		int minValue = 0;
		String minString = "";
		for (int i = 0; i < s.length() - n; i++) {
			String stringVal = s.substring(i, i + n);
			int intVal = Integer.parseInt(stringVal);
			if (minValue > intVal) {
				minValue = intVal;
				minString = stringVal;
			}
		}
		return minString;
	}

	/**
	 * Merge two linked lists and remove the duplicates.
	 */
	public ListNode mergeTwoListsRemoveDuplicates(ListNode a, ListNode b) {
		ListNode result = new ListNode(0);
		ListNode node = result;
		while (a != null && b != null) {
			if (a.val == b.val) { // Removes duplicates.
				b = b.next;
			} else if (a.val < b.val) {
				node.next = a;
				a = a.next;
			} else {
				node.next = b;
				b = b.next;
			}
		}
		if (a != null) {
			node.next = a;
		} else {
			node.next = b;
		}
		return result.next;
	}

	/**
	 * Find repeated elements in an array.
	 */
	public HashSet<Integer> getRepeatedElements(ArrayList<Integer> array) {
		HashSet<Integer> repeated = new HashSet<Integer>();
		HashSet<Integer> hashSet = new HashSet<Integer>();

		for (Integer i : array) {
			if (hashSet.contains(i)) {
				repeated.add(i);
			} else {
				hashSet.add(i);
			}
		}
		return repeated;
	}

	/**
	 * Reverse string except spaces. A string has mix of alphabets and spaces.
	 * Your task is to reverse the string, but preserve the positions of spaces.
	 * For example, reverse of " a if" is " f ia".
	 */
	public String reverse(String s) {
		String reverse = new StringBuilder(s).reverse().toString();
		int j = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c != ' ') {
				while (reverse.charAt(j) == ' ') {
					j++;
				}
				s = s.substring(0, i) + reverse.charAt(j) + s.substring(i + 1);
				j++;
			}
		}
		return s;
	}

	/**
	 * Write a function that takes an array of integers and a target integer and
	 * returns true if any two integers in the array add up to the target
	 * integer. After probing, it was stated that the integers are signed.
	 */
	public boolean doesAdd(ArrayList<Integer> numbers, int target) {
		HashSet<Integer> hashSet = new HashSet<Integer>();
		for (Integer n : numbers) {
			hashSet.add(n);
		}
		for (int i = 0; i < numbers.size(); i++) {
			if (hashSet.contains(target - numbers.get(i))) {
				return true;
			}
		}
		return false;
	}

	/**
	 * LeetCode - Spiral Matrix
	 * 
	 * Given a matrix of m x n elements (m rows, n columns), return all elements
	 * of the matrix in spiral order.
	 */
	public ArrayList<Integer> spiralOrder(int[][] matrix) {
		ArrayList<Integer> resultList = new ArrayList<Integer>();
		if (matrix.length > 0 && matrix[0].length > 0) {
			traverse(matrix, 0, 0, resultList);
		}
		return resultList;
	}

	public void traverse(int[][] matrix, int direction, int layer,
			ArrayList<Integer> resultList) {
		if (resultList.size() == matrix.length * matrix[0].length) {
			return;
		}

		switch (direction) {
		case 0:
			for (int j = layer; j <= matrix[0].length - layer - 1; j++) {
				resultList.add(matrix[layer][j]);
			}
			traverse(matrix, 1, layer, resultList);
			break;
		case 1:
			for (int i = layer + 1; i <= matrix.length - layer - 1; i++) {
				resultList.add(matrix[i][matrix[0].length - layer - 1]);
			}
			traverse(matrix, 2, layer, resultList);
			break;
		case 2:
			for (int j = matrix[0].length - layer - 2; j >= layer; j--) {
				resultList.add(matrix[matrix.length - layer - 1][j]);
			}
			traverse(matrix, 3, layer, resultList);
			break;
		case 3:
			for (int i = matrix.length - layer - 2; i >= layer + 1; i--) {
				resultList.add(matrix[i][layer]);
			}
			traverse(matrix, 0, layer + 1, resultList);
			break;
		}
	}

	public ListNode reverse(ListNode node) {
		Stack<ListNode> stack = new Stack<ListNode>();
		while (node != null) {
			stack.push(node);
			node = node.next;
		}
		ListNode result = new ListNode(0);
		while (!stack.isEmpty()) {
			result.next = stack.pop();
		}
		return result.next;
	}

	public ListNode reverseList(ListNode node) {
		if (node == null || node.next == null) {
			return node;
		}
		ListNode second = node.next;
		node.next = null;

		ListNode rest = reverseList(second);
		second.next = node;

		return rest;
	}

	/**
	 * Multiply 2 numbers without using * sign.
	 */
	public int multiply(int a, int b) {
		if (b == 0) {
			return 0;
		}
		if (b < 0) {
			return -multiply(a, -b);
		} else {
			return a + multiply(a, b - 1);
		}
	}
}
