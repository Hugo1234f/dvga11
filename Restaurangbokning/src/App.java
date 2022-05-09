import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class App implements ActionListener, MouseListener {

	public static final int ALLOCATE_BUTTON = -1;
	public static final int DEALLOCATE_BUTTON = -2;
	public static final int RESERVE_BUTTON = -3;
	public static final int WAITLIST_ADD_BUTTON = -4;
	public static final int WAITLIST_REMOVE_BUTTON = -5;
	
	private GUIManager gui;
	private Logic logic;
	
	public App() {
		gui = new GUIManager();
		logic = new Logic();
		
		//add actionlistener for the controll buttons
		for(int i = 0; i < 5; i++) {
			JButton btn = gui.getButton(i-5);
			btn.addActionListener(this);
			gui.setButton(i-5, btn);
		}
		
		//add actionlistener for the table buttons
		for(int i = 0; i < 16; i++) {
			JButton btn = gui.getButton(i);
			btn.addActionListener(this);
			btn.setBackground(Color.decode("#48A14D"));
			btn = logic.disableButton(btn);
			
			gui.setButton(i, btn);
		}
		
		//game loop
		while(true) {
			gui.setDate(logic.getDate());
			gui.setTime(logic.getTime());
			
			
			if(logic.getSelectedBtn() == ALLOCATE_BUTTON) {
				for(int i = 0; i < 16; i++) {
					if(logic.isTableFree(i)) {
						JButton btn = gui.getButton(i);
						btn = logic.enableButton(btn);
						gui.setButton(i, btn);
					}
				}
				
			}else if(logic.getSelectedBtn() == DEALLOCATE_BUTTON) {
				for(int i = 0; i < 16; i++) {
					if(logic.isTableOccupied(i)) {
						JButton btn = gui.getButton(i);
						btn = logic.enableButton(btn);
						gui.setButton(i, btn);
					}
				}
			}else if(logic.getSelectedBtn() == RESERVE_BUTTON) {
				
			}else if(logic.getSelectedBtn() == WAITLIST_ADD_BUTTON) {	//Add to waiting List
				String name = "";
				String number = "";
				int num = 0;
				
				while(true) {
					name = JOptionPane.showInputDialog("Namn of group...");
					if(name == null) {
						logic.controllBtnPress(0); 
						System.out.println("Pane canceled");
						break;
					}else if(name.length() == 0) {
						System.out.println("Error: name must have lenght");
					}else {
						if(name.length() < 1) {System.out.println("Error creating queueItem: item must have a name"); break;}
						break;
					}
				}
				
				while(true) {
					number = JOptionPane.showInputDialog("Storlek på sällskapet...");
					if(number == null) {
						logic.controllBtnPress(0); 
						System.out.println("Pane canceled");
						break;
					}else if(number.length() == 0) {
						System.out.println("Error: Size must exist");
					}else {
						if(number.length() < 1) {System.out.println("Error creating queueItem: item must have a size"); break;}
						
						try {
							num = Integer.parseInt(number);
							break;
						}catch(Exception e) {
							
						}
					}
				}
				
				if(name == null || number == null) {break;}
				
				gui.addToWaitingList(new QueueItem(name, number));
				gui.updateWaitList();
				QueueItem item = gui.getLastItem();
				item.addMouseListener(this);
				gui.setLastItem(item);
				
				logic.controllBtnPress(0);
				
			}else if(logic.getSelectedBtn() == WAITLIST_REMOVE_BUTTON) {
				int choice = JOptionPane.showConfirmDialog(null,"Är du säker på att du vill ta bort alla markerade köplatser?");
				
				//If choice is 'yes', remove marked elements
				if(choice == JOptionPane.YES_OPTION) {
					int len = gui.getListSize();
					
					for(int i = 0; i < len; i++) {
						if(gui.getColor(i) == Color.LIGHT_GRAY) {
							gui.removeElement(i);
							i--;
							len = gui.getListSize();
							gui.updateWaitList();
						}
					}
				}
				
				logic.controllBtnPress(0);
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
		
		//Find the button in which the event has taken place
		for(int i = 0; i < 16; i++) {
			if(e.getSource() == gui.getButton(i)) {
				if(logic.getSelectedBtn() == ALLOCATE_BUTTON) {		//allocate
					logic.setTableOccupied(i);
					
					JButton btn = gui.getButton(i);
					btn.setBackground(Color.decode("#cc79a7"));
					gui.setButton(i, btn);
				}
				
				if(logic.getSelectedBtn() == DEALLOCATE_BUTTON) {		//de-allocate
					logic.setTableAvailable(i);
					
					JButton btn = gui.getButton(i);
					btn.setBackground(Color.decode("#48A14D"));
					gui.setButton(i, btn);
				}
				
				if(logic.getSelectedBtn() == RESERVE_BUTTON) {}
				if(logic.getSelectedBtn() == WAITLIST_ADD_BUTTON) {}
				if(logic.getSelectedBtn() == WAITLIST_REMOVE_BUTTON) {}
				
				logic.controllBtnPress(0);
				System.out.println("table button " + (i+1) + " press");
				
				return;
			}
		}
		
		if(e.getSource() == gui.getButton(ALLOCATE_BUTTON)) {	//allocate button
			logic.controllBtnPress(ALLOCATE_BUTTON);
			System.out.println("Allocate button press");
			
			return;
		}
		
		if(e.getSource() == gui.getButton(DEALLOCATE_BUTTON)) {	//deallocate button
			logic.controllBtnPress(DEALLOCATE_BUTTON);
			System.out.println("Deallocate button press");
			
			return;
		}
		
		if(e.getSource() == gui.getButton(RESERVE_BUTTON)) {	//reserve button
			logic.controllBtnPress(RESERVE_BUTTON);
			System.out.println("Reserve button press");
			
			return;
		}
		
		if(e.getSource() == gui.getButton(WAITLIST_ADD_BUTTON)) {	//add wait button
			logic.controllBtnPress(WAITLIST_ADD_BUTTON);
			System.out.println("add queue button press");
			
			return;
		}
		
		if(e.getSource() == gui.getButton(WAITLIST_REMOVE_BUTTON)) {	//remove wait button
			logic.controllBtnPress(WAITLIST_REMOVE_BUTTON);
			System.out.println("Remove queue button press");
			
			return;
		}
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		QueueItem item = (QueueItem) e.getComponent();
		System.out.println(item.getBackground().toString());
		
		if(item.getBackground() == Color.white) {
			item.setBackground(Color.lightGray);
		}else {
			item.setBackground(Color.white);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
