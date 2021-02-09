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

			while(!model.isMoveValid(move)) {
				System.out.println("Invalid Move");
				move = view.askForMove(player);
			}

			model.makeMove(move, player);

			view.displayBoard(model);

		}

		if (gameTermConditions() == 'f'){
			System.out.println("Game Over, Full Board");
		} else {
			System.out.println("Game Over, Player " + gameTermConditions() + " Wins!");
		}
	}

	public char gameTermConditions(){
		/* Term Conditions:
		 *  - 4 in a row Vertically, horizontally, or diagonally
		*  - Board Full
		*  - Player Concedes */
		char [] [] board = model.getBoard();
		int nrRows = model.getNrRows();
		int nrCols = model.getNrCols();
		int tally =  1;

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
					if(i == 3) {
						if(j == 2){
							if (board[i][j] == board[i - 1][j + 1]) {
								tally += 1;
								if (board[i][j] == board[i - 2][j + 2]) {
									tally += 1;
									if (board[i][j] == board[i - 3][j + 3]) {
										tally += 1;
									}
								}
							}

							if (board[i][j] == board[i + 1][j + 1]) {
								tally += 1;
								if (board[i][j] == board[i + 2][j + 2]) {
									tally += 1;
									if (board[i][j] == board[i + 3][j + 3]) {
										tally += 1;
									}
								}
							}

						} else if(j == 3){
							if (board[i][j] == board[i - 1][j - 1]) {
								tally += 1;
								if (board[i][j] == board[i - 2][j - 2]) {
									tally += 1;
									if (board[i][j] == board[i - 3][j - 3]) {
										tally += 1;
									}
								}
							}
							if (board[i][j] == board[i + 1][j - 1]) {
								tally += 1;
								if (board[i][j] == board[i + 2][j - 2]) {
									tally += 1;
									if (board[i][j] == board[i + 3][j - 3]) {
										tally += 1;
									}
								}
							}
						}

						if (tally >= 4){
							return board[i][j];
						} else {
							tally = 1;
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
