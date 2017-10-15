/**
 * @author joshuaesau
 * @since 2017-09-15
 * @version 1.0
 *
 */

package othello;
import java.util.Scanner;

public class Game extends Board{
	boolean run = true;
	static boolean up, upRight, right, downRight, down, downLeft, left, upLeft;
	boolean movesLeft = true;
	int blackScore = 0;
	int whiteScore = 0;
	final String PLAYER_BLACK = "Black";
	final String PLAYER_WHITE = "White";
	String currentPlayer = PLAYER_BLACK;
	boolean valid;
	Scanner input = new Scanner(System.in);
	
	/**
	 * @param Specifies what color to pass through overridden constructor
	 */
	public Game(String color) {
		super(color);
	}
	
	//nextTurn() switches the current player
	private void nextTurn() {
		if(currentPlayer == PLAYER_BLACK) {
			currentPlayer = PLAYER_WHITE;
		}
		else if(currentPlayer == PLAYER_WHITE) {
			currentPlayer = PLAYER_BLACK;
		}
		else {
			System.out.println("ERROR DETERMINING CURRENT PLAYER");
			System.exit(1);
		}
	}
	/*boardCheck() makes sure that there are valid moves remaining on the board.
	 * If the board fills up or either player runs out of pieces, boardCheck()
	 * assigns false to variable movesLeft*/
	private void boardCheck() {
		int movesRemaining = 60;
		int blackPieces = 0;
		int whitePieces = 0;
		for(int i = 0; i < BOARD_SIZE; i++) {
			for(int j = 0; j < BOARD_SIZE; j++) {
				if(atPosition(i, j) != BLANK) {
					movesRemaining--;
				}
			}
		}
		for(int i = 0; i < BOARD_SIZE; i++) {
			for(int j = 0; j < BOARD_SIZE; j++) {
				if(atPosition(i, j).equals(BLACK)) {
					blackPieces++;
				}
			}
		}
		for(int i = 0; i < BOARD_SIZE; i++) {
			for(int j = 0; j < BOARD_SIZE; j++) {
				if(atPosition(i, j).equals(WHITE)) {
					whitePieces++;
				}
			}
		}
		if(movesRemaining == 0 || blackPieces == 0 || whitePieces == 0) {
			movesLeft = false;
		}
	}
	
	/*isValidMove() takes the player's adjusted input as coordinates as well
	as the color of the turn. The assigned Piece color is then flipped in order
	to check for opposite colors in between the current piece.
	If there is an opponent's piece between, and if the space is already blank,
	it returns true on both if loops*/
	private void isValidMove(int x, int y, String color) {
		valid = false;
		up = false;
		upRight = false;
		right = false;
		downRight = false;
		down = false;
		downLeft = false;
		left = false;
		upLeft = false;
		setPiece(color);
		flipPiece();
//		int y1=y-1;
//		int y2=y+1;
//		int x1=x-1;
//		int x2=x+1;
		
		//up
		if(atPosition(x, y-1).equals(getPiece())) {
			up = true;
			if(atPosition(x, y).equals(BLANK)) {
				valid = true;
			}
		}
		//upRight
		if(atPosition(x+1, y-1).equals(getPiece())) {
			upRight = true;
			if(atPosition(x, y).equals(BLANK)) {
				valid = true;
			}
		}
		//right
		if(atPosition(x+1, y).equals(getPiece())) {
			right = true;
			if(atPosition(x, y).equals(BLANK)) {
				valid = true;
			}
		}
		//downRight
		if(atPosition(x+1, y+1).equals(getPiece())) {
			downRight = true;
			if(atPosition(x,y).equals(BLANK)) {
				valid = true;
			}
		}
		//down
		if(atPosition(x, y+1).equals(getPiece())) {
			down = true;
			if(atPosition(x, y).equals(BLANK)) {
				valid = true;
			}
		}
		//downLeft
		if(atPosition(x-1, y+1).equals(getPiece())) {
			downLeft = true;
			if(atPosition(x,y).equals(BLANK)) {
				valid = true;
			}
		}
		//left
		if(atPosition(x-1, y).equals(getPiece())) {
			left = true;
			if(atPosition(x, y).equals(BLANK)) {
				valid = true;
			}
		}
		//upLeft
		if(atPosition(x-1, y-1).equals(getPiece())) {
			upLeft = true;
			if(atPosition(x, y).equals(BLANK)) {
				valid = true;
			}
		}
		
		else if(atPosition(x, y) != BLANK){
			valid = false;
		}
	}

	/*scoreGame() iterates through a double for loop and tallies the number
	 * of pieces that each player has on the board*/
	private void scoreGame() {
		blackScore = 0;
		whiteScore = 0;
		for(int i = 0; i < BOARD_SIZE; i++) {
			for(int j = 0; j < BOARD_SIZE; j++) {
				if(atPosition(i, j) == BLACK) {
					blackScore++;
				}
				else if(atPosition(i, j) == WHITE) {
					whiteScore++;
				}
				/*else {
					System.out.println("ERROR CALCULATING SCORE");
					System.exit(1);
				}*/
			}
		}
		
		System.out.println("Black Score: " + blackScore + " White Score: " + whiteScore);
		if(blackScore > whiteScore) {
			System.out.println("BLACK PLAYER WINS WITH SCORE OF " + blackScore);
		}
		else if(whiteScore > blackScore) {
			System.out.println("WHITE PLAYER WINS WITH SCORE OF " + whiteScore);
		}
		else {
			System.out.println("SOMEHOW, you tied. Is this even possible?");
		}
		
	}
	
