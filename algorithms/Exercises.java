import java.util.ArrayList;
import java.util.Arrays;

public class Exercises {
	public static void main(String[] args) {
		int[] a = new int[] { 1, 0, 2, 0, 0, 3, 4 };

		System.out.println(nonZeroElements(a));

		multiplicationTable(12);

		printOddNumbers(1, 99);

		int[] intArray = new int[4];
		intArray[0] = 5;
		intArray[1] = 50;
		intArray[2] = 100;
		intArray[3] = 100;

		largest(intArray);

		printDuplicates(intArray);
		// nthElement(new Node(1), 2);

		// nthLast(new Node(1), 3);

		System.out.println(stringToInt("-1a23"));
	}

	public Node reverse(Node node) {
		Node root = node;
		Node next = node.next;
		Node nextNext = node.next.next;
		while (next != null) {
			next.next = root;
			root.next = nextNext;
			root = next;
			next = next.next;
			nextNext = nextNext.next;
		}
		return root;
	}

	public Node findMiddle(Node node) {
		Node middle = node;
		Node last = node;
		while (last != null) {
			last = last.next.next;
			middle = middle.next;
		}
		return middle;
	}

	public static void printPairSums(int[] array, int sum) {
		Arrays.sort(array);
		int first = 0;
		int last = array.length - 1;
		while (first < last) {
			int s = array[first] + array[last];
			if (s == sum) {
				first++;
				last--;
			} else {
				if (s < sum) {
					first++;
				} else {
					last--;
				}
			}
		}
	}

	public int maxSubsequence(int[] array) {
		int sum = 0;
		int maxSum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
			if (maxSum < sum) {
				maxSum = sum;
			} else if (sum < 0) {
				sum = 0;
			}
		}
		return maxSum;
	}

	public static int stringToInt(String s) {
		boolean isNegative = false;
		boolean isNumber = false;
		if (s == null) {
			return -1;
		}
		if (s.charAt(0) == '-') {
			isNegative = true;
			s = s.substring(1);
		}
		char[] chars = s.toCharArray();
		int[] ints = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		char[] intchars = new char[] { '0', '1', '2', '3', '4', '5', '6', '7',
				'8', '9' };
		int retVal = 0;
		for (int i = 0; i < chars.length; i++) {
			for (int j = 0; j < intchars.length; j++) {
				if (chars[i] == intchars[j]) {
					retVal += ints[j] * Math.pow(10, chars.length - 1 - i);
					isNumber = true;
				}
			}
			if (!isNumber)
				return -1;
			isNumber = false;
		}
		if (isNegative)
			return -retVal;
		return retVal;
	}

	public static int nthLast(Node n, int nthLast) {
		if (n == null)
			return nthLast--;
		int i = nthLast(n.next, nthLast);
		if (i == 0)
			return n.value;
		else
			return i--;
	}

	public static int nthElement(Node n, int nth) {
		if (nth == 0)
			return n.value;
		while (nth != 0) {
			n = n.next;
			nth--;
		}
		return n.value;
	}

	public static void printDuplicates(int[] array) {
		ArrayList<Integer> hash = new ArrayList<Integer>();

		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] == array[j]) {
					hash.add(array[i]);
				}
			}
		}
		for (int i = 0; i < hash.size(); i++) {
			System.out.println("Duplicates: " + hash.get(i));
		}
	}

	public static void largest(int[] array) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		System.out.println(max);
	}

	public static void printOddNumbers(int begin, int end) {
		for (int i = 1; i <= 99; i += 2) {
			System.out.println(i);
		}
	}

	public static void multiplicationTable(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.print(String.format("%4d", i * j));
			}
			System.out.println();
		}
	}

	public static int[] nonZeroElements(int[] array) {
		int j = array.length - 1;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == 0) {
				while (array[j] == 0) {
					j--;
				}
				if (i > j) {
					break;
				}
				int temp = array[j];
				array[j] = array[i];
				array[i] = temp;
				j--;
			}
		}
		System.out.println(array.length - j);
		return array;
	}
}