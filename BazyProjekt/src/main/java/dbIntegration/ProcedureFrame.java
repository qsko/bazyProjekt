package dbIntegration;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import dbGUI.DatabaseGUI;
import dbIntegration.TableFrame.TableFrameListener;

public class ProcedureFrame {
	private JFrame myFrame;
	DatabaseGUI masterFrame;
	
	public ProcedureFrame(DatabaseGUI masterFrame) {
		this.masterFrame=masterFrame;
		
		masterFrame.sendMessage("Select the desired procedure/function in the menu");
		myFrame = new JFrame("Choose a procedure");

		myFrame.setLayout(new GridLayout(4,1));
		
		ActionListener myActionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String event = e.getActionCommand();
				if (event.equals("NUMBER SOLD")) {
					
				}
				else if (event.equals("INVOICE VALUE")) {
					
				}
				else if (event.equals("INVOICE PRODUCTS")) {
					
				}
				else if (event.equals("SHOW INVOICES BY NIP")) {
					
				}
				else if (event.equals("CALCULATE PAYOUT")) {
					
				}
			}
		};
		new ProcedureFrameBuilder(myFrame,masterFrame.getUserPosition(),myActionListener).build();
		
		
	}
}
