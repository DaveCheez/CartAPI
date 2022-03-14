package com.fusionarc.cart.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


// Create the Product table in the database
@Entity
public class Product {

	//Create the Id column as an auto generated value
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	// Define the columns within the table
	@Column(nullable = false)
	private String title;
	
	@Column
	private String description;
	
	@Column(nullable = false)
	@Min(1)
	@Max(10000)
	private double price;
	
	@Column(nullable = false)
	private boolean inStock;
	
	public Product() { }
	
	// For creating Product objects
	public Product(String title, String description, @Min(1) @Max(10000) double price, boolean inStock) {
		super();
		this.title = title;
		this.description = description;
		this.price = price;
		this.inStock = inStock;
	}


	// For testing data persists
	public Product(long id, String title, String description, @Min(1) @Max(10000) double price, boolean inStock) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.price = price;
		this.inStock = inStock;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isInStock() {
		return inStock;
	}

	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, id, inStock, price, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(description, other.description) && id == other.id && inStock == other.inStock
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", title=" + title + ", description=" + description + ", price=" + price
				+ ", inStock=" + inStock + "]";
	}
	
}
