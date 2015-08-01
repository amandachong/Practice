public class TreeTraversal {

	/**
	 * Find the node with the given value.
	 */
	public Node find(Node root, int value) {
		if (root == null) {
			return null;
		}
		if (value < root.data) {
			return find(root.left, value);
		} else if (value > root.data) {
			return find(root.right, value);
		}
		return root;
	}

	/**
	 * Find the node with the given value iteratively.
	 */
	public Node iterativeFind(Node root, int value) {
		while (root != null && root.data != value) {
			if (value < root.data) {
				root = root.left;
			} else if (value > root.data) {
				root = root.right;
			}
		}
		return root;
	}

	/**
	 * In order traversal.
	 */
	public void inorder(Node root) {
		if (root != null) {
			inorder(root.left);
			System.out.println(root.data);
			inorder(root.right);
		}
	}

	/**
	 * Pre order traversal.
	 */
	public void preorder(Node root) {
		if (root != null) {
			System.out.println(root.data);
			inorder(root.left);
			inorder(root.right);
		}
	}

	/**
	 * Pre order traversal, iteratively.
	 */
	public void preOrderRecursive(Node root) {
		Stack stack = new Stack();
		if (root != null) {
			stack.push(root);
		}
		while (stack.size() > 0) {
			Node node = stack.pop();
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
	public void postorder(Node root) {
		if (root != null) {
			inorder(root.left);
			inorder(root.right);
			System.out.println(root.data);
		}
	}

	public Node findLowestCommonAncestor(Node root, Node child1, Node child2) {
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
	public Node lowestCommonAncestor(Node root, int value1, int value2) {
		while (root != null) {
			if (value1 < root.data && value2 < root.data) {
				root = root.left;
			} else if (value1 > root.data && value2 > root.data) {
				root = root.right;
			} else {
				return root;
			}
		}
		return null;
	}
}
