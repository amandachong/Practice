public class Queue {

	private Node first;
	private Node last;

	private Vertex v;

	public Queue() {
	}

	public void enqueue(Node node) {
		if (first == last) {
			first = node;
			last = first;
		} else {
			last.next = node;
			last = last.next;
		}
	}

	public Node dequeue() {
		if (first == null) {
			return null;
		}
		Node ret = first;
		first = first.next;
		return ret;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public void enqueue(Vertex v) {

	}
}
