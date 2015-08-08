public class TreeTraversal {

	/**
	 * Find the node with the given value.
	 */
	public TreeNode find(TreeNode root, int value) {
		if (root == null) {
			return null;
		}
		if (value < root.val) {
			return find(root.left, value);
		} else if (value > root.val) {
			return find(root.right, value);
		}
		return root;
	}

	/**
	 * Find the node with the given value iteratively.
	 */
	public TreeNode iterativeFind(TreeNode root, int value) {
		while (root != null && root.val != value) {
			if (value < root.val) {
				root = root.left;
			} else if (value > root.val) {
				root = root.right;
			}
		}
		return root;
	}

	/**
	 * In order traversal.
	 */
	public void inorder(TreeNode root) {
		if (root != null) {
			inorder(root.left);
			System.out.println(root.val);
			inorder(root.right);
		}
	}

	/**
	 * Pre order traversal.
	 */
	public void preorder(TreeNode root) {
		if (root != null) {
			System.out.println(root.val);
			inorder(root.left);
			inorder(root.right);
		}
	}

	/**
	 * Pre order traversal, iteratively.
	 */
	public void preOrderRecursive(TreeNode root) {
		Stack stack = new Stack();
		if (root != null) {
			stack.push(root);
		}
		while (stack.size() > 0) {
			TreeNode node = (TreeNode) stack.pop();
			System.out.println(node.data);
			Node child = node.right;
			if (child != null) {
				stack.push(child);
			}
			child = node.left;
			if (child != null) {
				stack.push(child);
			}
		}
	}

	/**
	 * Post order traversal.
	 */
	public void postorder(TreeNode root) {
		if (root != null) {
			inorder(root.left);
			inorder(root.right);
			System.out.println(root.val);
		}
	}

	public TreeNode findLowestCommonAncestor(TreeNode root, TreeNode child1,
			TreeNode child2) {
		if (root == null || child1 == null || child2 == null) {
			return null;
		}
		return lowestCommonAncestor(root, child1.getValue(), child2.getValue());
	}

	/**
	 * Given the value of two nodes in a binary search tree, find the lowest
	 * (nearest) common ancestor. You may assume that both values already exist
	 * in the tree.
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, int value1, int value2) {
		while (root != null) {
			if (value1 < root.val && value2 < root.val) {
				root = root.left;
			} else if (value1 > root.val && value2 > root.val) {
				root = root.right;
			} else {
				return root;
			}
		}
		return null;
	}

	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}
}
