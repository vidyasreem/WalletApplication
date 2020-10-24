package com.cg.paymentapp.beans;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Table(name = "BankAccount")
public class BankAccount {
	@Id
	@Column(length = 10)
	private int accountNo;
	@Column(name = "ifscCode")
	private String ifscCode;
	@Column
	private String bankName;
	@Column
	private double balance;
	@ManyToOne
	@JoinColumn(name = "walletid")
	private Wallet wallet;

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}

	@Override
	public String toString() {
		return "BankAccount [accountNo=" + accountNo + ", ifscCode=" + ifscCode + ", bankName=" + bankName
				+ ", balance=" + balance + "]"; // wallet=" + wallet + "]";
	}

}
