package dbIntegration;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;

import dbGUI.DatabaseGUI;
import entity.Account;
import entity.Contract;
import entity.Delivery;
import entity.DeliveryProduct;
import entity.Employee;
import entity.Invoice;
import entity.InvoiceProduct;
import entity.LoginPosition;
import entity.Product;
import entity.ProductAviability;
import entity.SaleByDay;
import entity.Schedule;
import enums.Position;

public class ProcessAddOperation {
	DatabaseGUI masterFrame;
	
	public ProcessAddOperation (DatabaseGUI masterFrame,String[] vars){
		this.masterFrame=masterFrame;
		addNewObject(vars);
	}
	
	public void addNewObject(String[] vars){
		switch (masterFrame.getCurrentTable()) {
		case Account:
			addAccount(vars);
			break;
		case Contract:
			addContract(vars);
			break;
		case Delivery:
			addDelivery(vars);
			break;
		case DeliveryProducts:
			addDeliveryProduct(vars);
			break;
		case Employee:
			addEmployee(vars);
			break;
		case Invoice:
			addInvoice(vars);
			break;
		case InvoiceProduct:
			addInvoiceProduct(vars);
			break;
		case Product:
			addProduct(vars);
			break;
		case ProductAviability:
			addProductAviability(vars);
			break;
		case SaleByDay:
			addSaleByDay(vars);
			break;
		case Schedule:
			addSchedule(vars);
			break;
		case LoginPosition:
			addLoginPosition(vars);
		default:
			break;
		};
	}
	
	private void addLoginPosition(String[] vars) {
		Position p = null;
		try {
			p = (Position) EntityTypes.Position.fromString(vars[1]);
		}
		catch (Exception e) {
			masterFrame.sendErrorMessage("Error when adding object: No such position.");
			return;
		}
		
		LoginPosition lp = new LoginPosition(vars[0],p);
		Tables.LoginPosition.getDAO().addObject(lp);
		masterFrame.sendMessage("Added new LoginPosition.");
		displayTable();
	}

	public void addAccount(String[] vars) {
		int eid=0;
		try {
			eid = Integer.parseInt(vars[0]);
		}
		catch (NumberFormatException e) {
			masterFrame.sendErrorMessage("Error when adding object: Wrong Employee ID");
			return;
		}
		
		Employee oE = (Employee) Tables.Employee.getDAO().getObjectById(eid);
		
		if (oE!=null) {
			String hashtext;
			
			try {
				MessageDigest md = MessageDigest.getInstance("MD5");
				byte[] messageDigest = md.digest(vars[2].getBytes()); 
	            BigInteger no = new BigInteger(1, messageDigest); 
	            hashtext = no.toString(16); 
	            while (hashtext.length() < 32) { 
	                hashtext = "0" + hashtext; 
	            }
			} catch (NoSuchAlgorithmException ne) {
				masterFrame.sendErrorMessage("Critical Error.");
				return;
			}
			
			Account nA = new Account(vars[1], hashtext);
			nA.setEmployee(oE);
			Tables.Account.getDAO().addObject(nA);
			masterFrame.sendMessage("Added new Account.");
			displayTable();
		}
		else {
			masterFrame.sendErrorMessage("Error when adding object: No such Employee");
		}
	}
	
	public void addContract(String[] vars) {
		LocalDate ld1 = LocalDate.parse(vars[1]);
		
		LocalDate ld2 = LocalDate.parse(vars[2]);
		
		enums.ContractType ect = null;
		for (enums.ContractType e: enums.ContractType.values()) {
			if (e.name().equals(vars[3])) {
				ect=e;
				break;
			}
		}
		if (ect==null) {
			masterFrame.sendErrorMessage("Error when adding object: Wrong Contract type");
			return;
		}
		
		int salary;
		int e_id;
		try {
			salary=Integer.parseInt(vars[4]);
			e_id=Integer.parseInt(vars[0]);
		}
		catch (NumberFormatException e) {
			masterFrame.sendErrorMessage("Error when adding object: Integer format");
			return;
		}
		
		Employee oE = (Employee) Tables.Employee.getDAO().getObjectById(e_id);
		if (oE == null) {
			masterFrame.sendErrorMessage("Error when adding object: No such Employee");
			return;
		}
		
		enums.Position ep = null;
		for(enums.Position e: enums.Position.values()) {
			if (e.name().equals(vars[5])) {
				ep=e;
				break;
			}
		}
		if (ep==null) {
			masterFrame.sendErrorMessage("Error when adding object: Wrong Position name");
			return;
		}
		
		Contract nC = new Contract(ld1,ld2,ect,salary,ep);
		nC.setEmployee(oE);		
		Tables.Contract.getDAO().addObject(nC);
		masterFrame.sendMessage("Added new Contract.");
		displayTable();
	}
	
