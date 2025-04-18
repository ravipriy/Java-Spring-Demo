package com.springdemo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "AllInventoryProducts")
public class Product {
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_sequence")
//	@SequenceGenerator(name = "product_sequence", sequenceName = "product_seq", allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;
	private int quantity;
	private double price;
	private String location;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Product(Long id, String name, int quantity, double price, String location) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.location = location;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", quantity=" + quantity + ", price=" + price + ", location="
				+ location + "]";
	}
	

}
