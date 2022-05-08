import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;


// https://docs.oracle.com/javase/tutorial/uiswing/painting/step2.html
public class QueueItem extends JPanel {

	private String ReservationName;
	private String persons;
	private boolean clickable = true;;
	
	public QueueItem(String ReservationName) {
		this.ReservationName = ReservationName;
		
		setBorder(BorderFactory.createLineBorder(Color.black));
		this.setMinimumSize(getPreferredSize());
		this.setMaximumSize(getPreferredSize());
		this.setPreferredSize(getPreferredSize());
		this.setLayout(new FlowLayout(FlowLayout.LEADING));
		
		this.add(new JLabel(ReservationName));
		
	}
	
	public String getReservationName() {
		return ReservationName;
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(200,50);
	}
	
	public boolean isClickable() {
		return clickable;
	}
	
	public void setClickable(boolean state) {
		clickable = state;
	}
	
	public void setPersons(String persons) {
		this.persons = persons;
	}
	
	public String getPersons() {
		return this.persons;
	}

	
	
}
