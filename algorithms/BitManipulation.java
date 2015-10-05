public class BitManipulation {

	/**
	 * Odd Man Out
	 */
	public int oddManOut(int[] array) {
		int val = 0;
		for (int i = 0; i < array.length; i++) {
			val ^= array[i];
		}
		return val;
	}
}
