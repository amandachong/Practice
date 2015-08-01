public class LinkedList {

	Node first;
	Node last;

	public LinkedList() {
	}

	public void add(Node node) {
		if (first == null) {
			first = node;
			last = first;
		} else {
			last.next = node;
			last = last.next;
		}
	}
}
