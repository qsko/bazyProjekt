package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import entity.InvoiceProduct;
import entity.ProductAviability;
import util.HibernateUtil;

public class ProductAviabilityDAO implements interfaceDAO{
	//add method
	public void addObject(Object productAviability) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Transaction transaction = null;

		try(Session currentSession = sessionFactory.getCurrentSession()) {
			
			transaction = currentSession.beginTransaction();
			currentSession.save((ProductAviability)productAviability);
			transaction.commit();
			
		}catch(Exception ex) {
		    //error occured rollback
		    if (transaction != null) {
		        transaction.rollback();
		    }
		}
		
	}
	
	//update method
	public void updateObject(Object productAviability) {
		

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Transaction transaction = null;

		try(Session currentSession = sessionFactory.getCurrentSession()) {
			
			transaction = currentSession.beginTransaction();
			currentSession.saveOrUpdate((ProductAviability)productAviability);
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
		ProductAviability productAviability = null;
		Transaction transaction = null;

		try(Session currentSession = sessionFactory.getCurrentSession()) {
			
			transaction = currentSession.beginTransaction();
			productAviability =currentSession.get(ProductAviability.class, id);
			currentSession.delete(productAviability);
			transaction.commit();
		}catch(Exception ex) {
		    //error occured rollback
		    if (transaction != null) {
		        transaction.rollback();
		    }
		}
	}
	
	//getter by id
	public ProductAviability getObjectById(int id) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		ProductAviability productAviability = null;
		Transaction transaction = null;

		try(Session currentSession = sessionFactory.getCurrentSession()) {
			
			transaction = currentSession.beginTransaction();
			productAviability = currentSession.get(ProductAviability.class, id);
			transaction.commit();
		}finally {
			sessionFactory.close();
		}
		
		return productAviability;
	}
	
	//get all method
	public List<ProductAviability> getObjectList(){
	
		// get session
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		List<ProductAviability> productsAviability = null;
		Transaction transaction = null;
		try(Session currentSession = sessionFactory.getCurrentSession()){
			
			transaction = currentSession.beginTransaction();
			Query<ProductAviability> query = currentSession.createQuery("from ProductAviability", ProductAviability.class);
			productsAviability = query.getResultList();
		
			transaction.commit();
			
			
		}catch(Exception ex) {
		    //error occured rollback
		    if (transaction != null) {
		        transaction.rollback();
		    }
		}
		return productsAviability;
	}
}