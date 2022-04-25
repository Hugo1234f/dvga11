import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MainPanel {

	private JPanel controllBtnsPanel, tablesPanel;
	private JPanel centerPanel, controllPanel;
	
	private JButton AddButton, removeButton, ReserveButton;
	
	public MainPanel(JPanel centerPanel) {
		this.centerPanel = centerPanel;
		controllPanel = new JPanel(new BorderLayout());
		controllBtnsPanel = new JPanel();
		tablesPanel = new JPanel();
		
		controllPanel.add(tablesPanel, BorderLayout.EAST);
		controllPanel.add(controllBtnsPanel, BorderLayout.WEST);
		centerPanel.add(controllPanel, BorderLayout.SOUTH);
		
		
	}
	
}
