package dbGUI;

import dbIntegration.DeleteFrame;
import dbIntegration.Tables;
import enums.Position;

public class DeleteFrameVerification {
	DatabaseGUI masterGUI;

	public DeleteFrameVerification(DatabaseGUI masterGUI) {
		this.masterGUI=masterGUI;
	}
	
	public void verify() {
		if (masterGUI.getUserPosition() == Position.worker || masterGUI.getUserPosition() == Position.owner) {
			denyRequest();
			return;
		}

		if (masterGUI.getUserPosition() == Position.manager) {
			Tables table = masterGUI.getCurrentTable();
			if (table == Tables.Product || table == Tables.Employee
			|| table == Tables.Contract || table == Tables.SaleByDay
			|| table == Tables.LoginPosition || table == Tables.ProductAviability)
				denyRequest();
			else
				acceptRequest();
			return;
		}
		acceptRequest();
	}
	
	private void acceptRequest() {
		new DeleteFrame(masterGUI);
		masterGUI.sendMessage("Deleting object of type "+masterGUI.getCurrentTable().name());
	}
	
	private void denyRequest() {
		masterGUI.sendErrorMessage("You are not permited to do this operation!");
	}
}
