

public class Logic {

	private String[] gameStatus = {"","","","","","","","",""};
	
	public Logic() {
		
	}
	
	//Returns true if the index provided is empty, otherwise returns false
	public boolean IsLeagalMove(int i) throws IndexOutOfBoundsException {
		if(gameStatus[i] == "") {
			return true;
		}
		return false;
	}
	
	
	//Enters the current player into the index provided
	public void makeMove(int i) throws IndexOutOfBoundsException {
		gameStatus[i] = App.currentPlayer;
		
		if(App.currentPlayer == App.player1) {
			App.currentPlayer = App.player2;
		}else {
			App.currentPlayer = App.player1;
		}
	}
	
	//0: not finished
	//1: player 1 won
	//2: player 2 won
	//3: draw
	public int getStatus() {
		if(isHorizontalWin(App.player1) || isVerticalWin(App.player1) || isDiagonalWin(App.player1)) {
			return 1;
		}
		if(isHorizontalWin(App.player2) || isVerticalWin(App.player2) || isDiagonalWin(App.player2)) {
			return 2;
		}
		
		if(isFull()) {return 3;}
		
		return 0;
	}
	
	//Checks if the board is full
	private boolean isFull() {
		for(int i = 0; i < 9; i++) {
			if(gameStatus[i] == "") {return false;}
		}
		return true;
	}
	
	//Checks if the specified player has a horizontal victory
	private boolean isHorizontalWin(String player) {
		if((gameStatus[0] == player && gameStatus[1] == player && gameStatus[2] == player) ||
			(gameStatus[3] == player && gameStatus[4] == player && gameStatus[5] == player) ||
			(gameStatus[6] == player && gameStatus[7] == player && gameStatus[8] == player)) {
			return true;
		}
			return false;
	}
	
	//Checks if the specified player has a vertical victory
	private boolean isVerticalWin(String player) {
		if((gameStatus[0] == player && gameStatus[3] == player && gameStatus[6] == player) ||
				(gameStatus[1] == player && gameStatus[4] == player && gameStatus[7] == player) ||
				(gameStatus[2] == player && gameStatus[5] == player && gameStatus[8] == player)) {
			return true;
		}
			return false;
	}
	
	//Checks if the specified player has a diagonal victory
	private boolean isDiagonalWin(String player) {
		if((gameStatus[0] == player && gameStatus[4] == player && gameStatus[8] == player) ||
			(gameStatus[6] == player && gameStatus[4] == player && gameStatus[2] == player)) {
			return true;
		}
			return false;
	}
	
	//Clears the gameStatus array
	public void reset() {
		for(int i = 0; i < 9; i++) {
			gameStatus[i] = "";
		}
	}
	
	
}
