import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JPanel;

class WaitingList extends Component {

	private JPanel waitingList;
	
	public WaitingList(JPanel waitingList) {
		this.waitingList = waitingList;
		
		this.waitingList.add(new QueueItem("Adam"));
		this.waitingList.add(new QueueItem("Bertil"));
		this.waitingList.add(new Reservation("Cesar", "", ""));

	}
	
	public void addElementToList(JPanel newItem) {
		waitingList.add(newItem);
	}

	
}
