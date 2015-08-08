import java.util.ArrayList;

public class Vertex extends Node {

	int distance = 0;
	int x;
	int y;
	Vertex up;
	Vertex down;
	Vertex left;
	Vertex right;
	boolean visited = false;
	Vertex previous;

	public Vertex(Vertex up, Vertex down, Vertex left,
			Vertex right) {
		this.up = up;
		this.down = down;
		this.left = left;
		this.right = right;
	}

	public Vertex() {
	}

	public ArrayList<Vertex> getAdjacentVertices() {
		return null;
	}

}