	public void addDelivery(String[] vars) {
		LocalDateTime dtime;
		try {
			dtime = LocalDateTime.parse(vars[0]);
		}
		catch (DateTimeParseException e) {
			masterFrame.sendErrorMessage("Error when adding object: Wrong date format");
			return;
		}
		
		enums.Status es = null;
		for (enums.Status e: enums.Status.values()) {
			if (e.name().equals(vars[1])) {
				es = e;
				break;
			}
		}
		
		if (es==null) {
			masterFrame.sendErrorMessage("Error when adding object: No such status");
			return;
		}
		
		Delivery nD = new Delivery(dtime, es, vars[2]);
		Tables.Delivery.getDAO().addObject(nD);
		masterFrame.sendMessage("Added new Delivery.");
		displayTable();
	}
	
	public void addDeliveryProduct(String[] vars) {
		int d_id;
		int p_id;
		int n;
		
		try {
			d_id = Integer.parseInt(vars[0]);
			p_id = Integer.parseInt(vars[1]);
			n = Integer.parseInt(vars[2]);
		}
		catch (NumberFormatException e) {
			masterFrame.sendErrorMessage("Error when adding object: Wrong Integer format.");
			return;
		}
		
		Delivery oD = (Delivery) Tables.Delivery.getDAO().getObjectById(d_id);
		Product oP = (Product) Tables.Product.getDAO().getObjectById(p_id);
		
		if (oD != null && oP != null) {
			DeliveryProduct nDP = new DeliveryProduct(n);
			nDP.setDelivery(oD);
			nDP.setProduct(oP);
			Tables.DeliveryProducts.getDAO().addObject(nDP);
			masterFrame.sendMessage("Added new DeliveryProduct.");
			displayTable();
		}
		else {
			masterFrame.sendErrorMessage("Error when adding object: No such Delivery or Product.");
		}
	}

	public void addEmployee(String[] vars) {
		Employee nE = new Employee(vars[0], vars[1]);
		Tables.Employee.getDAO().addObject(nE);
	}

	public void addInvoice(String[] vars) {
		int nip;
		try {
			nip = Integer.parseInt(vars[0]);
		}
		catch (NumberFormatException e) {
			masterFrame.sendErrorMessage("Error when adding object: NIP not valid");
			return;
		}
		
		enums.InvoiceType it = null;
		for (enums.InvoiceType e: enums.InvoiceType.values()) {
			if (vars[1].equals(e.name())) {
				it = e;
			}
		}

		if (it!=null && nip!=0) {
			Invoice nI = new Invoice(nip,it);
			Tables.Invoice.getDAO().addObject(nI);
			masterFrame.sendMessage("Added new Invoice.");
			displayTable();
		}
		else {
			masterFrame.sendErrorMessage("Error when adding object: No such Invoice type.");
		}
	}

