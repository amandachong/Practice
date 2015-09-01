public class BinarySearchTreeQuestions {

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

	/**
	 * LeetCode - Lowest Common Ancestor of a Binary Search Tree: Given a binary
	 * search tree (BST), find the lowest common ancestor (LCA) of two given
	 * nodes in the BST.
	 */
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p,
			TreeNode q) {
		if (root == null || p == null || q == null) {
			return null;
		}
		if (p.value < root.value && q.value < root.value) {
			return lowestCommonAncestor(root.left, p, q);
		}
		if (p.value > root.value && q.value > root.value) {
			return lowestCommonAncestor(root.right, p, q);
		}
		return root;
	}
}
