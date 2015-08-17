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

	public static void main(String[] args) {
		int[] array = new int[] { 1, 2, 4, 0, 4, 0 };
		int[] modified = reverseFirstNToEnd(array, 3);
		for (int i = 0; i < modified.length; i++) {
			System.out.println(modified[i]);
		}
	}
}
