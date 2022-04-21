import java.awt.Color;
import java.awt.Graphics;
import java.time.LocalDate;
import java.time.LocalTime;

public class Reservation extends QueueItem {
	
	private String name;
	private String time;
	private String date;
	
	public Reservation(String name, String time, String date) {
		super(name);
		
		this.name = name;
		this.time = time;
		this.date = date;
		
		
	}
	
	public String getReservationName() {
		return name;
	}
	
	public String getReservationTime() {
		return time;
	}
	
	public String getReservationDate() {
		return date;
	}
	
	
}
