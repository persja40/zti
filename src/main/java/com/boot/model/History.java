package com.boot.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class History {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer historyId;
	@Fetch(FetchMode.JOIN)
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "clientId")
	private Client client;
	@Fetch(FetchMode.JOIN)
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "barCode")
	private Product product;
	private Float price;
	private Integer amount;
	private Date date;

	public History(Client client, Product product, Integer amount) {
		this.client = client;
		this.product = product;
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

	public void setPrice(Float price) {
		this.price = price;
	}

	public Date getDate() {
		return date;
	}

	public Integer getAmount() {
		return amount;
	}

}
