package tic_tac_toe_game;
import java.util.*;

class TicTacToe{
	static char[][] board;
	public TicTacToe(){
		board = new char[3][3];
		initBoard();
	}
	void initBoard(){
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[i].length;j++) {
				board[i][j]= ' ';
			}
		}
	}
	void displayboard() {
		System.out.println("-------------");
		for(int i=0;i<board.length;i++) {
			System.out.print("| ");
			for(int j=0;j<board[i].length;j++) {
				System.out.print(board[i][j]+" | ");
			}
			System.out.println();
			System.out.println("-------------");
		}
	}
    static void placeMark(int row,int col,char mark) {
    	if(row >=0 && row<=2 && col >=0 && col<=2) {
    		board[row][col] = mark; 
    	}
    	else {
    		System.out.println("Invalid Position");
    	}
    }
    static boolean checkColWin() {
    	for(int j=0;j<=2;j++) {
    		if(board[0][j] != ' ' && board[0][j]==board[1][j] && board[1][j]==board[2][j]) {
    			return true;
    		}
    	}
    	return false;
    }
    static boolean checkRowWin() {
    	for(int i=0;i<=2;i++) {
    		if(board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1]== board[i][2]) {
    			return true;
    		}
    	}
    	return false;
    }
    static boolean checkDiaWin() {
    	if((board[0][0] !=' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2])|| 
    			(board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1]==board[2][0])) {
    		return true;
    	}
    	return false;
    }
    
    static boolean checkDraw() {
    	for(int i=0;i<=2;i++) {
    		for(int j=0;j<=2;j++) {
    			if(board[i][j] == ' ') {
    				return false;
    			}
    		}
    	}
    	return true;
    }
}

abstract class Player{
	String name;
	char mark;
	abstract void makeMove();
	boolean isValidMove(int row,int col) {
		if(row >=0 && row <=2 && col >=0 && col <=2) {
			if(TicTacToe.board[row][col] ==' ') {
				return true;
			}
		}
		return false;
	}
}

class HumanPlayer extends Player {
	public HumanPlayer(String name,char mark) {
		this.name = name;
		this.mark = mark;
	}
	
	void makeMove() {
		Scanner in = new Scanner(System.in);
		int row,col;
		do {
			System.out.println("Enter the row and column");
			row = in.nextInt();
			col = in.nextInt();
			
		}while(!isValidMove(row,col));
		TicTacToe.placeMark(row, col, mark);
	}
	
	
}
class AIPlayer extends Player{
	
	public AIPlayer(String name,char mark) {
		this.name = name;
		this.mark = mark;
	}
	
	void makeMove() {
		Scanner in = new Scanner(System.in);
		int row,col;
		do {
			Random r = new Random();
			row =r.nextInt(3);
			col = r.nextInt(3);
			
		}while(!isValidMove(row,col));
		TicTacToe.placeMark(row, col, mark);
	}
}
public class Lanuchgame {

	public static void main(String[] args) {
         TicTacToe t = new TicTacToe();
         HumanPlayer p1 = new HumanPlayer("subbu",'X');
         AIPlayer p2 = new AIPlayer("TapAI",'O');
         Player cp;
         cp =p1;
         while(true) {
        	 System.out.println(cp.name +" turn");
             cp.makeMove();
             
             t.displayboard();
             if(TicTacToe.checkColWin() || TicTacToe.checkDiaWin() || TicTacToe.checkRowWin()) {
            	 System.out.println(cp.name+" has won");
            	 break;
             }
             else if(t.checkDraw()) {
            	 System.out.println("Game is a Draw");
            	 break;
             }
             else {
            	 if(cp==p1) {
            		 cp = p2;
            	 }else {
            		 cp = p1;
            	 }
             } 
         }  
	}
}
