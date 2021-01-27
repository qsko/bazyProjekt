package loginGUI;

import javax.swing.JPasswordField;

public class MyPasswordField extends JPasswordField{
	private static final long serialVersionUID = -980962433431167487L;
	private String msg;
		
	public MyPasswordField(String msg, int size) {
		super(msg,size);
		this.msg=msg;
		this.setMsg();
	}
	public void clearMsg() {
		this.setEchoChar('*');
		this.setText("");
		this.setFont(LoginFrame.myFont2);
	}
	public void setMsg() {
		this.setText(msg);
		this.setEchoChar((char)0);
		this.setFont(LoginFrame.myFont1);
	}
}