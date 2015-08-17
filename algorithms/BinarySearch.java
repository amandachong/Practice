public class BinarySearch {

	public int binarySearch(int[] array, int key) {
		return binarySearch(array, key, 0, array.length - 1);
	}

	public int binarySearch(int[] array, int key, int i, int j) {
		if (j < i) {
			return -1;
		}
		int m = (i + j) / 2;
		if (key < array[m]) {
			return binarySearch(array, key, i, m - 1);
		} else if (key > array[m]) {
			return binarySearch(array, key, m + 1, j);
		}
		return m;
	}

	public int binarySearchIterative(int[] array, int key, int i, int j) {
		while (j < i) {
			int m = (i + j) / 2;
			if (key < array[m]) {
				j = m - 1;
			} else if (key > array[m]) {
				i = m + 1;
			} else {
				return m;
			}
		}
		return -1;
	}

	public TreeNode binarySearch(TreeNode root, int value) {
		while (root != null) {
			if (root.value == value) {
				break;
			} else if (value < root.value) {
				root = root.left;
			} else if (value > root.value) {
				root = root.right;
			}
		}
		return root;
	}

	/**
	 * No. 57 - Integer Identical to Index
	 * 
	 * Problem: Integers in an array are unique and increasingly sorted. Please
	 * write a function/method to find an integer from the array who equals to
	 * its index. For example, in the array {-3, -1, 1, 3, 5}, the number 3
	 * equals its index 3.
	 */
	public int getNumberSameAsIndex(int[] numbers) {
		if (numbers == null || numbers.length == 0) {
			return -1;
		}
		int start = 0;
		int end = numbers.length - 1;
		while (start < end) {
			int m = (start + end) / 2;
			if (numbers[m] == m) {
				return m;
			}
			if (numbers[m] > m) {
				end = m - 1;
			} else {
				start = m + 1;
			}
		}
		return -1;
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
}
