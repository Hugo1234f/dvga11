import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MainPanel {

	private JPanel controllBtnsPanel, tablesPanel;
	private JPanel centerPanel, controllPanel;

	private JButton addButton, removeButton, reserveButton;
	private JButton[] tableButtons;
	
	public MainPanel(JPanel centerPanel) {
		tableButtons = new JButton[16];
		
		
		
		this.centerPanel = centerPanel;
		controllPanel = new JPanel(new BorderLayout());
		controllBtnsPanel = new JPanel();
		tablesPanel = new JPanel(new GridLayout(2,4));
		tablesPanel.setPreferredSize(new Dimension(600,170));
		
		for(int i = 0; i < tableButtons.length; i++) {
			tableButtons[i] = new JButton(Integer.toString(i+1));
			tablesPanel.add(tableButtons[i]);
		}
		
		controllPanel.add(tablesPanel, BorderLayout.EAST);
		controllPanel.add(controllBtnsPanel, BorderLayout.WEST);

		controllPanel.setBackground(new Color(2, 27, 39));

		centerPanel.add(controllPanel, BorderLayout.SOUTH);

		
	}
	
	//-1: allocaate btn
	//-2: deallocate btn
	//-3: reserve btn
	public JButton getButton(int index) throws IndexOutOfBoundsException {
		if(index == -1) {return addButton;}
		if(index == -2) {return removeButton;}
		if(index == -3) {return reserveButton;}
		
		return tableButtons[index];
		
	}
	public void setButton(int index, JButton btn) throws IndexOutOfBoundsException {
		if(index == -1) {addButton = btn; return;}
		if(index == -2) {removeButton = btn; return;}
		if(index == -3) {reserveButton = btn; return;}
		tableButtons[index] = btn;
	}
}
