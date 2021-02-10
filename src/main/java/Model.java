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
	
	// ========================================================================
	// ================================ FIELDS ================================
	// ========================================================================
	// The size of the board.
	private final int nrRows;
	private final int nrCols;
	private final char[][] board;

	// =============================================================================
	// ================================ CONSTRUCTOR ================================
	// =============================================================================
	public Model()
	{
		// Initialise the board size to its default values.
		nrRows = setNrRows();
		nrCols = setNrCols();

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

	// =========================================================================
	// ================================ SETTERS ================================
	// =========================================================================
	public final int setNrRows(){
		System.out.print("Enter the width of the board: ");
		int nrRows = InputUtil.readIntFromUser();

		while (nrRows <= 4){
			System.out.println("Custom width must be more than 4");
			System.out.print("Enter the width of the board: ");
			nrRows = InputUtil.readIntFromUser();
		}

		return nrRows;

	}

	public final int setNrCols(){
		System.out.print("Enter the height of the board: ");
		int nrCols = InputUtil.readIntFromUser();

		while (nrCols <= 4){
			System.out.println("Custom height must be more than 4");
			System.out.print("Enter the height of the board: ");
			nrCols = InputUtil.readIntFromUser();
		}

		return nrCols;
	}

	public final void setBoard(){
		for (int i= 0 ; i < nrRows ; i++) {
			for (int j = 0; j < nrCols; j++) {
				board[i][j] = ' ';
			}
		}
	}

}
