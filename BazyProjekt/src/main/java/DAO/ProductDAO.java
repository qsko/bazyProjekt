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
import util.HibernateUtil;

public class ProductDAO {
	
	
	//add method
	public void addProduct(Product product) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Transaction transaction = null;
		try(Session currentSession = sessionFactory.getCurrentSession()) {
			
			transaction = currentSession.beginTransaction();
			
			currentSession.save(product);
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
	public void updateProduct(Product product) {
		

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Transaction transaction = null;

		try (Session currentSession = sessionFactory.getCurrentSession()){
			
			transaction = currentSession.beginTransaction();
			currentSession.saveOrUpdate(product);
			transaction.commit();
		}catch(Exception ex) {
		    //error occured rollback
		    if (transaction != null) {
		        transaction.rollback();
		    }
		}

	}
	
	//delete method
	public void deleteProduct(int id) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Product product = null;
		Transaction transaction = null;

		try (Session currentSession = sessionFactory.getCurrentSession()){
			
			transaction = currentSession.beginTransaction();
			product =currentSession.get(Product.class, id);
			currentSession.delete(product);
			transaction.commit();
		}finally {
			sessionFactory.close();
		}
	}
	
	//getter by id
	public Product getProduct(int id) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
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
	public List<Product> getProducts(){
	
		// get session
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
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