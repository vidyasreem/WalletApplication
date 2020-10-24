package com.cg.paymentapp.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="wallet")
public class Wallet implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="walletid")
	private int walletId;
	private BigDecimal balance;
	
	@OneToOne(mappedBy = "wallet", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
	private Customer c;
	@OneToMany(mappedBy = "wallet", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<BillPayment> payment =new ArrayList<BillPayment>();
	@OneToMany(mappedBy = "wallet", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Transaction> transaction=new ArrayList<Transaction>();
	public List<Transaction> getTransaction() {
		return transaction;
	}

	public void setTransaction(List<Transaction> transaction) {
		this.transaction =transaction;
	}
	@OneToMany(mappedBy = "wallet", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<BankAccount> bacc=new ArrayList<BankAccount>();
	public List<BankAccount> getBacc() {
		return bacc;
	}

	public void setBacc(List<BankAccount> bacc) {
		this.bacc = bacc;
	}

	public int getWalletId() {
		return walletId;
	}

	public void setWalletId(int walletId) {
		this.walletId = walletId;
	}

	public Wallet() {

	}

	public Wallet(BigDecimal amount) {
		this.balance = amount;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return " balance= " + balance;
	}

}
