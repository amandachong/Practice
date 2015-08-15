public class GraphNode extends Node {

	public int value;
	public GraphNode next;
	public GraphNode[] neighbours;
	public boolean visited;

	public GraphNode(int value) {
		this.value = value;
	}

	public GraphNode(int value, GraphNode[] neighbours) {
		this.value = value;
		this.neighbours = neighbours;
	}

	public String toString() {
		return "value: " + this.value;
	}
}
