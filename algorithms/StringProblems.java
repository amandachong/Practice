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

	public static String reverseInPlace(String s) {
		char[] cArray = s.toCharArray();
		for (int i = 0, j = s.length() - 1; i < s.length() / 2; i++, j--) {
			char c = cArray[i];
			cArray[i] = cArray[j];
			cArray[j] = c;
		}
		String retVal = "";
		for (int i = 0; i < cArray.length; i++) {
			retVal += cArray[i];
		}
		return retVal;
	}

	public static void main(String[] args) {
		String s = "Hi, I'm Amanda";
		System.out.println(reverseInPlace(s));
	}
}
