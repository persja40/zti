package com.boot.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class History {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer historyId;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clientId")
	private Client client;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "productId")
	private Product product;
	private Float price;
	private Integer amount;
	private Date date;

	public History(Integer historyId, Client client, Product product, Float price, Integer amount) {
		this.historyId = historyId;
		this.client = client;
		this.product = product;
		this.setPrice(price) ;
		this.setAmount(amount);
		this.date = new Date();
	}

	public History() {
	}

	public Integer getHistoryId() {
		return historyId;
	}

	public void setHistoryId(Integer historyId) {
		this.historyId = historyId;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

}
