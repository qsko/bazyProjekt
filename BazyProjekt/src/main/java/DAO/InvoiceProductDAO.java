package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import entity.InvoiceProduct;
import util.HibernateUtil;

public class InvoiceProductDAO implements interfaceDAO{
	//add method
	public void addObject(Object invoiceProduct) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Transaction transaction = null;
		try(Session currentSession = sessionFactory.getCurrentSession()){
			
			transaction = currentSession.beginTransaction();
			currentSession.save((InvoiceProduct)invoiceProduct);
			transaction.commit();
		}catch(Exception ex) {
		    //error occured rollback
		    if (transaction != null) {
		        transaction.rollback();
		    }
		}
		
	}
	
	//update method
	public void updateObject(Object invoiceProduct) {
		

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Transaction transaction = null;

		try(Session currentSession = sessionFactory.getCurrentSession()) {
			
			transaction = currentSession.beginTransaction();
			currentSession.saveOrUpdate((InvoiceProduct)invoiceProduct);
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
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		InvoiceProduct invoiceProduct = null;
		Transaction transaction = null;

		try(Session currentSession = sessionFactory.getCurrentSession()){
			
			transaction = currentSession.beginTransaction();
			invoiceProduct =currentSession.get(InvoiceProduct.class, id);
			currentSession.delete(invoiceProduct);
			transaction.commit();
		}catch(Exception ex) {
		    //error occured rollback
		    if (transaction != null) {
		        transaction.rollback();
		    }
		}
	}
	
	//getter by id
	public InvoiceProduct getObjectById(int id) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		InvoiceProduct invoiceProduct = null;
		Transaction transaction = null;

		try(Session currentSession = sessionFactory.getCurrentSession()){
			
			transaction = currentSession.beginTransaction();
			invoiceProduct =currentSession.get(InvoiceProduct.class, id);
			transaction.commit();
		}catch(Exception ex) {
		    //error occured rollback
		    if (transaction != null) {
		        transaction.rollback();
		    }
		}
		return invoiceProduct;
	}
	
	//get all method
	public List<InvoiceProduct> getObjectList(){
	
		// get session
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		List<InvoiceProduct> invoiceProducts = null;
		Transaction transaction = null;

		try(Session currentSession = sessionFactory.getCurrentSession()){
			transaction = currentSession.beginTransaction();
			Query<InvoiceProduct> query = currentSession.createQuery("from InvoiceProduct", InvoiceProduct.class);
			invoiceProducts = query.getResultList();
		
			transaction.commit();
			
		}catch(Exception ex) {
		    //error occured rollback
		    if (transaction != null) {
		        transaction.rollback();
		    }
		}
		return invoiceProducts;
	}
}