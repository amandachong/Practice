import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class ArrayProblems {

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
	 * Given a list of integers, return true if two of the numbers add to 12.
	 */
	public static boolean addTo12(ArrayList<Integer> numbers) {
		HashSet<Integer> hashSet = new HashSet<Integer>();
		for (Integer number : numbers) {
			if (hashSet.contains(number)) {
				return true;
			}
			hashSet.add(12 - number);
		}
		return false;
	}

	public static void testAddTo12() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(3);
		list.add(9);
		System.out.println(addTo12(list));
		list.clear();

		list.add(1);
		list.add(1);
		System.out.println(addTo12(list));
		list.clear();

		list.add(6);
		list.add(6);
		System.out.println(addTo12(list));
	}

	/**
	 * Find the contiguous subarray within an array (containing at least one
	 * number) which has the largest sum. For example, given the array
	 * [−2,1,−3,4,−1,2,1,−5,4], the contiguous subarray [4,−1,2,1] has the
	 * largest sum = 6.
	 */
	public static int maxSubArray(int[] array) {
		int[] sum = new int[array.length];
		sum[0] = array[0];
		int max = array[0];

		for (int i = 1; i < array.length; i++) {
			sum[i] = Math.max(array[i], sum[i - 1] + array[i]);
			max = Math.max(max, sum[i]);
		}
		return max;
	}

	public static void largest(int[] array) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		System.out.println(max);
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

	public void convertMatrix(int[][] matrix) {
		int[] row = new int[matrix.length];
		int[] column = new int[matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					row[i] = 1;
					row[j] = 1;
				}
			}
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (row[i] == 1 || column[j] == 1) {
					matrix[i][j] = 0;
				}
			}
		}
	}

	public static void printDuplicates(int[] array) {
		ArrayList<Integer> hash = new ArrayList<Integer>();

		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] == array[j]) {
					hash.add(array[i]);
				}
			}
		}
		for (int i = 0; i < hash.size(); i++) {
			System.out.println("Duplicates: " + hash.get(i));
		}
	}

	public static void printPairSums(int[] array, int sum) {
		Arrays.sort(array);
		int first = 0;
		int last = array.length - 1;
		while (first < last) {
			int s = array[first] + array[last];
			if (s == sum) {
				first++;
				last--;
			} else {
				if (s < sum) {
					first++;
				} else {
					last--;
				}
			}
		}
	}

	public int maxSubsequence(int[] array) {
		int sum = 0;
		int maxSum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
			if (maxSum < sum) {
				maxSum = sum;
			} else if (sum < 0) {
				sum = 0;
			}
		}
		return maxSum;
	}

	public static int[] nonZeroElements(int[] array) {
		int j = array.length - 1;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == 0) {
				while (array[j] == 0) {
					j--;
				}
				if (i > j) {
					break;
				}
				int temp = array[j];
				array[j] = array[i];
				array[i] = temp;
				j--;
			}
		}
		System.out.println(array.length - j);
		return array;
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

	public static void main(String[] args) {
		int[] array = new int[] { 1, 2, 4, 0, 4, 0 };
		int[] modified = reverseFirstNToEnd(array, 3);
		for (int i = 0; i < modified.length; i++) {
			System.out.println(modified[i]);
		}
		largest(new int[] { 5, 50, 100, 100 });
		System.out.println(nonZeroElements(new int[] { 1, 0, 2, 0, 0, 3, 4 }));
		printDuplicates(new int[] { 5, 50, 100, 100 });
	}
}
