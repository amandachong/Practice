public class Stack {

	private Node top;
	private int size;

	public Stack() {
		size = 0;
	}

	public void push(Node node) {
		if (node != null) {
			node.next = top;
			top = node;
			size++;
		}
	}

	public Node pop() {
		if (!isEmpty()) {
			Node node = new Node(top.value);
			top = top.next;
			size--;
			return node;
		}
		return null;
	}

	public Node top() {
		return top;
	}

	public Node peek() {
		return top;
	}

	public boolean isEmpty() {
		return top == null;
	}

	public int size() {
		return size;
	}
}
