package dbIntegration;

import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import org.hibernate.metadata.ClassMetadata;

import dbGUI.DatabaseGUI;
import util.HibernateUtil;

public class AddFrame {
	private JFrame myFrame;
	private DatabaseGUI masterGUI;
	
	public AddFrame(DatabaseGUI masterGUI) {
		this.masterGUI=masterGUI;
		buildFrame();
	}
	
	private void buildFrame() {
		myFrame = new JFrame();
		myFrame.setLayout(new GridLayout(2,1));
		
		JPanel topPanel=new JPanel();
		topPanel.add(new JLabel("Adding new entity type: "+masterGUI.getCurrentTable().name()));

		
		
		String[] variableNames = masterGUI.getCurrentTable().getTablesNames();
		
		JPanel bottomPanel=new JPanel();
		JPanel leftPanel=new JPanel();
		JPanel rightPanel=new JPanel();
		
		leftPanel.setLayout(new GridLayout(variableNames.length,1));
		leftPanel.setSize(50, 100);
		rightPanel.setLayout(new GridLayout(variableNames.length,1));
		
		for(String s: variableNames) {
			JLabel myLabel = new JLabel(s);
			leftPanel.add(myLabel);
		}
		
		JTextArea [] myTextAreas = new JTextArea[variableNames.length];
		
		for(JTextArea ja: myTextAreas) {
			ja = new JTextArea();
			rightPanel.add(ja);
		}
		
		bottomPanel.setLayout(new BoxLayout(bottomPanel,BoxLayout.LINE_AXIS));
		bottomPanel.add(leftPanel);
		bottomPanel.add(rightPanel);
		
		myFrame.add(topPanel);
		myFrame.add(bottomPanel);
	
		myFrame.setSize(400,200);
		myFrame.setVisible(true);
		
	}
}
