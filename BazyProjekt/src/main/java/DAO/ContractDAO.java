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
import util.HibernateUtil;

public class ContractDAO {
	
	//add method
	public void addContract(Contract contract) {
			
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Transaction transaction = null;

		try(Session currentSession = sessionFactory.getCurrentSession()) {
				
			transaction = currentSession.beginTransaction();
			currentSession.save(contract);
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
	public void updateContract(Contract contract) {
			

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Transaction transaction = null;

		try (Session currentSession = sessionFactory.getCurrentSession()){
				
			transaction = currentSession.beginTransaction();
			currentSession.saveOrUpdate(contract);
			transaction.commit();
		}catch(Exception ex) {
		    //error occured rollback
		    if (transaction != null) {
		        transaction.rollback();
		    }
		}

	}
		
		//delete method
	public void deleteContract(int id) {
			
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
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
	public Contract getContractById(int id) {
			
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
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
	public List<Contract> getContracts(){
	
		// get session
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
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