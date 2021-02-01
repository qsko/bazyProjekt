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

public class ProcedureFrameInsertParameters {
	private JFrame myFrame;
	private DatabaseGUI masterGUI;
	private JTextArea [] myTextAreas;
	private String[] variables;
	private EntityTypes[] varTypes;
	private int length;
	private int n;
	
	public ProcedureFrameInsertParameters(DatabaseGUI masterGUI,String[] vars, EntityTypes[] types, int n) {
		this.masterGUI=masterGUI;
		this.variables=vars;
		this.varTypes=types;
		this.length=vars.length;
		this.n=n;
		buildFrame();
	}
	
	private void buildFrame() {
		myFrame = new JFrame();
		myFrame.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill=GridBagConstraints.HORIZONTAL;
		
		JPanel topPanel=new JPanel();
		topPanel.add(new JLabel("Insert variables for functions"));
		topPanel.setBorder(
				BorderFactory.createCompoundBorder(
						BorderFactory.createTitledBorder(""),
						BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		
		
		JPanel midPanel=new JPanel();
		JPanel bottomPanel=new JPanel();
		JPanel leftPanel=new JPanel();
		JPanel rightPanel=new JPanel();
		
		leftPanel.setLayout(new GridLayout(length,1));
		leftPanel.setSize(50, 100);
		leftPanel.setBorder(
				BorderFactory.createCompoundBorder(
						BorderFactory.createTitledBorder(""),
						BorderFactory.createEmptyBorder(10, 10, 10, 10)));

		rightPanel.setLayout(new GridLayout(length,1));
		rightPanel.setBorder(
				BorderFactory.createCompoundBorder(
						BorderFactory.createTitledBorder(""),
						BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		
		for(int i=0;i<length;i++) {
			JLabel myLabel = new JLabel(variables[i] + " " + varTypes[i].name());
			leftPanel.add(myLabel);
		}
		
		myTextAreas = new JTextArea[length];
		
		for(int i=0;i<length;i++) {
			myTextAreas[i] = new JTextArea();
			rightPanel.add(myTextAreas[i]);
		}
		rightPanel.setPreferredSize(new Dimension(200,25*length));
		
		midPanel.setLayout(new BoxLayout(midPanel,BoxLayout.LINE_AXIS));
		midPanel.add(leftPanel);
		midPanel.add(rightPanel);
		midPanel.setBorder(
				BorderFactory.createCompoundBorder(
						BorderFactory.createTitledBorder(""),
						BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		
		JButton addButton = new JButton("CALL");
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("CALL")) {
					String[] args=new String[length];
					for(int i=0;i<length;i++) {
						args[i]=myTextAreas[i].getText();
					}
					new ProcessProcedureFrame(masterGUI, args, varTypes,n).process();
					myFrame.setVisible(false);
					myFrame.dispose();
				}	
			}
		});
		bottomPanel.add(addButton);
		bottomPanel.setBorder(
				BorderFactory.createCompoundBorder(
						BorderFactory.createTitledBorder(""),
						BorderFactory.createEmptyBorder(10, 10, 10, 10)));

		c.gridx=0;
		c.gridy=0;
		c.fill=GridBagConstraints.HORIZONTAL;
		myFrame.add(topPanel,c);

		c.gridy++;
		c.ipady=10*length;
		myFrame.add(midPanel,c);

		c.gridy++;
		c.ipady=0;
		myFrame.add(bottomPanel,c);

		myFrame.setSize(400,200+30*length);
		myFrame.setVisible(true);
	}
}
