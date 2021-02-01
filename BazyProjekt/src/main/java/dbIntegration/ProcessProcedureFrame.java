package dbIntegration;

import java.time.LocalDate;

import dbGUI.DatabaseGUI;

public class ProcessProcedureFrame {
	private DatabaseGUI masterGUI;
	private String[] args;
	private EntityTypes[] types;
	private int proc_n;
	
	public ProcessProcedureFrame(DatabaseGUI masterGUI, String[] args, EntityTypes[] types, int n) {
		this.masterGUI = masterGUI;
		this.args = args;
		this.types = types;
		this.proc_n=n;
	}
	
	public void process() {
		try {
			switch(proc_n) {
			case 1:
				int prod = (int) EntityTypes.Integer.fromString(args[0]);
				LocalDate d1 = (LocalDate) EntityTypes.Date.fromString(args[1]);
				LocalDate d2 = (LocalDate) EntityTypes.Date.fromString(args[2]);
				int result1=ProcedureFrameCaller.callFUNCTION1(prod, d1, d2);
				masterGUI.sendMessage("The worth of product " + prod +" between " + d1 + " " + d2 + " is "+ result1);
				break;
			case 2:
				int invoice_id = (int) EntityTypes.Integer.fromString(args[0]);
				int result = ProcedureFrameCaller.callFUNCTION2(invoice_id);
				masterGUI.sendMessage("The value of invoice " + invoice_id + "is " + result);
				break;
			case 3:
				int invoice_id2 = (int) EntityTypes.Integer.fromString(args[0]);
				masterGUI.setNewTable(ProcedureFrameCaller.callFUNCTION3(invoice_id2));
				masterGUI.sendMessage("Successfully performed procedure");
				break;
			case 4:
				int nip = (int) EntityTypes.Integer.fromString(args[0]);
				masterGUI.setNewTable(ProcedureFrameCaller.callFUNCTION4(nip));
				masterGUI.sendMessage("Successfully performed procedure");
				break;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			masterGUI.sendErrorMessage("Error when calling procedure.");
		}
		
	}

}
