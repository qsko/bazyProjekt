package dbGUI;

import javax.swing.Box;
import javax.swing.JButton;

public class BuildActionPanel {
	DatabaseGUI masterGUI;
	
	public BuildActionPanel(DatabaseGUI masterGUI){
		this.masterGUI=masterGUI;
	}
	
	public void buildActionPanel() {
		enums.Position p = masterGUI.getUserPosition();
		
		switch (p){
		case admin:
			buildAdmin();
			break;
		case manager:
			buildManager();
			break;
		case owner:
			buildCEO();
			break;
		case worker:
			buildWorker();
			break;
		default:
			break;
		}
	}

	private void buildAdmin() {
		JButton addRecord = new JButton("Add");
		addRecord.addActionListener(masterGUI.myListener);
		JButton deleteRecord = new JButton("Delete");
		deleteRecord.addActionListener(masterGUI.myListener);
		JButton queryButton = new JButton("Query");
		queryButton.addActionListener(masterGUI.myListener);
		JButton backupButton = new JButton("Backup");
		backupButton.addActionListener(masterGUI.myListener);
		JButton tableButton = new JButton("Table");
		tableButton.addActionListener(masterGUI.myListener);
		JButton refreshButton = new JButton("Refresh");
		refreshButton.addActionListener(masterGUI.myListener);
		JButton procedureButton = new JButton("Procedure");
		procedureButton.addActionListener(masterGUI.myListener);

		masterGUI.actionPanel.add(tableButton);
		masterGUI.actionPanel.add(refreshButton);
		masterGUI.actionPanel.add(Box.createRigidArea(null));
		masterGUI.actionPanel.add(addRecord);
		masterGUI.actionPanel.add(deleteRecord);
		masterGUI.actionPanel.add(Box.createRigidArea(null));
		masterGUI.actionPanel.add(queryButton);
		masterGUI.actionPanel.add(Box.createRigidArea(null));
		masterGUI.actionPanel.add(backupButton);
		masterGUI.actionPanel.add(procedureButton);
	}
	
	private void buildWorker() {
		JButton addRecord = new JButton("Add");
		addRecord.addActionListener(masterGUI.myListener);
		JButton queryButton = new JButton("Query");
		queryButton.addActionListener(masterGUI.myListener);
		JButton tableButton = new JButton("Table");
		tableButton.addActionListener(masterGUI.myListener);
		JButton refreshButton = new JButton("Refresh");
		refreshButton.addActionListener(masterGUI.myListener);
		JButton procedureButton = new JButton("Procedure");
		procedureButton.addActionListener(masterGUI.myListener);

		masterGUI.actionPanel.add(tableButton);
		masterGUI.actionPanel.add(refreshButton);
		masterGUI.actionPanel.add(Box.createRigidArea(null));
		masterGUI.actionPanel.add(addRecord);
		masterGUI.actionPanel.add(Box.createRigidArea(null));
		masterGUI.actionPanel.add(Box.createRigidArea(null));
		masterGUI.actionPanel.add(queryButton);
		masterGUI.actionPanel.add(Box.createRigidArea(null));
		masterGUI.actionPanel.add(Box.createRigidArea(null));
		masterGUI.actionPanel.add(procedureButton);
	}
	
	private void buildManager() {
		JButton addRecord = new JButton("Add");
		addRecord.addActionListener(masterGUI.myListener);
		JButton deleteRecord = new JButton("Delete");
		deleteRecord.addActionListener(masterGUI.myListener);
		JButton queryButton = new JButton("Query");
		queryButton.addActionListener(masterGUI.myListener);
		JButton tableButton = new JButton("Table");
		tableButton.addActionListener(masterGUI.myListener);
		JButton refreshButton = new JButton("Refresh");
		refreshButton.addActionListener(masterGUI.myListener);
		JButton procedureButton = new JButton("Procedure");
		procedureButton.addActionListener(masterGUI.myListener);

		masterGUI.actionPanel.add(tableButton);
		masterGUI.actionPanel.add(refreshButton);
		masterGUI.actionPanel.add(Box.createRigidArea(null));
		masterGUI.actionPanel.add(addRecord);
		masterGUI.actionPanel.add(deleteRecord);
		masterGUI.actionPanel.add(Box.createRigidArea(null));
		masterGUI.actionPanel.add(queryButton);
		masterGUI.actionPanel.add(Box.createRigidArea(null));
		masterGUI.actionPanel.add(Box.createRigidArea(null));
		masterGUI.actionPanel.add(procedureButton);
	}
	
	private void buildCEO() {
		JButton queryButton = new JButton("Query");
		queryButton.addActionListener(masterGUI.myListener);
		JButton tableButton = new JButton("Table");
		tableButton.addActionListener(masterGUI.myListener);
		JButton refreshButton = new JButton("Refresh");
		refreshButton.addActionListener(masterGUI.myListener);
		JButton procedureButton = new JButton("Procedure");
		procedureButton.addActionListener(masterGUI.myListener);

		masterGUI.actionPanel.add(tableButton);
		masterGUI.actionPanel.add(refreshButton);
		masterGUI.actionPanel.add(Box.createRigidArea(null));
		masterGUI.actionPanel.add(Box.createRigidArea(null));
		masterGUI.actionPanel.add(Box.createRigidArea(null));
		masterGUI.actionPanel.add(Box.createRigidArea(null));
		masterGUI.actionPanel.add(queryButton);
		masterGUI.actionPanel.add(Box.createRigidArea(null));
		masterGUI.actionPanel.add(Box.createRigidArea(null));
		masterGUI.actionPanel.add(procedureButton);
	}
}
