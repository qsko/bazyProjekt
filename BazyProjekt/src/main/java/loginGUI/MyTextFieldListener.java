package loginGUI;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class MyTextFieldListener implements FocusListener{
	private MyTextField t;
	
	public MyTextFieldListener(MyTextField t){
		this.t = t;
	}
	@Override
	public void focusGained(FocusEvent e) {
		if (t.getText().equals(t.getMsg()))
			t.clearMsg();
	}
	@Override
	public void focusLost(FocusEvent e) {
		if (t.getText().equals(""))
			t.setMsg();				
	}
}
