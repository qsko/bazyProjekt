package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import entity.Account;
import util.HibernateUtil;

public class AccountDAO {

	
	//add method
	public void addAccount(Account account) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Transaction transaction = null;

		try(Session currentSession = sessionFactory.getCurrentSession()) {
			
			transaction = currentSession.beginTransaction();
			currentSession.save(account);
			transaction.commit();
		} catch(Exception ex) {
		    //error occured rollback
		    if (transaction != null) {
		        transaction.rollback();
		    }
		}
		
	}
	
	//update method
	public void updateAccount(Account account) {
		

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Transaction transaction = null;

		try(Session currentSession = sessionFactory.getCurrentSession()) {
			
			transaction = currentSession.beginTransaction();
			currentSession.saveOrUpdate(account);
			transaction.commit();
		} catch(Exception ex) {
		    //error occured rollback
		    if (transaction != null) {
		        transaction.rollback();
		    }
		}

	}
	
	//delete method
	public void deleteAccount(int id) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
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
	public Account getAccountById(int id) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
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
	public List<Account> getAccounts(){
	
		// get session
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
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
		} catch(Exception ex) {
		    //error occured rollback
		    if (transaction != null) {
		        transaction.rollback();
		    }
		}
		return accounts;
	}
}