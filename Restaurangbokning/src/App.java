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
			
			btn = logic.disableButton(btn);
			
			gui.setButton(i, btn);
		}
		
		while(true) {
			gui.setDate(logic.getDate());
			gui.setTime(logic.getTime());
			
			if(logic.getSelectedBtn() == -1) {
				for(int i = 0; i < 16; i++) {
					if(logic.isTableFree(i)) {
						JButton btn = gui.getButton(i);
						btn = logic.enableButton(btn);
						gui.setButton(i, btn);
					}
				}
			}
			else {
				for(int i = 0; i < 16; i++) {
					JButton btn = gui.getButton(i);
					btn = logic.disableButton(btn);
					gui.setButton(i, btn);
				}
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("test");
		
		if(e.getSource() == gui.getButton(-1)) {	//allocate button
			logic.controllBtnPress(-1);
			return;
		}
		if(e.getSource() == gui.getButton(-2)) {	//deallocate button
			logic.controllBtnPress(-2);
			return;
		}
		if(e.getSource() == gui.getButton(-3)) {	//reserve button
			logic.controllBtnPress(-3);
			return;
		}
		if(e.getSource() == gui.getButton(-4)); {	//wait button
			logic.controllBtnPress(-4);
			return;
		}
	}
	
}
