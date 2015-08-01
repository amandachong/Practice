import java.util.ArrayList;
import java.util.HashSet;

public class Practice {

	/**
	 * Given a list of integers, return true if two of the numbers add to 12.
	 */
	public static boolean addTo12(ArrayList<Integer> numbers) {
		HashSet hashSet = new HashSet();
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

	/**
	 * Given an array of n integers where n > 1, nums, return an array output
	 * such that output[i] is equal to the product of all the elements of nums
	 * except nums[i].
	 * 
	 * Solve it without division and in O(n).
	 * 
	 * For example, given [1,2,3,4], return [24,12,8,6].
	 */
	public static int[] productExceptSelf(int[] nums) {
		int[] output = new int[nums.length];
		for (int i = 0; i < nums.length - 1; i++) {
			output[i] = output[i + 1];
		}
		return output;
	}

	/**
	 * Convert a binary tree into a In Order traversal circular list
	 * re-purposing the node's pointers Left & Right as Previous and Next
	 * respectively.
	 * 
	 * Hint: A single node Left & Right points to itself.
	 * 
	 * Note: This is not a binary search tree.
	 */
	public static Node treeToCircle(Node tree) {
		if (tree == null) {
			return tree;
		}
		Node circle = new Node();
		circle.previous = treeToCircle(tree.left);
		circle.data = tree.data;
		circle.next = treeToCircle(tree.right);
		return circle;
	}

	public static void main(String[] args) {

	}
}
