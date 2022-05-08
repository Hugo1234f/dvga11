import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class App implements ActionListener, MouseListener {

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
				
			}else if(logic.getSelectedBtn() == -4) {	//Add to waiting List
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
				
			}else if(logic.getSelectedBtn() == -5) {
				int choice = JOptionPane.showConfirmDialog(null,"Är du säker på att du vill ta bort alla markerade köplatser?");
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
		if(e.getSource() == gui.getButton(-4)) {	//add wait button
			logic.controllBtnPress(-4);
			System.out.println("add queue button press");
			return;
		}
		if(e.getSource() == gui.getButton(-5)) {	//remove wait button
			logic.controllBtnPress(-5);
			System.out.println("Remove queue button press");
			return;
		}
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
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
