public class BinarySearchTree {

	/**
	 * LeetCode – Convert Sorted Array to Binary Search Tree: Given an array
	 * where elements are sorted in ascending order, convert it to a height
	 * balanced BST.
	 */
	public static TreeNode sortedArrayToBST(int[] num) {
		if (num == null || num.length == 0) {
			return null;
		}
		return sortedArrayToBST(num, 0, num.length - 1);
	}

	public static TreeNode sortedArrayToBST(int[] num, int start, int end) {
		if (start > end) {
			return null;
		}
		int m = (start + end) / 2;
		TreeNode root = new TreeNode(num[m]);
		root.left = sortedArrayToBST(num, start, m - 1);
		root.right = sortedArrayToBST(num, m + 1, end);
		return root;
	}
}
