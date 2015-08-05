public class AVLTree {

	public void rotateRight(Node a) {
		Node b = a.right;
		a.right = b.left;
		b.left = a;
		updateHeight(a);
		updateHeight(b);
		a = b;
	}

	void doubleRotateRight(Node a) {
		rotateLeft(a.right);
		rotateRight(a);
	}

	void doubleRotateLeft(Node a) {
		rotateRight(a.left);
		rotateLeft(a);
	}

	public void rotateLeft(Node a) {
		Node b = a.left;
		a.left = b.right;
		b.right = a;
		updateHeight(a);
		updateHeight(b);
		a = b;
	}

	public void updateHeight(Node a) {
		a.height = 1 + Math.max(height(a.left), height(a.right));
	}

	public boolean isBalanced(Node root) {
		return Math.abs(height(root.left) - height(root.right)) <= 1;
	}

	public int height(Node root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(height(root.left), height(root.right));
	}
}
