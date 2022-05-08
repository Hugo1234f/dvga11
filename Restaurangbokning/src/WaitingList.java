import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

class WaitingList extends Component {

	private JPanel waitingList;
	private ArrayList<QueueItem> waitList;
	
	public WaitingList(JPanel waitingList) {
		this.waitingList = waitingList;
		waitList = new ArrayList<>();
		
		QueueItem startItem = new QueueItem("","");
		startItem.setClickable(false);
	}
	
	public void addElementToList(QueueItem newItem) {
		waitList.add(newItem);
		System.out.println("Queue item added");
	}
	
	public void removeFirstElement() {
		if(waitList.size() > 0) {
			waitList.remove(0);
			System.out.println("Queue item removed");
			return;
		}
		System.out.println("Error: waitList is empty");
	}
	
	public JPanel getPanel() {
		int height = waitingList.getHeight();
		
		waitingList = new JPanel();
		waitingList.setLayout(new BoxLayout(waitingList, BoxLayout.Y_AXIS));
		waitingList.setPreferredSize(new Dimension(200, height));
		waitingList.setBackground(Color.decode("#990059"));
		
		for(int i = 0; i < waitList.size(); i++) {
			waitingList.add(waitList.get(i));
		}
		
		return waitingList;
	}
	
	public int getLenght() {
		return waitList.size();
	}
	
	public QueueItem getLast() {
		return waitList.get(waitList.size()-1);
	}
	
	public void setLast(QueueItem item) throws IndexOutOfBoundsException {
		waitList.set(waitList.size()-1, item);
	}
	
	public Color getColor(int index) throws IndexOutOfBoundsException {
		return waitList.get(index).getBackground();
	}
	
	public void removeItem(int index) {
		waitList.remove(index);
	}

	
}
