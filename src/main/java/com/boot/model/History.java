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
	@JoinColumn(name = "barCode")
	private Product product;
	private Float price;
	private Integer amount;
	private Date date;

	public History(Client client, Product product, Float price, Integer amount) {
		this.client = client;
		this.product = product;
		this.price = price;
		this.amount = amount;
		this.date = new Date();
	}

	public History() {
	}

	public Integer getHistoryId() {
		return historyId;
	}

	public Client getClient() {
		return client;
	}

	public Product getProduct() {
		return product;
	}

	public Float getPrice() {
		return price;
	}

	public Date getDate() {
		return date;
	}

	public Integer getAmount() {
		return amount;
	}

}
