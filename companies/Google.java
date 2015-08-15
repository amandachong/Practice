import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Google {

	/**
	 * Write a function f(a, b) which takes two character string arguments and
	 * returns a string containing only the characters found in both strings in
	 * the order of a. Write a version which is order N-squared and one which is
	 * order N.
	 */
	public static String commonChar(String a, String b) {
		if (a == null || b == null) {
			return null;
		}
		String s = "";
		HashSet<Character> hashSet = new HashSet<Character>();
		for (int i = 0; i < b.length(); i++) {
			hashSet.add(b.charAt(i));
		}
		for (int i = 0; i < a.length(); i++) {
			if (hashSet.contains(a.charAt(i))) {
				s += a.charAt(i);
			}
		}
		return s;
	}

	/**
	 * Given that you have one string of length N and M small strings of length
	 * L. How do you efficiently find the occurrence of each small string in the
	 * larger one?
	 */
	public static void findSmallStrings(String n, String[] ms, int l) {
		HashSet<String> hashSet = new HashSet<String>();
		for (int i = 0; i < n.length() - l; i++) {
			hashSet.add(n.substring(i, i + l));
		}
		for (String m : ms) {
			if (hashSet.contains(m)) {
				System.out.println(m);
			}
		}
	}

	/**
	 * Given two linked lists, return the intersection of the two lists: i.e.
	 * return a list containing only the elements that occur in both of the
	 * input lists.
	 */
	public ListNode intersection(ListNode a, ListNode b) {
		HashSet<Integer> hashSet = new HashSet<Integer>();
		while (a != null) {
			hashSet.add(a.value);
			a = a.next;
		}
		ListNode intersectionHead = null;
		ListNode intersection = intersectionHead;
		while (b != null) {
			if (hashSet.contains(b.value)) {
				if (intersection == null) {
					intersection = b;
				} else {
					intersection.next = b;
					intersection = intersection.next;
				}
				b = b.next;
			}
		}
		return intersectionHead;
	}

	/**
	 * Given a set of coin denominators, find the minimum number of coins to
	 * give a certain amount of change.
	 */
	public int minCoins(int change, int[] coins) {
		int numberOfCoins = 0;
		Arrays.sort(coins);

		return numberOfCoins;
	}

	/**
	 * You are given an array [a1 to an] and we have to construct another array
	 * [b1 To bn] where bi = a1 * a2 * … * an / ai. You are allowed to use only
	 * constant space and the time complexity is O(n). No divisions are allowed.
	 */
	public static int[] productExceptSelf(int[] array) {
		int[] result = new int[array.length];
		result[result.length - 1] = 1;
		for (int i = array.length - 2; i >= 0; i--) {
			result[i] = result[i + 1] * array[i + 1];
		}
		int left = 1;
		for (int i = 0; i < array.length; i++) {
			result[i] *= left;
			left *= array[i];
		}
		return result;
	}

	/**
	 * Same Tree: Given two binary trees, write a function to check if they are
	 * equal or not. Two binary trees are considered equal if they are
	 * structurally identical and the nodes have the same value.
	 */
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null || q == null) {
			return p == null && q == null;
		}
		return p.value == q.value && isSameTree(p.left, q.left)
				&& isSameTree(p.right, q.right);
	}

	public static void main(String[] args) {
		System.out.println(commonChar("abcdefg", "afcbedf"));
		findSmallStrings(
				"find the small strings that occurr in the big string",
				new String[] { "find", "that", "big ", "noth" }, 4);

		int[] product = productExceptSelf(new int[] { 1, 2, 3, 4, 5 });
		for (int digit : product) {
			System.out.print(digit + " ");
		}
	}

	/**
	 * You have an array of integers. Each integer in the array should be listed
	 * three times in the array. Find the integer which does not comply to that
	 * rule.
	 */
	public static int listed(int[] array, int n) {
		HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < array.length; i++) {
			if (!hashMap.containsKey(array[i])) {
				hashMap.put(array[i], 1);
			} else {
				hashMap.put(array[i], hashMap.get(array[i]) + 1);
			}
		}
		for (int key : hashMap.keySet()) {
			if (hashMap.get(key) != n) {
				return key;
			}
		}
		return -1;
	}
}
