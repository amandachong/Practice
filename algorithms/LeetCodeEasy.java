import java.util.HashSet;

public class LeetCodeEasy {

	/**
	 * LeetCode – Path Sum: Given a binary tree and a sum, determine if the tree
	 * has a root-to-leaf path such that adding up all the values along the path
	 * equals the given sum.
	 */
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		if (root.value == sum && root.left == null && root.right == null) {
			return true;
		}
		return hasPathSum(root.left, sum - root.value)
				|| hasPathSum(root.right, sum - root.value);
	}

	/**
	 * LeetCode - Contains Duplicate: Given an array of integers, find if the
	 * array contains any duplicates. Your function should return true if any
	 * value appears at least twice in the array, and it should return false if
	 * every element is distinct.
	 */
	public boolean containsDuplicate(int[] nums) {
		HashSet<Integer> hashSet = new HashSet<Integer>();
		for (int num : nums) {
			if (hashSet.contains(num)) {
				return true;
			}
			hashSet.add(num);
		}
		return false;
	}

	/**
	 * LeetCode - Remove Element: Given an array and a value, remove all
	 * instances of that value in place and return the new length.
	 */
	public int removeElement(int[] nums, int val) {
		int newLength = nums.length;
		for (int i = 0; i < newLength; i++) {
			if (nums[i] == val) {
				int temp = nums[newLength - 1];
				nums[newLength - 1] = nums[i];
				nums[i] = temp;
				newLength--;
				i--;
			}
		}
		return newLength;
	}

	/**
	 * LeetCode - String to Integer (atoi): Implement atoi to convert a string
	 * to an integer.
	 */
	public int myAtoi(String str) {
		if (str == null || str.length() < 1)
			return 0;
		str = str.trim();
		char flag = '+';
		int i = 0;
		if (str.charAt(0) == '-') {
			flag = '-';
			i++;
		} else if (str.charAt(0) == '+') {
			i++;
		}
		double result = 0;
		while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
			result = result * 10 + (str.charAt(i) - '0');
			i++;
		}
		if (flag == '-')
			result = -result;
		if (result > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
		if (result < Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
		return (int) result;
	}

	/**
	 * LeetCode - Length of Last Word: Given a string s consists of
	 * upper/lower-case alphabets and empty space characters ' ', return the
	 * length of last word in the string.
	 */
	public int lengthOfLastWord(String s) {
		if (s == null) {
			return 0;
		}
		s = s.trim();
		if (s.length() == 0) {
			return 0;
		}
		int index = s.lastIndexOf(' ');
		if (index == -1) {
			return s.length();
		}
		String lastWord = s.substring(index + 1, s.length());
		return lastWord.length();
	}

	/**
	 * LeetCode - Remove Duplicates from Sorted Array: Given a sorted array,
	 * remove the duplicates in place such that each element appear only once
	 * and return the new length.
	 */
	public int removeDuplicates(int[] nums) {
		if (nums == null) {
			return 0;
		}
		if (nums.length <= 1) {
			return nums.length;
		}
		int i = 0;
		for (int j = 0; j < nums.length; j++)
			if (nums[i] != nums[j])
				nums[++i] = nums[j];
		return i + 1;
	}

	/**
	 * LeetCode – Maximum Subarray
	 * 
	 * Find the contiguous subarray within an array (containing at least one
	 * number) which has the largest sum.
	 * 
	 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4], the contiguous
	 * subarray [4,−1,2,1] has the largest sum = 6.
	 */
	public static int maxSumSubArray(int[] array) {
		int max = array[0];
		int newSum = array[0];
		for (int i = 1; i < array.length; i++) {
			newSum = Math.max(newSum + array[i], array[i]);
			max = Math.max(max, newSum);
		}
		return max;
	}
}
