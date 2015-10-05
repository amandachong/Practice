/**
 * Given a 1,000,000 by 1,000,000 int matrix, what problems would occur with the
 * current implementation? How much disk space does this require?
 * 
 * 16 GB RAM, 1TB disk space
 * 
 * Grab subsets of the board to compute with that fit into 16 GB RAM.
 * 
 * Tell me about your project at Google.
 * 
 * Tell me about the permutohedral lattice.
 * 
 * How is the permutohedral lattice better than a regular bilateral grid?
 */

public class DropboxGameOfLife {

	private int[][] board;

	public DropboxGameOfLife(int[][] board) {
		this.board = board;
	}

	public int[][] next() {
		int[][] newBoard = new int[board.length][board[0].length];
		for (int y = 0; y < board.length; y++) {
			for (int x = 0; x < board[0].length; x++) {
				newBoard[y][x] = deadOrAlive(board, y, x);
			}
		}
		board = newBoard;
		return board;
	}

	private int deadOrAlive(int[][] board, int y, int x) {
		int alive = 0;

		for (int i = x - 1; i < x + 1; i++) { // Go through top and bottom rows
			if (y - 1 > 0) {
				alive += board[y - 1][i];
			}
			if (y + 1 < board.length) {
				alive += board[y + 1][i];
			}
		}

		if (x - 1 > 0) { // Check neighbor to left and right
			alive += board[y][x - 1];
		}
		if (x + 1 < board[0].length) {
			alive += board[y][x + 1];
		}

		if (board[y][x] == 1) { // Current alive
			if (alive >= 2) {
				return 1;
			}
			return 0;
		} else { // Current dead
			if (alive == 3) {
				return 1;
			}
			return 0;
		}
	}
}