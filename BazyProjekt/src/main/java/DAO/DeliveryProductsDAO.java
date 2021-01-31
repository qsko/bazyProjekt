package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import entity.Account;
import entity.DeliveryProduct;
import login.VerifyLogin;
import util.HibernateUtil;

public class DeliveryProductsDAO implements interfaceDAO{
	
	//add method
	public void addObject(Object deliveryProducts) {
		
		SessionFactory sessionFactory = VerifyLogin.getSessionFactory();
		Transaction transaction = null;

		try(Session currentSession = sessionFactory.getCurrentSession()) {
			
			transaction = currentSession.beginTransaction();
			
			currentSession.save((DeliveryProduct)deliveryProducts);
			transaction.commit();
		}catch(Exception ex) {
		    //error occured rollback
		    if (transaction != null) {
		        transaction.rollback();
		    }
		}
	}
	
	//update method
	public void updateObject(Object deliveryProduct) {
		

		SessionFactory sessionFactory = VerifyLogin.getSessionFactory();
		Transaction transaction = null;

		try (Session currentSession = sessionFactory.getCurrentSession()){
			
			transaction = currentSession.beginTransaction();
			currentSession.saveOrUpdate((DeliveryProduct)deliveryProduct);
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
		DeliveryProduct deliveryProduct = null;
		Transaction transaction = null;

		try (Session currentSession = sessionFactory.getCurrentSession()){
			
			transaction = currentSession.beginTransaction();
			deliveryProduct =currentSession.get(DeliveryProduct.class, id);
			currentSession.delete(deliveryProduct);
			transaction.commit();
		}catch(Exception ex) {
		    //error occured rollback
		    if (transaction != null) {
		        transaction.rollback();
		    }
		}
	}
	
	//getter by id
	public DeliveryProduct getObjectById(int id) {
		
		SessionFactory sessionFactory = VerifyLogin.getSessionFactory();
		DeliveryProduct deliveryProduct = null;
		Transaction transaction = null;

		try(Session currentSession = sessionFactory.getCurrentSession()) {
			
			transaction = currentSession.beginTransaction();
			deliveryProduct =currentSession.get(DeliveryProduct.class, id);
			transaction.commit();
		}catch(Exception ex) {
		    //error occured rollback
		    if (transaction != null) {
		        transaction.rollback();
		    }
		}
		
		return deliveryProduct;
	}
	
	//get all method	
	public List<DeliveryProduct> getObjectList(){
	
		// get session
		SessionFactory sessionFactory = VerifyLogin.getSessionFactory();
		
		List<DeliveryProduct> deliveryProducts = null;
		Transaction transaction = null;
		try(Session currentSession = sessionFactory.getCurrentSession()) {
			//begin transaction
			transaction = currentSession.beginTransaction();
			//create query
			Query<DeliveryProduct> query = currentSession.createQuery("from DeliveryProduct",  DeliveryProduct.class);
			//get result
			deliveryProducts = query.getResultList();
		
			transaction.commit();
			
		}catch(Exception ex) {
		    //error occured rollback
		    if (transaction != null) {
		        transaction.rollback();
		    }
		}
		return deliveryProducts;
	}
}