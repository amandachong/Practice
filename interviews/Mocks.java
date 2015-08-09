import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class Mocks {

	/**
	 * Distilled problem statement: given n, find x and y so that n <= x*y <=
	 * n-2 and abs(x-y)->min. n,y,x are positive integers. There is always the
	 * (n,1) solution.
	 * 
	 * The problem is to determine the dimensions (x,y) of a grid that is as
	 * square as possible and large enough to contain n elements with no more
	 * than 2 empty spaces. Orientation of the grid does not matter (tall vs
	 * wide)
	 * 
	 * Examples: n=4 x = 2, y=2 0 empty spaces
	 * 
	 * n=17 x=6, y=3 1 empty spaces square, better than other options with fewer
	 * empty spaces (x=6, y=4)
	 */
	public static void calculateDimensions(int n) {
		int x = (int) Math.sqrt(n);
		if (x * x != n) {
			x++;
		}
		int y = x;
		while (x * y > n + 2) {
			x--;
			y = (n + x - 1) / x; // (int) Math.ceil((double) n / x)
		}
		System.out.println(x + "," + y);
	}

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

		if (new String(first).equals(new String(second))) {
			return true;
		}
		return false;
	}

	/**
	 * McDonald's sells Chicken McNuggets in packages of 6, 9 or 20. Thus, it is
	 * possible, for example, to buy exactly 15 McNuggets (with one package of 6
	 * and a second package of 9), but it is not possible to buy exactly 16,
	 * since no non-negative integer combination of 6's, 9's and 20's add up to
	 * 16. Write a function that takes one argument, n, and returns True if it
	 * is possible to buy a combination of 6, 9 and 20 pack units such that the
	 * total number of Chicken McNuggets equals n, and otherwise returns False.
	 */
	public static boolean chicken(int n) {
		if (n < 0) {
			return false;
		}
		if (n % 6 == 0 || n % 9 == 0 || n % 20 == 0) {
			return true;
		}
		return chicken(n - 6) || chicken(n - 9) || chicken(n - 20);
	}

	/**
	 * A Pythagorean triplet is a set of three natural numbers, a, b and c, for
	 * which a2 + b2 = c2.
	 */
	public static void pythagoreanTriplet(int[] array) {
		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
		for (int i = 0; i < array.length; i++) {
			array[i] *= array[i];
		}
		Arrays.sort(array);
		for (int a = 0; a < array.length - 1; a++) {
			for (int b = a + 1; b < array.length; b++) {
				hashMap.put(array[a] + array[b], array[a] + ", " + array[b]);
			}
		}
		for (int i = 0; i < array.length; i++) {
			if (hashMap.containsKey(array[i])) {
				System.out.println(hashMap.get(array[i]) + ", " + array[i]);
			}
		}
	}

	/**
	 * Say you have an array for which the ith element is the price of a given
	 * stock on day i. Design an algorithm to find the maximum profit. You may
	 * complete at most k transactions.
	 */
	public static int maxProfit(int k, int[] prices) {
		if (prices.length < 2 || k <= 0) {
			return 0;
		}
		int[] local = new int[k + 1];
		int[] global = new int[k + 1];
		for (int i = 0; i < prices.length - 1; i++) {
			int diff = prices[i + 1] - prices[i];
			for (int j = k; j >= 1; j--) {
				local[j] = Math.max(global[j - 1] + Math.max(diff, 0), local[j]
						+ diff);
				global[j] = Math.max(local[j], global[j]);
			}
		}
		return global[k];
	}

	/**
	 * Trapping Rain Water: Given n non-negative integers representing an
	 * elevation map where the width of each bar is 1, compute how much water it
	 * is able to trap after raining. For example, Given
	 * [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
	 * 
	 * height[i] = Min(maxHeight(i's left), maxHeight(i's right)) - A[i]
	 */
	public int trap(int[] A) {
		int rain = 0;
		int[] leftCache = new int[A.length];
		int maxOnLeft = 0;
		for (int i = 0; i < A.length; i++) {
			leftCache[i] = maxOnLeft;
			maxOnLeft = Math.max(maxOnLeft, A[i]);
		}
		int maxOnRight = 0;
		for (int i = A.length - 1; i >= 0; i--) {
			rain += Math.max(Math.min(leftCache[i], maxOnRight) - A[i], 0);
			maxOnRight = Math.max(maxOnRight, A[i]);
		}
		return rain;
	}

	/**
	 * Plus One: Given a number represented as an array of digits, plus one to
	 * the number.
	 */
	public int[] plusOne(int[] digits) {
		if (digits.length == 0) {
			return new int[] { 1 };
		}
		digits[digits.length - 1]++;
		for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] == 10) {
				digits[i - 1]++;
				digits[i] = 0;
			} else {
				break;
			}
		}
		if (digits[0] == 10) {
			int[] ret = new int[digits.length + 1];
			for (int i = 2; i < digits.length; i++) {
				ret[i] = digits[i - 1];
			}
			ret[0] = 1;
			ret[1] = 9;
			digits = ret;
		}
		return digits;
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
		ListNode pre = new ListNode(0);
		pre.next = head;
		ListNode c0 = pre;
		while (c0.next != null && c0.next.next != null) {
			ListNode c1 = c0.next;
			ListNode c2 = c0.next.next;
			c1.next = c2.next;
			c2.next = c1;
			c0.next = c2;
			c0 = c1;
		}
		return pre.next;
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

	public static void main(String[] args) {
		calculateDimensions(4);
		System.out.println(isAnagram("abcd", "dcba"));
		System.out.println(isAnagram("red", "red deer"));
		pythagoreanTriplet(new int[] { 3, 4, 5, 6, 25 });
	}
}
