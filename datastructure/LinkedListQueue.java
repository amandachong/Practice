public class LinkedListQueue {

	Node front;
	Node back;

	public void enqueue(int object) {
		Node node = new Node(object);
		if (isEmpty()) {
			front = node;
			back = node;
		} else {
			back.next = node;
			back = back.next;
		}
	}

	public Node dequeue() {
		if (isEmpty()) {
			return null;
		} else {
			Node node = front;
			front = front.next;
			return node;
		}
	}

	public boolean isEmpty() {
		if (front == null) {
			return true;
		}
		return false;
	}

}
