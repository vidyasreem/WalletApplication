package com.cg.paymentapp.repo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.cg.paymentapp.beans.Customer;
import com.cg.paymentapp.beans.Wallet;

import com.cg.paymentapp.exception.InvalidInputException;

public interface WalletRepo {
	public Wallet findWallet(int walletid);
	public Wallet addWallet(Wallet wallet);
	public Wallet removeWallet(Wallet wallet);
	public Customer createAccount(String name ,String mobileno, BigDecimal amount) throws InvalidInputException;
	public Customer showCustomer (String mobileno);
	public Customer depositAmount (String mobileNo,BigDecimal amount );
	public Customer withdrawAmount(String mobileNo, BigDecimal amount);
}
