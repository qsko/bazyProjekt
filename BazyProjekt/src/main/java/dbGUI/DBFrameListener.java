package dbGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dbIntegration.TableFrame;

public class DBFrameListener implements ActionListener{
	private DatabaseGUI dbFrame;

	public DBFrameListener(DatabaseGUI dbFrame) {
		this.dbFrame=dbFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(">>")) {
			dbFrame.myStringDisplayer.increaseCurrent();
			dbFrame.myStringDisplayer.displayN();
			dbFrame.checkConstrains();
		}
		else if (e.getActionCommand().equals("<<")) {
			dbFrame.myStringDisplayer.decreaseCurrent();
			dbFrame.myStringDisplayer.displayN();
			dbFrame.checkConstrains();
		}
		else if (e.getActionCommand().equals("+")) {
			dbFrame.myStringDisplayer.increaseMaxRecords();
			dbFrame.myStringDisplayer.displayN();
			dbFrame.checkConstrains();
		}
		else if (e.getActionCommand().equals("-")) {
			dbFrame.myStringDisplayer.decreaseMaxRecords();
			dbFrame.myStringDisplayer.displayN();
			dbFrame.checkConstrains();
		}
		else if (e.getActionCommand().equals("Add")){
			//TODO
			dbFrame.sendErrorMessage("TODO Add");
		}
		else if (e.getActionCommand().equals("Delete")){
			//TODO
			dbFrame.sendErrorMessage("TODO Delete");
		}
		else if (e.getActionCommand().equals("Table")){
			//TODO
			new TableFrame(dbFrame);
		}
		else if (e.getActionCommand().equals("Backup")){
			//TODO
			dbFrame.sendMessage("TODO Backup");
		}
		else if (e.getActionCommand().equals("Query")){
			//TODO
			dbFrame.sendMessage("TODO Query");
		}
	}
}
