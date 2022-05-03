import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;

public class Logic {
	
	private Table tables[];
	private int selectedBtn = 0;
	
	public Logic() {
		tables = new Table[16];
		
		for(int i = 0; i < tables.length; i++) {
			tables[i] = new Table(i+1, "available");
		}
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
	
	public JButton enableButton(JButton btn) {
		JButton currentBtn = btn;
		currentBtn.setEnabled(true);
		return currentBtn;
	}
	
	public JButton disableButton(JButton btn) {
		JButton currentBtn = btn;
		currentBtn.setEnabled(false);
		return currentBtn;
	}
	
	public void controllBtnPress(int button) {
		if(button == selectedBtn) {selectedBtn = 0; return;}
		
		selectedBtn = button;
	}
	
	public int getSelectedBtn() {
		return selectedBtn;
	}
	
	public boolean isTableFree(int index) throws IndexOutOfBoundsException {
		if(tables[index].getStatus() == "available") {return true;}
		return false;
	}
	
	public boolean isTableOccupied(int index) throws IndexOutOfBoundsException {
		if(tables[index].getStatus() == "occupied") {return true;}
		return false;
	}
	
	public void setTableOccupied(int id) throws IndexOutOfBoundsException {
		try {
			tables[id].setStatus("occupied");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setTableAvailable(int id) throws IndexOutOfBoundsException {
		try {
			tables[id].setStatus("available");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
