import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1085496835987043717L;
	JPanel topBar, gameArea, bottomBar;
	private JButton[] btns;
	
	public GUI() {
		//Set up the window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,500);
		setResizable(false);
		setPreferredSize(new Dimension(500,600));
		setMinimumSize(new Dimension(400,500));
		setVisible(true);
		setLayout(new BorderLayout());
		
		//Initialize the JPanels
		topBar = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 10));
		gameArea = new JPanel(new GridLayout(3,3));
		bottomBar = new JPanel(new FlowLayout());
		btns = new JButton[9];
		
		//Adds content to the panels
		topBar.add(new JLabel("Player O Score"), FlowLayout.LEFT);
		topBar.add(new JLabel("It's O's turn"), FlowLayout.CENTER);
		topBar.add(new JLabel("Player X Score"), FlowLayout.RIGHT);
		
		for(int i = 0; i < 9; i++) {
			btns[i] = new JButton(Integer.toString(i));
			
			btns[i].setBackground(Color.white);
			btns[i].setRolloverEnabled(false);
			btns[i].addActionListener(this);
			
			gameArea.add(btns[i]);
		}
		
		bottomBar.add(getLogo());
		
		
		//Adds the JPanels and packs the frame
		this.add(topBar, BorderLayout.NORTH);
		this.add(gameArea, BorderLayout.CENTER);
		this.add(bottomBar, BorderLayout.SOUTH);
		this.pack();
	}
	
	//ImageIO och ImageIcon h�mtat fr�n:
	//	https://stackoverflow.com/questions/299495/how-to-add-an-image-to-a-jpanel
	//getScaledInstance h�mtat fr�n:
	//	https://stackoverflow.com/questions/5895829/resizing-image-in-java
	private JLabel getLogo() {
		Image logo, scaledLogo;
		try {
			logo = ImageIO.read(new File("./tttlogo.png"));
		} catch (IOException e) {
			return new JLabel("Could not load logo");
		}
		
		scaledLogo = logo.getScaledInstance(60, 40, Image.SCALE_DEFAULT);
		return new JLabel(new ImageIcon(scaledLogo));
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i = 0; i < btns.length; i++) {
			if(e.getSource() == btns[i]) {
				System.out.println("Button " + (i+1) + " was pressed");
			}
		}
	}
	
	
	
}