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

		myFrame.setLayout(new GridLayout(Tables.values().length,1));
		
		TableFrameListener myActionListener = new TableFrameListener();
		new BuildTableFrame(masterFrame).buildTableFrame(myFrame, myActionListener);

		myFrame.setSize(140,400);
		myFrame.setLocation(MouseInfo.getPointerInfo().getLocation());
		myFrame.setVisible(true);
	}
	
	public class TableFrameListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			for (Tables t: Tables.values()) {
				if (e.getActionCommand().equals(t.name())) {
					//masterFrame.myStringDisplayer.flush();
					myFrame.setVisible(false);
					masterFrame.setCurrentTable(t);
					myFrame.dispose();
					try {
						masterFrame.setNewTable(t.getDAO().getObjectList());
					}
					catch (Exception f) {
						masterFrame.sendErrorMessage("Display error: "+f.getMessage());
						f.printStackTrace();
						return;
					}
					//masterFrame.myStringDisplayer.displayN();
					masterFrame.sendMessage("Showing table "+t.name());
					//masterFrame.setCurrentTable(t);
					return;
				}
			}
		}
		
	}
}
