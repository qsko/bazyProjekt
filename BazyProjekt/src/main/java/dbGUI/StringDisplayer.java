package dbGUI;

import javax.swing.JTextArea;

public class StringDisplayer {
	private JTextArea myArea;
	private String[] sArray;
	private int sLen;
	private int current;

	private int MAX_RECORDS=15;
	
	public StringDisplayer(JTextArea myArea) {
		this.myArea=myArea;
		current=0;
		sLen=0;
	}
	
	public void setStringArray(String[] sArray) {
		this.sArray=sArray;
		this.sLen=sArray.length;
		current=0;
	}
	
	public void displayN() {
		int i=current;
		int currentMax=getCurrentMax();

		while(i<currentMax) {
			if (i==current)
				myArea.setText(sArray[i++]);
			else
			myArea.setText(myArea.getText()+"\n"+sArray[i++]);
		}
	}

	public int getCurrentMax() {
		int max=current+MAX_RECORDS;

		if (max>sLen) return sLen;
		return max;
	}
	
	public void increaseCurrent() {
		int tmp=current+MAX_RECORDS;
		if (tmp<sLen) {current=tmp;}
	}
	
	public void decreaseCurrent() {
		int tmp=current-MAX_RECORDS;
		if (tmp>=0) {current=tmp;}
	}
	
	public boolean canDisplayNext() {
		if(current+MAX_RECORDS>sLen) return false;
		return true;
	}
	
	public boolean canDisplayPrev() {
		if (current-MAX_RECORDS<0) return false;
		return true;
	}
	
	public int getCurrent() {
		return this.current;
	}
	
	public int getSLen() {
		return this.sLen;
	}
	
	public void increaseMaxRecords() {
		if (MAX_RECORDS<sLen) this.MAX_RECORDS+=5;
		this.current=0;
	}
	
	public void decreaseMaxRecords() {
		if (MAX_RECORDS>5) this.MAX_RECORDS-=5;
		this.current=0;
	}
}
