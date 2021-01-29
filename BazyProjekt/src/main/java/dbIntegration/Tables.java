package dbIntegration;

import DAO.*;

public enum Tables {
	Account {
		@Override
		public interfaceDAO getDAO() {
			return new AccountDAO();
		}
		@Override
		public Class<?> getTableClass() {
			return entity.Account.class;
		}
		@Override
		public String[] getTablesNames() {
			String[] names = new String [3];
			int i=0;
			names[i++]="employee_id";
			names[i++]="login";
			names[i++]="password";
			return names;
		}
	},
	Contract {
		@Override
		public interfaceDAO getDAO() {
			return new ContractDAO();
		}
		@Override
		public Class<?> getTableClass() {
			return entity.Contract.class;
		}
		@Override
		public String[] getTablesNames() {
			String[] names = new String [6];
			int i=0;
			names[i++]="employee_id";
			names[i++]="beginning";
			names[i++]="ending";
			names[i++]="type";
			names[i++]="salary";
			names[i++]="position";
			return names;
		}
	},
	Delivery {
		@Override
		public interfaceDAO getDAO() {
			return new DeliveryDAO();
		}
		@Override
		public Class<?> getTableClass() {
			return entity.Delivery.class;
		}
		@Override
		public String[] getTablesNames() {
			String[] names = new String [3];
			int i=0;
			names[i++]="plannedDate";
			names[i++]="status";
			names[i++]="supplier";
			return names;
		}
	},
	DeliveryProducts {
		@Override
		public interfaceDAO getDAO() {
			return new DeliveryProductsDAO();
		}
		@Override
		public Class<?> getTableClass() {
			return entity.DeliveryProduct.class;
		}
		@Override
		public String[] getTablesNames() {
			String[] names = new String [2];
			int i=0;
			names[i++]="delivery_id";
			names[i++]="product_id";
			names[i++]="amount";
			return names;
		}
	},
	Employee {
		@Override
		public interfaceDAO getDAO() {
			return new EmployeeDAO();
		}
		@Override
		public Class<?> getTableClass() {
			return entity.Employee.class;
		}
		@Override
		public String[] getTablesNames() {
			String[] names = new String [2];
			int i=0;
			names[i++]="name";
			names[i++]="surname";
			return names;
		}
	},
	Invoice {
		@Override
		public interfaceDAO getDAO() {
			return new InvoiceDAO();
		}
		@Override
		public Class<?> getTableClass() {
			return entity.Invoice.class;
		}
		@Override
		public String[] getTablesNames() {
			String[] names = new String [2];
			int i=0;
			names[i++]="nip";
			names[i++]="type";
			return names;
		}
	},
	InvoiceProduct {
		@Override
		public interfaceDAO getDAO() {
			return new InvoiceProductDAO();
		}
		@Override
		public Class<?> getTableClass() {
			return entity.InvoiceProduct.class;
		}
		@Override
		public String[] getTablesNames() {
			String[] names = new String [3];
			int i=0;
			names[i++]="invoice_id";
			names[i++]="product_id";
			names[i++]="amount";
			return names;
		}
	},
	Product {
		@Override
		public interfaceDAO getDAO() {
			return new ProductDAO();
		}
		@Override
		public Class<?> getTableClass() {
			return entity.Product.class;
		}
		@Override
		public String[] getTablesNames() {
			String[] names = new String [5];
			int i=0;
			names[i++]="name";
			names[i++]="weight";
			names[i++]="price";
			names[i++]="price_type";
			names[i++]="is_18+";
			return names;
		}
	},
	ProductAviability {
		@Override
		public interfaceDAO getDAO() {
			return new ProductAviabilityDAO();
		}
		@Override
		public Class<?> getTableClass() {
			return entity.ProductAviability.class;
		}
		@Override
		public String[] getTablesNames() {
			String[] names = new String [3];
			int i=0;
			names[i++]="product_id";
			names[i++]="shopAmount";
			names[i++]="warehouseAmount";
			return names;
		}
	},
	SaleByDay {
		@Override
		public interfaceDAO getDAO() {
			return new SaleByDayDAO();
		}
		@Override
		public Class<?> getTableClass() {
			return entity.SaleByDay.class;
		}
		@Override
		public String[] getTablesNames() {
			String[] names = new String [1];
			int i=0;
			names[i++]="amount";
			return names;
		}
	},
	Schedule {
		@Override
		public interfaceDAO getDAO() {
			return new ScheduleDAO();
		}
		@Override
		public Class<?> getTableClass() {
			return entity.Schedule.class;
		}
		@Override
		public String[] getTablesNames() {
			String[] names = new String [3];
			int i=0;
			names[i++]="employee_id";
			names[i++]="beginning";
			names[i++]="ending";
			return names;
		}
	};
	
	public abstract interfaceDAO getDAO();
	public abstract Class<?> getTableClass();
	public abstract String[] getTablesNames();
}