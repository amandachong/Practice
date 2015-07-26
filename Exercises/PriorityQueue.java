public class PriorityQueue {

	Node min;
	int n = 0;
	Node[] heap = new Node[10];

	/**
	 * logn
	 */
	public Node deleteMin() {
		if (!isEmpty()) {
			Node node = heap[0];
			heap[0] = heap[n - 1];
			n--;
			swapDown(0);
			return node;
		}
		return null;
	}

	/**
	 * logn
	 */
	public void insert(Node node) {
		if (!isFull()) {
			heap[n] = node;
			n++;
			swapUp(n - 1);
		}
	}

	public boolean isEmpty() {
		return heap[0] == null;
	}

	public boolean isFull() {
		return n != heap.length - 1;
	}

	public void swapDown(int i) {
		int s = i;
		int left = i * 2 + 1;
		int right = left + 1;
		if (left < n && heap[left].data < heap[s].data) {
			s = left;
		}
		if (right < n && heap[right].data < heap[s].data) {
			s = right;
		}
		if (s != 1) {
			Node temp = heap[i];
			heap[i] = heap[s];
			heap[s] = temp;
			swapDown(s);
		}
	}

	public void swapUp(int i) {
		if (i == 0) {
			return;
		}
		int p = (i - 1) / 2;
		if (heap[i].data < heap[p].data) {
			Node temp = heap[i];
			heap[i] = heap[p];
			heap[p] = temp;
			swapUp(p);
		}
	}

	/**
	 * In this case, the swapDown function would have to reference the array,
	 * not the heap
	 * 
	 * nlogn
	 */
	public void heapify(int[] array) {
		for (int i = array.length; i >= 0; i--) {
			swapDown(i);
		}
	}
}
