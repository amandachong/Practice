import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TreeTraversal {

	/**
	 * Find the node with the given value.
	 */
	public TreeNode find(TreeNode root, int value) {
		if (root == null) {
			return null;
		}
		if (value < root.value) {
			return find(root.left, value);
		} else if (value > root.value) {
			return find(root.right, value);
		}
		return root;
	}

	/**
	 * Find the node with the given value iteratively.
	 */
	public TreeNode iterativeFind(TreeNode root, int value) {
		while (root != null && root.value != value) {
			if (value < root.value) {
				root = root.left;
			} else if (value > root.value) {
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
			System.out.println(root.value);
			inorder(root.right);
		}
	}

	/**
	 * Leetcode – Binary Tree Inorder Traversal
	 * 
	 * The order of "inorder" is: left child -> parent -> right child Use a
	 * stack to track nodes Understand when to push node into the stack and when
	 * to pop node out of the stack
	 */
	public void inorderStack(TreeNode root) {
		if (root == null) {
			return;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.peek();
			if (node.left != null) {
				stack.push(node.left);
			} else {
				node = stack.pop();
				System.out.println(node.value);
				if (node.right != null) {
					stack.push(node.right);
				}
			}
		}
	}

	/**
	 * Pre order traversal.
	 */
	public void preorder(TreeNode root) {
		if (root != null) {
			System.out.println(root.value);
			inorder(root.left);
			inorder(root.right);
		}
	}

	/**
	 * Pre order traversal, iteratively.
	 */
	public void preOrderRecursive(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if (root != null) {
			stack.push(root);
		}
		while (stack.size() > 0) {
			TreeNode node = (TreeNode) stack.pop();
			System.out.println(node.value);
			TreeNode child = node.right;
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
			System.out.println(root.value);
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
			if (value1 < root.value && value2 < root.value) {
				root = root.left;
			} else if (value1 > root.value && value2 > root.value) {
				root = root.right;
			} else {
				return root;
			}
		}
		return null;
	}

	/**
	 * LeetCode - Minimum Depth of Binary Tree: Given a binary tree, find its
	 * minimum depth.
	 */
	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null) {
			return 1 + minDepth(root.right);
		}
		if (root.right == null) {
			return 1 + minDepth(root.left);
		}
		return 1 + Math.min(minDepth(root.left), minDepth(root.right));
	}

	/**
	 * LeetCode - Maximum Depth of Binary Tree: Given a binary tree, find its
	 * maximum depth.
	 */
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}

	/**
	 * LeetCode - Symmetric Tree: Given a binary tree, check whether it is a
	 * mirror of itself (ie, symmetric around its center).
	 */
	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		return isSymmetric(root.left, root.right);
	}

	private boolean isSymmetric(TreeNode l, TreeNode r) {
		if (l == null || r == null) {
			return l == null && r == null;
		}
		return l.value == r.value && isSymmetric(l.left, r.right)
				&& isSymmetric(l.right, r.left);
	}

	/**
	 * LeetCode – Path Sum: Given a binary tree and a sum, determine if the tree
	 * has a root-to-leaf path such that adding up all the values along the path
	 * equals the given sum.
	 */
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		if (root.value == sum && root.left == null && root.right == null) {
			return true;
		}
		return hasPathSum(root.left, sum - root.value)
				|| hasPathSum(root.right, sum - root.value);
	}

	/**
	 * LeetCode - Binary Tree Right Side View
	 * 
	 * Given a binary tree, imagine yourself standing on the right side of it,
	 * return the values of the nodes you can see ordered from top to bottom.
	 */
	public List<Integer> rightSideView(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();

		if (root == null) {
			return result;
		}

		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();

		while (queue.size() > 0) {
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				TreeNode top = queue.remove();

				if (i == 0) {
					result.add(top.value);
				}

				if (top.right != null) {
					queue.add(top.right);
				}

				if (top.left != null) {
					queue.add(top.left);
				}
			}
		}

		return result;
	}
}
