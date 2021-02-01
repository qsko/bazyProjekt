package dbIntegration;

import java.awt.font.MultipleMaster;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.jdbc.Work;

import entity.Invoice;
import entity.Product;
import login.VerifyLogin;

public class ProcedureFrameCaller {
	public static int callFUNCTION1(int productid, LocalDate date1, LocalDate date2) {
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
	public static int callFUNCTION2(int invoiceid) {
		SessionFactory sessionFactory = VerifyLogin.getSessionFactory();
		Transaction transaction = null;
		
		try(Session currentSession = sessionFactory.getCurrentSession()) {
			transaction = currentSession.beginTransaction();
			Query query = currentSession.getNamedNativeQuery("callInvoiceValue");
			query.setParameter(1, invoiceid);
			List<Integer> res = query.getResultList();
			if (res.get(0)==null) { 
				return 0;
			}
			transaction.commit();
			return res.get(0);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		    if (transaction != null) {
		        transaction.rollback();
		        return 0;
		    }
		}
		return 0;
	}
	public static List<Product> callFUNCTION3(int invoiceid) {
		SessionFactory sessionFactory = VerifyLogin.getSessionFactory();
		Transaction transaction = null;
		
		try(Session currentSession = sessionFactory.getCurrentSession()) {
			transaction = currentSession.beginTransaction();
			Query query = currentSession.getNamedNativeQuery("callSelectItemsFromInvoice");
			query.setParameter(1, invoiceid);
			List<?> res = query.getResultList();
			if (res==null) { 
				return null;
			}
			List<Product> ress = (List<Product>) res;
			transaction.commit();
			return ress;
		}
		catch(Exception ex) {
		    if (transaction != null) {
		        transaction.rollback();
		        return null;
		    }
		}
		return null;
	}

	public static List<Invoice> callFUNCTION4(int nip) {
		SessionFactory sessionFactory = VerifyLogin.getSessionFactory();
		Transaction transaction = null;
		
		try(Session currentSession = sessionFactory.getCurrentSession()) {
			transaction = currentSession.beginTransaction();
			
			Query query = currentSession.createSQLQuery("callSelectInvoicesByNIP")
					.setParameter("var1", nip);
			List<?> results = query.getResultList();
			transaction.commit();
			return (List<Invoice>) results;
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
			Query query = currentSession.getNamedNativeQuery("callPayInMonth");
			List<Integer> res = query.getResultList();
			if (res.get(0)==null) { 
				return 0;
			}
			transaction.commit();
			return res.get(0);
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
