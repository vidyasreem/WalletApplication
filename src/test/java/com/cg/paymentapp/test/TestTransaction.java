package com.cg.paymentapp.test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.cg.paymentapp.beans.Transaction;
import com.cg.paymentapp.beans.Wallet;

import com.cg.paymentapp.service.ITransactionService;
import com.cg.paymentapp.service.TransactionService;


 

public class TestTransaction {
	
	private ITransactionService service ;
	
	@Before
	public void init() {
		service = new TransactionService();
		
	}
	@Test
	public void testaddTransactionPositive() {
		Transaction tran = new Transaction();
		tran.setTransactionId(120);
		tran.setAmount(5000);
		tran.setTransactionDateFrom(LocalDate.of(2040,06, 21));
		tran.setTransactionDateTo(LocalDate.of(2040,06, 26));
		tran.setDescription("unsuccessful");
		tran.setTransactionType("withdraw");
		Wallet wallet = new Wallet();
		wallet.setWalletId(410);
		Transaction t = service.addTransaction(tran);
		assertEquals(tran, t);
		System.out.println(t);	
	}
	@Test
	public void testaddTransactionNegative() {
		Transaction tran = new Transaction();
		tran.setTransactionId(120);
		tran.setAmount(11019);
		tran.setTransactionDateFrom(LocalDate.of(2020,05,12));
		tran.setTransactionDateTo(LocalDate.of(2020,05,14));
		tran.setDescription("success");
		tran.setTransactionType("check");
		Transaction t = service.addTransaction(tran);
		assertEquals(tran, t);
		System.out.println(t);	
	}
	
	@Test
	public void testviewAllTransactionsByWalletPositive() {
		Wallet wallet = new Wallet();
		wallet.setWalletId(29);
		//wallet.setBalance(new BigDecimal("30007"));
		List<Transaction> t = service.viewAllTransactions(wallet);
		assertEquals(wallet, t);
	}
	
	@Test
	public void testviewAllTransactionsByWalletNegative() {
		Wallet wallet = new Wallet();
		wallet.setWalletId(101);
		wallet.setBalance(new BigDecimal("30007"));
		List<Transaction> t = service.viewAllTransactions(wallet);
		assertEquals(wallet, t);
	}
	
	@Test
	public void testViewAllTransactionsByTransactionTypePositive() {
		Transaction tran = new Transaction();
		tran.setTransactionType("withdraw");
		List<Transaction> t = service.viewAllTransactions(tran.getTransactionType());
		//assertEquals(, t);;
		assertTrue(t.isEmpty());
		
	}
	
	@Test
	public void testViewAllTransactionsByTransactionTypeNegative() {
		Transaction tran = new Transaction();
		tran.setTransactionType("check");
		List<Transaction> t = service.viewAllTransactions(tran.getTransactionType());
		//assertEquals(, t);;
		assertTrue(t.isEmpty());
		
	}
	@Test
	public void testViewAllTransactionsByTransactionDatePositive() {
		Transaction tran = new Transaction();
		tran.setTransactionDateFrom(LocalDate.of(2020,04,22));
		tran.setTransactionDateTo(LocalDate.of(2020,04,27));
		List<Transaction> t = service.viewTransactionsByDate(LocalDate.of(2020,04,22),LocalDate.now().plusDays(5));
		assertEquals(tran, t);	
		
	}
	
	@Test
	public void testViewAllTransactionsByTransactionDateNegative() {
		Transaction tran = new Transaction();
		tran.setTransactionDateFrom(LocalDate.of(2020,04,22));
		tran.setTransactionDateTo(LocalDate.of(2020,04,28));
		List<Transaction> t = service.viewTransactionsByDate(LocalDate.of(2020,04,22),LocalDate.now().plusDays(5));
		assertEquals(tran, t);	
		
	}
	
	

}
