/**
 * Serialize & deserialize a binary tree.
 */
public class UberTreeSerializer {

	private final String DELIMITER = "#";

	public String serialize(TreeNode root) {
		if (root == null) {
			return DELIMITER;
		}
		String s = "" + root.value;
		s += serialize(root.left);
		return s + serialize(root.right);
	}

	public TreeNode deserialize(String s) {
		if (s == null) {
			return null;
		}
		String value = s.substring(0, 1);
		if (value.equals(DELIMITER)) {
			return null;
		}
		TreeNode head = new TreeNode(Integer.parseInt(value));
		head.left = deserialize(s.substring(1));
		head.right = deserialize(s.substring(2));
		return head;
	}
}