public class FrontBackQueue {

	private Node front;
	private Node back;

	public void enqueueFront(int data) {
		Node node = new Node(data);
		if (isEmpty()) {
			front = node;
			back = front;
		} else {
			Node temp = front;
			front = node;
			front.next = temp;
			front.next.previous = front;
		}
	}

	public void enqueueBack(int data) {
		Node node = new Node(data);
		if (isEmpty()) {
			back = node;
			front = back;
		} else {
			back.next = node;
			back.next.previous = back;
			back = back.next;
		}
	}

	public Node dequeueFront() {
		if (!isEmpty()) {
			Node ret = front;
			front = front.next;
			front.previous = null;
			return ret;
		}
		return null;
	}

	public Node dequeueBack() {
		if (!isEmpty()) {
			Node ret = back;
			back = back.previous;
			back.next = null;
			return ret;
		}
		return null;
	}

	public boolean isEmpty() {
		return front == null;
	}
}
