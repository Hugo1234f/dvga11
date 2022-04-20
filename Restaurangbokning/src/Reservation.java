import java.time.LocalDate;
import java.time.LocalTime;

public class Reservation extends QueueItem {
	
	private String name;
	private LocalTime time;
	private LocalDate date;
	
	public Reservation(String name, LocalTime time, LocalDate date) {
		this.name = name;
		this.time = time;
		this.date = date;
	}
	
	public String getReservationName() {
		return name;
	}
	
	public LocalTime getReservationTime() {
		return time;
	}
	
	public LocalDate getReservationDate() {
		return date;
	}
	
}
