import java.util.ArrayList;
import java.util.List;

public class BreadthFirstSearch {

	private final int INFINITE = Integer.MAX_VALUE;

	public void breadthFirstSearch(Node node) {
		node.distance = 0;
		Queue queue = new Queue();
		queue.enqueue(node);
		while (!queue.isEmpty()) {
			node = queue.dequeue();
			if (!node.visited) {
				node.visited = true;
				for (Node adjacent : node.getAdjacentNodes()) {
					adjacent.distance = node.distance + 1;
					queue.enqueue(adjacent);
				}
			}
		}
	}

	public void visit(Node node) {
		System.out.println(node.data);
	}

	public void BFS(Node root) {
		Queue queue = new Queue();
		root.visited = true;
		visit(root);
		queue.enqueue(root);

		while (!queue.isEmpty()) {
			Node node = queue.dequeue();
			for (Node adjacent : node.getAdjacentNodes()) {
				if (adjacent.visited == false) {
					visit(adjacent);
					adjacent.visited = true;
					queue.enqueue(adjacent);
				}
			}
		}
	}

	public void breadthFirstSearch(ArrayList array, Vertex s) {
		int distance = 0;
		s.distance = distance;
		Queue queue = new Queue();
		queue.enqueue(s);
		while (!(queue.isEmpty())) {
			Vertex vertex = (Vertex) queue.dequeue();
			if (vertex.distance == INFINITE) {
				vertex.distance = distance;
				List<Vertex> adjacentVertices = v.getAdjacentVertices();
				for (Vertex v : adjacentVertices) {
					v.distance = distance + 1;
					queue.enqueue(v);
				}
			}
		}
		for (int i = 0; i < array.size(); i++) {
			for (int j = 0; j < array[i][j]; j++) {
				if (array[i][j].distance == INFINITE) {
					return false;
				}
			}
		}
		return true;
	}
}
