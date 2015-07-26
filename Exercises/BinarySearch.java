public class BinarySearch {

	public int binarySearch(int[] array, int key, int i, int j) {
		if (j < i) {
			return -1;
		}
		int m = (i + j) / 2;
		if (key < array[m]) {
			return binarySearch(array, key, i, m - 1);
		} else if (key > array[m]) {
			return binarySearch(array, key, m + 1, j);
		} else {
			return m;
		}
	}

	public Node binarySearch(Node root, int value) {
		while (root != null) {
			if (root.data == value) {
				break;
			} else if (value < root.data) {
				root = root.left;
			} else if (value > root.data) {
				root = root.right;
			}
		}
		return root;
	}

	// public int binarySearch(int[] array, int key, int i, int j) {
	// if (j < i) {
	// return -1;
	// }
	// int m = (i + j) / 2;
	// if (key < array[m]) {
	// return binarySearch(array, key, i, m - 1);
	// } else if (key > array[m]) {
	// return binarySearch(array, key, m + 1, j);
	// } else {
	// return m;
	// }
	// }

}
