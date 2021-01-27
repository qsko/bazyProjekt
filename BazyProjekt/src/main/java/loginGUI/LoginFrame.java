package loginGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dbGUI.DatabaseFrame;
import login.VerifyLogin;

public class LoginFrame {
	private JFrame myFrame;
	private JPanel myPanel;
	private JLabel myLabel;
	private MyTextField loginText;
	private MyPasswordField pwdText;
	
	private JButton loginButton;
	
	public static Font myFont1 = new Font("Arial",Font.ITALIC,20);
	public static Font myFont2 = new Font("Arial",Font.BOLD,20);

	public LoginFrame() {
		initComponents();
		initLayout();
	}
	
	private void initComponents() {
		myFrame = new JFrame("Login to database.");
		myPanel = new JPanel();
		myPanel.setBackground(new Color(255,255,0));

		myLabel = new JLabel("Welcome to database!");
		
		loginText = new MyTextField("login",10);
		loginText.addFocusListener(new MyTextFieldListener(loginText));
		
		pwdText = new MyPasswordField("password",10);
		pwdText.addFocusListener(new MyPasswordListener(pwdText));

		loginButton = new JButton("Login");
		loginButton.addActionListener(new MyActionListener());
	}
	
	private void initLayout() {
		myPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.insets=new Insets(15,15,0,0);
		
		gbc.fill = GridBagConstraints.NONE;
		myPanel.add(myLabel);
		gbc.gridy++;

		gbc.fill = GridBagConstraints.HORIZONTAL;
		myPanel.add(loginText,gbc);
		gbc.gridy++;
		myPanel.add(pwdText,gbc);
		gbc.gridy++;
		
		gbc.fill = GridBagConstraints.NONE;
		myPanel.add(loginButton,gbc);
		
		myFrame.setLayout(new BorderLayout());
		myFrame.add(myPanel);
		myFrame.setSize(320, 240);
		myFrame.setResizable(false);
		myFrame.setVisible(true);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private class MyActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("Login")) {
				String login = loginText.getText();
				if (login.equals("login")) return;
				
				String password = String.valueOf(pwdText.getPassword());
				if (password.equals("password")) return;

				pwdText.setMsg();
				loginText.setMsg();
				myLabel.setText(login + " tried to log in.");
				
				System.out.println("Proba logowania: "+login+" haslo: "+password);
	
				//TODO logowanie
				try {
					VerifyLogin vl = new VerifyLogin(login,password);
					vl.buildConfig();
					vl.verify();
				}
				catch (Exception f) {
					myLabel.setText("Blad logowania. Sprobuj ponownie.");
					System.out.println(f.toString());
					return;
				}
				
				myFrame.setVisible(false);
				myFrame.dispose();
				new DatabaseFrame("Welcome to Stonka database! Logged in as "+login+".");
			}
		}
	}
}
