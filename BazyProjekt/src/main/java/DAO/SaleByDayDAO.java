package DAO;

import java.time.LocalDate;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import entity.SaleByDay;
import login.VerifyLogin;
import util.HibernateUtil;

public class SaleByDayDAO implements interfaceDAO{


	//add method
	public void addObject(Object saleByDay) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session currentSession = sessionFactory.getCurrentSession();
		Transaction transaction = null;
		try {
			
			transaction = currentSession.beginTransaction();
			currentSession.save((SaleByDay)saleByDay);
			transaction.commit();
		} catch(Exception ex) {
		    //error occured rollback
		    if (transaction != null) {
		        transaction.rollback();
		    }
		} finally {
		    if (currentSession != null) {
		        currentSession.close();
		    }

		}
	}
	
	//update method
	public void updateObject(Object saleByDay) {
		

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session currentSession = sessionFactory.getCurrentSession();
		Transaction transaction = null;
		try {
			
			transaction = currentSession.beginTransaction();
			currentSession.saveOrUpdate((SaleByDay)saleByDay);
			transaction.commit();
			
		} catch(Exception ex) {
				    //error occured rollback
				    if (transaction != null) {
				        transaction.rollback();
				    }
				} finally {
				    if (currentSession != null) {
				        currentSession.close();
				    }

				}
	}
	
	//delete method
	public void removeObject(int id) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session currentSession = sessionFactory.getCurrentSession();
		SaleByDay saleByDay = null;
		Transaction transaction = null;
		try {
			
			transaction = currentSession.beginTransaction();
			saleByDay =currentSession.get(SaleByDay.class, id);
			currentSession.delete(saleByDay);
			transaction.commit();
		} catch(Exception ex) {
		    //error occured rollback
		    if (transaction != null) {
		        transaction.rollback();
		    }
		} finally {
		    if (currentSession != null) {
		        currentSession.close();
		    }

		}
	}
	
	//getter by date
	public SaleByDay getObjectById(int id) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session currentSession = sessionFactory.getCurrentSession();
		SaleByDay saleByDay = null;
		Transaction transaction = null;
		try {
			
			transaction = currentSession.beginTransaction();
			saleByDay = currentSession.get(SaleByDay.class, id);
			transaction.commit();
		} catch(Exception ex) {
		    //error occured rollback
		    if (transaction != null) {
		        transaction.rollback();
		    }
		}
		
		return saleByDay;
	}
	
	//get all method
	public List<SaleByDay> getObjectList(){
	
		// get session
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Transaction transaction = null;
		List<SaleByDay> sales = null;
		
		try (Session currentSession = sessionFactory.getCurrentSession()){
			transaction = currentSession.beginTransaction();
			Query<SaleByDay> query = currentSession.createQuery("from SaleByDay", SaleByDay.class);
			sales = query.getResultList();
		
			transaction.commit();
		} catch(Exception ex) {
		    //error occured rollback
		    if (transaction != null) {
		        transaction.rollback();
		    }
		}
		return sales; 
		
		
	}
}