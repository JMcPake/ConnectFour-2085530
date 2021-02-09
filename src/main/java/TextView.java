/**
 * This file is to be completed by you.
 *
 * @author s2085530
 */
public final class TextView
{
	public TextView()
	{
	
	}
	
	public final void displayNewGameMessage()
	{
		System.out.println("---- NEW GAME STARTED ----");
	}

	public final boolean askAgain(){

		char choice = 'a';

		while (!(choice == 'y' || choice == 'n')){
			System.out.println("Would You Like to Play Again? [y/n]: ");
			choice = InputUtil.readCharFromUser();
		}

		return choice == 'y';
	}
	
	public final int askForMove(char player)
	{
		System.out.print("Select a free column, player "+ player +": ");
		return InputUtil.readIntFromUser();
	}
	
	public final void displayBoard(Model model)
	{
		int nrRows = model.getNrRows();
		int nrCols = model.getNrCols();
		char [][] board = model.getBoard();
		// Get your board representation.
		
		// This can be used to print a line between each row.
		// You may need to vary the length to fit your representation.
		String rowDivider = "-".repeat((4 * nrCols)+1);

		// A StringBuilder is used to assemble longer Strings more efficiently.
		StringBuilder sb = new StringBuilder();

		sb.append(rowDivider).append("\n");
		
		// You can add to the String using its append method.
		for (int i= 0 ; i < nrRows ; i++) {
			for (int j = 0 ; j < nrCols; j++){
				sb.append("| ").append(board[i][j]).append(" ");
			}
			sb.append("|").append("\n").append(rowDivider).append("\n");

		}

		// Then print out the assembled String.
		System.out.println(sb);
	}
}
