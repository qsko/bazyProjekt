package entity;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "Sales_by_day")
public class SaleByDay {

	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

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
		return "SaleByDay [id="+id+", date=" + date + ", amount=" + amount + "]";
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
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id=id;
	}
}
