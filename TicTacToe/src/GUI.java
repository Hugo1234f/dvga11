import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

public class GUI extends JFrame{
	
	private JPanel top, bottom, game;
	private JButton[] btns;
	private JLabel currentPlayer;

	private final Color defaultColor;
	
	public GUI(Color defaulColor) {
		currentPlayer = new JLabel("Current Player: X");
		currentPlayer.setForeground(Color.red);
		
		btns = new JButton[9];
		this.defaultColor = defaulColor;
		
		//Set up window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setPreferredSize(new Dimension(500,600));
		setResizable(false);
	
		//Set up layouts
		setLayout(new BorderLayout());
		top = new JPanel(new FlowLayout());
		game = new JPanel(new GridLayout(3,3));
		bottom = new JPanel(new FlowLayout());
		//Add content to the layouts
		
		JLabel player1 = new JLabel("Player: O");
		JLabel player2 = new JLabel("Player: X");
		player1.setForeground(Color.red);
		player2.setForeground(Color.blue);
		
		
		top.add(player1);
		top.add(currentPlayer);
		top.add(player2);
		for(int i = 0; i < 9; i++) {
			btns[i] = new JButton();
			
			btns[i].setBackground(defaultColor);
			btns[i].setRolloverEnabled(false);
			
			game.add(btns[i]);
		}
		bottom.add(getLogo());
		
		
		//Add the layouts to the frame
		add(top, BorderLayout.NORTH);
		add(game, BorderLayout.CENTER);
		add(bottom, BorderLayout.SOUTH);
		pack();
	}
	
	//tries to read tttlogo.png and either returns it, or a error message as a JLabel
	//getScaledInstance taken from:
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
	
	//Returns the JButton at the requested index if it exists. Otherwise throws an exception
	public JButton getButton(int index) throws IndexOutOfBoundsException {
		return btns[index];
	}
	
	//sets the JButton at the requested index if it exists. Otherwise throws an exception
	public void setButton(int index, JButton value) throws IndexOutOfBoundsException {
		btns[index] = value;
	}
	
	public void resetPlayArea() {
		for(int i = 0; i < btns.length; i++) {
			btns[i].setText("");
			btns[i].setBackground(defaultColor);
		}
	}
	
	public void setCurrentPlayer(String player, Color color) {
		currentPlayer.setText(player);
		currentPlayer.setForeground(color);
	}
	
	
}