/**
 * This file is to be completed by you.
 *
 * @author s2085530
 */
public final class Model
{
	// ===========================================================================
	// ================================ CONSTANTS ================================
	// ===========================================================================
	// The most common version of Connect Four has 7 rows and 6 columns.
	public static final int DEFAULT_NR_ROWS = 7;
	public static final int DEFAULT_NR_COLS = 6;
	
	// ========================================================================
	// ================================ FIELDS ================================
	// ========================================================================
	// The size of the board.
	private int nrRows;
	private int nrCols;
	private char[][] board;

	// =============================================================================
	// ================================ CONSTRUCTOR ================================
	// =============================================================================
	public Model()
	{
		// Initialise the board size to its default values.
		nrRows = DEFAULT_NR_ROWS;
		nrCols = DEFAULT_NR_COLS;

		board = new char[nrRows][nrCols];

		for (int i= 0 ; i < nrRows ; i++) {
			for (int j = 0 ; j < nrCols; j++){
				board[i][j] = ' ';
			}
		}

	}
	
	// ====================================================================================
	// ================================ MODEL INTERACTIONS ================================
	// ====================================================================================
	public boolean isMoveValid(int move)
	{

		if(move> nrCols || move <= 0){
			return false;
		}

		move = move - 1;

		int j;

		for (j = nrRows - 1 ; j >= 0; j--){
			if (board[j][move] == ' ') {
				break;
			}
		}

		return j >= 0;
	}
	
	public void makeMove(int move, char player)
	{

		move = move - 1;

			for (int j = nrRows - 1 ; j >= 0; j--){
				if (board[j][move] == ' ') {
					board[j][move] = player;
					break;
				}
			}

	}
	
	// =========================================================================
	// ================================ GETTERS ================================
	// =========================================================================
	public int getNrRows()
	{
		return nrRows;
	}
	
	public int getNrCols()
	{
		return nrCols;
	}

	public char[][] getBoard() {
		return board;
	}
}
