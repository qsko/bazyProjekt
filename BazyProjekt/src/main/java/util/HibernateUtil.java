package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.*;

public class HibernateUtil {

	private static SessionFactory sessionFactory;
	public static SessionFactory getSessionFactory() {
		
		try {
			if(sessionFactory == null) {
				
				sessionFactory = new Configuration().configure("hibernate.cfg.xml")
		 				
		 				.addAnnotatedClass(Account.class)
		 				.addAnnotatedClass(Contract.class)
		 				.addAnnotatedClass(Delivery.class)
		 				.addAnnotatedClass(Employee.class)
		 				.addAnnotatedClass(DeliveryProduct.class)
		 				.addAnnotatedClass(Invoice.class)
		 				.addAnnotatedClass(InvoiceProduct.class)
		 				.addAnnotatedClass(Product.class)
		 				.addAnnotatedClass(ProductAviability.class)
		 				.addAnnotatedClass(SaleByDay.class)
		 				.addAnnotatedClass(Schedule.class)
		 				.buildSessionFactory(); 
			}
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return sessionFactory;
	}
}
