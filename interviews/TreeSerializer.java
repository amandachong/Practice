public class TreeSerializer {

	private int DELIMETER_TOKEN = 0;

	public String serialize(TreeNode root, String out) {
		if (root == null) {
			out += DELIMETER_TOKEN;
			return out;
		} else {
			out += root.value;
		}
		out = serialize(root.left, out);
		out = serialize(root.right, out);
		return out;
	}

	public TreeNode deserialize(TreeNode root, String in) {
		int data = next(in);
		if (data == DELIMETER_TOKEN) {
			return null;
		} else {
			root.value = data;
		}
		root.left = deserialize(root.left, in);
		root.right = deserialize(root.right, in);
		return root;
	}

	/** Iterates through the string s. */
	private int next(String s) {
		return 0;
	}
}
