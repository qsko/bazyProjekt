package dbIntegration;

import java.time.LocalDate;
import java.time.LocalDateTime;

public enum EntityTypes {
	Integer {
		@Override
		public Object fromString(java.lang.String s) throws Exception {
			try {
				return java.lang.Integer.parseInt(s);
			}
			catch (Exception e) {
				throw new Exception("Wrong Integer format");
			}
		}
	},
	String {
		@Override
		public Object fromString(java.lang.String s) throws Exception {
			return s;
		}
	},
	Date {
		@Override
		public Object fromString(java.lang.String s) throws Exception {
			try {
				return LocalDate.parse(s);
			}
			catch (Exception e) {
				throw new Exception ("Wrong Date format");
			}
		}
	},
	DateTime {
		@Override
		public Object fromString(java.lang.String s) throws Exception {
			try {
				return LocalDateTime.parse(s);
			}
			catch (Exception e) {
				throw new Exception("Wrong DateTime format");
			}
		}
	},
	ContractType {
		@Override
		public Object fromString(java.lang.String s) throws Exception {
			for(enums.ContractType c : enums.ContractType.values()) {
				if (c.name().equals(s)) {
					return c;
				}
			}
			throw new Exception("No such ContractType");
		}
	},
	InvoiceType {
		@Override
		public Object fromString(java.lang.String s) throws Exception {
			for(enums.InvoiceType c : enums.InvoiceType.values()) {
				if (c.name().equals(s)) {
					return c;
				}
			}
			throw new Exception("No such InvoiceType");
		}
	},
	Is_18 {
		@Override
		public Object fromString(java.lang.String s) throws Exception {
			for(enums.Is_18 c : enums.Is_18.values()) {
				if (c.name().equals(s)) {
					return c;
				}
			}
			throw new Exception("No such Is_18");
		}
	},
	Position {
		@Override
		public Object fromString(java.lang.String s) throws Exception {
			for(enums.Position c : enums.Position.values()) {
				if (c.name().equals(s)) {
					return c;
				}
			}
			throw new Exception("No such Position");
		}
	},
	PriceType {
		@Override
		public Object fromString(java.lang.String s) throws Exception {
			for(enums.PriceType c : enums.PriceType.values()) {
				if (c.name().equals(s)) {
					return c;
				}
			}
			throw new Exception("No such PriceType");
		}
	},
	Status {
		@Override
		public Object fromString(java.lang.String s) throws Exception {
			for(enums.Status c : enums.Status.values()) {
				if (c.name().equals(s)) {
					return c;
				}
			}
			throw new Exception("No such Status");
		}
	};
	
	public abstract Object fromString(String s) throws Exception;
}
