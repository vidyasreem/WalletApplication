package com.cg.paymentapp.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.junit.Before;
import org.junit.Test;

import com.cg.paymentapp.beans.Customer;
import com.cg.paymentapp.beans.Wallet;
import com.cg.paymentapp.exception.InvalidInputException;
import com.cg.paymentapp.service.AccountService;
import com.cg.paymentapp.service.WalletService;
import com.cg.paymentapp.service.WalletServiceImp;

public class TestWallet {
	private WalletService wservice;
	@Before
	public void init() {
		wservice=new WalletServiceImp();
	}
	
	@Test
	public void testShowCustomerN() {
		Customer customer=new Customer();
		customer.setMobileNo("78459654");
		assertNull(wservice.showCustomer(customer.getMobileNo()));
	}
	@Test
	public void testShowCustomerP() {
		Customer customer=new Customer();
		customer.setMobileNo("7845965874");
		assertNotNull(wservice.showCustomer(customer.getMobileNo()));
	}
	@Test(expected=InvalidInputException.class)
	public void testCreateAccountN() {
		Customer customer=wservice.createAccount("ytfcyg","5478965120" , new BigDecimal("200"));
		assertNull(customer);
	}
	@Test
	public void testCreateAccountP() {
		Customer customer=wservice.createAccount("mom","5784226" , new BigDecimal("100"));
		assertNotNull(customer);
	}
	
	@Test
	public void testAddWalletP() {
		Wallet wallet=new Wallet();
		wallet.setBalance(new BigDecimal("500"));
		assertEquals(wallet, wservice.addWallet(wallet));
	}
	@Test(expected=InvalidInputException.class)
	public void testAddWalletN() {
		Wallet wallet=new Wallet();
		wallet.setBalance(new BigDecimal("200"));
		assertNotEquals(wallet, wservice.addWallet(wallet));
	}
	@Test
	public void viewWalletByIdP() {
		Wallet wallet=new Wallet();
		//System.out.println(wservice.findWallet(4));
		assertNotNull(wservice.findWallet(30));
	}
	@Test(expected=InvalidInputException.class)
	public void viewWalletByIdN() {
		Wallet wallet=new Wallet();
		//System.out.println(wservice.findWallet(4));
		assertNull(wservice.findWallet(50));
	}
	@Test
	public void testRemoveWalletP() {
		Wallet wallet=new Wallet();
		wallet.setWalletId(7);
		//System.out.println(wservice.removeWallet(wallet));
		assertEquals(wallet, wservice.removeWallet(wallet));
	}
	@Test(expected=InvalidInputException.class)
	public void testRemoveWalletN() {
		Wallet wallet=new Wallet();
		wallet.setWalletId(50);
		//System.out.println(wservice.removeWallet(wallet));
		assertNotEquals(wallet, wservice.removeWallet(wallet));
	}
}
