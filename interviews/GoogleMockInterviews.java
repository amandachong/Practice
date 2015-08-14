import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class GoogleMockInterviews {

	/**
	 * Given some input and a keyboard, return how to navigate through the
	 * keyboard to produce the input using left, right, up and left. Accessing
	 * characters in the last row other than 'z' will cause a crash so avoid it.
	 */
	public static String keyboardDirections(String input, char[][] keyboard) {
		String output = "";
		int rows = keyboard[0].length;
		int start = intValue('a');
		int startX = start % rows;
		int startY = start / rows;
		for (int i = 0; i < input.length(); i++) {
			int value = intValue(input.charAt(i));
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
			startX = x;
			startY = y;
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
	public static int[] nextLargestNumber(int[] array) {
		if (array == null || array.length == 0) {
			return array;
		}
		int index = 0;
		for (int i = 1; i < array.length; i++) {
			if (array[index] > array[i]) {
				index = i;
				break;
			}
			index++;
		}

		int nextBiggest = nextBiggest(array, index, array[index]);
		int temp = array[index];
		array[index] = array[nextBiggest];
		array[nextBiggest] = temp;
		int[] sorted = new int[index];
		for (int i = 0; i < index; i++) {
			sorted[i] = array[i];
		}
		Arrays.sort(sorted);
		for (int i = 0; i < index; i++) {
			array[i] = sorted[index - 1 - i];
		}
		return array;
	}

	public static int nextBiggest(int[] array, int index, int biggerThan) {
		int min = Integer.MAX_VALUE;
		int retIndex = 0;
		for (int i = 0; i < index; i++) {
			if (array[i] > biggerThan && array[i] < min) {
				min = array[i];
				retIndex = i;
			}
		}
		return retIndex;
	}

	/**
	 * Write a function which, given two integers (a numerator and a
	 * denominator), prints the decimal representation of the rational number
	 * "numerator/denominator".
	 * 
	 * Since all rational numbers end with a repeating section, print the
	 * repeating section of digits inside parentheses; the decimal printout will
	 * be/must be
	 */
	public static String divide(int a, int b) {
		int real = a / b;
		int r = a % b;
		String decimal = "";
		HashMap<Integer, Integer> remainders = new HashMap<Integer, Integer>();
		int i = 0;
		while (r != 0) {
			if (!remainders.containsKey(r)) {
				remainders.put(r, i);
			} else {
				decimal = decimal.substring(0, remainders.get(r))
						+ '('
						+ decimal
								.substring(remainders.get(r), decimal.length());
				break;
			}
			r *= 10;
			int digit = r / b;
			r = r % b;
			decimal += digit;
			i++;
		}
		if (r != 0) {
			decimal += ')';
		}
		return real + "." + decimal;
	}

	/**
	 * Merge Overlapping Intervals: Given a set of time intervals in any order,
	 * merge all overlapping intervals into one and output the result which
	 * should have only mutually exclusive intervals. Let the intervals be
	 * represented as pairs of integers for simplicity.
	 */
	public ArrayList<Interval> mergeIntervals(ArrayList<Interval> intervals) {
		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
		});
		Stack<Interval> stack = new Stack<Interval>();
		stack.push(intervals.get(0));
		for (int i = 1; i < intervals.size(); i++) {
			Interval interval = intervals.get(i);
			if (interval.start <= stack.peek().end) {
				interval = merge((Interval) stack.pop(), interval);
			}
			stack.push(interval);
		}
		ArrayList<Interval> merged = new ArrayList<Interval>();
		while (stack.size() > 0) {
			merged.add(stack.pop());
		}
		return merged;
	}

	private static Interval merge(Interval first, Interval second) {
		return new Interval(first.start, Math.max(first.end, second.end));
	}

	public static ListNode intersection(ListNode first, ListNode second) {
		if (first == null || second == null) {
			return null;
		}
		int firstLength = 0;
		Node node = first;
		while (node != null) {
			firstLength++;
			node = node.next;
		}
		int secondLength = 0;
		node = second;
		while (node != null) {
			secondLength++;
			node = node.next;
		}
		int diff = secondLength - firstLength;
		if (firstLength > secondLength) {
			diff = firstLength - secondLength;
			int i = 0;
			while (i < diff) {
				first = first.next;
				i++;
			}
		} else {
			diff = secondLength - firstLength;
			int i = 0;
			while (i < diff) {
				second = second.next;
				i++;
			}
		}
		while (first != null && second != null) {
			if (first.data == second.data) {
				return first;
			}
		}
		return null;
	}

	public static void search(String input, Set<String> dictionary,
			Stack<String> words, List<List<String>> results) {

		for (int i = 0; i < input.length(); i++) {
			// Take the first i characters of the input and see if it is a word.
			String substring = input.substring(0, i + 1);

			if (dictionary.contains(substring)) {
				// The beginning of the input matches a word, store on stack.
				words.push(substring);

				if (i == input.length() - 1) {
					// There's no input left, copy the words stack to results.
					results.add(new ArrayList<String>(words));
				} else {
					// There's more input left, search the remaining part
					search(input.substring(i + 1), dictionary, words, results);
				}

				// Pop the matched word back off so we can move onto the next i.
				words.pop();
			}
		}
	}

	public static int countOverlap(QuadTreeNode first, QuadTreeNode second) {
		if (first.children.isEmpty() || second.children.isEmpty()) {
			return Math.min(first.blockPixels, second.blockPixels);
		}
		int count = 0;
		for (int i = 0; i < first.children.size(); i++) {
			count += countOverlap(first.children.get(i), second.children.get(i));
		}
		return count;
	}

	public static void main(String[] args) {
		char[][] keyboard = new char[][] { { 'a', 'b', 'c', 'd', 'e' },
				{ 'f', 'g', 'h', 'i', 'j' }, { 'k', 'l', 'm', 'n', 'o' },
				{ 'p', 'q', 'r', 's', 't' }, { 'u', 'v', 'w', 'x', 'y' },
				{ 'z' } };
		System.out.println(keyboardDirections("dog", keyboard));
		System.out.println(keyboardDirections("zed", keyboard));
		System.out.println(divide(1, 3));
		System.out.println(divide(2, 4));
		System.out.println(divide(22, 7));
		int[] nextLargestNumber = nextLargestNumber(new int[] { 6, 7, 2, 8, 3 });
		for (int i = nextLargestNumber.length - 1; i >= 0; i--) {
			System.out.print(nextLargestNumber[i]);
		}
		System.out.println();
		nextLargestNumber = nextLargestNumber(new int[] { 1, 2, 3, 4, 5, 6, 7,
				8, 9, 4, 8, 7, 6, 5, 4, 3, 2, 1 });
		for (int i = nextLargestNumber.length - 1; i >= 0; i--) {
			System.out.print(nextLargestNumber[i]);
		}
	}
}