	private void blackTurn() {
		System.out.println();
		System.out.println("Current Player: BLACK");
		System.out.println("BLACK Player, enter your next move in format \"x y\"");
		System.out.println("You may also enter p to pass or q to quit the program");
		
		try{
			if(input.hasNextInt() == true) {
				int x = input.nextInt();
				int y = input.nextInt();
				//adjust coordinates from user input to array coordinates 
				x--;
				y--;
				isValidMove(x, y, setPiece(BLACK));
				if(valid == false) {
					System.out.println("Invalid move! Piece must be placed in a straight line across opponent's piece.");
					nextTurn();
				}
				else {
					if(up == true) {
						setSquare(x, y-1, BLACK);
					}
					if(upRight == true) {
						setSquare(x+1, y-1, BLACK);
					}
					if(right == true) {
						setSquare(x+1, y, BLACK);
					}
					if(downRight == true) {
						setSquare(x+1, y+1, BLACK);
					}
					if(down == true) {
						setSquare(x, y+1, BLACK);
					}
					if(downLeft == true) {
						setSquare(x-1, y+1, BLACK);
					}
					if(left == true) {
						setSquare(x-1, y, BLACK);
					}
					if(upLeft == true) {
						setSquare(x-1, y-1, BLACK);
					}
					setSquare(x, y, setPiece(BLACK));
					drawBoard();
				}
			}
			else if(input.hasNext("q") == true) {
				run = false;
			}
			else if(input.hasNext("p") == true) {
				System.out.println(input.next() + " selected. Turn passed");
				nextTurn();
			}
			else {
				System.out.println(input.next() + " is not valid input.");
				nextTurn();
			}
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Numbers must be between 1 and 8!");
			nextTurn();
		}
		nextTurn();
	}
	
	private void whiteTurn() {
		System.out.println();
		System.out.println("Current Player: WHITE");
		System.out.println("WHITE Player, enter your next move in format \"x y\"");
		System.out.println("You may also enter p to pass or q to quit the program");
		
		try {
			if(input.hasNextInt() == true) {
				int x = input.nextInt();
				int y = input.nextInt();
				//adjust coordinates from user input to array coordinates
				x--;
				y--;
				isValidMove(x, y, setPiece(WHITE));
				if(valid == false) {
					System.out.println("Invalid move! Piece must be placed in a straight line across opponent's piece.");
					nextTurn();
				}
				else {
					if(up == true) {
						setSquare(x, y-1, WHITE);
					}
					if(upRight == true) {
						setSquare(x+1, y-1, WHITE);
					}
					if(right == true) {
						setSquare(x+1, y, WHITE);
					}
					if(downRight == true) {
						setSquare(x+1, y+1, WHITE);
					}
					if(down == true) {
						setSquare(x, y+1, WHITE);
					}
					if(downLeft == true) {
						setSquare(x-1, y+1, WHITE);
					}
					if(left == true) {
						setSquare(x-1, y, WHITE);
					}
					if(upLeft == true) {
						setSquare(x-1, y-1, WHITE);
					}
					setSquare(x, y, setPiece(WHITE));
					drawBoard();
				}
			}
			else if(input.hasNext("q") == true) {
				run = false;
			}
			else if(input.hasNext("p") == true) {
				nextTurn();
				System.out.println("Turn passed");
				nextTurn();
			}
			else {
				System.out.println(input.next() + " is not valid input.");
				nextTurn();
			}
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Numbers must be between 1 and 8!");
			nextTurn();
		}
		nextTurn();
	}
	
	public static void main(String[] args) {
		
		Game othello = new Game(BLANK);
		
		//ensures the board is blank and writes beginning pieces before drawing
		othello.wipeBoard();
		othello.setSquare(3, 3, othello.setPiece(WHITE));
		othello.setSquare(4, 3, othello.setPiece(BLACK));
		othello.setSquare(3, 4, othello.setPiece(BLACK));
		othello.setSquare(4, 4, othello.setPiece(WHITE));
		othello.drawBoard();

		while(othello.run == true) {

			if(othello.currentPlayer == othello.PLAYER_BLACK) {
				othello.blackTurn();
			}
			
			//WHITE player turn
			else if(othello.currentPlayer == othello.PLAYER_WHITE) {
				othello.whiteTurn();
			}
			
			//Runs boardCheck() following each successful move to ensure that more moves exist
			othello.boardCheck();
			if(othello.movesLeft == false) {
				//If no moves remain, game scores itself and prints results
				othello.run = false;
				othello.scoreGame();
				
			}
		}
		
		System.out.println("Goodbye! Thanks for playing!");
		othello.input.close();
		System.exit(0);
	}	
}