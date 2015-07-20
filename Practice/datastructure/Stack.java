public class Stack {
	
	private Node top;

	public Stack() {

	}

	public void push(Node node) {
		if (top == null) {
			top = node;
		} else {
			node.next = top;
			top = node;
		}
	}

	public Node pop() {
		if (top == null) {
			return null;
		}
		Node ret = top;
		top = top.next;
		return ret;
	}
	
	public Node top() {
		return top;
	}
}
