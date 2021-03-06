package dbGUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class DBFrameBuilder {
	private DatabaseGUI dbFrame;
	
	public DBFrameBuilder(DatabaseGUI dataBaseFrame) {
		this.dbFrame=dataBaseFrame;
	}
	
	public void buildAllPanels() {
		buildActionPanel();
		
		buildInfoPanel();
		buildMovePanel();
		
		buildDataPanel(dbFrame.infoPanel,buildScrollPane(),dbFrame.movePanel);
		
		buildMasterPanel(dbFrame.actionPanel,dbFrame.dataPanel);
	}
	
	private void buildActionPanel() {
		dbFrame.actionPanel = new JPanel();
		//actionPanel.setLayout(new BoxLayout(actionPanel,BoxLayout.Y_AXIS));
		dbFrame.actionPanel.setLayout(new GridLayout(10,1));
		dbFrame.actionPanel.setBorder(
				BorderFactory.createCompoundBorder(
						BorderFactory.createTitledBorder("Instructions"),
						BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		dbFrame.actionPanel.setMinimumSize(new Dimension(200, 300));
		dbFrame.actionPanel.setMaximumSize(new Dimension(200, 300));
		dbFrame.actionPanel.setBackground(DatabaseGUI.appColor1);

		new BuildActionPanel(dbFrame).buildActionPanel();
	}
	
	private void buildInfoPanel() {
		dbFrame.infoPanel = new MyInfoPanel();
		dbFrame.infoPanel.setLayout(new GridLayout(1,1));
		dbFrame.infoPanel.setMinimumSize(new Dimension(0, 60));
		dbFrame.infoPanel.setMaximumSize(new Dimension(1000, 60));
		dbFrame.infoPanel.setBorder(
				BorderFactory.createCompoundBorder(
						BorderFactory.createTitledBorder("Information"),
						BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		dbFrame.infoPanel.setBackground(DatabaseGUI.appColor1);
		dbFrame.infoPanel.setBackground(Color.WHITE);
		
		dbFrame.infoPanel.initLabel();
	}
	
	private JScrollPane buildScrollPane() {
		JTextArea dataArea = new JTextArea();
		dataArea.setEditable(false);
		dataArea.setFont(DatabaseGUI.myFont1);
		
		dbFrame.myStringDisplayer=new StringDisplayer(dataArea);
		
		return new JScrollPane(dataArea);
	}
	
	private JScrollPane buildTable() {
		JScrollPane myScrollPane = new JScrollPane();
		JTable myTable = new JTable();
		myTable.setFont(DatabaseGUI.myFont1);

		dbFrame.myTableDisplayer=new TableDisplayer(myTable,dbFrame);
		return new JScrollPane(myTable);
	}
	
	private void buildMovePanel() {
		dbFrame.movePanel = new MyMovePanel();
		dbFrame.movePanel.setLayout(new GridLayout(1,2));
		dbFrame.movePanel.setBorder(BorderFactory.createTitledBorder(""));
		dbFrame.movePanel.setBackground(DatabaseGUI.appColor1);
		dbFrame.movePanel.setMaximumSize(new Dimension(800, 50));
		
		dbFrame.movePanel.moreLeft=new JButton("<<");
		dbFrame.movePanel.moreLeft.addActionListener(dbFrame.myListener);
		
		dbFrame.movePanel.moreRight=new JButton(">>");
		dbFrame.movePanel.moreRight.addActionListener(dbFrame.myListener);
		
		JPanel movePanelLeft=new JPanel();
		movePanelLeft.setLayout(new GridLayout(1,1));
		movePanelLeft.add(dbFrame.movePanel.getNewLabel());
		movePanelLeft.setBackground(DatabaseGUI.appColor1);
		
		JPanel movePanelRight=new JPanel();
		movePanelRight.setLayout(new GridLayout(1,5));
		
		JButton increaseRecords = new JButton("+");
		increaseRecords.addActionListener(dbFrame.myListener);
		JButton decreaseRecords = new JButton("-");
		decreaseRecords.addActionListener(dbFrame.myListener);
		
		movePanelRight.add(increaseRecords);
		movePanelRight.add(decreaseRecords);
		movePanelRight.add(Box.createRigidArea(new Dimension(0,0)));
		movePanelRight.add(dbFrame.movePanel.moreLeft);
		movePanelRight.add(dbFrame.movePanel.moreRight);
		movePanelRight.setBackground(DatabaseGUI.appColor1);
		
		dbFrame.movePanel.add(movePanelLeft);
		dbFrame.movePanel.add(movePanelRight);
	}

	private void buildDataPanel(MyInfoPanel infoPanel,JScrollPane myTable,MyMovePanel movePanel) {
		dbFrame.dataPanel = new JPanel();
		dbFrame.dataPanel.setLayout(new BoxLayout(dbFrame.dataPanel,BoxLayout.PAGE_AXIS));
		dbFrame.dataPanel.setBorder(
				BorderFactory.createCompoundBorder(
						BorderFactory.createTitledBorder("Stonka Database"),
						BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		dbFrame.dataPanel.setBackground(DatabaseGUI.appColor1);
		
		dbFrame.dataPanel.add(infoPanel);
		dbFrame.dataPanel.add(Box.createRigidArea(new Dimension(0,10)));
		dbFrame.dataPanel.add(myTable);
		dbFrame.dataPanel.add(Box.createRigidArea(new Dimension(0,10)));
		dbFrame.dataPanel.add(movePanel);
	}
	
	private void buildMasterPanel(JPanel actionPanel, JPanel dataPanel) {
		dbFrame.masterPanel = new JPanel();
		dbFrame.masterPanel.setLayout(new BoxLayout(dbFrame.masterPanel,BoxLayout.LINE_AXIS));
		
		dbFrame.masterPanel.setBorder(
				BorderFactory.createCompoundBorder(
						BorderFactory.createTitledBorder(""),
						BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		dbFrame.masterPanel.setBackground(DatabaseGUI.appColor1);
		dbFrame.masterPanel.add(actionPanel);
		dbFrame.masterPanel.add(Box.createRigidArea(new Dimension(10,0)));
		dbFrame.masterPanel.add(dataPanel);
	}
}
