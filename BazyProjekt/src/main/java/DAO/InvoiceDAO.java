package DAO;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import entity.DeliveryProduct;
import entity.Invoice;
import enums.InvoiceType;
import util.HibernateUtil;

public class InvoiceDAO {
	//add method
	public void addInvoice(Invoice invoice) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Transaction transaction = null;

		try (Session currentSession = sessionFactory.getCurrentSession()){
			
			transaction = currentSession.beginTransaction();
			currentSession.save(invoice);
			transaction.commit();
		}catch(Exception ex) {
		    //error occured rollback
		    if (transaction != null) {
		        transaction.rollback();
		    }
		}
		
	}
	
	//update method
	public void updateInvoice(Invoice invoice) {
		

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Transaction transaction = null;

		try(Session currentSession = sessionFactory.getCurrentSession()) {
			
			currentSession.beginTransaction();
			currentSession.saveOrUpdate(invoice);
			transaction.commit();
		}catch(Exception ex) {
		    //error occured rollback
		    if (transaction != null) {
		        transaction.rollback();
		    }
		}

	}
	
	//delete method
	public void deleteInvoice(int id) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Invoice invoice = null;
		Transaction transaction = null;

		try (Session currentSession = sessionFactory.getCurrentSession()){
			
			transaction = currentSession.beginTransaction();
			invoice =currentSession.get(Invoice.class, id);
			currentSession.delete(invoice);
			transaction.commit();
		}catch(Exception ex) {
		    //error occured rollback
		    if (transaction != null) {
		        transaction.rollback();
		    }
		}
	}
	
	//getter by id
	public Invoice getInvoiceById(int id) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Invoice invoice = null;
		Transaction transaction = null;
		
		try (Session currentSession = sessionFactory.getCurrentSession()){
			
			transaction = currentSession.beginTransaction();
			invoice =currentSession.get(Invoice.class, id);
			transaction.commit();
		}catch(Exception ex) {
		    //error occured rollback
		    if (transaction != null) {
		        transaction.rollback();
		    }
		}
		return invoice;
	}
	
	//get all method
	public List<Invoice> getEmployees(){
	
		// get session
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		List<Invoice> invoices = null;
		Transaction transaction = null;
		try(Session currentSession = sessionFactory.getCurrentSession()) {
			
			transaction = currentSession.beginTransaction();
			Query<Invoice> query = currentSession.createQuery("from Invoice", Invoice.class);
			invoices = query.getResultList();
		
			transaction.commit();
			
		}catch(Exception ex) {
		    //error occured rollback
		    if (transaction != null) {
		        transaction.rollback();
		    }
		}
		return invoices;
	}
}