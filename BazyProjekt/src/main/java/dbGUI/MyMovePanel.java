package dbGUI;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MyMovePanel extends JPanel{
	private JLabel moveLabel;
	public JButton moreRight;
	public JButton moreLeft;
	
	public JLabel getNewLabel() {
		moveLabel=new JLabel("", SwingConstants.CENTER);
		return moveLabel;
	}
	
	public void displayMessage(String message) {
		moveLabel.setText(message);
	}

	public void clearMessage() {
		moveLabel.setText("");
	}
	
	public void showRightButton(boolean b) {
		moreRight.setVisible(b);
	}
	
	public void showLeftButton(boolean b) {
		moreLeft.setVisible(b);
	}
}
