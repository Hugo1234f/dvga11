
public class Table {

	private int id;
	private String status;
	
	public Table(int id, String status) {
		this.id = id;
		this.status = status;
	}
	
	public void setId(int id) throws Exception {
		if(id > 16 || id < 1) {
			throw new Exception("Error: argument for setID is not valid");
		}
		
		this.id = id;
	}
	
	public void setStatus(String status) throws Exception {
		if(status != "available" && status != "occupied" && status != "reserved") {
			throw new Exception("Error: argument for setStatus is not valid");
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
