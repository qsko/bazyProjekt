package dbIntegration;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.mysql.cj.jdbc.integration.c3p0.MysqlConnectionTester;

import dbGUI.DatabaseGUI;
import entity.Account;
import util.HibernateUtil;

public class QueryFrame {
	private JFrame queryFrame;
	private DatabaseGUI masterGUI;
	private JTextArea myTextArea;
	private JLabel tableLabel;
	private JLabel operLabel;
	private JTextArea infoArea;
	private MyActionListener myActionListener;
	private String [] tables;
	private EntityTypes [] tablesTypes;

	private Operation selectedOperation;
	private String selectedColumn;
	private EntityTypes selectedType;
	private List<QueryElement> selectedElements;
	
	public QueryFrame(DatabaseGUI masterGUI) {
		this.masterGUI=masterGUI;
		myActionListener=new MyActionListener();
		
		selectedOperation=null;
		selectedColumn=null;
		selectedElements=new ArrayList<QueryElement>();
		
		queryFrame = new JFrame("Create Query");
		JPanel masterPanel = new JPanel();
		JPanel topPanel = new JPanel();
		JPanel midPanel = new JPanel();
		JPanel botPanel = new JPanel();
		
		infoArea = new JTextArea("Query: SELECT FROM " + masterGUI.getCurrentTable().name()+ " WHERE");
		infoArea.setEditable(false);
		topPanel.add(infoArea);
		
		myTextArea = new JTextArea();
		tableLabel = new JLabel("<?>");
		operLabel = new JLabel("<?>");
		JButton addButton = new JButton("ADD");
		addButton.addActionListener(myActionListener);
		midPanel.setLayout(new GridBagLayout());
		
		
		GridBagConstraints midcon = new GridBagConstraints();
		
		midcon.gridy=0;
		midcon.gridx=0;
		midPanel.add(tableLabel,midcon);
		midcon.gridx++;
		midPanel.add(Box.createRigidArea(new Dimension(10,10)));
		midcon.gridx++;
		midPanel.add(operLabel,midcon);
		midcon.gridx++;
		midPanel.add(Box.createRigidArea(new Dimension(10,10)));
		midcon.gridx++;
		midcon.ipadx=50;
		midPanel.add(myTextArea,midcon);
		midcon.gridx++;
		midPanel.add(Box.createRigidArea(new Dimension(10,10)));
		midcon.gridx++;
		midcon.ipadx=0;
		midPanel.add(addButton,midcon);
		
		midPanel.setBorder(
				BorderFactory.createCompoundBorder(
						BorderFactory.createTitledBorder(""),
						BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		
		JButton queryButton = new JButton("EXEC");
		queryButton.addActionListener(myActionListener);
		botPanel.add(queryButton);
		
		masterPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.ipady=0;
		masterPanel.add(topPanel,gbc);
		gbc.gridy++;
		gbc.ipady=20;
		masterPanel.add(midPanel,gbc);
		gbc.gridy++;
		gbc.ipady=0;
		masterPanel.add(botPanel,gbc);
		
		//MENU
		JMenu tableMenu = new JMenu("Table");
		tables = masterGUI.getCurrentTable().getTablesNames();
		tablesTypes = masterGUI.getCurrentTable().getTablesTypes();
		
		for(String s: tables) {
			JMenuItem jmi = new JMenuItem(s);
			jmi.addActionListener(myActionListener);
			tableMenu.add(jmi);
		}
		
		JMenu operMenu = new JMenu("Operation");
		for(Operation o: Operation.values()) {
			JMenuItem jmi = new JMenuItem(o.name());
			jmi.addActionListener(myActionListener);
			operMenu.add(jmi);
		}
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(tableMenu);
		menuBar.add(operMenu);
		queryFrame.setJMenuBar(menuBar);
		
		
		
		queryFrame.add(masterPanel);
		queryFrame.setSize(400,300);
		queryFrame.setVisible(true);
	}
	
	private String generateQueryString() {
		String stmt = "from " + masterGUI.getCurrentTable().getTableClass().getSimpleName();
		
		if (selectedElements.size()!=0) {
			stmt+=" where ";
		}
		else {
			return stmt;
		}
		
		for(int i=0;i<selectedElements.size();i++) {
			QueryElement qe = selectedElements.get(i);
			String substmt="";
			substmt+=qe.column + " ";								//"column "
			substmt+=qe.getOperation().getOperationCode() + " "; 	//"column oper "
			substmt+=":var"+ String.valueOf(i);						//"column oper :var1"
			
			if (i!=selectedElements.size()-1) {
				substmt+=" and ";
			}
			stmt+=substmt;
		}
		return stmt;
	}
	
	private List<?> ProcessQuery(String queryS) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		List<?> result = null;
		Transaction transaction = null;
		
		try(Session currentSession = sessionFactory.getCurrentSession()) {
			transaction = currentSession.beginTransaction();
			
			Query query = currentSession.createQuery(queryS);
			int i=0;
			for(QueryElement qe: selectedElements) {
				String var = "var" + String.valueOf(i++);
				query.setParameter(var,qe.getVariable());
			}
			//query.executeUpdate();

			result = query.list();
			transaction.commit();
		} catch(Exception ex) {
			ex.printStackTrace();
		    if (transaction != null) {
		        transaction.rollback();
		        return null;
		    }
		}
		return result;
	}
	
	private class QueryElement {
		private String column;
		private String variable;
		private Operation operation;
		private EntityTypes type;
		
		public QueryElement(String column, Operation operation, String variable, EntityTypes type) {
			this.column=column;
			this.operation=operation;
			this.variable=variable;
			this.type=type;
		}

		public String getColumn() {
			return column;
		}

		public String getVariable() {
			return variable;
		}

		public Operation getOperation() {
			return operation;
		}
		
		public EntityTypes getType() {
			return this.type;
		}
	}

	private enum Operation{
		EQUAL_TO {
			@Override
			public String getOperationCode() {
				return "=";
			}
		},
		LIKE {
			@Override
			public String getOperationCode() {
				return "like";
			}
		},
		GREATER_THAN {
			@Override
			public String getOperationCode() {
				return ">";
			}
		},
		LESS_THAN {
			@Override
			public String getOperationCode() {
				return "<";
			}
		};
		
		public abstract String getOperationCode();
	}
	
	private class MyActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String action = e.getActionCommand();
			if (action.equals("ADD")) {
				String var = myTextArea.getText();
				if (selectedColumn!= null && selectedOperation!= null && var!="" && var!=null) {
					selectedElements.add(new QueryElement(selectedColumn,selectedOperation,var,selectedType));
					String op = selectedColumn + " " + selectedOperation.getOperationCode() + " " + var + ",";
					infoArea.setText(infoArea.getText()+"\n"+op);
					
					selectedColumn = null;
					selectedOperation = null;
					operLabel.setText("<?>");
					tableLabel.setText("<?>");
					myTextArea.setText("");
					return;
				}
			}
			else if (action.equals("EXEC")) {
				List<?> l = ProcessQuery(generateQueryString());
				masterGUI.displayStringArray(l);
			}
			
			for(String s:tables) {
				if (action.equals(s)) {
					selectedColumn=s;
					tableLabel.setText(s);
					return;
				}
			}
			
			for(int i=0;i<tables.length;i++) {
				if (action.equals(tables[i])) {
					selectedColumn=tables[i];
					selectedType=tablesTypes[i];
					tableLabel.setText(tables[i]);
					return;
				}
			}
			for(Operation o: Operation.values()) {
				if (action.equals(o.name())) {
					selectedOperation=o;
					operLabel.setText(o.getOperationCode());
					return;
				}
			}
		}
	}
}
