import java.util.ArrayList;
import java.util.HashMap;

public class DynamicProgramming {

	/**
	 * LeetCode – House Robber: You are a professional robber planning to rob
	 * houses along a street. Each house has a certain amount of money stashed,
	 * the only constraint stopping you from robbing each of them is that
	 * adjacent houses have security system connected and it will automatically
	 * contact the police if two adjacent houses were broken into on the same
	 * night.
	 * 
	 * Given a list of non-negative integers representing the amount of money of
	 * each house, determine the maximum amount of money you can rob tonight
	 * without alerting the police.
	 */
	public int houseRobber(int[] num) {
		if (num == null || num.length == 0) {
			return 0;
		}

		int n = num.length;

		int[] dp = new int[n];
		dp[0] = 0;
		dp[1] = num[0];

		for (int i = 2; i < n + 1; i++) {
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + num[i - 1]);
		}
		return dp[n];
	}

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
