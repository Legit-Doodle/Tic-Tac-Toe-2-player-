import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Random;

public class TicTacToe {
	static char[][] board = {{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};
	static String user1;
	static String user2;
	static char user1Mark;
	static char user2Mark;
	static Set<Integer> taken1 = new HashSet<>();
	static Set<Integer> taken2 = new HashSet<>();
	
	public static void main(String[] args) {

		displayBoard();
		play();
	}
	
	public static void registration(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter user 1 name:");
		user1 = scanner.next();
		System.out.println("Enter user 2 name:");
		user2 = scanner.next();
	}
	
	public static int toss() {
		List<Integer> tossResult = new ArrayList<>();
		tossResult.add(1);
		tossResult.add(2);
		Random rand = new Random();
		return tossResult.get(rand.nextInt(2));
		
	}
	
	public static void fillPos(int x,char c) {
		board[x/3][x%3]=c;
	}
	
	public static void move(int x,boolean one) {
		if(one) {
			fillPos(x,user1Mark);
			taken1.add(x);
		}
		else {
			fillPos(x,user2Mark);
			taken2.add(x);
		}
	}
	
	public static boolean checkWinner(boolean one) {
		boolean winnerOne=false;
		boolean winnerTwo=false;
		if(one) {
		winnerOne=taken1.contains(0) && taken1.contains(1) && taken1.contains(2)
			||taken1.contains(3) && taken1.contains(4) && taken1.contains(5)
			||taken1.contains(6) && taken1.contains(7) && taken1.contains(8)
			||taken1.contains(0) && taken1.contains(3) && taken1.contains(6)
			||taken1.contains(1) && taken1.contains(4) && taken1.contains(7)
			||taken1.contains(2) && taken1.contains(5) && taken1.contains(8)
			||taken1.contains(0) && taken1.contains(4) && taken1.contains(8)
			||taken1.contains(2) && taken1.contains(4) && taken1.contains(6);
		}
		else {
		winnerTwo=taken2.contains(0) && taken2.contains(1) && taken2.contains(2)
			||taken2.contains(3) && taken2.contains(4) && taken2.contains(5)
			||taken2.contains(6) && taken2.contains(7) && taken2.contains(8)
			||taken2.contains(0) && taken2.contains(3) && taken2.contains(6)
			||taken2.contains(1) && taken2.contains(4) && taken2.contains(7)
			||taken2.contains(2) && taken2.contains(5) && taken2.contains(8)
			||taken2.contains(0) && taken2.contains(4) && taken2.contains(8)
			||taken2.contains(2) && taken2.contains(4) && taken2.contains(6);
		}
		
		if(winnerOne) {
			System.out.println("Congratulations!! "+user1+" is the winner!!");
		}
		else if(winnerTwo) {
			System.out.println("Congratulations!! "+user2+" is the winner!!");
		}
		
		return (winnerOne||winnerTwo);
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
	
	public static void play() {
		registration();
		int t= toss();
		Scanner scanner = new Scanner(System.in);
		if(t==1) {
			System.out.println(user1+" won the toss!! Enter your mark(X or O): ");
			user1Mark=scanner.next().charAt(0);
			if(user1Mark=='X') {
				user2Mark='O';
			}
			else {
				user2Mark='X';
			}
		}
		else {
			System.out.println(user2+" won the toss!! Enter your mark(X or O): ");
			user2Mark=scanner.next().charAt(0);
			if(user2Mark=='X') {
				user1Mark='O';
			}
			else {
				user1Mark='X';
			}
		}
		
		int moveCount=1;
		while(moveCount<=9) {
			boolean one = moveCount%2!=0;
			if(one) {
				System.out.println(user1+" Enter posn number: ");
			}
			else {
				System.out.println(user2+" Enter posn number: ");
			}
			boolean error=true;
			while(error) {
				int x=scanner.nextInt();
				error=taken1.contains(x)||taken2.contains(x);
				if(error) {
					System.out.println("Invalid Input!! Enter again");
				}
				else {
					move(x,one);
				}
			}
			displayBoard();
			if(checkWinner(one)) {
				return;
			}
			moveCount++;
		}
		System.out.println("It's a draw!!");
	}
}


