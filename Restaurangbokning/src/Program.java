import java.awt.Dimension;
import java.awt.Toolkit;

public class Program {
	
	private static Dimension size;
	private static int WIDTH;
	private static int HEIGHT;
	
	public static void main(String args[]) {
		size = Toolkit.getDefaultToolkit().getScreenSize();
		
		App app = new App();
	}
	
	public int getHEIGHT() {
		return HEIGHT;
	}
	
	public int getWIDTH() {
		return WIDTH;
	}
	
}
