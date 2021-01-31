package login;

import java.time.LocalDate;
import java.util.List;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import entity.*;
import enums.Position;

public class VerifyLogin {
	private String login;
	private String pw;
	static Configuration config;
	private static SessionFactory sessionFactory;
	
	public VerifyLogin(String login, String pw){
		this.login=login;
		this.pw=pw;
	}
	
	static public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	/**utworzenie nowego hibernate.cfg dla danego hasla i loginu*/
	public void buildConfig() {
		config = new Configuration();
		config.configure("hibernate.cfg.xml");
		config.getProperties().setProperty("hibernate.connection.username", login);
		config.getProperties().setProperty("hibernate.connection.password", pw);
		config.addAnnotatedClass(Account.class);
		config.addAnnotatedClass(Contract.class);
		config.addAnnotatedClass(Delivery.class);
		config.addAnnotatedClass(DeliveryProduct.class);
		config.addAnnotatedClass(Employee.class);
		config.addAnnotatedClass(Invoice.class);
		config.addAnnotatedClass(InvoiceProduct.class);
		config.addAnnotatedClass(Product.class);
		config.addAnnotatedClass(ProductAviability.class);
		config.addAnnotatedClass(SaleByDay.class);
		config.addAnnotatedClass(Schedule.class);
		config.addAnnotatedClass(LoginPosition.class);
		sessionFactory = config.buildSessionFactory();
	}

	/**Weryfikacja uzytkownika za pomoca pustej sesji*/
	public Position verify(String login) throws Exception{
		SessionFactory sessionFactory = getSessionFactory();
		if (sessionFactory==null) throw new Exception ("Critical Error");
		
		
		Transaction transaction = null;
		
		try (Session session = sessionFactory.getCurrentSession()){
			transaction = session.beginTransaction();
			String query1="from LoginPosition where login = :var";
			Query<?> q = session.createQuery(query1);
			q.setParameter("var", login);
			
			List<LoginPosition> a = (List<LoginPosition>) q.list();
			
			if (a==null) {
				throw new Exception("No employee data in database");
			}
			LoginPosition p = a.get(0);
			
			return p.getPosition();
		}
		catch (Exception e) {
			if (transaction!=null)
				transaction.rollback();
		}
		return null;
	}
}
