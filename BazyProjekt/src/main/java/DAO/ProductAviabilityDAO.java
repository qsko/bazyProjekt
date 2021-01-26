package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import entity.InvoiceProduct;
import entity.ProductAviability;
import util.HibernateUtil;

public class ProductAviabilityDAO {
	//add method
	public void addProductAviability(ProductAviability productAviability) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Transaction transaction = null;

		try(Session currentSession = sessionFactory.getCurrentSession()) {
			
			transaction = currentSession.beginTransaction();
			currentSession.save(productAviability);
			transaction.commit();
			
		}catch(Exception ex) {
		    //error occured rollback
		    if (transaction != null) {
		        transaction.rollback();
		    }
		}
		
	}
	
	//update method
	public void updateProductAviability(ProductAviability productAviability) {
		

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Transaction transaction = null;

		try(Session currentSession = sessionFactory.getCurrentSession()) {
			
			transaction = currentSession.beginTransaction();
			currentSession.saveOrUpdate(productAviability);
			transaction.commit();
		}catch(Exception ex) {
		    //error occured rollback
		    if (transaction != null) {
		        transaction.rollback();
		    }
		}

	}
	
	//delete method
	public void deleteProductAviability(int id) {
		
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
	public ProductAviability getProductAviability(int id) {
		
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
	public List<ProductAviability> getProductsAviability(){
	
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