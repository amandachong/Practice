import java.util.ArrayList;
import java.util.HashSet;

public class Facebook {

	/**
	 * FACEBOOK
	 * 
	 * Question: Given an integer array with distinct elements, Find/Print all
	 * triplets (a,b,c) such that a + b + c = target and a != b != c.
	 * 
	 * Example:
	 * 
	 * Array(2, -1, 0, -2, 1) Target: 0
	 * 
	 * Output: (2,0,-2) (exactly one such permutation) (-1,0,1)
	 */

	public static void findTripletsOfTarget(ArrayList<Integer> elements,
			int target) {
		HashSet<Integer> elementsHashed = new HashSet<Integer>();
		elementsHashed.addAll(elements);

		HashSet<String> triplets = new HashSet<String>();
		for (int i = 0; i < elements.size(); i++) {
			for (int j = i + 1; j < elements.size(); j++) {
				int k = target - elements.get(i) - elements.get(j);
				if (elementsHashed.contains(k) && k != elements.get(i)
						&& k != elements.get(j)) {
					triplets.add("" + i + j + k);
				}
			}
		}
	}

	public boolean isTreeMirror(TreeNode root) {
		return compareHelper(root.left, root.right);
	}

	public boolean compareHelper(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true;
		}
		if (left == right) {
			if (compareHelper(left.left, right.left)
					&& compareHelper(left.right, right.right))
				return true;
		}
		return false;
	}

	public boolean symmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		return symmetricHelper(root.left, root.right);
	}

	public boolean symmetricHelper(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true;
		}
		if (symmetricHelper(left.left, right.right)
				&& symmetricHelper(left.right, right.left)) {
			return true;
		}
		return false;
	}
}
