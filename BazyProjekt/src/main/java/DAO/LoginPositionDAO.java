package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import entity.LoginPosition;
import entity.ProductAviability;
import login.VerifyLogin;

public class LoginPositionDAO implements interfaceDAO{

	@Override
	public void addObject(Object o) {
		SessionFactory sessionFactory = VerifyLogin.getSessionFactory();
		Transaction transaction = null;

		try(Session currentSession = sessionFactory.getCurrentSession()) {
				
			transaction = currentSession.beginTransaction();
			currentSession.save((LoginPosition)o);
			transaction.commit();
				
		}catch(Exception ex) {
			   //error occured rollback
			   if (transaction != null) {
			       transaction.rollback();
			   }
		}
	}

	@Override
	public void updateObject(Object o) {
		SessionFactory sessionFactory = VerifyLogin.getSessionFactory();
		Transaction transaction = null;

		try(Session currentSession = sessionFactory.getCurrentSession()) {
			
			transaction = currentSession.beginTransaction();
			currentSession.saveOrUpdate((LoginPosition)o);
			transaction.commit();
		}catch(Exception ex) {
		    //error occured rollback
		    if (transaction != null) {
		        transaction.rollback();
		    }
		}
	}

	@Override
	public void removeObject(int id) {
		SessionFactory sessionFactory = VerifyLogin.getSessionFactory();
		LoginPosition o = null;
		Transaction transaction = null;

		try(Session currentSession = sessionFactory.getCurrentSession()) {
			
			transaction = currentSession.beginTransaction();
			o =currentSession.get(LoginPosition.class, id);
			currentSession.delete(o);
			transaction.commit();
		}catch(Exception ex) {
		    //error occured rollback
		    if (transaction != null) {
		        transaction.rollback();
		    }
		}
	}

	@Override
	public LoginPosition getObjectById(int id) {
		SessionFactory sessionFactory = VerifyLogin.getSessionFactory();
		LoginPosition o = null;
		Transaction transaction = null;

		try(Session currentSession = sessionFactory.getCurrentSession()) {
			
			transaction = currentSession.beginTransaction();
			o = currentSession.get(LoginPosition.class, id);
			transaction.commit();
		}finally {
			sessionFactory.close();
		}
		
		return o;
	}

	@Override
	public List<LoginPosition> getObjectList() {
		// get session
		SessionFactory sessionFactory = VerifyLogin.getSessionFactory();
		List<LoginPosition> o = null;
		Transaction transaction = null;
		try(Session currentSession = sessionFactory.getCurrentSession()){
			
			transaction = currentSession.beginTransaction();
			Query<LoginPosition> query = currentSession.createQuery("from LoginPosition", LoginPosition.class);
			o = query.getResultList();
			transaction.commit();
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
		    //error occured rollback
		    if (transaction != null) {
		        transaction.rollback();
		    }
		}
		return o;
	}
}
