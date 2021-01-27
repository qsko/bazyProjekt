package loginGUI;

import javax.swing.JTextField;

public class MyTextField extends JTextField {
	private static final long serialVersionUID = 298314503213820028L;
	private String msg;
	
	public MyTextField(String msg,int size) {
		super(msg,size);
		this.msg=msg;
		this.setMsg();
	}
	public void clearMsg() {
			this.setText("");
			this.setFont(LoginFrame.myFont2);
	}
	public void setMsg() {
			this.setText(msg);
			this.setFont(LoginFrame.myFont1);
	}
	public String getMsg() {
		return this.msg;
	}
}