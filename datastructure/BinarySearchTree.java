public class BinarySearchTree {

	public TreeNode find(TreeNode node, int key) {
		while (node != null && node.value != key) {
			if (key < node.value) {
				node = node.left;
			} else {
				node = node.right;
			}
		}
		return node;
	}

	public void insert(TreeNode root, int key) {
		TreeNode target = find(root, key);
		target = new TreeNode(key);
	}

	public void delete(TreeNode root, int key) {
		TreeNode node = find(root, key);
		if (node != null) {
			TreeNode toDelete = node;
			if (node.left == null) { // Leaf or only right child
				node = node.right;
			} else if (node.right == null) { // Only left child
				node = node.left;
			} else { // Two children
				TreeNode successor = successor(node);
				node.value = successor.value;
				toDelete = successor;
				successor = successor.right; // At most right child
			}
		}
	}

	public TreeNode successor(TreeNode root) {
		if (root == null) {
			return root;
		}
		return min(root.right);
	}

	private TreeNode min(TreeNode root) {
		if (root == null || root.left == null) {
			return root;
		}
		return min(root.left);
	}

	public TreeNode predecessor(TreeNode root) {
		if (root == null) {
			return root;
		}
		return max(root.left);
	}

	private TreeNode max(TreeNode root) {
		if (root == null || root.right == null) {
			return root;
		}
		return max(root.right);
	}
}
