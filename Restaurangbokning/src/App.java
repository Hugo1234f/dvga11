import java.awt.Color;
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
			btn.setBackground(Color.green);
			btn = logic.disableButton(btn);
			
			gui.setButton(i, btn);
		}
		
		//game loop
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
				
			}else if(logic.getSelectedBtn() == -2) {
				for(int i = 0; i < 16; i++) {
					if(logic.isTableOccupied(i)) {
						JButton btn = gui.getButton(i);
						btn = logic.enableButton(btn);
						gui.setButton(i, btn);
					}
				}
			}else if(logic.getSelectedBtn() == -3) {
				
			}else if(logic.getSelectedBtn() == -4) {
				
			}else if(logic.getSelectedBtn() == -5) {
				
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
		
		for(int i = 0; i < 16; i++) {
			if(e.getSource() == gui.getButton(i)) {
				if(logic.getSelectedBtn() == -1) {		//allocate
					logic.setTableOccupied(i);
					
					JButton btn = gui.getButton(i);
					btn.setBackground(Color.red);
					gui.setButton(i, btn);
				}
				if(logic.getSelectedBtn() == -2) {		//de-allocate
					logic.setTableAvailable(i);
					
					JButton btn = gui.getButton(i);
					btn.setBackground(Color.green);
					gui.setButton(i, btn);
				}
				if(logic.getSelectedBtn() == -3) { 		//reserve
					
				}
				if(logic.getSelectedBtn() == -4) {		//add to wait list
					
				}
				if(logic.getSelectedBtn() == -5) {		//remove from wait list
					
				}
				
				logic.controllBtnPress(0);
				System.out.println("table button " + (i+1) + " press");
				return;
			}
		}
		
		if(e.getSource() == gui.getButton(-1)) {	//allocate button
			logic.controllBtnPress(-1);
			System.out.println("Allocate button press");
			return;
		}
		if(e.getSource() == gui.getButton(-2)) {	//deallocate button
			logic.controllBtnPress(-2);
			System.out.println("Deallocate button press");
			return;
		}
		if(e.getSource() == gui.getButton(-3)) {	//reserve button
			logic.controllBtnPress(-3);
			System.out.println("Reserve button press");
			return;
		}
		if(e.getSource() == gui.getButton(-4)); {	//wait button
			logic.controllBtnPress(-4);
			System.out.println("Wait button press");
			return;
		}
		
		
	}
	
}
