import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JPanel;


// https://docs.oracle.com/javase/tutorial/uiswing/painting/step2.html
public class QueueItem extends JPanel {

	public QueueItem() {
		setBorder(BorderFactory.createLineBorder(Color.black));
		this.setMinimumSize(getPreferredSize());
		this.setMaximumSize(getPreferredSize());
		this.setPreferredSize(getPreferredSize());
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(200,50);
	}
	
	public void paintComponent(Graphics g) {
        super.paintComponent(g);       

        // Draw Text
        g.drawString("This is my custom Panel!",10,20);
    }
	
}