	public void addInvoiceProduct(String[] vars) {
		int i_id;
		int p_id;
		int n;
		
		try {
			i_id = Integer.parseInt(vars[0]);
			p_id = Integer.parseInt(vars[1]);
			n = Integer.parseInt(vars[2]);
		}
		catch (NumberFormatException e) {
			masterFrame.sendErrorMessage("Error when adding object: Wrong Integer format");
			return;
		}
		
		Invoice oI = (Invoice) Tables.Invoice.getDAO().getObjectById(i_id);
		if (oI == null) {
			masterFrame.sendErrorMessage("Error when adding object: No such invoice");
			return;
		}
		
		Product oP = (Product) Tables.Product.getDAO().getObjectById(p_id);
		if (oP == null) {
			masterFrame.sendErrorMessage("Error when adding object: No such product");
			return;
		}

		InvoiceProduct nIP = new InvoiceProduct(n);
		nIP.setInvoice(oI);
		nIP.setProduct(oP);
		
		Tables.InvoiceProduct.getDAO().addObject(nIP);
		masterFrame.sendMessage("Added new InvoiceProduct.");
		displayTable();
	}

	public void addProduct(String[] vars) {
		int weight;
		int price;
		
		try {
			weight=Integer.parseInt(vars[1]);
			price=Integer.parseInt(vars[2]);
		}
		catch (NumberFormatException e) {
			masterFrame.sendErrorMessage("Error when adding object: Wrong weight/price");
			return;
		}
		
		enums.PriceType ept = null;
		for(enums.PriceType e: enums.PriceType.values()) {
			if (e.name().equals(vars[3])){
				ept=e;
				break;
			}
		}
		enums.Is_18 eie = null;
		for(enums.Is_18 e: enums.Is_18.values()) {
			if (e.name().equals(vars[4])) {
				eie=e;
				break;
			}
		}
		
		if (weight != 0 && price != 0 && ept != null && eie != null) {
			Product nP = new Product(vars[0],weight,price,ept,eie);
			Tables.Product.getDAO().addObject(nP);
			masterFrame.sendMessage("Added new Product.");
			displayTable();
		}
		else
			masterFrame.sendErrorMessage("Error when adding object: Non-existent priceType/is_18");	
	}

	public void addProductAviability(String[] vars) {
		int prod;
		int s;
		int w;
		
		try {
			prod = Integer.parseInt(vars[0]);
			s = Integer.parseInt(vars[1]);
			w = Integer.parseInt(vars[2]);
		}
		catch  (NumberFormatException e) {
			masterFrame.sendErrorMessage("Error when adding object: non-Integers");
			return;
		}

		Product oP = (Product) Tables.Product.getDAO().getObjectById(prod);
		
		if (oP != null) {
			ProductAviability nPA = new ProductAviability(oP,s,w);
			Tables.ProductAviability.getDAO().addObject(nPA);
			masterFrame.sendMessage("Added new ProductAviability.");
			displayTable();
		}
		else
			masterFrame.sendErrorMessage("Error when adding object: No such Product");
	}

	public void addSaleByDay(String[] vars) {
		int n;
		try {
			n = Integer.parseInt(vars[0]);
		}
		catch (NumberFormatException e) {
			masterFrame.sendErrorMessage("Error when adding object: Wrong amount");
			return;
		}

		SaleByDay nS = new SaleByDay(n);

		Tables.SaleByDay.getDAO().addObject(nS);
		displayTable();
	}

	public void addSchedule(String[] vars) {
		Employee oE = null;
		try {
			int n = Integer.parseInt(vars[0]);
			oE = (Employee) Tables.Employee.getDAO().getObjectById(n);
			if (oE==null) {
				masterFrame.sendErrorMessage("Error when adding object: No such employee");
				return;
			}
		}
		catch (NumberFormatException e) {
			masterFrame.sendErrorMessage("Error when adding object: Wrong Integer format");
			return;
		}
		LocalDateTime stime1;
		LocalDateTime stime2;
		try {
			stime1 = LocalDateTime.parse(vars[1]);
			stime2 = LocalDateTime.parse(vars[2]);
		}
		catch (DateTimeParseException e) {
			masterFrame.sendErrorMessage("Error when adding object: Wrong date format");
			return;
		}
		
		Schedule nS = new Schedule(stime1, stime2);
		nS.setEmployee_id(oE);
		Tables.Schedule.getDAO().addObject(nS);
		displayTable();
	}
	
	public void displayTable() {
		masterFrame.setNewTable(masterFrame.getCurrentTable().getDAO().getObjectList());
	}
}
