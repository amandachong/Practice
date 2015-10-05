import java.util.ArrayList;
import java.util.HashSet;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Airbnb {

	// ["gab", "cat", "bag", "alpha", "race", "car"] => ["gab", "bag"], ["bag",
	// "gab"], ["race", "car"]

	// racecar

	public static void main(String[] args) {
		ArrayList<String> strings = new ArrayList<String>();
		strings.add("gab");
		strings.add("cat");
		strings.add("bag");
		strings.add("alpha");
		strings.add("race");
		strings.add("car");

		ArrayList<ArrayList<String>> results = palindrome(strings);

		for (ArrayList<String> result : results) {
			for (String s : result) {
				System.out.println(s);
			}
		}
	}

	public static boolean isPalindrome(String word) {
		for (int i = 0; i < word.length() / 2; i++) {
			if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}

	// racec ac
	// race lecar

	public static ArrayList<ArrayList<String>> pairs(ArrayList<String> words) {
		ArrayList<ArrayList<String>> pairs = new ArrayList<ArrayList<String>>();
		if (words == null || words.size() == 0) {
			return pairs;
		}

		HashSet<String> hashSet = new HashSet<String>();
		for (String word : words) {
			hashSet.add(word);
		}

		for (String word : words) {
			int n = word.length();
			for (int i = 0; i < n; i++) {
				String prefix = word.substring(0, i);
				String suffix = word.substring(i, n);
				String reverse = new String(new StringBuffer(suffix).reverse());
				if (isPalindrome(prefix) && hashSet.contains(reverse)) {
					ArrayList<String> pair = new ArrayList<String>();
					pair.add(reverse);
					pair.add(word);
					pairs.add(pair);
				}
			}
		}
		return pairs;
	}

	// public static ArrayList<ArrayList<String>> palindrom2(ArrayList<String>
	// words) {
	// HashSet<String> hashSet = new HashSet<String>();
	// for (String s : words) {
	// hashSet.add(s);
	// }
	//
	// ArrayList<ArrayList<String>> results = new
	// ArrayList<ArrayList<String>>();
	//
	// for (int i = 0; i < words.size(); i++) {
	// String s = words.get(i);
	// ArrayList<String> res = new ArrayList<String>();
	// int count = 1;
	// while (s.length > 0 && ) {
	// String first = new StringBuilder(s).reverse().toString();
	// if (hashSet.contains(first)) {
	// ArrayList<String> result = new ArrayList<String>();
	// result.add(hashSet.get(first));
	// result.add(s);
	// results.add(result);
	// break;
	// }
	// String rest = s.substring(0, count);
	// if (isPalindrom(rest)) {
	// res.add(s.substring(count));
	// }
	// rest = s.substring(count, s.length());
	// if (isPalindrom(rest)) {
	// res.add(s.substring(0, s.length() - count));
	// }
	//
	// }
	// }
	//
	//
	// return results;
	// }

	public static ArrayList<ArrayList<String>> palindrome(
			ArrayList<String> words) {
		ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();

		for (int i = 0; i < words.size() - 1; i++) {
			for (int j = i + 1; j < words.size(); j++) {
				String first = words.get(i) + words.get(j);

				if (isPalindrome(first)) {
					ArrayList<String> result = new ArrayList<String>();
					result.add(words.get(i));
					result.add(words.get(j));
					results.add(result);
				}

				String second = words.get(j) + words.get(i);

				if (isPalindrome(second)) {
					ArrayList<String> result = new ArrayList<String>();
					result.add(words.get(j));
					result.add(words.get(i));
					results.add(result);
				}
			}
		}

		return results;
	}
}

// ["gab", "cat", "bag", "alpha", "race", "car"] => ["gab", "bag"], ["bag",
// "gab"], ["race", "car"]

// race lecar

class CSVParser {

	public CSVParser() {

	}
}

class Practice {

	/**
	 * Given a dictionary, and a matrix of letters, find all the words in the
	 * matrix that are in the dictionary.
	 */
	public static ArrayList<String> findAllWords(HashSet<String> dictionary,
			String[][] letters) {
		ArrayList<String> words = new ArrayList<String>();
		return words;
	}

	/**
	 * Return the coins combination with the minimum number of coins. Time
	 * complexity O(MN), where M is the target value and N is the number of
	 * distinct coins. Space complexity O(M).
	 */
	public int minCoins(int coins[], int m, int value) {
		if (value == 0) {
			return 0;
		}

		int residue = Integer.MAX_VALUE;

		for (int i = 0; i < m; i++) {
			if (coins[i] <= value) {
				int subResidue = minCoins(coins, m, value - coins[i]);

				if (subResidue != Integer.MAX_VALUE && subResidue + 1 < residue) {
					residue = subResidue + 1;
				}
			}
		}
		return residue;
	}

}
