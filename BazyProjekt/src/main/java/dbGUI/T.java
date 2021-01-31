package dbGUI;

import java.lang.reflect.Field;

import org.hibernate.cfg.beanvalidation.HibernateTraversableResolver;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.type.Type;

import dbIntegration.EntityTypes;
import dbIntegration.Tables;
import entity.Account;
import loginGUI.LoginFrame;
import util.HibernateUtil;

public class T {
	public static void main(String args[]) {
		new LoginFrame();
		//new DatabaseGUI("");
		
	
	}
}