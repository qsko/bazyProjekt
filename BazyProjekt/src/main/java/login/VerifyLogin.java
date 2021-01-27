package login;

import java.time.LocalDate;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import DAO.EmployeeDAO;
import entity.Employee;

public class VerifyLogin {
	private String login;
	private String pw;
	private static Configuration config;
	private static ServiceRegistry serreg;
	
	public VerifyLogin(String login, String pw){
		this.login=login;
		this.pw=pw;
		config = new Configuration();
	}
	
	static public SessionFactory getSessionFactory() {
		return config.buildSessionFactory(serreg);
	}
	
	/**utworzenie nowego hibernate.cfg dla danego hasla i loginu*/
	public void buildConfig() {
		Properties settings = new Properties();
		settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
		settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
		settings.put(Environment.URL, "jdbc:mysql://localhost/db");
		settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
		settings.put(Environment.SHOW_SQL, "true");
		settings.put(Environment.PASS, pw);
		settings.put(Environment.USER, login);
		config.setProperties(settings);
		
		serreg = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
	}

	/**Weryfikacja uzytkownika za pomoca pustej sesji*/
	public void verify() throws Exception{
		//TODO
	}
}
