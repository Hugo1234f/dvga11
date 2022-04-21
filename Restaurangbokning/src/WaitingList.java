import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JPanel;

class WaitingList extends Component {

	private JPanel waitingList;
	
	public WaitingList(JPanel waitingList) {
		this.waitingList = waitingList;
		
		this.waitingList.add(new JLabel("Test"));
		this.waitingList.add(new JLabel("Test 2"));
		this.waitingList.add(new QueueItem());
	}
	
}
