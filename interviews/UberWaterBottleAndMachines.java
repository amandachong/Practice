import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Given a matrix defining '.' as a valid path, 'x' as a wall, and Mi as a
 * machine, find the minimum path such that a person returning to a water bottle
 * has to walk the minimum distance.
 * 
 * Make one graph for every machine and add up these graphs to get the distances
 * needed. The smallest added distance will give the answer of where to place
 * the water bottle.
 */
public class UberWaterBottleAndMachines {

	/**
	 * O(n) - BFS.
	 */
	public int getMin(GraphNode water, GraphNode machine) {
		LinkedList<GraphNode> queue = new LinkedList<GraphNode>();
		queue.add(water);
		water.value = 0;
		while (!queue.isEmpty()) {
			GraphNode n = queue.pop();
			n.visited = true;
			if (n.equals(machine)) {
				return n.value;
			}
			for (GraphNode adjacent : n.getNeighbours()) {
				if (!adjacent.visited) {
					adjacent.value = n.value + 1;
					queue.add(adjacent);
				}
			}
		}
		return -1;
	}

	/**
	 * O(n) ~ O(8n).
	 */
	public ArrayList<GraphNode> getNeighbours(char[][] graph, int x, int y) {
		ArrayList<GraphNode> neighbours = new ArrayList<GraphNode>();
		for (int i = x - 1; i < x + 1; i++) {
			for (int j = y - 1; j < y + 1; j++) {
				if (i > 0 && i < graph.length && j > 0 && j < graph[0].length
						&& i != x && j != y) {
					neighbours.add(new GraphNode(graph[i][j]));
				}
			}
		}
		return neighbours;
	}
}
