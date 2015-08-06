public class AVLTree {

	public void rotateRight(TreeNode a) {
		TreeNode b = a.right;
		a.right = b.left;
		b.left = a;
		updateHeight(a);
		updateHeight(b);
		a = b;
	}

	void doubleRotateRight(TreeNode a) {
		rotateLeft(a.right);
		rotateRight(a);
	}

	void doubleRotateLeft(TreeNode a) {
		rotateRight(a.left);
		rotateLeft(a);
	}

	public void rotateLeft(TreeNode a) {
		TreeNode b = a.left;
		a.left = b.right;
		b.right = a;
		updateHeight(a);
		updateHeight(b);
		a = b;
	}

	public void updateHeight(TreeNode a) {
		a.height = 1 + Math.max(height(a.left), height(a.right));
	}

	public boolean isBalanced(TreeNode root) {
		return Math.abs(height(root.left) - height(root.right)) <= 1;
	}

	public int height(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(height(root.left), height(root.right));
	}
}
