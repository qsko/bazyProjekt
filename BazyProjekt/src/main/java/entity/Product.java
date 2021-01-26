package entity;



import javax.persistence.*;

import enums.Is_18;
import enums.PriceType;


@Entity
@Table(name = "Products")
public class Product {

	public Product(String name, int weight, int price, PriceType priceType, Is_18 is_18) {
		super();
		this.name = name;
		this.weight = weight;
		this.price = price;
		this.priceType = priceType;
		this.is_18 = is_18;
	}
	
	public Product() {
		super();
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", weight=" + weight + ", price=" + price + ", priceType="
				+ priceType + ", is_18=" + is_18 + "]";
	}

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 120, name= "name")
	private String name;
	@Column(name = "weight")
	private int weight;
	@Column(name = "price")
	private int price;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "price_type")
	private PriceType priceType;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "is_18")
	private Is_18 is_18;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public PriceType getPriceType() {
		return priceType;
	}

	public void setPriceType(PriceType priceType) {
		this.priceType = priceType;
	}

	public Is_18 getIs_18() {
		return is_18;
	}

	public void setIs_18(Is_18 is_18) {
		this.is_18 = is_18;
	}
}
