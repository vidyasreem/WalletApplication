package com.cg.paymentapp.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.cg.paymentapp.beans.BankAccount;
import com.cg.paymentapp.beans.Customer;
import com.cg.paymentapp.beans.Wallet;
import com.cg.paymentapp.exception.InvalidInputException;
import com.cg.paymentapp.service.AccountService;
import com.cg.paymentapp.service.IAccountService;
import com.cg.paymentapp.service.WalletService;
import com.cg.paymentapp.service.WalletServiceImp;

public class TestAccount {
	private IAccountService service;
	private WalletService wservice;

	@Before
	public void init() {
		service = new AccountService();
		wservice = new WalletServiceImp();
	}

	@Test
	public void testAddAccountP() {
		BankAccount bankaccount = new BankAccount();
		bankaccount.setAccountNo(22);
		bankaccount.setBalance(1500);
		bankaccount.setBankName("hdfc");
		bankaccount.setIfscCode("hdfc412");
		Wallet w1 = new Wallet();
		Wallet wallet = wservice.findWallet(8);
		bankaccount.setWallet(wallet);
		assertNotNull(service.addAccount(bankaccount));
	}
	@Test(expected= InvalidInputException.class)
	public void testAddAccountN() {
		BankAccount bankaccount = new BankAccount();
		bankaccount.setAccountNo(100);
		bankaccount.setBalance(54000);
		bankaccount.setBankName("");
		bankaccount.setIfscCode("hdfc412");
		Wallet w1 = new Wallet();
		Wallet wallet = wservice.findWallet(4);
		bankaccount.setWallet(wallet);
		assertNotEquals(bankaccount, service.addAccount(bankaccount));
	}

	@Test
	public void testRemoveAccountP() {
		BankAccount bankAccount = new BankAccount();
		bankAccount.setAccountNo(21);
		//service.removeAccount(bankAccount);
		//assertNotNull(service.removeAccount(bankAccount));
		assertNotNull(service.removeAccount(bankAccount));

	}
	@Test(expected=InvalidInputException.class)
	public void testRemoveAccountN() {
		BankAccount bankAccount = new BankAccount();
		bankAccount.setAccountNo(11);
		service.removeAccount(bankAccount);
		assertNull(service.removeAccount(bankAccount));

	}
	@Test
	public void testViewBankAccountN(){
		assertNull(service.viewAccount(10));
	}

	@Test
	public void testViewBankAccountP() {
		assertNotNull(service.viewAccount(100));
	}

	@Test
	public void testViewAllBankAccountN() {
		Wallet wallet = new Wallet();
		wallet.setWalletId(1);
		/*
		 * BankAccount bacc=new BankAccount(); bacc.setWallet(wallet);
		 */
		// System.out.println(service.viewAllAccounts(wallet));
		assertTrue(service.viewAllAccounts(wallet).isEmpty());
	}

	@Test
	public void testViewAllBankAccountP() {
		Wallet wallet = new Wallet();
		wallet.setWalletId(8);
		/*
		 * BankAccount bacc=new BankAccount(); bacc.setWallet(wallet);
		 */
		System.out.println(service.viewAllAccounts(wallet));
		assertTrue(!service.viewAllAccounts(wallet).isEmpty());
	}
}
