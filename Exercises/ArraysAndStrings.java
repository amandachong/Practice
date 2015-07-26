import java.util.HashMap;

public class ArraysAndStrings {

	public boolean isAllUnique(String word) {
		HashMap<String, Boolean> hashTable = new HashMap<String, Boolean>();
		for (int i = 0; i < word.length(); i++) {
			if (hashTable.get(word.charAt(i))) {
				return false;
			} else {
				hashTable.put(word.substring(i, i + 1), true);
			}
		}
		return true;
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

	public void rotate90(int[][] matrix) {
		
	}

	public void convertMatrix(int[][] matrix) {
		int[] row = new int[matrix.length];
		int[] column = new int[matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					row[i] = 1;
					row[j] = 1;
				}
			}
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (row[i] == 1 || column[j] == 1) {
					matrix[i][j] = 0;
				}
			}
		}
	}

	public boolean isRotation(String s1, String s2) {
		if (s1.length() != s2.length() || s1.length() <= 0) {
			return false;
		}
		String s1s1 = s1 + s1;
		return isSubstring(s1s1, s2);
	}

	private boolean isSubstring(String s1, String s2) {
		return true;
	}
}
