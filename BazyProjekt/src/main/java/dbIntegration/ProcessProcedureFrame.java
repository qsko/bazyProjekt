package dbIntegration;

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
		if (proc_n==1) {
			//TODO konwersja i call ProcedureFrameCaller
		}
	}

}
