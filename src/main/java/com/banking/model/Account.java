package com.banking.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.banking.enums.AccountType;

@Entity
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Enumerated(EnumType.STRING)
	private AccountType type;
	private double rateOfInterest;
	private double balance;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public AccountType getType() {
		return type;
	}
	public void setType(AccountType type) {
		this.type = type;
	}
	public double getRateOfInterest() {
		return rateOfInterest;
	}
	public void setRateOfInterest(double rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
}
