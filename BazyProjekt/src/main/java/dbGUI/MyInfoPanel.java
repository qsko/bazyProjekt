package dbGUI;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyInfoPanel extends JPanel{
	private JLabel infoLabel;
	
	public void initLabel() {
		infoLabel = new JLabel();
		this.add(infoLabel);
	}
	
	public void sendMessage(String message) {
		infoLabel.setForeground(Color.BLACK);
		infoLabel.setText(message);
	}
	
	public void sendErrorMessage(String message) {
		infoLabel.setForeground(Color.RED);
		infoLabel.setText(message);
	}
}
