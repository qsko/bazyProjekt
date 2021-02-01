package dbIntegration;

import java.awt.GridLayout;
import java.awt.MouseInfo;
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

		myFrame.setLayout(new GridLayout(5,1));
		
		ActionListener myActionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String event = e.getActionCommand();
				if (event.equals("NUMBER SOLD")) {
					String[] vars = {"product_id","start_date","end_date"};
					EntityTypes[] types = {EntityTypes.Integer,EntityTypes.Date,EntityTypes.Date};
					new ProcedureFrameInsertParameters(masterFrame, vars, types,1);
				}
				else if (event.equals("invoiceValue")) {
					String[] vars = {"invoice_id"};
					EntityTypes[] types = {EntityTypes.Integer};
					new ProcedureFrameInsertParameters(masterFrame, vars, types,2);
				}
				else if (event.equals("selectItemsFromInvoice")) {
					String[] vars = {"invoice_id"};
					EntityTypes[] types = {EntityTypes.Integer};
					new ProcedureFrameInsertParameters(masterFrame, vars, types,3);
				}
				else if (event.equals("selectInvoicesByNIP")) {
					String[] vars = {"nip"};
					EntityTypes[] types = {EntityTypes.Integer};
					new ProcedureFrameInsertParameters(masterFrame, vars, types,4);
				}
				else if (event.equals("payInMonth")) {
					int result = ProcedureFrameCaller.callFUNCTION5();
					masterFrame.sendMessage("Required payout = " + String.valueOf(result));
				}
				myFrame.setVisible(false);
				myFrame.dispose();
			}
		};
		new ProcedureFrameBuilder(myFrame,masterFrame.getUserPosition(),myActionListener).build();
		myFrame.setSize(200,200);
		myFrame.setLocation(MouseInfo.getPointerInfo().getLocation());
		myFrame.setVisible(true);
	}
}
