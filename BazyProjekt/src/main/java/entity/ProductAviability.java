package entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name ="Products_aviability")
public class ProductAviability {

	@Id
	private int id;
	
	@OneToOne
	@JoinColumn(name = "prod_id")
	@MapsId
	private Product prodId;
	
	@Column(name = "shop_amount")
	private int shopAmount;
	
	@Column(name = "warehouse_amount")
	private int warehouseAmount;

	public ProductAviability() {
		super();
	}

	public ProductAviability(int shopAmount, int warehouseAmount) {
		super();
		this.shopAmount = shopAmount;
		this.warehouseAmount = warehouseAmount;
	}
	
	public ProductAviability(Product product, int shopAmount, int warehouseAmount) {
		super();
		this.prodId=product;
		this.shopAmount = shopAmount;
		this.warehouseAmount = warehouseAmount;
	}

	@Override
	public String toString() {
		return "ProductAviability [id=" + id + ", shopAmount=" + shopAmount + ", warehouseAmount=" + warehouseAmount
				+ "]";
	}
	
	public String[] toStringArray() {
		String[] s = new String[4];
		s[0]=String.valueOf(id);
		s[1]=String.valueOf(prodId.getId());
		s[2]=String.valueOf(shopAmount);
		s[3]=String.valueOf(warehouseAmount);
		return s;
	}

	public Product getProdId() {
		return prodId;
	}

	public void setProdId(Product prodId) {
		this.prodId = prodId;
	}

	public int getShop_amount() {
		return shopAmount;
	}

	public void setShop_amount(int shopAmount) {
		this.shopAmount = shopAmount;
	}

	public int getWarehouse_amount() {
		return warehouseAmount;
	}

	public void setWarehouse_amount(int warehouseAmount) {
		this.warehouseAmount = warehouseAmount;
	}
}
