package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import entity.InvoiceProduct;
import util.HibernateUtil;

public class InvoiceProductDAO {
	//add method
	public void addInvoiceProduct(InvoiceProduct invoiceProduct) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Transaction transaction = null;
		try(Session currentSession = sessionFactory.getCurrentSession()){
			
			transaction = currentSession.beginTransaction();
			currentSession.save(invoiceProduct);
			transaction.commit();
		}catch(Exception ex) {
		    //error occured rollback
		    if (transaction != null) {
		        transaction.rollback();
		    }
		}
		
	}
	
	//update method
	public void updateInvoiceProduct(InvoiceProduct invoiceProduct) {
		

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Transaction transaction = null;

		try(Session currentSession = sessionFactory.getCurrentSession()) {
			
			transaction = currentSession.beginTransaction();
			currentSession.saveOrUpdate(invoiceProduct);
			transaction.commit();
		}catch(Exception ex) {
		    //error occured rollback
		    if (transaction != null) {
		        transaction.rollback();
		    }
		}

	}
	
	//delete method
	public void deleteInvoiceProduct(int id) {
		
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
	public InvoiceProduct getInvoiceProduct(int id) {
		
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
	public List<InvoiceProduct> getInvoiceProducts(){
	
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