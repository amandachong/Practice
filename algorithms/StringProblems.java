import java.util.ArrayList;
import java.util.HashMap;

public class StringProblems {

	public boolean isRotation(String s1, String s2) {
		if (s1.length() != s2.length() || s1.length() <= 0) {
			return false;
		}
		String s1s1 = s1 + s1;
		return s1s1.contains(s2);
	}

	public static String reverse(String s) {
		String reverse = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			reverse = reverse + s.charAt(i);
		}
		return reverse;
	}

	/**
	 * Given a keyword (ex: "abc") and a list of words (ex: "aabc", "cab",
	 * "ab"), write a function that will return all words in the list that are
	 * the same/anagrams of the keyword. In this case, "cab" would be the only
	 * word returned. Later changes to the function were added: numbers and
	 * symbols might be included in the words but were to be ignored ("ca2b"
	 * still matched "abc"), make the function not case sensitive ("A" == "a")
	 */
	public static void findSameOrAnagram(ArrayList<String> list, String keyword) {
		ArrayList<String> sameOrAnagrams = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			if (keyword.toLowerCase().equals(list.get(i).toLowerCase())) {
				sameOrAnagrams.add(keyword);
			} else if (keyword.length() == list.get(i).length()
					&& keyword.length() != 0) {
				boolean isAnagram = true;
				for (int j = 0, k = keyword.length() - 1; j < keyword.length(); j++, k--) {
					if (keyword.charAt(j) != list.get(i).charAt(k)) {
						isAnagram = false;
					}
				}
				if (isAnagram) {
					sameOrAnagrams.add(list.get(i));
				}
			}
		}
	}

	/**
	 * Write a function to convert a string (char* that contains a number, e.g.
	 * "586") to int.
	 */
	public int stringToInt(char[] s) {
		if (s == null || s.length <= 0) {
			throw new IllegalArgumentException();
		}
		int number = 0;
		for (int i = 0; i < s.length; i++) {
			number += (s[i] - 48) * Math.pow(10, s.length - 1 - i);
		}
		return number;
	}

	/**
	 * LeetCode - String to Integer (atoi): Implement atoi to convert a string
	 * to an integer.
	 */
	public int myAtoi(String str) {
		if (str == null || str.length() < 1)
			return 0;
		str = str.trim();
		char flag = '+';
		int i = 0;
		if (str.charAt(0) == '-') {
			flag = '-';
			i++;
		} else if (str.charAt(0) == '+') {
			i++;
		}
		double result = 0;
		while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
			result = result * 10 + (str.charAt(i) - '0');
			i++;
		}
		if (flag == '-')
			result = -result;
		if (result > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
		if (result < Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
		return (int) result;
	}

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

	/**
	 * LeetCode - Length of Last Word: Given a string s consists of
	 * upper/lower-case alphabets and empty space characters ' ', return the
	 * length of last word in the string.
	 */
	public int lengthOfLastWord(String s) {
		if (s == null) {
			return 0;
		}
		s = s.trim();
		if (s.length() == 0) {
			return 0;
		}
		int index = s.lastIndexOf(' ');
		if (index == -1) {
			return s.length();
		}
		String lastWord = s.substring(index + 1, s.length());
		return lastWord.length();
	}

	public char[] replaceSpaces(char[] s) {
		int spaceCount = 0;
		for (int i = 0; i < s.length; i++) {
			if (s[i] == ' ') {
				spaceCount++;
			}
		}
		int newLength = s.length + (spaceCount * 3);
		char[] newString = new char[newLength];
		int newStringIndex = -1;
		for (int i = 0; i < newString.length; i++) {
			if (s[i] == ' ') {
				newString[newStringIndex++] = '%';
				newString[newStringIndex++] = '2';
				newString[newStringIndex++] = '0';
			} else {
				newString[newStringIndex++] = s[i];
			}
		}
		return newString;
	}

	public boolean isAllUnique(String word) {
		HashMap<String, Boolean> hashTable = new HashMap<String, Boolean>();
		for (int i = 0; i < word.length(); i++) {
			if (hashTable.get(word.charAt(i))) {
				return false;
			}
			hashTable.put(word.substring(i, i + 1), true);
		}
		return true;
	}

	public static boolean isPalindrome(String s) {
		for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}

	public static String reverseInPlace(String s) {
		char[] cArray = s.toCharArray();
		for (int i = 0, j = s.length() - 1; i < s.length() / 2; i++, j--) {
			char c = cArray[i];
			cArray[i] = cArray[j];
			cArray[j] = c;
		}
		return new String(cArray);
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

	public static void main(String[] args) {
		String s = "Hi, I'm Amanda";
		System.out.println(reverseInPlace(s));
		System.out.println(isPalindrome("moooooooom"));
		System.out.println(isPalindrome("moooojoooom"));
		System.out.println(isPalindrome("nooon"));
		System.out.println(stringToInt("-1a23"));
	}
}
