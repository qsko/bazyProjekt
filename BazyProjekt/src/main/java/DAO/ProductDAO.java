package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import entity.Product;
import entity.ProductAviability;
import enums.Is_18;
import enums.PriceType;
import login.VerifyLogin;
import util.HibernateUtil;

public class ProductDAO implements interfaceDAO{
	
	
	//add method
	public void addObject(Object product) {
		
		SessionFactory sessionFactory = VerifyLogin.getSessionFactory();
		Transaction transaction = null;
		try(Session currentSession = sessionFactory.getCurrentSession()) {
			
			transaction = currentSession.beginTransaction();
			
			currentSession.save((Product)product);
			transaction.commit();
		}catch(Exception ex) {
		    //error occured rollback
		    if (transaction != null) {
		    	ex.printStackTrace();
		        transaction.rollback();
		    }
		}
	}
	
	//update method
	public void updateObject(Object product) {
		

		SessionFactory sessionFactory = VerifyLogin.getSessionFactory();
		Transaction transaction = null;

		try (Session currentSession = sessionFactory.getCurrentSession()){
			
			transaction = currentSession.beginTransaction();
			currentSession.saveOrUpdate((Product)product);
			transaction.commit();
		}catch(Exception ex) {
		    //error occured rollback
		    if (transaction != null) {
		        transaction.rollback();
		    }
		}

	}
	
	//delete method
	public void removeObject(int id) {
		
		SessionFactory sessionFactory = VerifyLogin.getSessionFactory();
		Product product = null;
		Transaction transaction = null;

		try (Session currentSession = sessionFactory.getCurrentSession()){
			transaction = currentSession.beginTransaction();
			product =currentSession.get(Product.class, id);
			currentSession.delete(product);
			transaction.commit();
		}catch(Exception ex) {
		    //error occured rollback
		    if (transaction != null) {
		        transaction.rollback();
		    }
		}
	}
	
	//getter by id
	public Product getObjectById(int id) {
		
		SessionFactory sessionFactory = VerifyLogin.getSessionFactory();
		Product product = null;
		Transaction transaction = null;

		try(Session currentSession = sessionFactory.getCurrentSession()) {
			
			transaction = currentSession.beginTransaction();
			product = currentSession.get(Product.class, id);
			transaction.commit();
		}catch(Exception ex) {
		    //error occured rollback
		    if (transaction != null) {
		        transaction.rollback();
		    }
		}
		
		return product;
	}
	
	//get all method
	public List<Product> getObjectList(){
	
		// get session
		SessionFactory sessionFactory = VerifyLogin.getSessionFactory();
		List<Product> products = null;
		Transaction transaction = null;

		try(Session currentSession = sessionFactory.getCurrentSession()){
			transaction = currentSession.beginTransaction();
			Query<Product> query = currentSession.createQuery("from Product", Product.class);
			products = query.getResultList();
		
			transaction.commit();
			
		}catch(Exception ex) {
		    //error occured rollback
		    if (transaction != null) {
		        transaction.rollback();
		    }
		}
		return products;
	}
	
}