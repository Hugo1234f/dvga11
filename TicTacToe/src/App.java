import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class App implements ActionListener{

	private Logic logic;
	private GUI gui;

	private Color defaultColor = Color.white;
	
	public App() {
		logic = new Logic(defaultColor);
		gui = new GUI(defaultColor);
		
		//Add actionListeners to the buttons
		for(int i= 0; i < 9; i++) {
			JButton tmp = gui.getButton(i);
			tmp.addActionListener(this);
			gui.setButton(i, tmp);
		}
	}

	//Catches events from the GUI buttons and deals with them
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i = 0; i < 9; i++) {
			if(e.getSource() == gui.getButton(i)) {
				if(logic.IsLegalMove(i)) {
					logic.confirmMove(i);
					updateBoard();
				}
			}
		}
		
	}
	
	//Updates the GUI using the data from logic
	//setFont taken from:
	// 	http://www.java2s.com/Code/JavaAPI/java.awt/newFontStringnameintstyleintsize.htm
	private void updateBoard() {
		for(int i = 0; i < 9; i++) {
			JButton btn = gui.getButton(i);
			
			Color color = logic.getColor(i);
			Font font = new Font("Arial", Font.BOLD, 42);
			
			btn.setText(logic.getInfo(i));
			btn.setFont(font);
			btn.setForeground(logic.getColor(i));
			
			
			gui.setButton(i, btn);
			gui.setCurrentPlayer("Current player: " + logic.getCurrentPlayer(), logic.getCurrentPlayerColor());
		}
	}
	
	
	
	
	
}