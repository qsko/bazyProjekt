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
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

import enums.InvoiceType;

@Entity
@Table( name = "Invoices")
@NamedNativeQueries({
@NamedNativeQuery(
		name="callInvoiceValue",
		query="select invoiceValue(?)"
),
@NamedNativeQuery(
		name="callSelectInvoicesByNIP",
		query="call selectInvoicesByNIP(?)")})
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
	
	public String[] toStringArray() {
		String[] s = new String[4];
		s[0]=String.valueOf(id);
		s[1]=String.valueOf(nip);
		s[2]=String.valueOf(date);
		s[3]=type.name();
		return s;
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
