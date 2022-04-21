import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUIManager {

	private JFrame frame;
	private WaitingList waitingList;
	private static JPanel waitPanel, utilityPanel, keyboardPanel, centerPanel;
	private JLabel date, time;
	
	public GUIManager() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// https://www.geeksforgeeks.org/java-program-to-print-screen-resolution/
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		
		frame.setSize(size.width, (int)(size.height * 0.9f));
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setLayout(new BorderLayout());
		
		setUpLayouts();
		
		date = new JLabel("N/A");
		time = new JLabel("N/A");
		date.setForeground(Color.white);
		time.setForeground(Color.white);
		
		utilityPanel.add(date);
		utilityPanel.add(time);
		
		waitingList = new WaitingList(waitPanel);
		
		frame.add(utilityPanel, BorderLayout.NORTH);
		frame.add(waitPanel, BorderLayout.EAST);
		frame.add(keyboardPanel, BorderLayout.SOUTH);
		frame.add(centerPanel, BorderLayout.CENTER);
	}
	
	private void setUpLayouts() {
		//Center: BorderLayout(top: bild på restaurang, bot: knappar av borden)
		//right: väntlista/reserverade bord
		//bot: tangentbord
		//top: tid, datum, etc.
		
		utilityPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 10));
		utilityPanel.setBackground(Color.BLACK);
		
		waitPanel = new JPanel();
		waitPanel.setLayout(new BoxLayout(waitPanel, BoxLayout.Y_AXIS));
		waitPanel.setBackground(Color.red);
		
		keyboardPanel = new JPanel();
		keyboardPanel.setBackground(Color.yellow);
		
		centerPanel = new JPanel(new BorderLayout());
		centerPanel.setBackground(Color.GREEN);
		
		
	}
	
	public void setTime(String time) {
		this.time.setText(time);
	}
	public void setDate(String date) {
		this.date.setText(date);
	}
	


}
