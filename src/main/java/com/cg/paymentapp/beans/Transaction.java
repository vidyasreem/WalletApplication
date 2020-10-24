package com.cg.paymentapp.beans;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "Transaction")
public class Transaction {
	@Id
	@Column
	private int transactionId;
	@Column
	private String transactionType;
	@Column
	private LocalDate transactionDateFrom;
	public LocalDate getTransactionDateFrom() {
		return transactionDateFrom;
	}
	public void setTransactionDateFrom(LocalDate transactionDateFrom) {
		this.transactionDateFrom = transactionDateFrom;
	}
	public LocalDate getTransactionDateTo() {
		return transactionDateTo;
	}
	public void setTransactionDateTo(LocalDate transactionDateTo) {
		this.transactionDateTo = transactionDateTo;
	}


	@Column
	private LocalDate transactionDateTo;
	
	@ManyToOne
	@JoinColumn(name="walletid")
	public Wallet wallet;
	@Column
	private double amount;
	@Column
	private String description;
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	
	public Wallet getWallet() {
		return wallet;
	}
	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", transactionType=" + transactionType
				+ ", transactionDateFrom=" + transactionDateFrom + ", transactionDateTo=" + transactionDateTo
				+ ", wallet=" + wallet + ", amount=" + amount + ", description=" + description + "]";
	}
	
	
	
	
	
	}
