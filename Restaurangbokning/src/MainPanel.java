import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MainPanel {

	private JPanel controllBtnsPanel, tablesPanel;
	private JPanel centerPanel, controllPanel;

	private JButton[] tableButtons, tableControllButtons;
	
	public MainPanel(JPanel centerPanel) {
		tableButtons = new JButton[16];
		tableControllButtons = new JButton[4];
		
		this.centerPanel = centerPanel;
		
		controllPanel = new JPanel(new BorderLayout());
		controllBtnsPanel = new JPanel(new FlowLayout());
		tablesPanel = new JPanel(new GridLayout(2,4));
		tablesPanel.setPreferredSize(new Dimension(600,170));
		
		controllBtnsPanel.setBackground(new Color(2,27,39));
		
		for(int i = 0; i < tableButtons.length; i++) {
			tableButtons[i] = new JButton(Integer.toString(i+1));
			tablesPanel.add(tableButtons[i]);
		}
		
		tableControllButtons[0] = new JButton("Allocate");
		tableControllButtons[1] = new JButton("Deallocate");
		tableControllButtons[2] = new JButton("Reserve");
		tableControllButtons[3] = new JButton("wait list");
		
		tableControllButtons[0].setBackground(Color.green);
		tableControllButtons[1].setBackground(Color.red);
		tableControllButtons[2].setBackground(Color.yellow);
		
		controllBtnsPanel.add(tableControllButtons[0]);
		controllBtnsPanel.add(tableControllButtons[1]);
		controllBtnsPanel.add(tableControllButtons[2]);
		controllBtnsPanel.add(tableControllButtons[3]);
		
		
		
		
		controllPanel.add(tablesPanel, BorderLayout.EAST);
		controllPanel.add(controllBtnsPanel, BorderLayout.WEST);

		controllPanel.setBackground(new Color(2, 27, 39));

		centerPanel.add(controllPanel, BorderLayout.SOUTH);

		
	}
	
	//-1: allocaate btn
	//-2: deallocate btn
	//-3: reserve btn
	//-4: wait list btn
	public JButton getButton(int index) throws IndexOutOfBoundsException {
		if(index == -1) {return tableControllButtons[0];}
		if(index == -2) {return tableControllButtons[1];}
		if(index == -3) {return tableControllButtons[2];}
		if(index == -4) {return tableControllButtons[3];}
		
		return tableButtons[index];
		
	}
	public void setButton(int index, JButton btn) throws IndexOutOfBoundsException {
		if(index == -1) {tableControllButtons[0] = btn; return;}
		if(index == -2) {tableControllButtons[1] = btn; return;}
		if(index == -3) {tableControllButtons[2] = btn; return;}
		if(index == -4) {tableControllButtons[3] = btn; return;}
		tableButtons[index] = btn;
	}

	
}
