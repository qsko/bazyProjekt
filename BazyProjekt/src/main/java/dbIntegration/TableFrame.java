package dbIntegration;

import java.awt.GridLayout;
import java.awt.MouseInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import DAO.interfaceDAO;
import dbGUI.DatabaseGUI;

public class TableFrame {
	private JFrame myFrame;
	DatabaseGUI masterFrame;
	
	public TableFrame(DatabaseGUI masterFrame) {
		this.masterFrame=masterFrame;
		masterFrame.sendMessage("Select the desired Table in popup window.");
		myFrame = new JFrame("Choose a table");

		myFrame.setLayout(new GridLayout(11,1));
		
		JButton myButton;
		TableFrameListener myActionListener = new TableFrameListener();
		for(Tables t: Tables.values()) {
			myButton = new JButton(t.name());
			myButton.addActionListener(myActionListener);
			myFrame.add(myButton);
		}
		myFrame.setSize(140,400);
		myFrame.setLocation(MouseInfo.getPointerInfo().getLocation());
		myFrame.setVisible(true);
	}
	
	private class TableFrameListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			for (Tables t: Tables.values()) {
				if (e.getActionCommand().equals(t.name())) {
					masterFrame.myStringDisplayer.flush();
					myFrame.setVisible(false);
					myFrame.dispose();
					try {
						masterFrame.displayStringArray(t.getDAO().getObjectList());
					}
					catch (Exception f) {
						masterFrame.sendErrorMessage("Display error: "+f.getMessage());
						return;
					}
					masterFrame.myStringDisplayer.displayN();
					masterFrame.sendMessage("Showing table "+t.name());
					masterFrame.setCurrentTable(t);
					return;
				}
			}
		}
		
	}
}