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
	
	/**
	 * Given an number x, find the next largest number y such that x < y and uses the same digits as x.
	 */
	public int[] nextLargestNumber(int[] array) {
	  if (array == null || array.length == 0) {
	    return array;
	  }
	  
	  int[] ret = new ret[]{array};
	  int start = 0;
	  int end = 0;
	  int num = array[0];
	  for (int i = 1; i < array.length; i++) {
	    if (num > array[i])) {
	      end = i - 1;
	      break;
	    }
	    num = array[i];
	  }
	  int temp = ret[end + 1];
	  ret[end + 1] = nextBiggest(temp, num);
	  
	  for (int i = 0; i <= end; i++) {
	    
	  }
	}
	
	public int nextBiggest(int n, int[] array) {
	  int next = n;
	  for (int i = 0; i < array.length; i++) {
	    if (array[i] > n && array[i] < next) {
	      next = array[i];
	    }
	  }
	  return next;
	}
}
