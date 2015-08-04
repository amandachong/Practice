import java.util.ArrayList;
import java.util.HashMap;

public class CareerCup {

	/**
	 * Print all combinations of balanced parentheses. Write a function to
	 * generate all possible n pairs of balanced parentheses.
	 * 
	 * Example: n = 1 {}, n = 2 {}{} {{}}.
	 * 
	 * Solved using DP.
	 */
	public static void parenthesisPermutation(int n) {
		HashMap<Integer, ArrayList<String>> parenthesis = new HashMap<Integer, ArrayList<String>>();
		ArrayList<String> array = new ArrayList<String>();
		array.add("");
		parenthesis.put(0, array);
		array = new ArrayList<String>();
		array.add("()");
		parenthesis.put(1, array);
		for (int i = 2; i <= n; i++) {
			array = new ArrayList<String>();
			ArrayList<String> last = parenthesis.get(i - 1);
			for (int j = 0; j < last.size(); j++) {
				array.add("(" + last.get(j) + ")");
				array.add("()" + last.get(j));
				array.add(last.get(j) + "()");
			}
			parenthesis.put(i, array);
		}

		ArrayList<String> answer = parenthesis.get(n);
		for (int i = 0; i < answer.size(); i++) {
			System.out.println(answer.get(i));
			System.out.println();
		}
	}

	public static void main(String[] args) {
		parenthesisPermutation(3);
	}
}
