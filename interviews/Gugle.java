public class Gugle {

	public String keyboardDirections(String input, int col) {
		String output = "";
		int start = intValue('a');
		for (int i = 0; i < input.length(); i++) {
			int startX = start % col;
			int startY = start / col;

			int value = intValue(input.charAt(i));
			int x = value % col;
			int y = value / col;

			String letter = "L";
			if (x - startX > 0) {
				letter = "R";
			}
			for (int j = 0; j < Math.abs(x - startX); j++) {
				output += letter;
			}

			letter = "D";
			if (y - startY > 0) {
				letter = "U";
			}
			for (int j = 0; j < Math.abs(x - startX); j++) {
				output += letter;
			}
			output += "_";
			start = value;
		}
		return output;
	}

	private int intValue(char c) {
		return 0;
	}
}
