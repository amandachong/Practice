public class LinkedList {

	Node first;
	Node last;
	private int size;

	public LinkedList() {
		size = 0;
	}

	public void add(Node node) {
		if (first == null) {
			first = node;
			last = first;
		} else {
			last.next = node;
			last = last.next;
		}
		size++;
	}

	public int size() {
		return size;
	}
}
