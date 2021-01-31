package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Invoice_Products")
public class InvoiceProduct {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "invoice_id")
	private Invoice	invoice;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	@Column(name = "amount")
	private int amount;

	public InvoiceProduct() {
		super();
	}

	public InvoiceProduct(int amount) {
		super();

		this.amount = amount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "InvoiceProduct [id=" + id + ", amount=" + amount + "]";
	}
	
	public String[] toStringArray() {
		String[] s = new String[4];
		s[0]=String.valueOf(id);
		s[1]=String.valueOf(invoice.getId());
		s[2]=String.valueOf(product.getId());
		s[3]=String.valueOf(amount);
		return s;
	}


}
