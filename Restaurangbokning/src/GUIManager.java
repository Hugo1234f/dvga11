import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUIManager {

	private JFrame frame;
	private WaitingList waitingList;
	private UtilityManager utility;
	private JPanel waitPanel, utilityPanel, keyboardPanel, centerPanel;
	
	public GUIManager() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// https://www.geeksforgeeks.org/java-program-to-print-screen-resolution/
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		
		frame.setSize(size.width, (int)(size.height * 0.9f));
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		setUpLayouts();
		
		frame.add(utilityPanel, BorderLayout.NORTH);
		frame.add(waitPanel, BorderLayout.EAST);
	}
	
	private void setUpLayouts() {
		//Center: BorderLayout(top: bild på restaurang, bot: knappar av borden)
		//right: väntlista/reserverade bord
		//bot: tangentbord
		//top: tid, datum, etc.
		
		utilityPanel = new JPanel(new FlowLayout());
		waitPanel = new JPanel();
	}
	
}
