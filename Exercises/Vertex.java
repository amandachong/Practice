import java.util.ArrayList;

public class Vertex {

	public Vertex(Vertex up, Vertex down, Vertex left, Vertex right) {
		this.up = up;
		this.down = down;
		this.left = left;
		this.right = right;
	}

	public Vertex() {

	}

	int distance = 0;
	int x;
	int y;
	Vertex up;
	Vertex down;
	Vertex left;
	Vertex right;
	boolean visited = false;
	Vertex previous;

	public ArrayList<Vertex> getAdjacentVertices() {
		// TODO Auto-generated method stub
		return null;
	}

}
