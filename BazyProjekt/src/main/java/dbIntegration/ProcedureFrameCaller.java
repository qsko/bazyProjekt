package dbIntegration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Invoice;
import entity.Product;
import login.VerifyLogin;

public class ProcedureFrameCaller {
	public int callFUNCTION1(int productid, LocalDate date1, LocalDate date2) {
		SessionFactory sessionFactory = VerifyLogin.getSessionFactory();
		Transaction transaction = null;
		
		try(Session currentSession = sessionFactory.getCurrentSession()) {
			transaction = currentSession.beginTransaction();
			Query query = currentSession.createSQLQuery("CALL FUNCTION1(:var1,:var2,:var3)")
					.addEntity(Integer.class)
					.setParameter("var1", productid)
					.setParameter("var2", date1)
					.setParameter("var3",date2);
			List<Integer> results = query.getResultList();
			transaction.commit();
			return results.get(0);
		}
		catch(Exception ex) {
		    if (transaction != null) {
		        transaction.rollback();
		        return 0;
		    }
		}
		return 0;	
	}
	public int callFUNCTION2(int invoiceid) {
		SessionFactory sessionFactory = VerifyLogin.getSessionFactory();
		Transaction transaction = null;
		
		try(Session currentSession = sessionFactory.getCurrentSession()) {
			transaction = currentSession.beginTransaction();
			Query query = currentSession.createSQLQuery("CALL FUNCTION2(:var1)")
					.addEntity(Integer.class)
					.setParameter("var1", invoiceid);
			List<Integer> results = query.getResultList();
			transaction.commit();
			return results.get(0);
		}
		catch(Exception ex) {
		    if (transaction != null) {
		        transaction.rollback();
		        return 0;
		    }
		}
		return 0;
	}
	public List<Product> callFUNCTION3(int invoiceid) {
		SessionFactory sessionFactory = VerifyLogin.getSessionFactory();
		Transaction transaction = null;
		
		try(Session currentSession = sessionFactory.getCurrentSession()) {
			transaction = currentSession.beginTransaction();
			
			Query query = currentSession.createSQLQuery("CALL FUNCTION3(:var1)")
					.addEntity(Product.class)
					.setParameter("var1", invoiceid);
			List<Product> results = query.getResultList();
			transaction.commit();
			return results;
		}
		catch(Exception ex) {
		    if (transaction != null) {
		        transaction.rollback();
		        return null;
		    }
		}
		return null;
	}

	public List<Invoice> callFUNCTION4(int nip) {
		SessionFactory sessionFactory = VerifyLogin.getSessionFactory();
		Transaction transaction = null;
		
		try(Session currentSession = sessionFactory.getCurrentSession()) {
			transaction = currentSession.beginTransaction();
			
			Query query = currentSession.createSQLQuery("CALL FUNCTION4(:var1)")
					.addEntity(Invoice.class)
					.setParameter("var1", nip);
			List<Invoice> results = query.getResultList();
			transaction.commit();
			return results;
		}
		catch(Exception ex) {
		    if (transaction != null) {
		        transaction.rollback();
		        return null;
		    }
		}
		return null;
	}
	
	public static int callFUNCTION5() {
		SessionFactory sessionFactory = VerifyLogin.getSessionFactory();
		Transaction transaction = null;
		
		try(Session currentSession = sessionFactory.getCurrentSession()) {
			transaction = currentSession.beginTransaction();
			
			Query query = currentSession.createSQLQuery("CALL FUNCTION5()")
					.addEntity(Integer.class);
			List<Integer> results = query.getResultList();
			transaction.commit();
			return results.get(0);
		}
		catch(Exception ex) {
		    if (transaction != null) {
		        transaction.rollback();
		        return 0;
		    }
		}
		return 0;
	}
}
