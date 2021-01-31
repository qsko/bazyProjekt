package dbGUI;

import dbIntegration.AddFrame;
import dbIntegration.DeleteFrame;
import dbIntegration.Tables;
import enums.Position;

public class AddFrameVerification {
	private DatabaseGUI masterGUI;
	
	public AddFrameVerification(DatabaseGUI masterGUI) {
		this.masterGUI=masterGUI;
	}
	
	public void verify() {
		if (masterGUI.getUserPosition() == Position.owner) {
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

		if (masterGUI.getUserPosition() == Position.worker) {
			Tables table = masterGUI.getCurrentTable();
			if (table == Tables.Invoice || table == Tables.InvoiceProduct) {
				acceptRequest();
				return;
			}
			denyRequest();
			return;
		}

		acceptRequest();
	}
	
	private void acceptRequest() {
		new AddFrame(masterGUI);
		masterGUI.sendMessage("Adding object of type "+masterGUI.getCurrentTable().name());
	}
	
	private void denyRequest() {
		masterGUI.sendErrorMessage("You are not permited to do this operation!");
	}
}
