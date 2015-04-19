
public class FourInADoge {
    static char[][] gameBoard;
	static int width = 7;
	static int height = 6;
	
	public static void makeGameBoard(){
		gameBoard = new char[width][height];
		
		// Empty-fill array
		for(int i = 0; i < width; i++){
			for( int j = 0; j < height; j++){
				gameBoard[i][j] = ' ';
			}
		}
	}
	
	public static void displayGameBoard(){
		// Loop through all rows and display
		for(int i = 0; i < height; i ++){
			printRow(i);
		}
		
		// Display Bottom border
		for(int i = 0; i < width*2+1; i++){
			System.out.print("-");
		}
	}
	
	public static void printRow(int row){
		// Print the one row of the game board
		System.out.print('|');
		for (int i = 0; i < width; i++){
			System.out.print(gameBoard[i][row]);
			System.out.print('|');
		}
		System.out.print('\n');
	}
	public static void main(String args[])
	{
		makeGameBoard();
		displayGameBoard();
		// run game function here
	}
}
