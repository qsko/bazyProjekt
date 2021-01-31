package dbGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dbIntegration.AddFrame;
import dbIntegration.DeleteFrame;
import dbIntegration.QueryFrame;
import dbIntegration.TableFrame;

public class DBFrameListener implements ActionListener{
	private DatabaseGUI dbFrame;

	public DBFrameListener(DatabaseGUI dbFrame) {
		this.dbFrame=dbFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		if (action.equals(">>")) {
			dbFrame.myStringDisplayer.increaseCurrent();
			dbFrame.myStringDisplayer.displayN();
			dbFrame.checkConstrains();
		}
		else if (action.equals("<<")) {
			dbFrame.myStringDisplayer.decreaseCurrent();
			dbFrame.myStringDisplayer.displayN();
			dbFrame.checkConstrains();
		}
		else if (action.equals("+")) {
			dbFrame.myStringDisplayer.increaseMaxRecords();
			dbFrame.myStringDisplayer.displayN();
			dbFrame.checkConstrains();
		}
		else if (action.equals("-")) {
			dbFrame.myStringDisplayer.decreaseMaxRecords();
			dbFrame.myStringDisplayer.displayN();
			dbFrame.checkConstrains();
		}
		else if (action.equals("Add")){
			if (dbFrame.getCurrentTable()!=null) {
				new AddFrameVerification(dbFrame).verify();
			}
			else
				dbFrame.sendErrorMessage("No table selected!");
		}
		else if (action.equals("Delete")){
			if (dbFrame.getCurrentTable()!=null) {
				new DeleteFrameVerification(dbFrame).verify();
			}
			else
				dbFrame.sendErrorMessage("No table selected!");
		}
		else if (action.equals("Table")){
			new TableFrame(dbFrame);
		}

		else if (action.equals("Backup")){
			//TODO
			dbFrame.sendMessage("TODO Backup");
		}
		else if (action.equals("Query")){
			if (dbFrame.getCurrentTable()!=null) {
				new QueryFrame(dbFrame);
				dbFrame.sendMessage("Creating query on table "+dbFrame.getCurrentTable().name());
			}
			else
				dbFrame.sendErrorMessage("No table selected!");
		}
		else if (action.equals("Refresh")) {
			if (dbFrame.getCurrentTable()!=null)
				dbFrame.setNewTable(dbFrame.getCurrentTable().getDAO().getObjectList());
			else
				dbFrame.sendErrorMessage("No table selected!");
		}
	}
}
