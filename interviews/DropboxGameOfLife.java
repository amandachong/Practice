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

class GameOfLifeSolution {
	public void gameOfLife(int[][] board) {
		int m = board.length, n = board[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int countLive = 0;
				for (int p = Math.max(i - 1, 0); p < Math.min(i + 2, m); p++) {
					for (int q = Math.max(j - 1, 0); q < Math.min(j + 2, n); q++) {
						if (board[p][q] == 2 || board[p][q] == 1)
							countLive++; // Count status 0 is live
					}
				}
				countLive -= board[i][j];
				if (board[i][j] == 0 && countLive == 3)
					board[i][j] = 3; // Status 0 is dead, next status is live
				if (board[i][j] == 1 && (countLive < 2 || countLive > 3))
					board[i][j] = 2; // Status 0 is live, next status is dead

			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] %= 2;
			}
		}
	}
}