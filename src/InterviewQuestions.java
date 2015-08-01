import java.util.Arrays;
import java.util.HashSet;

public class InterviewQuestions {

	/**
	 * Question: Given an integer array with distinct elements, find/print all
	 * triplets (a,b,c) such that a + b + c = target and a != b != c.
	 * 
	 * Example:
	 * 
	 * Array(2, -1, 0, -2, 1) Target: 0
	 * 
	 * Output: (2,0,-2) (exactly one such permutation) (-1,0,1)
	 */
	public void printTriplets(int[] array, int target) {
		Arrays.sort(array);
		HashSet hashSet = new HashSet();
		for (int i = 0; i < array.length - 2; i++) {
			int m = i + 1;
			int u = array.length - 1;
			while (m < u) {
				int currSum = array[i] + array[m] + array[u];
				if (currSum == target) {
					System.out.println(array[i] + ", " + array[m] + ", "
							+ array[u]);
				} else if (currSum > target) {
					u--;
				} else {
					m++;
				}
			}
		}
	}
}
