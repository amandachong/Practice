public class Stack {

	Node back;
	Node min;
	Node top;

	public Node pop() {
		if (isEmpty()) {
			Node ret = top;
			top = top.next;
			return ret;
		}
		return null;
	}

	public boolean isEmpty() {
		if (top == null)
			return true;
		return false;
	}

	public void push(Node node) {
		node.next = top;
		top = node;
	}

	public Node top() {
		return top;
	}

	// public Node min() {
	// return min;
	// }
	//
	// public void push(Node node) {
	// Node temp = back;
	// back = node;
	// back.next = temp;
	// if (min == null) {
	// min = node;
	// } else {
	// Node current = min;
	// while (current.data < node.data) {
	// current = current.next;
	// }
	// Node temp1 = current;
	// current.next = current;
	// current = temp1;
	// }
	// }
	//
	// public Node pop() {
	// if (isEmpty()) {
	// return null;
	// }
	// Node node = back;
	// back = back.next;
	// return node;
	// }

	// Node top;
	//
	// public Object pop() {
	// if (top != null) {
	// Object item = top.data;
	// top = top.next;
	// return item;
	// }
	// return null;
	// }
	//
	// public void push(Node node) {
	// node.next = top;
	// top = node;
	// }
}
