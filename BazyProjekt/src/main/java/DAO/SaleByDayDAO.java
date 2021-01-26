package DAO;

import java.time.LocalDate;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import entity.SaleByDay;

import util.HibernateUtil;

public class SaleByDayDAO {


	//add method
	public void addSaleByDay(SaleByDay saleByDay) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session currentSession = sessionFactory.getCurrentSession();
		Transaction transaction = null;
		try {
			
		
			transaction = currentSession.beginTransaction();
			currentSession.save(saleByDay);
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
	public void updateSaleByDay(SaleByDay saleByDay) {
		

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session currentSession = sessionFactory.getCurrentSession();
		Transaction transaction = null;
		try {
			
			transaction = currentSession.beginTransaction();
			currentSession.saveOrUpdate(saleByDay);
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
	public void deleteSaleByDay(LocalDate date) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session currentSession = sessionFactory.getCurrentSession();
		SaleByDay saleByDay = null;
		Transaction transaction = null;
		try {
			
			transaction = currentSession.beginTransaction();
			saleByDay =currentSession.get(SaleByDay.class, date);
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
	public SaleByDay getSaleByDay(LocalDate date) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session currentSession = sessionFactory.getCurrentSession();
		SaleByDay saleByDay = null;
		Transaction transaction = null;
		try {
			
			transaction = currentSession.beginTransaction();
			saleByDay = currentSession.get(SaleByDay.class, date);
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
	public List<SaleByDay> getSalesByDay(){
	
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