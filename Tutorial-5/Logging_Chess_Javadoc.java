import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <dl>
 * <dt>Purpose:
 * <dd>To demonstrate Java skills
 *
 * <dt>Description:
 * <dd>Implements chessgame
 * </dl>
 *
 * @author Tobias Büschel
 * @version 1.0
 *
 */

public class Logging_Chess_Javadoc {
	
	private final static Logger LOGGER = Logger.getLogger(Logging_Chess_Javadoc.class.getName());
	
	/** This defines the enum Chessmen */
	public enum Chessmen {
		WHITE_KING, WHITE_QUEEN, WHITE_ROOK, WHITE_BISHOP, WHITE_KNIGHT, WHITE_PAWN, BLACK_KING, BLACK_QUEEN, BLACK_ROOK, BLACK_BISHOP, BLACK_KNIGHT, BLACK_PAWN, EMPTY
	}

	/**Places Chessmen on chessboard
	 * @param chessboard
	 */
	public static void populateChessboard(Chessmen[][] chessboard) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {

				if (i == 0) {
					switch (j) {
					case 0:
					case 7:
						chessboard[i][j] = Chessmen.BLACK_ROOK;
						break;
					case 1:
					case 6:
						chessboard[i][j] = Chessmen.BLACK_KNIGHT;
						break;
					case 2:
					case 5:
						chessboard[i][j] = Chessmen.BLACK_BISHOP;
						break;
					case 3:
						chessboard[i][j] = Chessmen.BLACK_QUEEN;
						break;
					case 4:
						chessboard[i][j] = Chessmen.BLACK_KING;
						break;
					}
				} else if (i == 1) {
					chessboard[i][j] = Chessmen.BLACK_PAWN;
				}

				else if (i > 1 && i < 6) {
					chessboard[i][j] = Chessmen.EMPTY;
				}

				else if (i == 6) {
					chessboard[i][j] = Chessmen.WHITE_PAWN;
				}

				else if (i == 7) {
					switch (j) {
						case 0:
						case 7:
							chessboard[i][j] = Chessmen.WHITE_ROOK;
							break;
						case 1:
						case 6:
							chessboard[i][j] = Chessmen.WHITE_KNIGHT;
							break;
						case 2:
						case 5:
							chessboard[i][j] = Chessmen.WHITE_BISHOP;
							break;
						case 3:
							chessboard[i][j] = Chessmen.WHITE_QUEEN;
							break;
						case 4:
							chessboard[i][j] = Chessmen.WHITE_KING;
							break;
					}
				}
			}

		}

	}

	/**
	 * Prints chessboard to the console
	 * @param chessboard
	 */
	public static void printBoard(Chessmen[][] chessboard) {
		char a = 'a';
		System.out.print(" ");
		for (int l = 0; l < 8; l++) {
			System.out.print(String.format("%3s", a));
			a++;
		}
		System.out.println("\r");
		
		for (int i = 0; i < 8; i++) {
			System.out.print(8-i + ". ");
			
			for (int j = 0; j < 8; j++) {		
				
				switch (chessboard[i][j]) {
				
				case BLACK_PAWN:
					System.out.print("\u265F ");
					break;
				case BLACK_ROOK:
					System.out.print("\u265C ");
					break;
				case BLACK_KNIGHT:
					System.out.print("\u265E ");
					break;
				case BLACK_BISHOP:
					System.out.print("\u265D ");
					break;
				case BLACK_QUEEN:
					System.out.print("\u265B ");
					break;
				case BLACK_KING:
					System.out.print("\u265A ");
					break;
				case WHITE_PAWN:
					System.out.print("\u2659 ");
					break;
				case WHITE_ROOK:
					System.out.print("\u2656 ");
					break;
				case WHITE_KNIGHT:
					System.out.print("\u2658 ");
					break;
				case WHITE_BISHOP:
					System.out.print("\u2657 ");
					break;
				case WHITE_QUEEN:
					System.out.print("\u2655 ");
					break;
				case WHITE_KING:
					System.out.print("\u2654 ");
					break;
				case EMPTY:
					System.out.print(" ");
					break;
				}
			}
			System.out.println("\r");
		}
	}

	/**
	 * Asks user for input to move Chessmen on chessboard
	 * @param chessboard
	 * @param move String user input
	 */
	public static void move(Chessmen[][] chessboard, String move) {
		// parse move string into components
		String[] components = move.split(" ");
		
		// validates user input
		if (components.length > 3){
			LOGGER.log(Level.SEVERE, "Provide valid move");
		}
		else if ( components[0].length() != 2 || components[2].length() != 2){
			LOGGER.log(Level.WARNING, "Provide valid move");
		}
		else if ( components[0].charAt(0) < 'a' || components[0].charAt(0) > 'h' || components[0].charAt(1) < '1' || components[0].charAt(1) > '8' ){
			LOGGER.log(Level.INFO, "Provide valid move");
		}
		else if ( components[2].charAt(0) < 'a' || components[2].charAt(0) > 'h' || components[2].charAt(1) < '1' || components[2].charAt(1) > '8' ){
			LOGGER.log(Level.INFO, "Provide valid move");
			LOGGER.log(Level.CONFIG, "Provide valid move"); // does not output any log
		}
		else{

		// make the move: replace original position with Chessmen.
		int col = components[0].charAt(0) - 97;
		int row = Math.abs(components[0].charAt(1) - 49-7);
		
		//and place the piece into the new position
		int nCol = components[2].charAt(0) - 97;
		int nRow = Math.abs(components[2].charAt(1) - 49-7);
		
		System.out.println(col+ " " + row + " " + nCol + " " + nRow);
		if (isValid(chessboard, row, col, nRow, nCol)){
			chessboard[nRow][+nCol] = chessboard[row][+col];
			chessboard[row][+col] = Chessmen.EMPTY;
		}
		else{
			LOGGER.log(Level.WARNING, "Move not allowed");
		}
		
		}
	}
	
	/**
	Returns a boolean true if the move is valid, false otherwise.
	@param chessboard @param oldI @param oldJ @param newI @param newJ @return
	**/
	public static Boolean isValid(Chessmen[][] chessboard, int row, int col, int nRow, int nCol) {

		switch (chessboard[row][col]) {
			
		case BLACK_PAWN:
			if (chessboard[nRow][nCol] != Chessmen.EMPTY && (nCol == col + 1 || nCol == col - 1) ){
				return true;
			}
			else if ( chessboard[nRow][nCol] != Chessmen.EMPTY ){
				return false;
			}
			else if ( row + 1 == nRow || (row == 1 && row + 2 == nRow)){
				return true;
			}
			break;
		case WHITE_PAWN:
			if (chessboard[nRow][nCol] != Chessmen.EMPTY && (nCol == col + 1 || nCol == col - 1) ){
				return true;
			}
			else if ( chessboard[nRow][nCol] != Chessmen.EMPTY ){
				return false;
			}
			else if ( row - 1 == nRow || (row == 6 && row - 2 == nRow)){
				return true;
			}
			break;
		case BLACK_ROOK:
				if ((chessboard[nRow][nCol] == Chessmen.WHITE_ROOK ||
				 chessboard[nRow][nCol] == Chessmen.WHITE_KNIGHT ||
				 chessboard[nRow][nCol] == Chessmen.WHITE_BISHOP ||
				 chessboard[nRow][nCol] == Chessmen.WHITE_QUEEN ||
				 chessboard[nRow][nCol] == Chessmen.WHITE_KING || chessboard[nRow][nCol] == Chessmen.EMPTY )
				 && (nCol == col || nRow == row) ){
				return true;
				}
			break;
		case WHITE_ROOK:
			if ((chessboard[nRow][nCol] == Chessmen.BLACK_ROOK ||
				 chessboard[nRow][nCol] == Chessmen.BLACK_KNIGHT ||
				 chessboard[nRow][nCol] == Chessmen.BLACK_BISHOP ||
				 chessboard[nRow][nCol] == Chessmen.BLACK_QUEEN ||
				 chessboard[nRow][nCol] == Chessmen.BLACK_KING || chessboard[nRow][nCol] == Chessmen.EMPTY )
				 && (nCol == col || nRow == row) ){
				return true;
				}
			break;
		case BLACK_KNIGHT:
		case WHITE_KNIGHT:
			break;
		case BLACK_BISHOP:
		case WHITE_BISHOP:
			break;
		case BLACK_QUEEN:
			if ((chessboard[nRow][nCol] == Chessmen.WHITE_ROOK ||
			 chessboard[nRow][nCol] == Chessmen.WHITE_KNIGHT ||
			 chessboard[nRow][nCol] == Chessmen.WHITE_BISHOP ||
			 chessboard[nRow][nCol] == Chessmen.WHITE_QUEEN ||
			 chessboard[nRow][nCol] == Chessmen.WHITE_KING || chessboard[nRow][nCol] == Chessmen.EMPTY)
			 && (nCol == col || nRow == row || nCol == col-1 || nRow == row+1 || nRow == row || nRow == row-1)){
				return true;
		}
		break;
		case WHITE_QUEEN:
			break;
		case BLACK_KING:
			if ((chessboard[nRow][nCol] == Chessmen.WHITE_ROOK ||
			 chessboard[nRow][nCol] == Chessmen.WHITE_KNIGHT ||
			 chessboard[nRow][nCol] == Chessmen.WHITE_BISHOP ||
			 chessboard[nRow][nCol] == Chessmen.WHITE_QUEEN ||
			 chessboard[nRow][nCol] == Chessmen.WHITE_KING || chessboard[nRow][nCol] == Chessmen.EMPTY)
			 && (( nCol == col+1 || nCol == col || nCol == col-1 ) && ( nRow == row+1 || nRow == row || nRow == row-1 ))){
				return true;
		}
		break;
		case WHITE_KING:
			if ((chessboard[nRow][nCol] == Chessmen.BLACK_ROOK ||
				 chessboard[nRow][nCol] == Chessmen.BLACK_KNIGHT ||
				 chessboard[nRow][nCol] == Chessmen.BLACK_BISHOP ||
				 chessboard[nRow][nCol] == Chessmen.BLACK_QUEEN ||
				 chessboard[nRow][nCol] == Chessmen.BLACK_KING || chessboard[nRow][nCol] == Chessmen.EMPTY)
				 && (( nCol == col+1 || nCol == col || nCol == col-1 ) && ( nRow == row+1 || nRow == row || nRow == row-1 ))){
					return true;
			}
			break;	
		case EMPTY:
			return false;		
		}
		return false;
	
	}
	
	
	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Chessmen[][] chessboard = new Chessmen[8][8]; // creates chessboard of size 8 x 8
		String move = "";
		
		populateChessboard(chessboard);
		System.out.println("Input the moves in standard chess notation, such as: “e1 to e5”:\n");
		
		while(true){
			printBoard(chessboard);
			move = sc.nextLine();
			
			if (move.equals("exit")){
				System.exit(1);
			}
			move(chessboard, move);			
		}
	}
}
