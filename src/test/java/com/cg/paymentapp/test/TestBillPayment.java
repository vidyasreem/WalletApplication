package com.cg.paymentapp.test;
import com.cg.paymentapp.exception.InvalidInputException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import com.cg.paymentapp.beans.BillPayment;
import com.cg.paymentapp.beans.BillType;
import com.cg.paymentapp.beans.Customer;
import com.cg.paymentapp.beans.Wallet;
import com.cg.paymentapp.service.BillPaymentService;
import com.cg.paymentapp.service.IBillPaymentService;
import com.cg.paymentapp.service.WalletService;
import com.cg.paymentapp.service.WalletServiceImp;



//Testing for Bill Payment Methods
public class TestBillPayment {
	private IBillPaymentService service;
	private WalletService wservice;

	@Before
	public void init() {
		service = new BillPaymentService();
		wservice = new WalletServiceImp();
	}

	// Testing Add Bill Payment(Positive)
	@Test
	public void TestAddBillP() {
		BillPayment payment = new BillPayment();
		LocalDate date = LocalDate.now();
		Wallet w1 = new Wallet();
		Wallet wallet = wservice.findWallet(24);
		payment.setWallet(wallet);
		payment.setAmount(830);
		payment.setBilltype(BillType.LPG);
		payment.setPaymentDate(date);
		assertEquals(payment, service.addBillPayment(payment));
	}
	
	// Testing Add Bill Payment(Negative)
	@Test(expected=InvalidInputException.class)
	public void TestAddBillN() {
		BillPayment payment = new BillPayment();
		LocalDate date = LocalDate.now();
		Wallet w1 = new Wallet();
		Wallet wallet = wservice.findWallet(24);
		payment.setWallet(wallet);
		payment.setAmount(0);
		payment.setBilltype(BillType.MobilePrepaid);
		payment.setPaymentDate(date);
		assertEquals(payment, service.addBillPayment(payment));
	}

	// Testing View Bill Payment(Positive)
	@Test
	public void TestviewBillPaymentP() {
		BillPayment payment = new BillPayment();
		payment.setBillId(34);
		assertNotNull(service.viewBillPayment(payment));

	}
	
	//Testing View Bill Payment(Negative)
	@Test(expected=InvalidInputException.class)
	public void TestViewBillPaymentN() {
		BillPayment payment=new BillPayment();
		payment.setBillId(787);
		assertNull(service.viewBillPayment(payment));
	}
}
