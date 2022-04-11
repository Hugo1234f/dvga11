import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class App implements ActionListener {

	public static final String player1 = "O";
	public static final String player2 = "X";
	public static String currentPlayer = player1;
	
	private GUI gui;
	private Logic logic;
	
	public App() {
		gui = new GUI();
		logic = new Logic();
		
		setUpBtnConnection();
	}
	
	//Adds action listeners to the gui buttons
	private void setUpBtnConnection() {
		for(int i = 0; i < 9; i++) {
			JButton btn = gui.getButton(i);
			btn.addActionListener(this);
			gui.setButton(btn, i);
		}
	}

	//Manages button presses
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i = 0; i < 9; i++) {						//Finds the button that triggered the event
			if(e.getSource() == gui.getButton(i)) {
				if(logic.IsLeagalMove(i)) {					//Checks if the move is leagal, and if so makes it.
					JButton btn = gui.getButton(i);			
					btn.setText(currentPlayer);
					if(currentPlayer == player1) {
						btn.setForeground(Color.red);
					}else {
						btn.setForeground(Color.blue);
					}
					gui.setButton(btn, i);
					
					logic.makeMove(i);
					gui.switchCurrentPlayer();
				}
			}
		}
		
		int gameStatus = logic.getStatus();
		System.out.println(gameStatus);
		if(gameStatus != 0) {
			gui.triggerWinEnd(gameStatus); 
			logic.reset();
		}
	}
	
	//Sets the current player
	public void SetCurrentPlayer(String newPlayer) {
		if(newPlayer == player1 || newPlayer == player2) {
			currentPlayer = newPlayer;
		}
	}

	
}