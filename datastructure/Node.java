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

	public Node deleteNode(Node head, int d) {
		Node n = head;
		if (n.data == d) {
			return head.next;
		}

		while (n.next != null) {
			if (n.next.data == d) {
				n.next = n.next.next;
				return head;
			}
			n = n.next;
		}
		return head;
	}
}
