package com.boot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer clientId;
	@Column(unique = true)
	private String name;
	@Column(unique = true)
	private String email;
	@Column(unique = true)
	private String phone;
	private Float credit;
	private Float accountBalance;

	public Client(String name, String email, String phone, Float credit, Float accountBalance) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.credit = credit;
		this.accountBalance = accountBalance;
	}

	public Client() {
	}

	public Integer getClientId() {
		return clientId;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public Float getCredit() {
		return credit;
	}

	public void setCredit(Float credit) {
		this.credit = credit;
	}

	public Float getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(Float accountBalance) {
		this.accountBalance = accountBalance;
	}

}
