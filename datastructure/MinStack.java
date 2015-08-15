/**
 * Design a stack. We want to push, pop, and also, retrieve the minimum element
 * in constant time.
 */
public class MinStack {

	private Node top;

	public void push(Node node) {
		if (isEmpty()) {
			top = node;
			top.min = top;
		} else {
			Node temp = top;
			top = node;
			top.next = temp;
			top.min = temp.value < node.value ? temp : top;
		}
	}

	public Node pop() {
		if (isEmpty()) {
			return null;
		}
		Node ret = top;
		top = top.next;
		return ret;
	}

	public Node min() {
		if (isEmpty()) {
			return null;
		}
		return top.min;
	}

	public Node top() {
		return top;
	}

	public boolean isEmpty() {
		return top == null;
	}
}
