package dbIntegration;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import dbGUI.DatabaseGUI;

public class DeleteFrame {
	private JFrame myFrame;
	private DatabaseGUI masterGUI;
	private JTextArea myTextArea;

	public DeleteFrame(DatabaseGUI masterGUI) {
		this.masterGUI=masterGUI;
		buildFrame();
	}
	
	private void buildFrame() {
		myFrame = new JFrame();
		myFrame.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill=GridBagConstraints.HORIZONTAL;
		
		JPanel topPanel=new JPanel();
		topPanel.add(new JLabel("Deleting entity type: "+masterGUI.getCurrentTable().name()));
		topPanel.setBorder(
				BorderFactory.createCompoundBorder(
						BorderFactory.createTitledBorder(""),
						BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		JPanel midPanel=new JPanel();
		JPanel bottomPanel=new JPanel();
		JPanel leftPanel=new JPanel();
		JPanel rightPanel=new JPanel();
		
		leftPanel.setLayout(new GridLayout(1,1));
		leftPanel.setSize(50, 25);
		leftPanel.setBorder(
				BorderFactory.createCompoundBorder(
						BorderFactory.createTitledBorder(""),
						BorderFactory.createEmptyBorder(10, 10, 10, 10)));

		rightPanel.setLayout(new GridLayout(1,1));
		rightPanel.setBorder(
				BorderFactory.createCompoundBorder(
						BorderFactory.createTitledBorder(""),
						BorderFactory.createEmptyBorder(10, 10, 10, 10)));

		leftPanel.add(new JLabel("id"));
		myTextArea = new JTextArea();
		rightPanel.add(myTextArea);
		rightPanel.setPreferredSize(new Dimension(100,25));
		
		midPanel.setLayout(new BoxLayout(midPanel,BoxLayout.LINE_AXIS));
		midPanel.add(leftPanel);
		midPanel.add(rightPanel);
		midPanel.setBorder(
				BorderFactory.createCompoundBorder(
						BorderFactory.createTitledBorder(""),
						BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		
		JButton removeButton = new JButton("DELETE");
		removeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("DELETE")) {
					String s = myTextArea.getText();
					int id;
					try {
						id = Integer.parseInt(s);
						masterGUI.getCurrentTable().getDAO().removeObject(id);
						masterGUI.sendMessage("Deleted "+masterGUI.getCurrentTable().name() + " with id="+id);
						masterGUI.setNewTable(masterGUI.getCurrentTable().getDAO().getObjectList());
					}
					catch(NumberFormatException n) {
						masterGUI.sendErrorMessage("Error when deleting Object: Wrong id format.");
					}
					myFrame.setVisible(false);
					myFrame.dispose();
				}	
			}
		});
		bottomPanel.add(removeButton);
		bottomPanel.setBorder(
				BorderFactory.createCompoundBorder(
						BorderFactory.createTitledBorder(""),
						BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		
		c.gridx=0;
		c.gridy=0;
		c.fill=GridBagConstraints.HORIZONTAL;
		myFrame.add(topPanel,c);

		c.gridy++;
		c.ipady=8;
		myFrame.add(midPanel,c);

		c.gridy++;
		c.ipady=0;
		myFrame.add(bottomPanel,c);

		myFrame.setSize(300,200);
		myFrame.setVisible(true);
	}
}
