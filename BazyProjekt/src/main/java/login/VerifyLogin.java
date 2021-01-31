package login;

import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.*;

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
		sessionFactory = config.buildSessionFactory();
	}

	/**Weryfikacja uzytkownika za pomoca pustej sesji*/
	public void verify() throws Exception{
		//TODO
	}
}
