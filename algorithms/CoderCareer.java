public class CoderCareer {

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
}
