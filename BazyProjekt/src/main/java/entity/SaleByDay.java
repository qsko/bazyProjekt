package entity;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "Sales_by_day")
public class SaleByDay {

	
	@Id
	@Column(name ="date")
	private LocalDate date;
	
	@Column(name = "amount")
	private int amount;

	public SaleByDay() {
		super();
	}

	public SaleByDay(int amount) {
		super();
		this.date = LocalDate.now();
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "SaleByDay [date=" + date + ", amount=" + amount + "]";
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
}
