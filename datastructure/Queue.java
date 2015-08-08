public class Queue {

	private Node front;
	private Node back;

	public Queue() {
	}

	public void enqueue(Node node) {
		if (isEmpty()) {
			front = node;
			back = front;
		} else {
			back.next = node;
			back = back.next;
		}
	}

	public Node dequeue() {
		if (isEmpty()) {
			return null;
		}
		Node ret = front;
		front = front.next;
		return ret;
	}

	public boolean isEmpty() {
		return front == null;
	}
}
