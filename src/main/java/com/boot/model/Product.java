package com.boot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer barCode;
	@Column(unique = true)
	private String name;
	private Float price;
	private Integer quantity;

	public Product() {
	}

	public Product(String name, Float price, Integer quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public Integer getBarCode() {
		return barCode;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public void setBarCode(Integer barCode) {
		this.barCode = barCode;
	}
}
