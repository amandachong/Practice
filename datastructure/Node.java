public class Node {

	public Node left;
	public Node right;
	public Node next;
	public Node previous;
	public int data;
	public String d;
	boolean visited = false;
	Node[] adjacentNodes;
	int height;
	int distance;
	Node min;

	public Node() {
	}

	public Node(int data) {
		this.data = data;
	}

	public Node(String d) {
		this.d = d;
	}

	public Node add(Node node) {
		next = node;
		return next;
	}

	public int getValue() {
		return data;
	}

	public void appendToTail(int d) {
		Node nodeForTail = new Node(d);
		Node n = this;
		while (n.next != null) {
			n = n.next;
		}
		n.next = nodeForTail;
	}

	public Node[] getAdjacentNodes() {
		return adjacentNodes;
	}

	public static Node deleteNode(Node head, int data) {
		Node node = head;
		if (node.data == data) {
			return head.next;
		}

		while (node.next != null) {
			if (node.next.data == data) {
				node.next = node.next.next;
				return head;
			}
			node = node.next;
		}
		return head;
	}
}
