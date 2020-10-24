package com.cg.paymentapp.repo;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cg.paymentapp.beans.BankAccount;
import com.cg.paymentapp.beans.Customer;
import com.cg.paymentapp.beans.Wallet;
import com.cg.paymentapp.service.WalletService;
import com.cg.paymentapp.exception.InvalidInputException;

public class WalletRepoImp implements WalletRepo {
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private EntityTransaction entityTransaction;
	public WalletRepoImp() {
		entityManagerFactory=Persistence.createEntityManagerFactory("WalletApplication");
		entityManager=entityManagerFactory.createEntityManager();
		entityTransaction=entityManager.getTransaction();
	}
	public boolean checkBalance(BigDecimal amount) throws InvalidInputException{
		if(amount.compareTo(new BigDecimal(500))==-1) {
			throw new InvalidInputException("Amount should be greater than 500");
		}else {
			return true;
		}
	}
	public boolean checknullorempty(String name, String mobileno) throws InvalidInputException {
		if(name==null||name.isEmpty()) {
			throw new InvalidInputException("Name is empty or is null");
		}else if(mobileno.length()<10) {
			throw new InvalidInputException("Mobile number is invalid");
		}else{
			return true;
		}
}
	public Wallet addWallet(Wallet wallet) {
		checkBalance(wallet.getBalance());
		try {
			entityTransaction.begin();
			entityManager.persist(wallet);
			entityTransaction.commit();
		}finally {
			entityManager.close();
		}
		return wallet;
	}

	public Customer createAccount(String name, String mobileno, BigDecimal amount) throws InvalidInputException{
		Customer customer=null;
		checknullorempty(name, mobileno);
		checkBalance(amount);
		try {
			entityTransaction.begin();
			Wallet wallet=new Wallet(amount);
			customer=new Customer(name, mobileno, wallet);
			entityManager.persist(customer);
			entityTransaction.commit();
			
			}
		finally {
			entityManager.close();
		}
		return customer;
	}

	public Customer showCustomer(String mobileno) {
		
		try {
			entityTransaction.begin();
			Customer customer=entityManager.find(Customer.class, mobileno);
			entityTransaction.commit();
			return customer;
		}finally {
			entityManager.close();
		}
		
	}

	public Customer depositAmount(String mobileNo, BigDecimal amount) {
		// TODO Auto-generated method stub
		return null;
	}

	public Customer withdrawAmount(String mobileNo, BigDecimal amount) {
		// TODO Auto-generated method stub
		return null;
	}
	public Wallet removeWallet(Wallet wallet) throws InvalidInputException{
		Wallet w;
		try {
			entityTransaction.begin();
			w=findWallet(wallet.getWalletId());
			entityManager.remove(w);
			entityTransaction.commit();
		}
		finally {
			entityManager.close();
		}
		return wallet;
	}
	public Wallet findWallet(int walletid) throws InvalidInputException {
		Wallet w=entityManager.find(Wallet.class, walletid);
		if(w==null) {
			throw new InvalidInputException("Record with "+walletid+" doesnot exist");
		}else {
			return w;
		}
	}

}
