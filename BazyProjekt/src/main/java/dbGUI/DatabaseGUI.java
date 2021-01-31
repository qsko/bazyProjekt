package dbGUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Paint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import DAO.EmployeeDAO;
import dbIntegration.Tables;
import entity.Employee;

public class DatabaseGUI {
	private JFrame myFrame;

	/**Panel mieszczacy wszystkie inne panele*/
	JPanel masterPanel;
	
	/**Panel po prawej stronie ekranu zawierajacy pole tekstowe, wiadomosc oraz pasek na dole*/
	JPanel dataPanel;
	/**Panel po lewej zezwalajacy wykonac akcje*/
	JPanel actionPanel;
	
	/**Panel w prawym gornym rogu wyswietlajacy wiadomosc*/
	MyInfoPanel infoPanel;
	/**Panel w prawym dolnym rogu zawierajacy przyciski*/
	MyMovePanel movePanel;
	
	private Tables currentTable;
	
	public StringDisplayer myStringDisplayer;
	
	public DBFrameListener myListener;
	
	public static Font myFont1 = new Font("Arial",Font.PLAIN,13);
	public static Font myErrorFont1 = new Font("Arial",Font.PLAIN,13);
	public static Color appColor1 = new Color(255,255,50);

	final String[] test = {"this","is","a","test","String","lenght","undefined","see","if","it","fits","inside","the",
			"frame","and","label","this","is","a","test","String","lenght","undefined","see","if","it","fits","inside","the",
			"frame","and","label","this","is","a","test","String","lenght","undefined","see","if","it","fits","inside","the",
			"frame","and","label"};

	public DatabaseGUI(String welcomeMessage) {
		myListener = new DBFrameListener(this);
		new DBFrameBuilder(this).buildAllPanels();
		
		myFrame = new JFrame("Stonka Database v0.01");
		myFrame.add(masterPanel);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setVisible(true);
		myFrame.setSize(832,468);
		myFrame.setMinimumSize(new Dimension(720, 400));
		
		if(welcomeMessage!=null)
				sendMessage(welcomeMessage);

	}
	
	/**Funkcja wysyla zwykla wiadomosc w prawym, gornym rogu*/
	public void sendMessage(String message) {
		infoPanel.sendMessage(message);
	}
	
	/**Funkcja wysyla wiadomosc w kolorze czerwonym w prawym, gornym rogu*/
	public void sendErrorMessage(String message) {
		infoPanel.sendErrorMessage(message);
	}

	/**Funkcja wyswietla dany zbior lancuchow znakow*/
	public void displayStringArray(List<?> list) {
		myStringDisplayer.setStringArray(list);
		myStringDisplayer.displayN();
		checkConstrains();
	}
	
	/**Funkcja sprawdza rozmiar tabeli znakow i odpowiednio wyswietla przyciski
	 * do zmiany wyswietlanych pozycji.
	 */
	public void checkConstrains() {
		if (myStringDisplayer.canDisplayNext())
			movePanel.showRightButton(true);
		else
			movePanel.showRightButton(false);;
		
		if (myStringDisplayer.canDisplayPrev())
			movePanel.showLeftButton(true);
		else
			movePanel.showLeftButton(false);
		
		movePanel.displayMessage("Displaying: "+(myStringDisplayer.getCurrent()+1)+"-"+myStringDisplayer.getCurrentMax()+"/"+myStringDisplayer.getSLen());
	}
	
	public void setCurrentTable(Tables t) {
		this.currentTable=t;
	}
	
	public Tables getCurrentTable() {
		return currentTable;
	}
	
}
