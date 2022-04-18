
public class App {

	private GUIManager gui;
	private Logic logic;
	
	public App() {
		gui = new GUIManager();
		logic = new Logic();
		
		while(true) {
			gui.setDate(logic.getDate());
			gui.setTime(logic.getTime());
		}
	}
	
}
