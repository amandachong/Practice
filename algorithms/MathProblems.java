import java.util.ArrayList;
import java.util.Arrays;

public class MathProblems {

	/**
	 * LeetCode - Reverse Integer: Reverse digits of an integer.
	 * 
	 * Example1: x = 123, return 321
	 * 
	 * Example2: x = -123, return -321
	 */
	public static int reverse(int x) {
		int reverse = 0;
		while (x != 0) {
			reverse *= 10 + (x % 10);
			x /= 10;
		}
		return reverse;
	}

	/**
	 * LeetCode – Palindrome Number
	 */
	public static boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		int div = 1;
		while (x / div >= 10) {
			div *= 10;
		}
		int left;
		int right;
		while (x > 0) {
			left = x / div;
			right = x % 10;
			if (left != right) {
				return false;
			}
			x = (x % div) / 10;
			div /= 100;
		}
		return true;
	}

	/**
	 * LeetCode – Valid Palindrome: Given a string, determine if it is a
	 * palindrome, considering only alphanumeric characters and ignoring cases.
	 * 
	 * For example, "Red rum, sir, is murder" is a palindrome, while
	 * "Programcreek is awesome" is not.
	 */
	public boolean isPalindrome(String s) {
		if (s == null) {
			return false;
		}
		if (s.length() <= 1) {
			return true;
		}
		s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * LeetCode – Subsets: Given a set of distinct integers, S, return all
	 * possible subsets.
	 * 
	 * Note: 1) Elements in a subset must be in non-descending order. 2) The
	 * solution set must not contain duplicate subsets.
	 */
	public static ArrayList<ArrayList<Integer>> subsets(int[] nums) {
		if (nums == null) {
			return null;
		}
		Arrays.sort(nums);
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < nums.length; i++) {
			ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
			for (ArrayList<Integer> subset : result) {
				ArrayList<Integer> add = new ArrayList<Integer>(subset);
				add.add(nums[i]);
				temp.add(add);
			}
			result.addAll(temp);
			result.add(new ArrayList<Integer>(nums[i]));
		}
		return result;
	}

	/**
	 * LeetCode - Plus One: Given a non-negative number represented as an array
	 * of digits, plus one to the number.
	 */
	public int[] plusOne(int[] digits) {
		int remainder = 1;
		for (int i = digits.length - 1; i >= 0; i--) {
			digits[i] += remainder;
			remainder = 0;
			if (digits[i] > 9) {
				digits[i] = 0;
				remainder = 1;
			} else {
				break;
			}
		}
		if (remainder != 0) {
			int[] newDigits = new int[digits.length + 1];
			for (int i = 0; i < digits.length; i++) {
				newDigits[i + 1] = digits[i];
			}
			newDigits[0] = remainder;
			return newDigits;
		}
		return digits;
	}

	public int countDigits(int n, int digit) {
		n = Math.abs(n);
		int count = 0;
		while (n != 0) {
			if ((n % 10) == digit) {
				count++;
			}
			n /= 10;
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(reverse(123));
		System.out.println(reverse(-123));
	}
}
