import java.util.Arrays;
import java.util.Stack;

public class Mocks {

	/**
	 * Write a function to find the nth smallest element in a binary search
	 * tree.
	 */
	public static TreeNode nthSmallestElement(TreeNode root, int n) {
		return nthSmallestElement(root, n, 0);
	}

	public static TreeNode nthSmallestElement(TreeNode node, int n,
			int seenSoFar) {
		if (node == null) {
			return null;
		}
		TreeNode temp = nthSmallestElement(node.left, n, seenSoFar);
		if (temp != null) {
			return temp;
		}
		seenSoFar++;
		if (seenSoFar == n) {
			return node;
		}
		return nthSmallestElement(node.right, n, seenSoFar);
	}

	public static boolean isAnagram(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}
		char[] first = s1.toCharArray();
		char[] second = s2.toCharArray();
		Arrays.sort(first);
		Arrays.sort(second);

		return new String(first).equals(new String(second));
	}

	/**
	 * Implement strStr(). Returns a pointer to the first occurrence of needle
	 * in haystack, or null if needle is not part of haystack.
	 */
	public String strStr(String haystack, String needle) {
		if (haystack.length() < needle.length()) {
			return null;
		}
		if (haystack.length() == 0) {
			return haystack;
		}
		for (int i = 0; i <= haystack.length() - needle.length(); i++) {
			if (haystack.substring(i, i + needle.length()).equals(needle)) {
				return haystack.substring(i);
			}
		}
		return null;
	}

	/**
	 * Pow(x, n): Implement pow(x, n). (count the value of x to the power of n).
	 */
	public double pow(double x, int n) {
		if (n == 0) {
			return 1;
		} else if (n > 0) {
			return x * pow(x, n - 1);
		} else {
			return 1 / (x * pow(x, Math.abs(n - 1)));
		}
	}

	/**
	 * Sqrt(x): Implement int sqrt(int x).
	 */
	public int sqrt(int x) {
		if (x <= 0) {
			return 0;
		}
		long l = 1;
		long r = x;
		while (l <= r) {
			long m = l + (r - 1) / 2;
			if (m * m == x) {
				return (int) m;
			}
			if (m * m < x) {
				if ((m + 1) * (m + 1) > x) {
					return (int) m;
				} else {
					l = m + 1;
				}
			} else {
				r = m - 1;
			}
		}
		return 0;
	}

	/**
	 * Unique Binary Search Trees: Given n, how many structurally unique BST's
	 * (binary search trees) that store values 1...n?
	 */
	public int numTrees(int n) {
		if (n <= 0)
			return 1;
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			int numLeft = i - 1;
			int numRight = n - i;
			sum += numTrees(numLeft) * numTrees(numRight);
		}
		return sum;
	}

	/**
	 * Swap Nodes in Pairs: Given a linked list, swap every two adjacent nodes
	 * and return its head.
	 * 
	 * For example, given 1->2->3->4, you should return the list as 2->1->4->3.
	 */
	public ListNode swapPairs(ListNode head) {
		ListNode before = new ListNode(0);
		before.next = head;
		ListNode node = before;
		while (node.next != null && node.next.next != null) {
			ListNode first = node.next;
			ListNode second = node.next.next;

			first.next = second.next;
			node.next = second;
			second.next = first;
			node = first;
		}
		return before.next;
	}

	/**
	 * Valid Parenthesis: Given a string containing just the characters '(',
	 * ')', '{', '}', '[' and ']', determine if the input string is valid. The
	 * brackets must close in the correct order, "()" and "()[]{}" are all valid
	 * but "(]" and "([)]" are not.
	 */
	public static boolean isValidParenthesis(String s) {
		if (s == null || s.length() == 0) {
			return false;
		}
		Stack<Character> stack = new Stack<Character>();
		stack.push(s.charAt(0));
		for (int i = 1; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(' || c == '[' || c == '{') {
				stack.push(c);
			} else if (!stack.isEmpty()
					&& (stack.peek() == '(' && c == ')' || stack.peek() == '['
							&& c == ']' || stack.peek() == '{' && c == '}')) {
				stack.pop();
			} else {
				return false;
			}
		}
		return stack.isEmpty();
	}

	/**
	 * Length of Last Word: Given a string s consists of upper/lower-case
	 * alphabets and empty space characters ' ', return the length of last word
	 * in the string. If the last word does not exist, return 0.
	 * 
	 * Note: A word is defined as a character sequence consists of non-space
	 * characters only.
	 * 
	 * For example, Given s = "Hello World", return 5.
	 */
	public static int lengthOfLastWord(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int front = -1;
		int end = -1;
		int index = s.length() - 1;
		while (index >= 0) {
			if (s.charAt(index) != ' ') {
				end = index;
				break;
			} else {
				index--;
			}
		}
		if (index == -1) {
			return 0;
		}
		while (index >= 0) {
			if (s.charAt(index) != ' ') {
				index--;
			} else {
				break;
			}
		}
		front = index + 1;
		return end - front + 1;
	}

	/**
	 * Reverse Integer: Reverse digits of an integer.
	 * 
	 * Example1: x = 123, return 321
	 * 
	 * Example2: x = -123, return -321
	 */
	public static int reverse(int x) {
		if (x == Integer.MIN_VALUE) {
			return 0;
		}
		if (x == 0) {
			return 0;
		}
		boolean isNegative = x < 0;
		String s = String.valueOf(x);
		String result = "";
		if (isNegative) {
			s = s.substring(1);
		}
		boolean started = false;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == '0') {
				if (started) {
					result += s.charAt(i);
				}
			} else {
				result += s.charAt(i);
				started = true;
			}
		}
		if (isNegative) {
			result = "-" + result;
		}
		return Integer.parseInt(result);
	}

	/**
	 * Sort Colors: Given an array with n objects colored red, white or blue,
	 * sort them so that objects of the same color are adjacent, with the colors
	 * in the order red, white and blue.
	 * 
	 * Here, we will use the integers 0, 1, and 2 to represent the color red,
	 * white, and blue respectively. Note: You are not suppose to use the
	 * library's sort function for this problem.
	 */
	public void sortColors(int[] array) {
		int i = 0;
		int j = array.length - 1;
		int k = 0;
		while (k <= j) {
			if (array[k] == 0) {
				swap(array, k, i);
				i++;
				k++;
			} else if (array[k] == 2) {
				swap(array, k, j);
				j--;
			} else {
				k++;
			}
		}
	}

	private void swap(int[] array, int i, int j) {
		int temp = array[j];
		array[j] = array[i];
		array[i] = temp;
	}

	/**
	 * Subsets: Given a set of distinct integers, s, return all possible
	 * subsets. Note: Elements in a subset must be in non-descending order. The
	 * solution set must not contain duplicate subsets.
	 */
	public static void subsets(int[] s) {
		int allMasks = (1 << s.length);
		for (int i = 1; i < allMasks; i++) {
			for (int j = 0; j < s.length; j++) {
				if ((i & (1 << j)) > 0) { // The j-th element is used.
					System.out.print((j + 1) + " ");
				}
			}
			System.out.println();
		}
	}

	/**
	 * Implement atoi to convert a string to an integer.
	 * 
	 * Hint: Carefully consider all possible input cases. If you want a
	 * challenge, please do not see below and ask yourself what are the possible
	 * input cases.
	 * 
	 * Notes: It is intended for this problem to be specified vaguely (ie, no
	 * given input specs). You are responsible to gather all the input
	 * requirements up front.
	 */
	public static int atoi(String s) {
		if (s == null || s.length() == 0) { // Cannot be null or have no length.
			return 0;
		}
		if (!isNumber(s.substring(1))) {
			return 0;
		}
		boolean isNegative = false;
		char c = s.charAt(0);
		if (isPrefixValid(c)) {
			isNegative = c == '-';
			if (c == '-' || c == '+') {
				s = s.substring(1);
			}
		} else {
			return 0;
		}
		int result = 0;
		int decimals = 0; // What about decimal places?
		for (int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			if (c == '.') {
				decimals++;
				if (decimals > 1) { // More than 1 decimal place is an error.
					return 0;
				}
			}
			result += (c - '0') * (int) Math.pow(10, i);
		}
		if (isNegative) {
			result = 0 - result;
		}
		return result;
	}

	/**
	 * Check if the chars of the string are valid numbers.
	 */
	private static boolean isNumber(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != '0' && s.charAt(i) != '1' && s.charAt(i) != '2'
					&& s.charAt(i) != '3' && s.charAt(i) != '4'
					&& s.charAt(i) != '5' && s.charAt(i) != '6'
					&& s.charAt(i) != '7' && s.charAt(i) != '8'
					&& s.charAt(i) != '9' && s.charAt(i) != '.') {
				return false;
			}
		}
		return true;
	}

	/**
	 * Account for if the number has no positive or negative sign.
	 */
	private static boolean isPrefixValid(char c) {
		return c == '0' || c == '1' || c == '2' || c == '3' || c == '4'
				|| c == '5' || c == '6' || c == '7' || c == '8' || c == '9'
				|| c == '.' || c == '-' || c == '+';
	}

	public static void main(String[] args) {
		System.out.println(isAnagram("abcd", "dcba"));
		System.out.println(isAnagram("red", "red deer"));
		System.out.println(lengthOfLastWord("Hello World bam!!! "));
		System.out.println(reverse(123));
		System.out.println(reverse(-123));
		System.out.println(reverse(-12300));
		subsets(new int[] { 1, 2, 3, 4, 5 });
		System.out.println(atoi("-123.0"));
	}
}
