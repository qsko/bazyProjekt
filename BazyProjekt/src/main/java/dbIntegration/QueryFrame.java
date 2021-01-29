package dbIntegration;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import dbGUI.DatabaseGUI;
import entity.Account;
import util.HibernateUtil;

public class QueryFrame {
	private JFrame queryFrame;
	private DatabaseGUI masterGUI;
	private JTextArea myTextArea;
	
	public QueryFrame(DatabaseGUI masterGUI) {
		this.masterGUI=masterGUI;
		
		queryFrame = new JFrame();
		JPanel masterPanel = new JPanel();
		JPanel topPanel = new JPanel();
		JPanel midPanel = new JPanel();
		JPanel botPanel = new JPanel();
		
		topPanel.add(new JLabel("Query: SELECT FROM " + masterGUI.getCurrentTable().name()+ " WHERE ..."));
		
		myTextArea = new JTextArea();
		midPanel.add(myTextArea);
		
		midPanel.setBorder(
				BorderFactory.createCompoundBorder(
						BorderFactory.createTitledBorder(""),
						BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		
		JButton queryButton = new JButton("SELECT");
		queryButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("SELECT")) {
					String query = myTextArea.getText();
					processQuery(query);
					queryFrame.setVisible(false);
					queryFrame.dispose();
				}
			}
		});
		botPanel.add(queryButton);
		
		masterPanel.setLayout(new BoxLayout(masterPanel,BoxLayout.PAGE_AXIS));
		masterPanel.add(topPanel);
		masterPanel.add(midPanel);
		masterPanel.add(botPanel);
		
		queryFrame.add(masterPanel);
		queryFrame.setSize(400,150);
		queryFrame.setVisible(true);
	}
	
	private void processQuery(String query) {
		//TODO
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		List <?> accounts = null;
		Transaction transaction = null;

		try(Session currentSession = sessionFactory.getCurrentSession()) {
			//begin transaction
			transaction = currentSession.beginTransaction();
			//create query
			Query<?> myQuery = currentSession.createQuery("select * from " + masterGUI.getCurrentTable().name() + " where " + query,masterGUI.getCurrentTable().getClass());
			//get result
			accounts = myQuery.getResultList();
		
			transaction.commit();
		} catch(Exception ex) {
		    //error occured rollback
		    if (transaction != null) {
		        transaction.rollback();
		    }
		}
		//TODO
	}
}
