package com.cg.paymentapp.service;

import java.math.BigDecimal;
import java.util.List;

import com.cg.paymentapp.beans.Customer;
import com.cg.paymentapp.beans.Wallet;
import com.cg.paymentapp.repo.WalletRepo;
import com.cg.paymentapp.repo.WalletRepoImp;
import com.cg.paymentapp.exception.InvalidInputException;


public class WalletServiceImp implements WalletService {
	private WalletRepo repo;
	//private Customer customer;
	//private Wallet wallet;
	public WalletServiceImp() {
		repo=new WalletRepoImp();
		//customer=new Customer();
		//wallet=new Wallet();
	}

	public Customer createAccount(String name, String mobileno, BigDecimal amount) throws InvalidInputException {
		return repo.createAccount(name,mobileno,amount);
	}

	public Customer showCustomer(String mobileno) {
		return repo.showCustomer(mobileno);
	}


	public Customer depositAmount(String mobileNo, BigDecimal amount) {
		return repo.depositAmount(mobileNo, amount);
	}

	public Customer withdrawAmount(String mobileNo, BigDecimal amount) {
		return repo.withdrawAmount(mobileNo, amount);
	}

	public Wallet addWallet(Wallet wallet) {
		return repo.addWallet(wallet);
	}

	public Wallet findWallet(int walletid) {
		return repo.findWallet(walletid);
	}

	public Wallet removeWallet(Wallet wallet) {
		return repo.removeWallet(wallet);
	}

}
