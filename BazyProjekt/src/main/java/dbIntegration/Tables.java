package dbIntegration;

import DAO.*;

public enum Tables {
	Account {
		@Override
		interfaceDAO getDAO() {
			return new AccountDAO();
		}
	},
	Contract {
		@Override
		interfaceDAO getDAO() {
			return new ContractDAO();
		}
	},
	Delivery {
		@Override
		interfaceDAO getDAO() {
			return new DeliveryDAO();
		}
	},
	DeliveryProduct {
		@Override
		interfaceDAO getDAO() {
			return new DeliveryProductsDAO();
		}
	},
	Employee {
		@Override
		interfaceDAO getDAO() {
			return new EmployeeDAO();
		}
	},
	Invoice {
		@Override
		interfaceDAO getDAO() {
			return new InvoiceDAO();
		}
	},
	InvoiceProduct {
		@Override
		interfaceDAO getDAO() {
			return new InvoiceProductDAO();
		}
	},
	Product {
		@Override
		interfaceDAO getDAO() {
			return new ProductDAO();
		}
	},
	ProductAviability {
		@Override
		interfaceDAO getDAO() {
			return new ProductAviabilityDAO();
		}
	},
	SaleByDay {
		@Override
		interfaceDAO getDAO() {
			return new SaleByDayDAO();
		}
	},
	Schedule {
		@Override
		interfaceDAO getDAO() {
			return new ScheduleDAO();
		}
	};
	
	abstract interfaceDAO getDAO();
}
