package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import entity.Account;
import login.VerifyLogin;
import util.HibernateUtil;

public class AccountDAO implements interfaceDAO{

	
	//add method
	public void addObject(Object account) {
		
		SessionFactory sessionFactory = VerifyLogin.getSessionFactory();
		Transaction transaction = null;

		try(Session currentSession = sessionFactory.getCurrentSession()) {
			
			transaction = currentSession.beginTransaction();
			currentSession.save((Account)account);
			transaction.commit();
		} catch(Exception ex) {
			ex.printStackTrace();
		    //error occured rollback
		    if (transaction != null) {
		        transaction.rollback();
		    }
		}
		
	}
	
	//update method
	public void updateObject(Object account) {

		SessionFactory sessionFactory = VerifyLogin.getSessionFactory();
		Transaction transaction = null;

		try(Session currentSession = sessionFactory.getCurrentSession()) {
			
			transaction = currentSession.beginTransaction();
			currentSession.saveOrUpdate((Account)account);
			transaction.commit();
		} catch(Exception ex) {
		    //error occured rollback
		    if (transaction != null) {
		        transaction.rollback();
		    }
		}

	}
	
	//delete method
	public void removeObject(int id) {
		
		SessionFactory sessionFactory = VerifyLogin.getSessionFactory();
		Account account = null;
		Transaction transaction = null;
		try(Session currentSession = sessionFactory.getCurrentSession()) {
			
			transaction = currentSession.beginTransaction();
			account =currentSession.get(Account.class, id);
			currentSession.delete(account);
			transaction.commit();
		} catch(Exception ex) {
		    //error occured rollback
		    if (transaction != null) {
		        transaction.rollback();
		    }
		}
	}
	
	//getter by id
	public Object getObjectById(int id) {
		
		SessionFactory sessionFactory = VerifyLogin.getSessionFactory();
		Account account = null;
		Transaction transaction = null;
		try(Session currentSession = sessionFactory.getCurrentSession()) {
			
			transaction = currentSession.beginTransaction();
			account =currentSession.get(Account.class, id);
			transaction.commit();
		} catch(Exception ex) {
		    //error occured rollback
		    if (transaction != null) {
		        transaction.rollback();
		    }
		}
		return account;
	}
	
	//get all method
	public List<Account> getObjectList(){
	
		// get session
		SessionFactory sessionFactory = VerifyLogin.getSessionFactory();
		List <Account> accounts = null;
		Transaction transaction = null;
		
		try(Session currentSession = sessionFactory.getCurrentSession()) {
			//begin transaction
			transaction = currentSession.beginTransaction();
			//create query
			Query<Account> query = currentSession.createQuery("from Account", Account.class);
			//get result
			accounts = query.getResultList();
		
			transaction.commit();
		}catch(Exception ex) {
		    //error occured rollback
		    if (transaction != null) {
		        transaction.rollback();
		    }
		}
		return accounts;
	}
}