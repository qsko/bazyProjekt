package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import entity.Employee;
import login.VerifyLogin;
import util.HibernateUtil;

public class EmployeeDAO implements interfaceDAO{

	
	//add method
	public void addObject(Object employee){
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Transaction transaction = null;

		try(Session currentSession = sessionFactory.getCurrentSession()) {
			
			transaction = currentSession.beginTransaction();
			currentSession.save((Employee)employee);
			transaction.commit();
		}catch(Exception ex) {
		    //error occured rollback
		    if (transaction != null) {
		        transaction.rollback();
		    }
		}
		
	}
	
	//update method
	public void updateObject(Object employee) {
		

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Transaction transaction = null;

		try (Session currentSession = sessionFactory.getCurrentSession()){
			
			transaction = currentSession.beginTransaction();
			currentSession.saveOrUpdate((Employee)employee);
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
		Employee employee = null;
		Transaction transaction = null;

		try(Session currentSession = sessionFactory.getCurrentSession()) {
			
			transaction = currentSession.beginTransaction();
			employee =currentSession.get(Employee.class, id);
			currentSession.delete(employee);
			transaction.commit();
		}catch(Exception ex) {
		    //error occured rollback
		    if (transaction != null) {
		        transaction.rollback();
		    }
		}
	}
	
	//getter by id
	public Employee getObjectById(int id) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Employee employee = null;
		Transaction transaction = null;

		try(Session currentSession = sessionFactory.getCurrentSession()) {
			
			transaction = currentSession.beginTransaction();
			employee =currentSession.get(Employee.class, id);
			transaction.commit();
		}catch(Exception ex) {
		    //error occured rollback
		    if (transaction != null) {
		        transaction.rollback();
		    }
		}
		return employee;
	}
	
	//get all method
	public List<?> getObjectList(){
	
		// get session
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		List<Employee> employees = null;
		Transaction transaction = null;
		
		try(Session currentSession = sessionFactory.getCurrentSession()) {
			transaction = currentSession.beginTransaction();
			Query<Employee> query = currentSession.createQuery("from Employee", Employee.class);
			 employees = query.getResultList();
		
			 transaction.commit();
			
		}catch(Exception ex) {
		    //error occured rollback
		    if (transaction != null) {
		        transaction.rollback();
		    }
		}
		return employees;
	}
}
