package dbGUI;

import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dbIntegration.Tables;
import entity.Account;
import entity.Contract;
import entity.Delivery;
import entity.DeliveryProduct;
import entity.Employee;
import entity.Invoice;
import entity.InvoiceProduct;
import entity.Product;
import entity.ProductAviability;
import entity.SaleByDay;
import entity.Schedule;

public class TableDisplayer {
	private JTable myTable;
	private DatabaseGUI d;
	
	TableDisplayer(JTable myTable,DatabaseGUI d){
		this.myTable=myTable;
		this.d=d;
	}
	
	public void setNewArray(List<?> data,Tables table) {
		String [] typestemp = table.getTablesNames();
		
		String [] tables = new String[typestemp.length+1];
		tables[0]="id";
		
		for(int i=1;i<typestemp.length+1;i++) {
			tables[i]=typestemp[i-1];
		}

		String [][] dataS = ListToData(data, table, tables.length);
		myTable = new JTable(dataS,tables);
		myTable.setModel(new DefaultTableModel(dataS, tables));
		d.dataPanel.revalidate();
		d.dataPanel.repaint();
	}
	
	private String[][] ListToData(List<?> data, Tables table, int tablesLength){
		String [][] dataS = new String[data.size()][tablesLength];
		
		switch (table) {
		case Account:
			List <Account> a = (List<Account>) data;
			for(int i=0;i<a.size();i++) {
				dataS[i]=a.get(i).toStringArray();
			}
			break;
		case Contract:
			List<Contract> c = (List<Contract>) data;
			for(int i=0;i<c.size();i++) {
				dataS[i]=c.get(i).toStringArray();
			}
			break;
		case Delivery:
			List<Delivery> d = (List<Delivery>) data;
			for(int i=0;i<d.size();i++) {
				dataS[i]=d.get(i).toStringArray();
			}
			break;
		case DeliveryProducts:
			List<DeliveryProduct> dp = (List<DeliveryProduct>) data;
			for(int i=0;i<dp.size();i++) {
				dataS[i]=dp.get(i).toStringArray();
			}
			break;
		case Employee:
			List<Employee> e = (List<Employee>) data;
			for(int i=0;i<e.size();i++) {
				dataS[i]=e.get(i).toStringArray();
			}
			break;
		case Invoice:
			List<Invoice> in = (List<Invoice>) data;
			for(int i=0;i<in.size();i++) {
				dataS[i]=in.get(i).toStringArray();
			}
			break;
		case InvoiceProduct:
			List<InvoiceProduct> ip = (List<InvoiceProduct>) data;
			for(int i=0;i<ip.size();i++) {
				dataS[i]=ip.get(i).toStringArray();
			}
			break;
		case Product:
			List<Product> p = (List<Product>) data;
			for(int i=0;i<p.size();i++) {
				dataS[i]=p.get(i).toStringArray();
			}
			break;
		case ProductAviability:
			List<ProductAviability> pa = (List<ProductAviability>) data;
			for(int i=0;i<pa.size();i++) {
				dataS[i]=pa.get(i).toStringArray();
			}
			break;
		case SaleByDay:
			List<SaleByDay> sbd = (List<SaleByDay>) data;
			for(int i=0;i<sbd.size();i++) {
				dataS[i]=sbd.get(i).toStringArray();
			}
			break;
		case Schedule:
			List<Schedule> s = (List<Schedule>) data;
			for(int i=0;i<s.size();i++) {
				dataS[i]=s.get(i).toStringArray();
			}
			break;
		default:
			break;
		}
		return dataS;
	}
}
