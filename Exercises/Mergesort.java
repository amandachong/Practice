public class Mergesort {

	public void mergesort(int[] array, int n) {
		int[] temp = new int[n];
		msort(array, 0, n - 1, temp);
	}

	public void msort(int[] array, int lo, int hi, int[] temp) {
		if (lo >= hi)
			return;
		int mid = (lo + hi) / 2;
		msort(array, lo, mid, temp);
		msort(array, mid + 1, hi, temp);
		merge(array, lo, mid, hi, temp);
	}

	public void merge(int[] array, int lo, int mid, int hi, int[] temp) {
		int a = lo;
		int b = mid + 1;
		for (int k = lo; k <= hi; k++) {
			if (a <= mid && (b > hi || array[a] < array[b]))
				temp[k] = array[a++];
			else
				temp[k] = array[b++];
		}
		for (int k = lo; k <= hi; k++)
			array[k] = temp[k];
	}
}
