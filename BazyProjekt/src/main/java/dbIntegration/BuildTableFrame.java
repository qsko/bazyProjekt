package dbIntegration;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;

import dbGUI.DatabaseGUI;
import dbIntegration.TableFrame.TableFrameListener;

public class BuildTableFrame {
	DatabaseGUI masterGUI;
	
	public BuildTableFrame(DatabaseGUI masterGUI) {
		this.masterGUI=masterGUI;
	}
	
	public void buildTableFrame(JFrame myFrame,TableFrameListener myActionListener) {
		switch (masterGUI.getUserPosition()) {
		case admin:
			buildAdmin(myFrame,myActionListener);
			break;
		case manager:
			buildManagerCEO(myFrame,myActionListener);
			break;
		case owner:
			buildManagerCEO(myFrame,myActionListener);
			break;
		case worker:
			buildWorker(myFrame,myActionListener);
			break;
		default:
			break;
		}
	}
	
	private void buildAdmin(JFrame myFrame,TableFrameListener myActionListener) {
		for(Tables t: Tables.values()) {
			JButton myButton = new JButton(t.name());
			myButton.addActionListener(myActionListener);
			myFrame.add(myButton);
		}
	}
	
	private void buildManagerCEO(JFrame myFrame,TableFrameListener myActionListener) {
		for(Tables t: Tables.values()) {
			if (t != Tables.Account) {
				JButton myButton = new JButton(t.name());
				myButton.addActionListener(myActionListener);
				myFrame.add(myButton);
			}
			else
				myFrame.add(Box.createRigidArea(null));
		}
	}

	private void buildWorker(JFrame myFrame,TableFrameListener myActionListener) {
		for(Tables t: Tables.values()) {
			if(t == Tables.Product || t==Tables.Employee || t==Tables.ProductAviability || t==Tables.Schedule || t==Tables.Invoice || t==Tables.InvoiceProduct) {
				JButton myButton = new JButton(t.name());
				myButton.addActionListener(myActionListener);
				myFrame.add(myButton);
			}
			else
				myFrame.add(Box.createRigidArea(null));
		}
	}
}
