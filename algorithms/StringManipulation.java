public class StringManipulation {

	/**
	 * LeetCode – Longest Common Prefix: Write a function to find the longest
	 * common prefix string amongst an array of strings.
	 */
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		int min = Integer.MAX_VALUE;
		for (String s : strs) {
			min = Math.min(min, s.length());
		}
		if (min == 0) {
			return "";
		}
		for (int i = min; i >= 0; i--) {
			String compare = strs[0].substring(0, min);
			String prefix;
			for (int j = 1; j < strs.length; j++) {
				prefix = strs[j].substring(0, i);
				if (prefix != compare) {
					continue;
				}
			}
			return compare;
		}
		return "";
	}
}
