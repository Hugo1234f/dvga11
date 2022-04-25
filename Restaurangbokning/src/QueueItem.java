import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
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
		this.setLayout(new FlowLayout(FlowLayout.LEADING));
		
		this.add(new JLabel(ReservationName));
		
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(200,50);
	}
	
	
}
