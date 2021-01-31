package dbGUI;

import java.lang.reflect.Field;

import org.hibernate.cfg.beanvalidation.HibernateTraversableResolver;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.type.Type;

import dbIntegration.EntityTypes;
import dbIntegration.Tables;
import entity.Account;
import util.HibernateUtil;

public class T {
	public static void main(String args[]) {
		//new LoginFrame();
		new DatabaseGUI("");
		
		/*
		ClassMetadata cm = HibernateUtil.getSessionFactory().getClassMetadata(Tables.Delivery.getTableClass());
		String[] names = cm.getPropertyNames();
		Type[] names2 = cm.getPropertyTypes();
		for (String n:names) {
			System.out.println(n);
		}
		for (Type t:names2) {
			System.out.println(t.getName());
		}*/
		
		EntityTypes[] et = Tables.Account.getTablesTypes();
		for(EntityTypes e: et) {
			System.out.println(e.name());
		}
	}
}