package DAO;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import entity.Schedule;
import util.HibernateUtil;

public class ScheduleDAO implements interfaceDAO{

	//add method
	public void addObject(Object schedule) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Transaction transaction = null;
		try(Session currentSession = sessionFactory.getCurrentSession()) {
			
			transaction = currentSession.beginTransaction();
			currentSession.save((Schedule)schedule);
			transaction.commit();
		} catch(Exception ex) {
		    //error occured rollback
		    if (transaction != null) {
		        transaction.rollback();
		    }
		    ex.printStackTrace();
		}
		
	}
	
	//update method
	public void updateObject(Object schedule) {
		

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Transaction transaction = null;
		try(Session currentSession = sessionFactory.getCurrentSession()) {
			
			transaction = currentSession.beginTransaction();
			currentSession.saveOrUpdate((Schedule)schedule);
			transaction.commit();
		} catch(Exception ex) {
		    //error occured rollback
		    if (transaction != null) {
		        transaction.rollback();
		    }
		    ex.printStackTrace();
		}

	}
	
	//delete method
	public void removeObject(int id) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Transaction transaction = null;
		Schedule schedule = null;
		try(Session currentSession = sessionFactory.getCurrentSession()) {
			
			transaction = currentSession.beginTransaction();
			schedule =currentSession.get(Schedule.class, id);
			currentSession.delete(schedule);
			transaction.commit();
		} catch(Exception ex) {
		    //error occured rollback
		    if (transaction != null) {
		        transaction.rollback();
		    }
		}
	}
	
	//getter by date
	public Schedule getObjectById(int id) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Transaction transaction = null;
		Schedule schedule = null;
		try(Session currentSession = sessionFactory.getCurrentSession()) {
			
			transaction = currentSession.beginTransaction();
			schedule = currentSession.get(Schedule.class, id);
			transaction.commit();
		} catch(Exception ex) {
		    //error occured rollback
		    if (transaction != null) {
		        transaction.rollback();
		    }
		}
		
		return schedule;
	}
	
	//get all method
	public List<Schedule> getObjectList(){
	
		// get session
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Transaction transaction = null;
		List<Schedule> schedules = null;
		
		try(Session currentSession = sessionFactory.getCurrentSession()) {
			
			transaction = currentSession.beginTransaction();
			Query<Schedule> query = currentSession.createQuery("from Schedule", Schedule.class);
			schedules = query.getResultList();
		
			transaction.commit();
			return schedules;
			
		} catch(Exception ex) {
		    //error occured rollback
		    if (transaction != null) {
		        transaction.rollback();
		    }
		}
		return schedules;

	}
}