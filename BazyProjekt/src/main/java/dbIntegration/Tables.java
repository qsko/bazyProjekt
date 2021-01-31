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
		public String getExactTableName() {
			return "Accounts";
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
		@Override
		public EntityTypes[] getTablesTypes() {
			EntityTypes[] types = new EntityTypes[3];
			int i=0;
			types[i++]=EntityTypes.Integer;
			types[i++]=EntityTypes.String;
			types[i++]=EntityTypes.String;
			return types;
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
		public String getExactTableName() {
			return "Contracts";
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
		@Override
		public EntityTypes[] getTablesTypes() {
			EntityTypes[] types = new EntityTypes[6];
			int i=0;
			types[i++]=EntityTypes.Integer;
			types[i++]=EntityTypes.Date;
			types[i++]=EntityTypes.Date;
			types[i++]=EntityTypes.ContractType;
			types[i++]=EntityTypes.Integer;
			types[i++]=EntityTypes.Position;
			return types;
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
		public String getExactTableName() {
			return "Deliveries";
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
		@Override
		public EntityTypes[] getTablesTypes() {
			EntityTypes[] types = new EntityTypes[3];
			int i=0;
			types[i++]=EntityTypes.DateTime;
			types[i++]=EntityTypes.Status;
			types[i++]=EntityTypes.String;
			return types;
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
		public String getExactTableName() {
			return "Delivery_Products";
		}
		@Override
		public String[] getTablesNames() {
			String[] names = new String [3];
			int i=0;
			names[i++]="delivery_id";
			names[i++]="product_id";
			names[i++]="amount";
			return names;
		}
		@Override
		public EntityTypes[] getTablesTypes() {
			EntityTypes[] types = new EntityTypes[3];
			int i=0;
			types[i++]=EntityTypes.Integer;
			types[i++]=EntityTypes.Integer;
			types[i++]=EntityTypes.Integer;
			return types;
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
		public String getExactTableName() {
			return "Employees";
		}
		@Override
		public String[] getTablesNames() {
			String[] names = new String [2];
			int i=0;
			names[i++]="name";
			names[i++]="surname";
			return names;
		}
		@Override
		public EntityTypes[] getTablesTypes() {
			EntityTypes[] types = new EntityTypes[2];
			int i=0;
			types[i++]=EntityTypes.String;
			types[i++]=EntityTypes.String;
			return types;
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
		public String getExactTableName() {
			return "Invoices";
		}
		@Override
		public String[] getTablesNames() {
			String[] names = new String [2];
			int i=0;
			names[i++]="nip";
			names[i++]="type";
			return names;
		}
		@Override
		public EntityTypes[] getTablesTypes() {
			EntityTypes[] types = new EntityTypes[2];
			int i=0;
			types[i++]=EntityTypes.Integer;
			types[i++]=EntityTypes.InvoiceType;
			return types;
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
		public String getExactTableName() {
			return "Invoice_Products";
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
		@Override
		public EntityTypes[] getTablesTypes() {
			EntityTypes[] types = new EntityTypes[3];
			int i=0;
			types[i++]=EntityTypes.Integer;
			types[i++]=EntityTypes.Integer;
			types[i++]=EntityTypes.Integer;
			return types;
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
		public String getExactTableName() {
			return "Products";
		}
		@Override
		public String[] getTablesNames() {
			String[] names = new String [5];
			int i=0;
			names[i++]="name";
			names[i++]="weight";
			names[i++]="price";
			names[i++]="price_type";
			names[i++]="is_18";
			return names;
		}
		@Override
		public EntityTypes[] getTablesTypes() {
			EntityTypes[] types = new EntityTypes[5];
			int i=0;
			types[i++]=EntityTypes.String;
			types[i++]=EntityTypes.Integer;
			types[i++]=EntityTypes.Integer;
			types[i++]=EntityTypes.PriceType;
			types[i++]=EntityTypes.Is_18;
			return types;
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
		public String getExactTableName() {
			return "Products_Aviability";
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
		@Override
		public EntityTypes[] getTablesTypes() {
			EntityTypes[] types = new EntityTypes[3];
			int i=0;
			types[i++]=EntityTypes.Integer;
			types[i++]=EntityTypes.Integer;
			types[i++]=EntityTypes.Integer;
			return types;
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
		public String getExactTableName() {
			return "Sales_by_day";
		}
		@Override
		public String[] getTablesNames() {
			String[] names = new String [1];
			int i=0;
			names[i++]="amount";
			return names;
		}
		@Override
		public EntityTypes[] getTablesTypes() {
			EntityTypes[] types = new EntityTypes[1];
			int i=0;
			types[i++]=EntityTypes.Integer;
			return types;
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
		public String getExactTableName() {
			return "Schedule";
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
		@Override
		public EntityTypes[] getTablesTypes() {
			EntityTypes[] types = new EntityTypes[3];
			int i=0;
			types[i++]=EntityTypes.Integer;
			types[i++]=EntityTypes.DateTime;
			types[i++]=EntityTypes.DateTime;
			return types;
		}
	};
	
	public abstract interfaceDAO getDAO();
	public abstract Class<?> getTableClass();
	public abstract String[] getTablesNames();
	public abstract String getExactTableName();
	public abstract EntityTypes [] getTablesTypes();
}