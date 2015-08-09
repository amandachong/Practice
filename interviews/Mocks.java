import java.util.Arrays;

public class Mocks {

	/**
	 * Distilled problem statement: given n, find x and y so that n <= x*y <=
	 * n-2 and abs(x-y)->min. n,y,x are positive integers. There is always the
	 * (n,1) solution.
	 * 
	 * The problem is to determine the dimensions (x,y) of a grid that is as
	 * square as possible and large enough to contain n elements with no more
	 * than 2 empty spaces. Orientation of the grid does not matter (tall vs
	 * wide)
	 * 
	 * Examples: n=4 x = 2, y=2 0 empty spaces
	 * 
	 * n=17 x=6, y=3 1 empty spaces square, better than other options with fewer
	 * empty spaces (x=6, y=4)
	 */
	public static void calculateDimensions(int n) {
		int x = (int) Math.sqrt(n);
		if (x * x != n) {
			x++;
		}
		int y = x;
		while (x * y > n + 2) {
			x--;
			y = (n + x - 1) / x; // (int) Math.ceil((double) n / x)
		}
		System.out.println(x + "," + y);
	}

	/**
	 * Write a function to find the nth smallest element in a binary search
	 * tree.
	 */
	public static TreeNode nthSmallestElement(TreeNode root, int n) {
		return nthSmallestElement(root, n, 0);
	}

	public static TreeNode nthSmallestElement(TreeNode node, int n,
			int seenSoFar) {
		if (node == null) {
			return null;
		}
		TreeNode temp = nthSmallestElement(node.left, n, seenSoFar);
		if (temp != null) {
			return temp;
		}
		seenSoFar++;
		if (seenSoFar == n) {
			return node;
		}
		return nthSmallestElement(node.right, n, seenSoFar);
	}

	public static boolean isAnagram(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}
		char[] first = s1.toCharArray();
		char[] second = s2.toCharArray();
		Arrays.sort(first);
		Arrays.sort(second);

		if (new String(first).equals(new String(second))) {
			return true;
		}
		return false;
	}

	/**
	 * McDonald's sells Chicken McNuggets in packages of 6, 9 or 20. Thus, it is
	 * possible, for example, to buy exactly 15 McNuggets (with one package of 6
	 * and a second package of 9), but it is not possible to buy exactly 16,
	 * since no non-negative integer combination of 6's, 9's and 20's add up to
	 * 16. Write a function that takes one argument, n, and returns True if it
	 * is possible to buy a combination of 6, 9 and 20 pack units such that the
	 * total number of Chicken McNuggets equals n, and otherwise returns False.
	 */
	public static boolean chicken(int n) {
		if (n < 0) {
			return false;
		}
		if (n % 6 == 0 || n % 9 == 0 || n % 20 == 0) {
			return true;
		}
		return chicken(n - 6) || chicken(n - 9) || chicken(n - 20);
	}

	public static void main(String[] args) {
		calculateDimensions(4);
		System.out.println(isAnagram("abcd", "dcba"));
		System.out.println(isAnagram("red", "red deer"));
	}
}
