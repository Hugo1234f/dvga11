import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JPanel;


// https://docs.oracle.com/javase/tutorial/uiswing/painting/step2.html
public class QueueItem extends JPanel {

	private String ReservationName;
	
	public QueueItem(String ReservationName) {
		this.ReservationName = ReservationName;
		
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
        g.drawString(ReservationName, this.getX() + 5, this.getY() + 5);

    }
	
}
