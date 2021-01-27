package loginGUI;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class MyPasswordListener implements FocusListener{
	private MyPasswordField t;
	
	MyPasswordListener(MyPasswordField t){
		this.t = t;
	}
	@Override
	public void focusGained(FocusEvent e) {
		t.clearMsg();
	}
	@Override
	public void focusLost(FocusEvent e) {
		if (t.getPassword().length==0) {
			t.setMsg();
		}
	}
}
