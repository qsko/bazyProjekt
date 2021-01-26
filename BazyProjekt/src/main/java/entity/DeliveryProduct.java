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
@Table (name = "Delivery_Products")
public class DeliveryProduct {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "delivery_id")
	private Delivery delivery;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	@Column(name = "amount")
	private int amount;

	public DeliveryProduct(int amount) {
		super();
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "DeliveryProduct [id=" + id + ", amount=" + amount + "]";
	}


	public DeliveryProduct() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Delivery getDelivery() {
		return delivery;
	}

	public void setDelivery(Delivery deliveryId) {
		this.delivery = deliveryId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product productId) {
		this.product = productId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
}
