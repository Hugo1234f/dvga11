import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GUI extends JFrame {

	private JButton[] btns;
	private JPanel header, gameArea, footer;

	private int player1Score, player2Score;
	private JLabel p1Label, p2Label, currentPlayerLabel;
	private Font largeFont;
	
	public GUI() {
		player1Score = 0;
		player2Score = 0;
		
		largeFont = new Font("sans", Font.BOLD, 42);
		
		//Sets up window
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setMinimumSize(new Dimension(500,400));
		this.setSize(500, 400);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		setTitle("TicTacToe");

		//Sets up window Layouts
		this.setLayout(new BorderLayout());
		header = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
		gameArea = new JPanel(new GridLayout(3, 3));
		footer = new JPanel(new FlowLayout());
		
		//Sets up header
		p1Label = new JLabel("Player O: " + player1Score);
		p2Label = new JLabel("Player X: " + player2Score);
		JLabel preCurPlayer = new JLabel("Current player: ");
		JPanel curPlayer = new JPanel();
		currentPlayerLabel = new JLabel(App.currentPlayer);
		curPlayer.add(preCurPlayer);
		curPlayer.add(currentPlayerLabel);
		if(currentPlayerLabel.getText() == App.player1) {
			currentPlayerLabel.setForeground(Color.red);
		}else {
			currentPlayerLabel.setForeground(Color.blue);
		}
		header.add(p1Label);
		header.add(curPlayer);
		header.add(p2Label);
		p1Label.setForeground(Color.red);
		p2Label.setForeground(Color.blue);
		
		//Sets up main game board
		btns = new JButton[9];
		for(int i = 0; i < 9; i++) {
			JButton btn = new JButton();
			btn.setBackground(Color.white);
			btn.setRolloverEnabled(false);
			btn.setFont(largeFont);
			
			btns[i] = btn;
			gameArea.add(btns[i]);
		}
		
		//Sets up footer
		JLabel logo = getLogo();
		footer.add(logo);
		
		//Adds the JPanels and packs the frame
		this.add(header, BorderLayout.NORTH);
		this.add(gameArea, BorderLayout.CENTER);
		this.add(footer, BorderLayout.SOUTH);
		this.pack();
	}
	
	//Tries to load the logo, returns either the logo, or and error message as a JLabel
	private JLabel getLogo() {
		File f = new File("./tttlogo.png");
		try {
			Image img = ImageIO.read(f);
			img = img.getScaledInstance(60, 40, Image.SCALE_DEFAULT);
			return new JLabel(new ImageIcon(img));
		} catch (IOException e) {
			return new JLabel("ERROR: Could not load logo");
		}
		
	}
	
	//Triggers and end screen, resets the board and adds any eventual points
	public void triggerWinEnd(int status) {
		if(status == 1) {
			player1Score++;
			p1Label.setText("Player O: " + Integer.toString(player1Score));
			JOptionPane.showMessageDialog(this, "Player O Won!");
		}
		if(status == 2) {
			player2Score++;
			p2Label.setText("Player X: " + Integer.toString(player2Score));
			JOptionPane.showMessageDialog(this, "Player X Won!");
		}
		if(status == 3) {
			JOptionPane.showMessageDialog(this, "Draw!");
		}
		
		for(int i = 0; i < 9; i++) {
			btns[i].setText("");
			btns[i].setForeground(Color.white);
		}
	}
	
	//Switches the current shown player
	public void switchCurrentPlayer() {
		currentPlayerLabel.setText(App.currentPlayer);
		if(currentPlayerLabel.getText() == App.player1) {
			currentPlayerLabel.setForeground(Color.red);
		}else {
			currentPlayerLabel.setForeground(Color.blue);
		}
	}

	//Getters and Setters------------------------------------------------------- 
	public JButton getButton(int index) throws IndexOutOfBoundsException {
		return btns[index];
	}
	
	public void setButton(JButton btn, int index) throws IndexOutOfBoundsException {
		btns[index] = btn;
	}

}