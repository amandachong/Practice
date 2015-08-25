import java.util.Iterator;
import java.util.Stack;

public class BSTIterator implements Iterator<TreeNode> {

	private Stack<TreeNode> stack;

	public BSTIterator(TreeNode root) {
		stack = new Stack<TreeNode>();
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
	}

	@Override
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	@Override
	public TreeNode next() {
		TreeNode node = stack.pop();
		TreeNode result = node;
		if (node.right != null) {
			node = node.right;
			while (node != null) {
				stack.push(node);
				node = node.left;
			}
		}
		return result;
	}
}
