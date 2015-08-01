public class Stack {

	private Node top;
	private int size;

	public Stack() {
		size = 0;
	}

	public void push(Node node) {
		node.next = top;
		top = node;
		size++;
	}

	public Node pop() {
		if (!isEmpty()) {
			Node ret = top;
			top = top.next;
			size--;
			return ret;
		}
		return null;
	}

	public Node top() {
		return top;
	}

	public int peek() {
		return top.data;
	}

	public boolean isEmpty() {
		return top == null;
	}

	public int size() {
		return size;
	}
}
