
public class Node {
	
	public Node left;
	public Node right;
	public Node next;
	public Node previous;
	public int data;
	public String d;
	
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
}
