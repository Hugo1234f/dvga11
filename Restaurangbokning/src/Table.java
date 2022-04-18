
public class Table {

	private int id;
	private String status;
	
	public Table(int id, String status) {
		this.id = id;
		this.status = status;
	}
	
	public void setId(int id) {
		if(id > 16 || id < 1) {
			System.out.println("Error: argument for setID is not valid");
			return;
		}
		
		this.id = id;
	}
	
	public void setStatus(String status) {
		if(status != "available" || status != "occupied" || status != "reserved") {
			System.out.println("Error: argument for setStatus is not valid");
			return;
		}
		
		this.status = status;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getStatus() {
		return this.status;
	}
}
