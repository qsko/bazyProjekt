package DAO;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import entity.Account;
import entity.Contract;
import enums.ContractType;
import enums.Position;
import login.VerifyLogin;
import util.HibernateUtil;

public class ContractDAO implements interfaceDAO{
	
	//add method
	public void addObject(Object contract) {
			
		SessionFactory sessionFactory = VerifyLogin.getSessionFactory();
		Transaction transaction = null;

		try(Session currentSession = sessionFactory.getCurrentSession()) {
				
			transaction = currentSession.beginTransaction();
			currentSession.save((Contract)contract);
			transaction.commit();
		}catch(Exception ex) {
		    //error occured rollback
		    if (transaction != null) {
		        transaction.rollback();
		    }
		    ex.printStackTrace();
		}
			
	}
		
	//update method
	public void updateObject(Object contract) {
			

		SessionFactory sessionFactory = VerifyLogin.getSessionFactory();
		Transaction transaction = null;

		try (Session currentSession = sessionFactory.getCurrentSession()){
				
			transaction = currentSession.beginTransaction();
			currentSession.saveOrUpdate((Contract)contract);
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
		Contract contract = null;
		Transaction transaction = null;

		try(Session currentSession = sessionFactory.getCurrentSession()) {
				
			transaction = currentSession.beginTransaction();
			contract =currentSession.get(Contract.class, id);
			currentSession.delete(contract);
			transaction.commit();
		}catch(Exception ex) {
		    //error occured rollback
		    if (transaction != null) {
		        transaction.rollback();
		    }
		}
	}
		
	//getter by id
	public Contract getObjectById(int id) {
			
		SessionFactory sessionFactory = VerifyLogin.getSessionFactory();
		Contract contract = null;
		Transaction transaction = null;
		try(Session currentSession = sessionFactory.getCurrentSession()) {
				
			transaction = currentSession.beginTransaction();
			contract =currentSession.get(Contract.class, id);
			transaction.commit();
		}catch(Exception ex) {
		    //error occured rollback
		    if (transaction != null) {
		        transaction.rollback();
		    }
		}
			
		return contract;
	}
	
	//get all method
	public List<Contract> getObjectList(){
	
		// get session
		SessionFactory sessionFactory = VerifyLogin.getSessionFactory();
		Transaction transaction = null;
		List<Contract> contracts = null; 
		try (Session currentSession = sessionFactory.getCurrentSession()){
			//begin transaction
			transaction =  currentSession.beginTransaction();
			//create query
			Query<Contract> query = currentSession.createQuery("from Contract", Contract.class);
			//get result
			contracts = query.getResultList();
		
			transaction.commit();
			
		}catch(Exception ex) {
		    //error occured rollback
		    if (transaction != null) {
		        transaction.rollback();
		    }
		}
		return contracts;
	}
}