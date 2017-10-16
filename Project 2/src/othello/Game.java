/**
 * @author joshuaesau
 * @since 2017-09-15
 * @version 1.0
 *
 */

package othello;
import java.util.InputMismatchException;
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
	String[] validMoves = new String[32];
	int validMovesIndex = 0;
	
	
	/**
	 * @param Specifies what color to pass through overridden constructor
	 */
	public Game(String color) {
		super(color);
	}
	
	//clearList wipes all values from the validMoves array
	//used before checking moves to ensure data is current
	private void clearList() {
		for(int i = 0; i < 32; i++) {
			validMoves[i] = null;
		}
	}
	
	//checkMoves iterates through the board looking for valid moves for the specified color
	private void checkBlackMoves() {
		for(Integer col = 0; col < BOARD_SIZE; col++) {
			for(Integer row = 0; row < BOARD_SIZE; row++) {
				
				if(atPosition(col, row) == BLANK) {
					
					//up
					if(row-1 >= 0 && row-2 >= 0) {
						if(atPosition(col, row-1).equals(isWhite())) {
							if(atPosition(col, row-2).equals(isBlack())) {
								up = true;
								validMoves[validMovesIndex] = col.toString() + " " + row.toString();
								validMovesIndex++;
							}
							if(row-3 >= 0 && atPosition(col, row-3).equals(isBlack()) && atPosition(col, row-3) != BLANK) {
								up = true;
							}
							if(row-4 >= 0 && atPosition(col, row-4).equals(isBlack()) && atPosition(col, row-4) != BLANK) {
								up = true;
							}
							if(row-5 >= 0 && atPosition(col, row-5).equals(isBlack()) && atPosition(col, row-5) != BLANK) {
								up = true;
							}
							if(row-6 >= 0 && atPosition(col, row-6).equals(isBlack()) && atPosition(col, row-6) != BLANK) {
								up = true;
							}
							if(row-7 >= 0 && atPosition(col, row-7).equals(isBlack()) && atPosition(col, row-7) != BLANK) {
								up = true;
							}
						}
					}
				
					//upRight
					if(col+1 <= 7 && col+2 <= 7 && row-1 >= 0 && row-2 >= 0) {
						if(atPosition(col+1, row-1).equals(isWhite())) {
							if(atPosition(col+2, row-2).equals(isBlack())) {
								upRight = true;
								validMoves[validMovesIndex] = col.toString() + " " + row.toString();
								validMovesIndex++;
							}
							if(col+3 <= 7 && row-3 >= 0 && atPosition(col+3, row-3).equals(isBlack()) && atPosition(col+3, row-3) != BLANK) {
								upRight = true;
							}
							if(col+4 <= 7 && row-4 >= 0 && atPosition(col+4, row-4).equals(isBlack()) && atPosition(col+4, row-4) != BLANK) {
								upRight = true;
							}
							if(col+5 <= 7 && row-5 >= 0 && atPosition(col+5, row-5).equals(isBlack()) && atPosition(col+5, row-5) != BLANK) {
								upRight= true;
							}
							if(col+6 <= 7 && row-6 >= 0 && atPosition(col+6, row-6).equals(isBlack()) && atPosition(col+6, row-6) != BLANK) {
								upRight = true;
							}
							if(col+7 <= 7 && row-7 >= 0 && atPosition(col+7, row-7).equals(isBlack()) && atPosition(col+7, row-7) != BLANK) {
								upRight = true;
							}
						}
					}
				
					//right
					if(col+1 <= 7 && col+2 <= 7) {
						if(atPosition(col+1, row).equals(isWhite())) {
							if(atPosition(col+2, row).equals(isBlack())) {
								right = true;
								validMoves[validMovesIndex] = col.toString() + " " + row.toString();
								validMovesIndex++;
							}
							if(col+3 <= 7 && atPosition(col+3, row).equals(isBlack()) && atPosition(col+3, row) != BLANK) {
								right = true;
							}
							if(col+4 <= 7 && atPosition(col+4, row).equals(isBlack()) && atPosition(col+4, row) != BLANK) {
								right = true;
							}
							if(col+5 <= 7 && atPosition(col+5, row).equals(isBlack()) && atPosition(col+5, row) != BLANK) {
								right = true;
							}
							if(col+6 <= 7 && atPosition(col+6, row).equals(isBlack()) && atPosition(col+6, row) != BLANK) {
								right = true;
							}
							if(col+7 <= 7 && atPosition(col+7, row).equals(isBlack()) && atPosition(col+7, row) != BLANK) {
								right = true;
							}
						}
					}
					
					//downRight
					if(col+1 <= 7 && col+2 <=7 && row+1 <= 7 && row+2 <= 7) {
						if(atPosition(col+1, row+1).equals(isWhite())) {
							if(atPosition(col+2, row+2).equals(isBlack())) {
								downRight = true;
								validMoves[validMovesIndex] = col.toString() + " " + row.toString();
								validMovesIndex++;
							}
							if(col+3 <= 7 && row+3 <= 7 && atPosition(col+3, row+3).equals(isBlack()) && atPosition(col+3, row+3) != BLANK) {
								downRight = true;
							}
							if(col+4 <= 7 && row+4 <= 7 && atPosition(col+4, row+4).equals(isBlack()) && atPosition(col+4, row+4) != BLANK) {
								downRight = true;
							}
							if(col+5 <= 7 && row+5 <= 7 && atPosition(col+5, row+5).equals(isBlack()) && atPosition(col+5, row+5) != BLANK) {
								downRight = true;
							}
							if(col+6 <= 7 && row+6 <= 7 && atPosition(col+6, row+6).equals(isBlack()) && atPosition(col+6, row+6) != BLANK) {
								downRight = true;
							}
							if(col+7 <= 7 && row+7 <= 7 && atPosition(col+7, row+7).equals(isBlack()) && atPosition(col+7, row+7) != BLANK) {
								downRight = true;
							}
						}
					}

					//down
					if(row+1 <= 7 && row+2 <= 7) {
						if(atPosition(col, row+1).equals(isWhite())) {
							if(atPosition(col, row+2).equals(isBlack())) {
								down = true;
								validMoves[validMovesIndex] = col.toString() + " " + row.toString();
								validMovesIndex++;
							}
							if(row+3 <= 7 && atPosition(col, row+3).equals(isBlack()) && atPosition(col, row+3) != BLANK) {
								down = true;
							}
							if(row+4 <= 7 && atPosition(col, row+4).equals(isBlack()) && atPosition(col, row+4) != BLANK) {
								down = true;
							}
							if(row+5 <= 7 && atPosition(col, row+5).equals(isBlack()) && atPosition(col, row+5) != BLANK) {
								down = true;
							}
							if(row+6 <= 7 && atPosition(col, row+6).equals(isBlack()) && atPosition(col, row+6) != BLANK) {
								down = true;
							}
							if(row+7 <= 7 && atPosition(col, row+7).equals(isBlack()) && atPosition(col, row+7) != BLANK) {
								down = true;
							}
						}
					}

					//downLeft
					if(col-1 >= 0 && col-2 >= 0 && row+1 <= 7 && row+2 <= 7) {
						if(atPosition(col-1, row+1).equals(isWhite())) {
							if(atPosition(col-2, row+2).equals(isBlack())) {
								downLeft = true;
								validMoves[validMovesIndex] = col.toString() + " " + row.toString();
								validMovesIndex++;
							}
							if(col-3 >= 0 && row+3 <= 7 && atPosition(col-3, row+3).equals(isBlack()) && atPosition(col-3, row+3) != BLANK) {
								downLeft = true;
							}
							if(col-4 >= 0 && row+4 <= 7 && atPosition(col-4, row+4).equals(isBlack()) && atPosition(col-4, row+4) != BLANK) {
								downLeft = true;
							}
							if(col-5 >= 0 && row+5 <= 7 && atPosition(col-5, row+5).equals(isBlack()) && atPosition(col-5, row+5) != BLANK) {
								downLeft = true;
							}
							if(col-6 >= 0 && row+6 <= 7 && atPosition(col-6, row+6).equals(isBlack()) && atPosition(col-6, row+6) != BLANK) {
								downLeft = true;
							}
							if(col-7 >= 0 && row+7 <= 7 && atPosition(col-7, row+7).equals(isBlack()) && atPosition(col-7, row+7) != BLANK) {
								downLeft = true;
							}
						}
					}

					//left
					if(col-1 >= 0 && col-2 >= 0) {
						if(atPosition(col-1, row).equals(isWhite())) {
							if(atPosition(col-2, row).equals(isBlack())) {
								left = true;
								validMoves[validMovesIndex] = col.toString() + " " + row.toString();
								validMovesIndex++;
							}
							if(col-3 >= 0 && atPosition(col-3, row).equals(isBlack()) && atPosition(col-3, row) != BLANK) {
								left = true;
							}
							if(col-4 >= 0 && atPosition(col-4, row).equals(isBlack()) && atPosition(col-4, row) != BLANK) {
								left = true;
							}
							if(col-5 >= 0 && atPosition(col-5, row).equals(isBlack()) && atPosition(col-5, row) != BLANK) {
								left = true;
							}
							if(col-6 >= 0 && atPosition(col-6, row).equals(isBlack()) && atPosition(col-6, row) != BLANK) {
								left = true;
							}
							if(col-7 >= 0 && atPosition(col-7, row).equals(isBlack()) && atPosition(col-7, row) != BLANK) {
								left = true;
							}
						}
					}

					//upLeft
					if(col-1 >= 0 && col-2 >= 0 && row-1 >= 0 && row-2 >= 0) {
						if(atPosition(col-1, row-1).equals(isWhite())) {
							if(atPosition(col-2, row-2).equals(isBlack())) {
								upLeft = true;
								validMoves[validMovesIndex] = col.toString() + " " + row.toString();
								validMovesIndex++;
							}
							if(col-3 >= 0 && row-3 >= 0 && atPosition(col-3, row-3).equals(isBlack()) && atPosition(col-3, row-3) != BLANK) {
								upLeft = true;
							}
							if(col-4 >= 0 && row-4 >= 0 && atPosition(col-4, row-4).equals(isBlack()) && atPosition(col-4, row-4) != BLANK) {
								upLeft = true;
							}
							if(col-5 >= 0 && row-5 >= 0 && atPosition(col-5, row-5).equals(isBlack()) && atPosition(col-5, row-5) != BLANK) {
								upLeft = true;
							}
							if(col-6 >= 0 && row-6 >= 0 && atPosition(col-6, row-6).equals(isBlack()) && atPosition(col-6, row-6) != BLANK) {
								upLeft = true;
							}
							if(col-7 >= 0 && row-7 >= 0 && atPosition(col-7, row-7).equals(isBlack()) && atPosition(col-7, row-7) != BLANK) {
								upLeft = true;
							}
						}
					}
				}
			}
		}
	}
	
	private void checkWhiteMoves() {
		for(Integer col = 0; col < BOARD_SIZE; col++) {
			for(Integer row = 0; row < BOARD_SIZE; row++) {
				
				if(atPosition(col, row) == BLANK) {
					
					//up
					if(row-1 >= 0 && row-2 >= 0) {
						if(atPosition(col, row-1).equals(isBlack())) {
							if(atPosition(col, row-2).equals(isWhite())) {
								up = true;
								validMoves[validMovesIndex] = col.toString() + " " + row.toString();
								validMovesIndex++;
							}
							if(row-3 >= 0 && atPosition(col, row-3).equals(isWhite()) && atPosition(col, row-3) != BLANK) {
								up = true;
							}
							if(row-4 >= 0 && atPosition(col, row-4).equals(isWhite()) && atPosition(col, row-4) != BLANK) {
								up = true;
							}
							if(row-5 >= 0 && atPosition(col, row-5).equals(isWhite()) && atPosition(col, row-5) != BLANK) {
								up = true;
							}
							if(row-6 >= 0 && atPosition(col, row-6).equals(isWhite()) && atPosition(col, row-6) != BLANK) {
								up = true;
							}
							if(row-7 >= 0 && atPosition(col, row-7).equals(isWhite()) && atPosition(col, row-7) != BLANK) {
								up = true;
							}
						}
					}
				
					//upRight
					if(col+1 <= 7 && col+2 <= 7 && row-1 >= 0 && row-2 >= 0) {
						if(atPosition(col+1, row-1).equals(isBlack())) {
							if(atPosition(col+2, row-2).equals(isWhite())) {
								upRight = true;
								validMoves[validMovesIndex] = col.toString() + " " + row.toString();
								validMovesIndex++;
							}
							if(col+3 <= 7 && row-3 >= 0 && atPosition(col+3, row-3).equals(isWhite()) && atPosition(col+3, row-3) != BLANK) {
								upRight = true;
							}
							if(col+4 <= 7 && row-4 >= 0 && atPosition(col+4, row-4).equals(isWhite()) && atPosition(col+4, row-4) != BLANK) {
								upRight = true;
							}
							if(col+5 <= 7 && row-5 >= 0 && atPosition(col+5, row-5).equals(isWhite()) && atPosition(col+5, row-5) != BLANK) {
								upRight= true;
							}
							if(col+6 <= 7 && row-6 >= 0 && atPosition(col+6, row-6).equals(isWhite()) && atPosition(col+6, row-6) != BLANK) {
								upRight = true;
							}
							if(col+7 <= 7 && row-7 >= 0 && atPosition(col+7, row-7).equals(isWhite()) && atPosition(col+7, row-7) != BLANK) {
								upRight = true;
							}
						}
					}
				
					//right
					if(col+1 <= 7 && col+2 <= 7) {
						if(atPosition(col+1, row).equals(isBlack())) {
							if(atPosition(col+2, row).equals(isWhite())) {
								right = true;
								validMoves[validMovesIndex] = col.toString() + " " + row.toString();
								validMovesIndex++;
							}
							if(col+3 <= 7 && atPosition(col+3, row).equals(isWhite()) && atPosition(col+3, row) != BLANK) {
								right = true;
							}
							if(col+4 <= 7 && atPosition(col+4, row).equals(isWhite()) && atPosition(col+4, row) != BLANK) {
								right = true;
							}
							if(col+5 <= 7 && atPosition(col+5, row).equals(isWhite()) && atPosition(col+5, row) != BLANK) {
								right = true;
							}
							if(col+6 <= 7 && atPosition(col+6, row).equals(isWhite()) && atPosition(col+6, row) != BLANK) {
								right = true;
							}
							if(col+7 <= 7 && atPosition(col+7, row).equals(isWhite()) && atPosition(col+7, row) != BLANK) {
								right = true;
							}
						}
					}
					
					//downRight
					if(col+1 <= 7 && col+2 <=7 && row+1 <= 7 && row+2 <= 7) {
						if(atPosition(col+1, row+1).equals(isBlack())) {
							if(atPosition(col+2, row+2).equals(isWhite())) {
								downRight = true;
								validMoves[validMovesIndex] = col.toString() + " " + row.toString();
								validMovesIndex++;
							}
							if(col+3 <= 7 && row+3 <= 7 && atPosition(col+3, row+3).equals(isWhite()) && atPosition(col+3, row+3) != BLANK) {
								downRight = true;
							}
							if(col+4 <= 7 && row+4 <= 7 && atPosition(col+4, row+4).equals(isWhite()) && atPosition(col+4, row+4) != BLANK) {
								downRight = true;
							}
							if(col+5 <= 7 && row+5 <= 7 && atPosition(col+5, row+5).equals(isWhite()) && atPosition(col+5, row+5) != BLANK) {
								downRight = true;
							}
							if(col+6 <= 7 && row+6 <= 7 && atPosition(col+6, row+6).equals(isWhite()) && atPosition(col+6, row+6) != BLANK) {
								downRight = true;
							}
							if(col+7 <= 7 && row+7 <= 7 && atPosition(col+7, row+7).equals(isWhite()) && atPosition(col+7, row+7) != BLANK) {
								downRight = true;
							}
						}
					}

					//down
					if(row+1 <= 7 && row+2 <= 7) {
						if(atPosition(col, row+1).equals(isBlack())) {
							if(atPosition(col, row+2).equals(isWhite())) {
								down = true;
								validMoves[validMovesIndex] = col.toString() + " " + row.toString();
								validMovesIndex++;
							}
							if(row+3 <= 7 && atPosition(col, row+3).equals(isWhite()) && atPosition(col, row+3) != BLANK) {
								down = true;
							}
							if(row+4 <= 7 && atPosition(col, row+4).equals(isWhite()) && atPosition(col, row+4) != BLANK) {
								down = true;
							}
							if(row+5 <= 7 && atPosition(col, row+5).equals(isWhite()) && atPosition(col, row+5) != BLANK) {
								down = true;
							}
							if(row+6 <= 7 && atPosition(col, row+6).equals(isWhite()) && atPosition(col, row+6) != BLANK) {
								down = true;
							}
							if(row+7 <= 7 && atPosition(col, row+7).equals(isWhite()) && atPosition(col, row+7) != BLANK) {
								down = true;
							}
						}
					}

					//downLeft
					if(col-1 >= 0 && col-2 >= 0 && row+1 <= 7 && row+2 <= 7) {
						if(atPosition(col-1, row+1).equals(isBlack())) {
							if(atPosition(col-2, row+2).equals(isWhite())) {
								downLeft = true;
								validMoves[validMovesIndex] = col.toString() + " " + row.toString();
								validMovesIndex++;
							}
							if(col-3 >= 0 && row+3 <= 7 && atPosition(col-3, row+3).equals(isWhite()) && atPosition(col-3, row+3) != BLANK) {
								downLeft = true;
							}
							if(col-4 >= 0 && row+4 <= 7 && atPosition(col-4, row+4).equals(isWhite()) && atPosition(col-4, row+4) != BLANK) {
								downLeft = true;
							}
							if(col-5 >= 0 && row+5 <= 7 && atPosition(col-5, row+5).equals(isWhite()) && atPosition(col-5, row+5) != BLANK) {
								downLeft = true;
							}
							if(col-6 >= 0 && row+6 <= 7 && atPosition(col-6, row+6).equals(isWhite()) && atPosition(col-6, row+6) != BLANK) {
								downLeft = true;
							}
							if(col-7 >= 0 && row+7 <= 7 && atPosition(col-7, row+7).equals(isWhite()) && atPosition(col-7, row+7) != BLANK) {
								downLeft = true;
							}
						}
					}

					//left
					if(col-1 >= 0 && col-2 >= 0) {
						if(atPosition(col-1, row).equals(isBlack())) {
							if(atPosition(col-2, row).equals(isWhite())) {
								left = true;
								validMoves[validMovesIndex] = col.toString() + " " + row.toString();
								validMovesIndex++;
							}
							if(col-3 >= 0 && atPosition(col-3, row).equals(isWhite()) && atPosition(col-3, row) != BLANK) {
								left = true;
							}
							if(col-4 >= 0 && atPosition(col-4, row).equals(isWhite()) && atPosition(col-4, row) != BLANK) {
								left = true;
							}
							if(col-5 >= 0 && atPosition(col-5, row).equals(isWhite()) && atPosition(col-5, row) != BLANK) {
								left = true;
							}
							if(col-6 >= 0 && atPosition(col-6, row).equals(isWhite()) && atPosition(col-6, row) != BLANK) {
								left = true;
							}
							if(col-7 >= 0 && atPosition(col-7, row).equals(isWhite()) && atPosition(col-7, row) != BLANK) {
								left = true;
							}
						}
					}

					//upLeft
					if(col-1 >= 0 && col-2 >= 0 && row-1 >= 0 && row-2 >= 0) {
						if(atPosition(col-1, row-1).equals(isBlack())) {
							if(atPosition(col-2, row-2).equals(isWhite())) {
								upLeft = true;
								validMoves[validMovesIndex] = col.toString() + " " + row.toString();
								validMovesIndex++;
							}
							if(col-3 >= 0 && row-3 >= 0 && atPosition(col-3, row-3).equals(isWhite()) && atPosition(col-3, row-3) != BLANK) {
								upLeft = true;
							}
							if(col-4 >= 0 && row-4 >= 0 && atPosition(col-4, row-4).equals(isWhite()) && atPosition(col-4, row-4) != BLANK) {
								upLeft = true;
							}
							if(col-5 >= 0 && row-5 >= 0 && atPosition(col-5, row-5).equals(isWhite()) && atPosition(col-5, row-5) != BLANK) {
								upLeft = true;
							}
							if(col-6 >= 0 && row-6 >= 0 && atPosition(col-6, row-6).equals(isWhite()) && atPosition(col-6, row-6) != BLANK) {
								upLeft = true;
							}
							if(col-7 >= 0 && row-7 >= 0 && atPosition(col-7, row-7).equals(isWhite()) && atPosition(col-7, row-7) != BLANK) {
								upLeft = true;
							}
						}
					}
				}
			}
		}
	}
	
	private void makeBlackMove(int x, int y) {
		if(up == true) {
			setSquare(x, y, BLACK);
			y--;
			while(atPosition(x,y) != BLANK && y >= 0) {
				if(atPosition(x, y).equals(isWhite())) {
				setSquare(x, y, BLACK);
				y--;
				}
			}
		}
		
		if(upRight == true) {
			setSquare(x, y, BLACK);
			x++;
			y--;
			while(atPosition(x,y) != BLANK && x <= 7 && y >= 0) {
				if(atPosition(x, y).equals(isWhite())) {
				setSquare(x, y, BLACK);
				x++;
				y--;
				}
			}
		}
		
		if(right == true) {
			setSquare(x, y, BLACK);
			x++;
			while(atPosition(x,y) != BLANK && x <= 7) {
				if(atPosition(x, y).equals(isWhite())) {
				setSquare(x, y, BLACK);
				x++;
				}
			}
		}
		
		if(downRight == true) {
			setSquare(x, y, BLACK);
			x++;
			y++;
			while(atPosition(x,y) != BLANK && x <= 7 && y >= 0) {
				if(atPosition(x, y).equals(isWhite())) {
				setSquare(x, y, BLACK);
				x++;
				y++;
				}
			}
		}
		
		if(down == true) {
			setSquare(x, y, BLACK);
			y++;
			while(atPosition(x,y) != BLANK && y <= 7) {
				if(atPosition(x, y).equals(isWhite())) {
				setSquare(x, y, BLACK);
				y++;
				}
			}
		}
		
		if(downLeft == true) {
			setSquare(x, y, BLACK);
			x--;
			y++;
			while(atPosition(x,y) != BLANK && y <= 7 && x >= 0) {
				if(atPosition(x, y).equals(isWhite())) {
				setSquare(x, y, BLACK);
				x--;
				y++;
				}
			}
		}
		
		if(left == true) {
			setSquare(x, y, BLACK);
			x--;
			while(atPosition(x,y) != BLANK && x >= 0) {
				if(atPosition(x, y).equals(isWhite())) {
				setSquare(x, y, BLACK);
				x--;
				}
			}
		}
		
		if(upLeft == true) {
			setSquare(x, y, BLACK);
			x--;
			y--;
			while(atPosition(x,y) != BLANK && x >= 0 && y >= 0) {
				if(atPosition(x, y).equals(isWhite())) {
				setSquare(x, y, BLACK);
				x--;
				y--;
				}
			}
		}
	}
	
	private void makeWhiteMove(int x, int y) {
		if(up == true) {
			setSquare(x, y, WHITE);
			y--;
			while(atPosition(x,y) != BLANK && y >= 0) {
				if(atPosition(x, y).equals(isBlack())) {
				setSquare(x, y, WHITE);
				y--;
				}
			}
		}
		
		if(upRight == true) {
			setSquare(x, y, WHITE);
			x++;
			y--;
			while(atPosition(x,y) != BLANK && x <= 7 && y >= 0) {
				if(atPosition(x, y).equals(isBlack())) {
				setSquare(x, y, WHITE);
				x++;
				y--;
				}
			}
		}
		
		if(right == true) {
			setSquare(x, y, WHITE);
			x++;
			while(atPosition(x,y) != BLANK && x <= 7) {
				if(atPosition(x, y).equals(isBlack())) {
				setSquare(x, y, WHITE);
				x++;
				}
			}
		}
		
		if(downRight == true) {
			setSquare(x, y, WHITE);
			x++;
			y++;
			while(atPosition(x,y) != BLANK && x <= 7 && y >= 0) {
				if(atPosition(x, y).equals(isBlack())) {
				setSquare(x, y, WHITE);
				x++;
				y++;
				}
			}
		}
		
		if(down == true) {
			setSquare(x, y, WHITE);
			y++;
			while(atPosition(x,y) != BLANK && y <= 7) {
				if(atPosition(x, y).equals(isBlack())) {
				setSquare(x, y, WHITE);
				y++;
				}
			}
		}
		
		if(downLeft == true) {
			setSquare(x, y, WHITE);
			x--;
			y++;
			while(atPosition(x,y) != BLANK && y <= 7 && x >= 0) {
				if(atPosition(x, y).equals(isBlack())) {
				setSquare(x, y, WHITE);
				x--;
				y++;
				}
			}
		}
		
		if(left == true) {
			setSquare(x, y, WHITE);
			x--;
			while(atPosition(x,y) != BLANK && x >= 0) {
				if(atPosition(x, y).equals(isBlack())) {
				setSquare(x, y, WHITE);
				x--;
				}
			}
		}
		
		if(upLeft == true) {
			setSquare(x, y, WHITE);
			x--;
			y--;
			while(atPosition(x,y) != BLANK && x >= 0 && y >= 0) {
				if(atPosition(x, y).equals(isBlack())) {
				setSquare(x, y, WHITE);
				x--;
				y--;
				}
			}
		}
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
//	private void isValidMove(int x, int y, String color) {
//		valid = false;
//		up = false;
//		upRight = false;
//		right = false;
//		downRight = false;
//		down = false;
//		downLeft = false;
//		left = false;
//		upLeft = false;
//		setPiece(color);
//		flipPiece();
//		flipPiece();
//		int y1=y-1;
//		int y2=y+1;
//		int x1=x-1;
//		int x2=x+1;
//		
//		if(atPosition(x, y).equals(BLANK)) {
//			valid = true;
//			
//			//up
//			if(y-1 >= 0) {
//				if(atPosition(x, y-1).equals(getPiece())) {
//					up = true;
//				}
//			}
//		
//			//upRight
//			if(x+1 <= 7 && y-1 >= 0) {
//				if(atPosition(x+1, y-1).equals(getPiece())) {
//					upRight = true;
//				}
//			}
//		
//			//right
//			if(x+1 <= 7) {
//				if(atPosition(x+1, y).equals(getPiece())) {
//					right = true;
//				}
//			}
//			
//			//downRight
//			if(x+1 <= 7 && y+1 <= 7) {
//				if(atPosition(x+1, y+1).equals(getPiece())) {
//					downRight = true;
//				}
//			}
//
//			//down
//			if(y+1 <= 7) {
//				if(atPosition(x, y+1).equals(getPiece())) {
//					down = true;
//				}
//			}
//
//			//downLeft
//			if(x-1 >= 0 && y+1 <= 7) {
//				if(atPosition(x-1, y+1).equals(getPiece())) {
//					downLeft = true;
//				}
//			}
//
//			//left
//			if(x-1 >= 0) {
//				if(atPosition(x-1, y).equals(getPiece())) {
//					left = true;
//				}
//			}
//
//			//upLeft
//			if(x-1 >= 0 && y-1 >= 0) {
//				if(atPosition(x-1, y-1).equals(getPiece())) {
//					upLeft = true;
//				}
//			}
//		}
//		
//		else if(atPosition(x, y) != BLANK){
//			valid = false;
//		}
//	}

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
		checkBlackMoves();
		try{
			if(input.hasNextInt() == true) {
				int x = input.nextInt();
				int y = input.nextInt();
				//adjust coordinates from user input to array coordinates 
				x--;
				y--;
				StringBuilder sb = new StringBuilder();
				sb.setLength(0);
				sb.append(x + " " + y);
				for(int i = 0; i < 32; i++) {
					clearList();
					if(validMoves[i] != null) {
						System.out.println(validMoves[i]);
						if(validMoves[i].equals(sb.toString())) {
							makeBlackMove(x, y);
						}
					}
				}
				drawBoard();
			}
			else if(input.hasNext("q") == true) {
				run = false;
			}
			else if(input.hasNext("p") == true) {
				nextTurn();
				System.out.println(input.next() + " selected. Turn passed");
				nextTurn();
			}
			else {
				System.out.println(input.next() + " is not valid input.");
				nextTurn();
			}
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("OUT OF BOUNDS -- Numbers must be between 1 and 8!");
			nextTurn();
		}
		catch(InputMismatchException e) {
			System.out.println("INPUT MISMATCH -- Please only use numbers.");
			nextTurn();
		}
		nextTurn();
	}
	
	private void whiteTurn() {
		System.out.println();
		System.out.println("Current Player: WHITE");
		System.out.println("WHITE Player, enter your next move in format \"x y\"");
		System.out.println("You may also enter p to pass or q to quit the program");
		checkWhiteMoves();
		try {
			if(input.hasNextInt() == true) {
				int x = input.nextInt();
				int y = input.nextInt();
				//adjust coordinates from user input to array coordinates 
				x--;
				y--;
				StringBuilder sb = new StringBuilder();
				sb.setLength(0);
				sb.append(x + " " + y);
				for(int i = 0; i < 32; i++) {
					clearList();
					if(validMoves[i] != null) {
						System.out.println(validMoves[i]);
						if(validMoves[i].equals(sb.toString())) {
							makeWhiteMove(x, y);
						}
					}
				}
				drawBoard();
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
			System.out.println("OUT OF BOUNDS -- Numbers must be between 1 and 8!");
			nextTurn();
		}
		catch(InputMismatchException e) {
			System.out.println("INPUT MISMATCH -- Please only use numbers.");
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
			
			//BLACK player turn
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