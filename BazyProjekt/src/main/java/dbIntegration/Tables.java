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
	};
	
	public abstract interfaceDAO getDAO();
	public abstract Class<?> getTableClass();
}