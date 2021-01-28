package dbGUI;

import java.lang.reflect.Field;

import org.hibernate.cfg.beanvalidation.HibernateTraversableResolver;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.type.Type;

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
		
		java.lang.reflect.Field[] f = entity.Account.class.getDeclaredFields();
		for (Field g: f) {
			System.out.println(g.toString());
		}
	}
}