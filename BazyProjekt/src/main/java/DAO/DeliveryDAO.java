package DAO;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import entity. Delivery;
import enums.Status;
import login.VerifyLogin;
import util.HibernateUtil;

public class DeliveryDAO implements interfaceDAO{

	//add method
	public void addObject(Object delivery) {
			
		SessionFactory sessionFactory = VerifyLogin.getSessionFactory();
		Transaction transaction = null;

		try(Session currentSession = sessionFactory.getCurrentSession()) {
				
			transaction = currentSession.beginTransaction();
			currentSession.save((Delivery)delivery);
			transaction.commit();
		}catch(Exception ex) {
		    //error occured rollback
		    if (transaction != null) {
		        transaction.rollback();
		    }
		}
	}
		
	//update method
	public void updateObject(Object delivery) {
			

		SessionFactory sessionFactory = VerifyLogin.getSessionFactory();
		Transaction transaction = null;

		try (Session currentSession = sessionFactory.getCurrentSession()){
				
			transaction = currentSession.beginTransaction();
			currentSession.saveOrUpdate((Delivery)delivery);
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
		Delivery delivery = null;
		Transaction transaction = null;

		try(Session currentSession = sessionFactory.getCurrentSession()) {
				
			transaction = currentSession.beginTransaction();
			delivery =currentSession.get(Delivery.class, id);
			currentSession.delete(delivery);
			transaction.commit();
		}catch(Exception ex) {
		    //error occured rollback
		    if (transaction != null) {
		        transaction.rollback();
		    }
		}
	}
		
	//getter by id
	public Delivery getObjectById(int id) {
			
		SessionFactory sessionFactory = VerifyLogin.getSessionFactory();
		Delivery delivery = null;
		Transaction transaction = null;

		try (Session currentSession = sessionFactory.getCurrentSession()){
				
			transaction = currentSession.beginTransaction();
			delivery =currentSession.get(Delivery.class, id);
			transaction.commit();
		}catch(Exception ex) {
		    //error occured rollback
		    if (transaction != null) {
		        transaction.rollback();
		    }
		}
			
		return delivery;
	}
	//get all method
	public List<Delivery> getObjectList(){
	
		// get session
		SessionFactory sessionFactory = VerifyLogin.getSessionFactory();
		Transaction transaction = null;
		List< Delivery> deliveries = null;
		try (Session currentSession = sessionFactory.getCurrentSession()){
			//begin transaction
			transaction = currentSession.beginTransaction();
			//create query
			Query<Delivery> query = currentSession.createQuery("from Delivery",  Delivery.class);
			//get result
			deliveries = query.getResultList();
		
			transaction.commit();
			
		}catch(Exception ex) {
		    //error occured rollback
		    if (transaction != null) {
		        transaction.rollback();
		    }
		}
		return deliveries;
	}
}