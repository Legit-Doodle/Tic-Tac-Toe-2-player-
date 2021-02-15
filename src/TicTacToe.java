
public class TicTacToe {
	static char[][] board = {{'X',' ',' '},{' ',' ',' '},{' ',' ',' '}};
	String user1;
	String user2;
	public static void main(String[] args) {
		displayBoard();
	}
	
	public static void displayBoard() {
		for(int i=0;i<3;i++) {
			System.out.println();
			System.out.println("--------");
			for(int j=0;j<3;j++) {
				System.out.print("|");
				System.out.print(board[i][j]);
			}
			System.out.print("|");
			
		}
		System.out.println();
		System.out.println("--------");
		
	}

}
