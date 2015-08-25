import java.util.Iterator;
import java.util.Stack;

public class BSTIterator implements Iterator<TreeNode> {

	private Stack<TreeNode> stack;

	public BSTIterator(TreeNode root) {
		stack = new Stack<TreeNode>();
		inOrder(root);
	}

	@Override
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	@Override
	public TreeNode next() {
		return stack.pop();
	}

	private void inOrder(TreeNode node) {
		if (node != null) {
			inOrder(node.left);
			stack.push(node);
			inOrder(node.right);
		}
	}
}
