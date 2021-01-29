package dbIntegration;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
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
	private JTextArea [] myTextAreas;
	private int length;
	
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
		length=variableNames.length;
		
		JPanel midPanel=new JPanel();
		JPanel bottomPanel=new JPanel();
		JPanel leftPanel=new JPanel();
		JPanel rightPanel=new JPanel();
		
		leftPanel.setLayout(new GridLayout(length,1));
		leftPanel.setSize(50, 100);
		rightPanel.setLayout(new GridLayout(length,1));
		
		for(String s: variableNames) {
			JLabel myLabel = new JLabel(s);
			leftPanel.add(myLabel);
		}
		
		myTextAreas = new JTextArea[length];
		
		for(int i=0;i<length;i++) {
			myTextAreas[i] = new JTextArea();
			rightPanel.add(myTextAreas[i]);
		}
		
		midPanel.setLayout(new BoxLayout(midPanel,BoxLayout.LINE_AXIS));
		midPanel.add(leftPanel);
		midPanel.add(rightPanel);
		
		JButton addButton = new JButton("ADD");
		addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("ADD")) {
					String[] args=new String[length];
					for(int i=0;i<length;i++) {
						args[i]=myTextAreas[i].getText();
					}
					new ProcessAddOperation(masterGUI, args);
					myFrame.setVisible(false);
					myFrame.dispose();
				}	
			}
		});
		bottomPanel.add(addButton);
		
		
		myFrame.add(topPanel);
		myFrame.add(midPanel);
		myFrame.add(bottomPanel);
	
		myFrame.setSize(400,200);
		myFrame.setVisible(true);
	}

}
