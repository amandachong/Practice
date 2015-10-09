public class Node {

	public Node next;
	public Node previous;
	public int value;
	public boolean visited;
	private Node[] adjacentNodes;
	public int distance;
	public Node min;
	public int key;

	public Node() {
	}

	public Node(int value) {
		this.value = value;
	}

	public Node(int key, int value) {
		this.key = key;
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public int getKey() {
		return key;
	}

	public void appendToTail(int value) {
		Node node = this;
		while (node.next != null) {
			node = node.next;
		}
		node.next = new Node(value);
	}

	public Node[] getAdjacentNodes() {
		return adjacentNodes;
	}

	public static Node deleteNode(Node head, int data) {
		Node node = head;
		if (node.value == data) {
			return head.next;
		}
		while (node.next != null) {
			if (node.next.value == data) {
				node.next = node.next.next;
				return head;
			}
			node = node.next;
		}
		return head;
	}
}
