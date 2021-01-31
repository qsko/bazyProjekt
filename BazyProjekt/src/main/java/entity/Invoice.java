package entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import enums.InvoiceType;

@Entity
@Table( name = "Invoices")
public class Invoice {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	public Invoice() {
		super();
	}

	public Invoice(int nip, LocalDateTime date, InvoiceType type) {
		super();
		this.nip = nip;
		this.date = date;
		this.type = type;
	}
	
	public Invoice(int nip, InvoiceType type) {
		super();
		this.nip = nip;
		this.date = LocalDateTime.now();
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "Invoice [id=" + id + ", nip=" + nip + ", date=" + date + ", type=" + type + "]";
	}

	@Column(name ="nip")
	private int nip;
	
	@Column(name ="date")
	private LocalDateTime date;
	
	@Column(name ="type")
	@Enumerated(EnumType.STRING)
	private InvoiceType type;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNip() {
		return nip;
	}

	public void setNip(int nip) {
		this.nip = nip;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public InvoiceType getType() {
		return type;
	}

	public void setType(InvoiceType type) {
		this.type = type;
	}
}
