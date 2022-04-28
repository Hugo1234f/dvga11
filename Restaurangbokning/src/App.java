import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class App implements ActionListener {

	private GUIManager gui;
	private Logic logic;
	
	public App() {
		gui = new GUIManager();
		logic = new Logic();
		
		//add actionlistener for the controll buttons
		for(int i = 0; i < 4; i++) {
			JButton btn = gui.getButton(i-4);
			btn.addActionListener(this);
			gui.setButton(i-4, btn);
		}
		
		//add actionlistener for the table buttons
		for(int i = 0; i < 16; i++) {
			JButton btn = gui.getButton(i);
			btn.addActionListener(this);
			gui.setButton(i, btn);
		}
		
		while(true) {
			gui.setDate(logic.getDate());
			gui.setTime(logic.getTime());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
	
}
