import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUIManager {

	private JFrame frame;
	private WaitingList waitingList;
	private MainPanel mainPanel;
	private static JPanel waitPanel, utilityPanel, centerPanel;
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
		
		centerPanel.add(loadImage("./floorplan.png"), BorderLayout.NORTH);
		
		waitingList = new WaitingList(waitPanel);
		waitPanel.setPreferredSize(new Dimension(200, waitPanel.getHeight()));
		
		mainPanel = new MainPanel(centerPanel);
		
		frame.add(utilityPanel, BorderLayout.NORTH);
		frame.add(waitPanel, BorderLayout.EAST);
		frame.add(centerPanel, BorderLayout.CENTER);
	}
	
	private void setUpLayouts() {
		//Center: BorderLayout(top: bild på restaurang, bot: knappar av borden)
		//right: väntlista/reserverade bord
		//top: tid, datum, etc.
		
		utilityPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 10));
		utilityPanel.setBackground(Color.BLACK);
		
		waitPanel = new JPanel();
		waitPanel.setLayout(new BoxLayout(waitPanel, BoxLayout.Y_AXIS));
		waitPanel.setBackground(Color.decode("#990059"));
		
		centerPanel = new JPanel(new BorderLayout());
		centerPanel.setBackground(new Color(2,27,39));
		
		
	}
	
	public void setTime(String time) {
		this.time.setText(time);
	}
	public void setDate(String date) {
		this.date.setText(date);
	}
	
	private JLabel loadImage(String path) {
		File f = new File(path);
		
		try {
			Image img = ImageIO.read(f);
			img = img.getScaledInstance(1100, 400, Image.SCALE_DEFAULT);
			return new JLabel(new ImageIcon(img));
		} catch (IOException e) {
			return new JLabel("Error, could not load image");
		}
		
	}
	
	public JButton getButton(int button) {
		return mainPanel.getButton(button);
	}
	
	public void setButton(int index, JButton btn) {
		mainPanel.setButton(index, btn);
	}
	
	public void addToWaitingList(QueueItem item) {
		waitingList.addElementToList(item);
	}
	
	public void removeFirstWaitElement() {
		waitingList.removeFirstElement();
	}
	
	public void updateWaitList() {
		frame.remove(waitPanel);
		waitPanel = waitingList.getPanel();
		frame.add(waitPanel, BorderLayout.EAST);
	}
	
	public int getWaitSize() {
		return waitingList.getLenght();
	}
	


}
