/**
 * This file is to be completed by you.
 *
 * @author s2085530
 */

public final class Controller
{
	private final Model model;
	private final TextView view;
	
	public Controller(Model model, TextView view)
	{
		this.model = model;
		this.view = view;
	}
	
	public void startSession()
	{

		char player = ' ';
		boolean conFlag = false;

		view.displayBoard(model);

		// Tell the user that the game has started.
		view.displayNewGameMessage();

		while (gameTermConditions() == 'g') {
			if (player == 'a'){
				player = 'b';
			} else {
				player = 'a';
			}

			int move = view.askForMove(player);

			if(move == 0){
				conFlag = true;
				break;
			}

			while(!model.isMoveValid(move)) {
				System.out.println("Invalid Move");
				move = view.askForMove(player);
			}

			model.makeMove(move, player);

			view.displayBoard(model);

		}

		if (gameTermConditions() == 'f'){
			System.out.println("Game Over, Full Board");
		} else if (conFlag) {
			System.out.println("Player " + player + " Conceded. Game Over.");
		} else {
			System.out.println("Game Over, Player " + gameTermConditions() + " Wins!");
		}
	}

	public char gameTermConditions(){
		/* Term Conditions:
		 *  - 4 in a row Vertically, horizontally, or diagonally
		*  - Board Full */
		char [] [] board = model.getBoard();
		int nrRows = model.getNrRows();
		int nrCols = model.getNrCols();

		//Find a piece
		for (int i= 0 ; i < nrRows ; i++) {
			for (int j = 0 ; j < nrCols; j++){
				if (!(board[i][j] == ' ')) {

					//See if 4 in a row
					//Vertical
					if (i<=3){
						if (board[i+1][j] == board[i][j]) {
							if (board[i + 2][j] == board[i][j]) {
								if (board[i + 3][j] == board[i][j]) {
									return board[i][j];
								}
							}
						}
					}

					if(i >= nrRows -3){

						if (board[i - 1][j] == board[i][j]) {

							if (board[i - 2][j] == board[i][j]) {

								if (board[i - 3][j] == board[i][j]) {
									return board[i][j];
								}
							}
						}
					}
					//Horizontal

					if(j>=3) {

						if (board[i][j - 1] == board[i][j]) {

							if (board[i][j - 2] == board[i][j]) {

								if (board[i][j - 3] == board[i][j]) {
									return board[i][j];
								}
							}
						}
					}

					if (j<= nrCols-3){

						if (board[i][j + 1] == board[i][j]) {

							if (board[i][j + 2] == board[i][j]) {

								if (board[i][j + 3] == board[i][j]) {
									return board[i][j];
								}
							}
						}
					}
					//Diagonal
					//Check Left & Up Diagonal \.
					if (!(j > nrCols - 4 || i > nrRows-4)) {
						//+i, +j
						if (board[i][j] == board [i + 1][j + 1]){
							if (board[i][j] == board [i + 2][j + 2]){
								if (board[i][j] == board [i + 3][j + 3]){
									return board[i][j];
								}
							}
						}
					}
					//Check Left & Down Diagonal ./
					if (!(j > nrCols - 4 || i < 3)) {
						//-i,+j
						if (board[i][j] == board [i - 1][j + 1]){
							if (board[i][j] == board [i - 2][j + 2]){
								if (board[i][j] == board [i - 3][j + 3]){
									return board[i][j];
								}
							}
						}
					}
					//Check Right & Down Diagonal /*
					if (!(j < 3 || i > nrRows - 4)) {
						// +i, -j
						if (board[i][j] == board [i + 1][j - 1]){
							if (board[i][j] == board [i + 2][j - 2]){
								if (board[i][j] == board [i + 3][j - 3]){
									return board[i][j];
								}
							}
						}
					}
					//Check Right & Up Diagonal \.
					if (!(j < 3 || i < 3 )) {
						// -i, -j
						if (board[i][j] == board [i - 1][j - 1]){
							if (board[i][j] == board [i - 2][j - 2]){
								if (board[i][j] == board [i - 3][j - 3]){
									return board[i][j];
								}
							}
						}
					}
				}
			}
		}


		//See if board has empty space
		for (int i= 0 ; i < nrRows ; i++) {
			for (int j = 0 ; j < nrCols; j++){
				if (board[i][j] == ' ') {
					return 'g';
				}
			}
		}

		return 'f';

	}
}
