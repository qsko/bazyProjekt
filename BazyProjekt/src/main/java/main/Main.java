package main;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import DAO.*;
import entity.*;
import enums.*;
import util.HibernateUtil;


public class Main {
	
	
	
	public static void main(String[] args) {
		
	 	Employee employee = new Employee();
	 	employee.setName("nowy3");
	 	employee.setSurname("pracownik");
	 	EmployeeDAO employeeDao= new EmployeeDAO();
	 	employeeDao.addObject(employee);
	 	
	 	Employee employee2 = new Employee();
	 	employee2.setName("nowy2");
	 	employee2.setSurname("pracownik2");	 	
	 	employeeDao.addObject(employee2);
		
		Account account = new Account();
		account.setLogin("nowypracownik2");
		account.setPassword("aaa2");
		account.setEmployee(employee2);
		AccountDAO accountDao = new AccountDAO();
		accountDao.addObject(account);
		
 		ProductDAO productDao = new ProductDAO();
 		Product product = new Product("jablko2",1,1,PriceType.unit, Is_18.no);
 		
 		productDao.addObject(product);
 		
 		Delivery delivery = new Delivery(LocalDateTime.now(),Status.realised,"aaa");
 		DeliveryDAO deliveryDao = new DeliveryDAO();
 		deliveryDao.addObject(delivery);
 		
 		DeliveryProduct deliveryProduct = new DeliveryProduct(1);
 		deliveryProduct.setProduct(product);
 		deliveryProduct.setDelivery(delivery);
 		DeliveryProductsDAO  dpdao = new DeliveryProductsDAO();
		dpdao.addObject(deliveryProduct);
		
		
		
		
		
//		
//	 	Employee employee = new Employee();
//	 	employee.setName("nowy");
//	 	employee.setSurname("pracownik");
//	 	EmployeeDAO employeeDao= new EmployeeDAO();
//	 	employeeDao.addEmployee(employee);
//	 	
//		Account account = new Account();
//		account.setLogin("nowypracownik");
//		account.setPassword("aaa");
//		account.setEmployeeId(employee);
//		AccountDAO accountDao = new AccountDAO();
//		accountDao.addAccount(account);
//	
//		System.out.print(accountDao.getAccountById(1));
		
		
			
//		 	Employee employee = new Employee();
//		 	employee.setName("nowy");
//		 	employee.setSurname("pracownik");
//		 	EmployeeDAO employeeDao= new EmployeeDAO();
//		 	employeeDao.addEmployee(employee);
//		 	
//		 	
//		 	Employee employee2 = new Employee();
//		 	employee2.setName("nowy2");
//		 	employee2.setSurname("pracownik2");
//		 	employeeDao.addEmployee(employee2);
//	 	
//
//		 
//			Schedule schedule = new Schedule();
//			schedule.setBeginning(LocalDateTime.now());
//			schedule.setEnding(LocalDateTime.now());
//			schedule.setEmployee_id(employee);
//			
//			Schedule schedule2 = new Schedule();
//			schedule2.setBeginning(LocalDateTime.now());
//			schedule2.setEnding(LocalDateTime.now());
//			schedule2.setEmployee_id(employee2);
//	
//			Schedule schedule3 = new Schedule();
//			schedule3.setBeginning(LocalDateTime.now());
//			schedule3.setEnding(LocalDateTime.now());
//			schedule3.setEmployee_id(employee);
//
//			ScheduleDAO scheduleDao = new ScheduleDAO();
//			scheduleDao.addSchedule(schedule);
//			scheduleDao.addSchedule(schedule2);
//			scheduleDao.addSchedule(schedule3);
			
			
		 
//
//		 	employeeDao.addEmployee(employee);
		 	
		 	
		 	
		 	
//			Employee employee = employeeDao.getEmployeeById(1);
//			Schedule schedule = new Schedule();
//			schedule.setBeginning(LocalDateTime.now());
//			schedule.setEnding(LocalDateTime.now());
//			schedule.setEmployee_id(employee);
//		 	
//			ScheduleDAO scheduleDao = new ScheduleDAO();
//			scheduleDao.addSchedule(schedule);
//			HibernateUtil.getSessionFactory().getCurrentSession();
//			System.out.print(employee.getSchedules());
//			HibernateUtil.getSessionFactory().close();
			
			
			
			
//	 		ProductDAO productDao = new ProductDAO();
//	 		Product product = new Product("jablko2",1,1,PriceType.unit, Is_18.no);
//	 		
//	 		productDao.addProduct(product);
//	 		ProductAviability productA= new ProductAviability();
//	 		productA.setProdId(product);
//	 		productA.setShop_amount(1);
//	 		productA.setWarehouse_amount(1);
//	 		ProductAviabilityDAO dao = new  ProductAviabilityDAO();
//	 		dao.addProductAviability(productA);
//	 		
	 		
	 		
//	 		Employee employee = new Employee();
//	 		employee.setName("d");
//	 		employee.setSurname("x");
//	 		
//	 		EmployeeDAO employeeDao = new EmployeeDAO();
// 		 employeeDao.addEmployee(employee);
//	 		
//	 		Contract contract = new Contract();
//	 		contract.setBeginning(LocalDate.now());
//	 		contract.setEnding(LocalDate.now());
//	 		contract.setPosition(Position.admin);
//	 		contract.setSalary(100);
//	 		contract.setType(ContractType.employment_contract);
//	 		contract.setWorker_id(employee);
//	 		
//	 		ContractDAO contractDao = new ContractDAO();
//	 		contractDao.addContract(contract);
	 		
	 		 
	   }
}
