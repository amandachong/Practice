public class DepthFirstSearch {

	public void depthFirstSearch(Node root) {
		if (root == null) {
			return;
		}
		visit(root);
		root.visited = true;
		for (Node adjacent : root.getAdjacentNodes()) {
			if (adjacent.visited == false) {
				depthFirstSearch(adjacent);
			}
		}
	}

	public void visit(Node node) {
		System.out.println(node.data);
	}
}
