import java.util.HashSet;

public class Google {

	/**
	 * Write a function f(a, b) which takes two character string arguments and
	 * returns a string containing only the characters found in both strings in
	 * the order of a. Write a version which is order N-squared and one which is
	 * order N.
	 */
	public static String commonChar(String a, String b) {
		if (a == null || b == null) {
			return null;
		}
		String s = "";
		HashSet<Character> hashSet = new HashSet<Character>();
		for (int i = 0; i < b.length(); i++) {
			hashSet.add(b.charAt(i));
		}
		for (int i = 0; i < a.length(); i++) {
			if (hashSet.contains(a.charAt(i))) {
				s += a.charAt(i);
			}
		}
		return s;
	}

	/**
	 * Given that you have one string of length N and M small strings of length
	 * L. How do you efficiently find the occurrence of each small string in the
	 * larger one?
	 */
	public static void findSmallStrings(String n, String[] ms, int l) {
		HashSet<String> hashSet = new HashSet<String>();
		for (int i = 0; i < n.length() - l; i++) {
			hashSet.add(n.substring(i, i + l));
		}
		for (String m : ms) {
			if (hashSet.contains(m)) {
				System.out.println(m);
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(commonChar("abcdefg", "afcbedf"));
		findSmallStrings(
				"find the small strings that occurr in the big string",
				new String[] { "find", "that", "big ", "noth" }, 4);
	}
}
