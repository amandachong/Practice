public class Mocks {

	public String keyboardDirections(String input, int col) {
		String output = "";
		int start = intValue('a');
		for (int i = 0; i < input.length(); i++) {
			int startX = start % col;
			int startY = start / col;

			int value = intValue(input.charAt(i));
			int x = value % col;
			int y = value / col;

			String letter = "L";
			if (x - startX > 0) {
				letter = "R";
			}
			for (int j = 0; j < Math.abs(x - startX); j++) {
				output += letter;
			}

			letter = "D";
			if (y - startY > 0) {
				letter = "U";
			}
			for (int j = 0; j < Math.abs(x - startX); j++) {
				output += letter;
			}
			output += "_";
			start = value;
		}
		return output;
	}

	private int intValue(char c) {
		return 0;
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
		int start = 0;
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

	public static void minSquare(int n) {
		if (n == 0) {
			return;
		}
		int sqrt = (int) Math.sqrt(n);
		if (sqrt * sqrt == n) {
			System.out.println("(" + Math.sqrt(n) + ", " + Math.sqrt(n) + ")");
		} else {
			int min = Integer.MAX_VALUE;
			int start = n;
			int end = 1;
			int x = start;
			int y = end;
			int diff = Integer.MAX_VALUE;
			while (start > end) {
				if (start % end == 0) {
					int currentMin = start * end - n;
					if (currentMin < min) {
						min = currentMin;
						x = start;
						y = end;
						diff = Math.abs(x - y);
					} else if (currentMin == min) {
						int currentDiff = Math.abs(start - end);
						if (currentDiff < diff) {
							x = start;
							y = end;
						}
					}
					start--;
					end++;
				}
			}
			System.out.println("(" + x + ", " + y + ")");
		}
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
	public TreeNode nthSmallestBinaryTree(TreeNode node) {
		return null;
	}

	public static void main(String[] args) {
		calculateDimensions(4);
		minSquare(4);
	}
}
