import java.awt.Color;

public class Logic {

	private final String player1 = "X";
	private final String player2 = "O";
	private final Color player1Color = Color.RED;
	private final Color player2Color = Color.BLUE;
	private final Color defaultColor;
	
	private String currentPlayer;
	
	private String[] gameInfo = {"","","","","","","","",""};;
	
	public Logic(Color defaultColor) {
		currentPlayer = player1;
		this.defaultColor = defaultColor;
	}
	
	//Checks if a move is leagal to make(i.e if the spot has not already been clicked)
	public boolean IsLegalMove(int i) throws IndexOutOfBoundsException{
		if(gameInfo[i] == "") {return true;}
		
		return false;
	}
	
	//makes a move, and switches the current player
	public void confirmMove(int i) throws IndexOutOfBoundsException {
		gameInfo[i] = currentPlayer;
		
		if(currentPlayer == player1) { currentPlayer = player2;}
		else { currentPlayer = player1;}
	}
	
	//returns the status of a position in the gameArea
	public String getInfo(int i) throws IndexOutOfBoundsException {
		return gameInfo[i];
	}
	
	//returns the current player
	public String getCurrentPlayer() {
		return currentPlayer;
	}
	
	//returns the color of a position
	public Color getColor(int i) {
		if(gameInfo[i] == player1) {return player1Color;} 
		else if(gameInfo[i] == player2) {return player2Color;}
		else {return defaultColor;}
	}
	
	public Color getCurrentPlayerColor() {
		if(currentPlayer == player1) {return player1Color;} 
		else {return player2Color;}
	}
	
}
