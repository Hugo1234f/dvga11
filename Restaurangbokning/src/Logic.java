import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Logic {
	
	public Logic() {
		
	}
	
	// https://www.w3schools.com/java/java_date.asp
	public String getTime() {
		DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
		return LocalTime.now().format(timeFormat);
	}
	
	// https://www.w3schools.com/java/java_date.asp
	public String getDate() {
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yy");
		return LocalDate.now().format(dateFormat);
	}
}
