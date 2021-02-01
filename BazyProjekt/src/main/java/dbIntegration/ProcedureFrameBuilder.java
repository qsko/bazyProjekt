package dbIntegration;

import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;

import enums.Position;

public class ProcedureFrameBuilder {
	JFrame myFrame;
	Position pos;
	ActionListener myActionListener;
	
	public ProcedureFrameBuilder(JFrame myFrame, Position p, ActionListener myActionListener) {
		this.myFrame=myFrame;
		this.pos=p;
		this.myActionListener=myActionListener;
	}
	
	public void build() {
		switch (pos) {
		case admin:
			buildAdminCEO();
			break;
		case manager:
			buildManager();
			break;
		case owner:
			buildAdminCEO();
			break;
		case worker:
			buildWorker();
			break;
		default:
			break;
		}
	}
	
	private void buildAdminCEO() {
		JButton nb = new JButton("NUMBER SOLD");
		nb.addActionListener(myActionListener);
		myFrame.add(nb);
		JButton iv = new JButton("INVOICE NUMBER");
		iv.addActionListener(myActionListener);
		myFrame.add(iv);
		JButton ip = new JButton("INVOICE PRODUCTS");
		ip.addActionListener(myActionListener);
		myFrame.add(ip);
		JButton si = new JButton("SHOW INVOICES BY NIP");
		si.addActionListener(myActionListener);
		myFrame.add(si);
		JButton cp = new JButton("CALCULATE PAYOUT");
		cp.addActionListener(myActionListener);
		myFrame.add(cp);
	}
	
	private void buildManager() {
		JButton nb = new JButton("NUMBER SOLD");
		nb.addActionListener(myActionListener);
		myFrame.add(nb);
		JButton iv = new JButton("INVOICE NUMBER");
		iv.addActionListener(myActionListener);
		myFrame.add(iv);
		JButton ip = new JButton("INVOICE PRODUCTS");
		ip.addActionListener(myActionListener);
		myFrame.add(ip);
		JButton si = new JButton("SHOW INVOICES BY NIP");
		si.addActionListener(myActionListener);
		myFrame.add(si);
		myFrame.add(Box.createRigidArea(null));
	}

	private void buildWorker() {
		myFrame.add(Box.createRigidArea(null));
		JButton iv = new JButton("INVOICE NUMBER");
		iv.addActionListener(myActionListener);
		myFrame.add(iv);
		JButton ip = new JButton("INVOICE PRODUCTS");
		ip.addActionListener(myActionListener);
		myFrame.add(ip);
		JButton si = new JButton("SHOW INVOICES BY NIP");
		si.addActionListener(myActionListener);
		myFrame.add(si);
		myFrame.add(Box.createRigidArea(null));
	}
}
