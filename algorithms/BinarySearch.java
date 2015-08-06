public class BinarySearch {

	public int binarySearch(int[] array, int key) {
		return binarySearch(array, key, 0, array.length - 1);
	}

	public int binarySearch(int[] array, int key, int i, int j) {
		if (j < i) {
			return -1;
		}
		int m = (i + j) / 2;
		if (key < array[m]) {
			return binarySearch(array, key, i, m - 1);
		} else if (key > array[m]) {
			return binarySearch(array, key, m + 1, j);
		}
		return m;
	}

	public int binarySearchIterative(int[] array, int key, int i, int j) {
		while (j < i) {
			int m = (i + j) / 2;
			if (key < array[m]) {
				j = m - 1;
			} else if (key > array[m]) {
				i = m + 1;
			} else {
				return m;
			}
		}
		return -1;
	}

	public TreeNode binarySearch(TreeNode root, int value) {
		while (root != null) {
			if (root.val == value) {
				break;
			} else if (value < root.val) {
				root = root.left;
			} else if (value > root.val) {
				root = root.right;
			}
		}
		return root;
	}
}
