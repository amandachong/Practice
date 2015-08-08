import java.util.Arrays;

public class Mocks {

	/**
	 * Given some input and a keyboard, return how to navigate through the
	 * keyboard to produce the input using left, right, up and left. Accessing
	 * characters in the last row other than 'z' will cause a crash so avoid it.
	 */
	public static String keyboardDirections(String input, char[][] keyboard) {
		String output = "";
		int rows = keyboard[0].length;
		int start = intValue('a');
		for (int i = 0; i < input.length(); i++) {
			int value = intValue(input.charAt(i));

			int startX = start % rows;
			int startY = start / rows;
			int x = value % rows;
			int y = value / rows;

			if (input.charAt(i) == 'z') {
				String letter = "L";
				if (x - startX > 0) {
					letter = "R";
				}
				for (int j = 0; j < Math.abs(x - startX); j++) {
					output += letter;
				}

				letter = "U";
				if (y - startY > 0) {
					letter = "D";
				}
				for (int j = 0; j < Math.abs(y - startY); j++) {
					output += letter;
				}
			} else {
				String letter = "U";
				if (y - startY > 0) {
					letter = "D";
				}
				for (int j = 0; j < Math.abs(y - startY); j++) {
					output += letter;
				}

				letter = "L";
				if (x - startX > 0) {
					letter = "R";
				}
				for (int j = 0; j < Math.abs(x - startX); j++) {
					output += letter;
				}
			}
			output += "_";
			start = value;
		}
		return output.substring(0, output.length() - 1);
	}

	private static int intValue(char c) {
		return c - '0' - 49;
	}

	/**
	 * Given an number x, find the next largest number y such that x < y and
	 * uses the same digits as x.
	 */
	public int[] nextLargestNumber(int[] array) {
		if (array == null || array.length == 0) {
			return array;
		}

		int[] ret = array.clone();
		int end = 0;
		int num = array[0];
		for (int i = 1; i < array.length; i++) {
			if (num > array[i]) {
				end = i - 1;
				break;
			}
			num = array[i];
		}
		int temp = ret[end + 1];
		ret[end + 1] = nextBiggest(temp, array);

		for (int i = 0; i <= end; i++) {

		}
		return null;
	}

	public int nextBiggest(int n, int[] array) {
		int next = n;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > n && array[i] < next) {
				next = array[i];
			}
		}
		return next;
	}

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

	public static void main(String[] args) {
		char[][] keyboard = new char[][] { { 'a', 'b', 'c', 'd', 'e' },
				{ 'f', 'g', 'h', 'i', 'j' }, { 'k', 'l', 'm', 'n', 'o' },
				{ 'p', 'q', 'r', 's', 't' }, { 'u', 'v', 'w', 'x', 'y' },
				{ 'z' } };
		System.out.println(keyboardDirections("dog", keyboard));
		System.out.println(keyboardDirections("zed", keyboard));
		calculateDimensions(4);
		System.out.println(isAnagram("abcd", "dcba"));
		System.out.println(isAnagram("red", "red deer"));
	}
}
