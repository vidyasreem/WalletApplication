package com.cg.paymentapp.service;

import java.util.List;

import com.cg.paymentapp.beans.BillPayment;
import com.cg.paymentapp.beans.Wallet;
import com.cg.paymentapp.exception.InvalidInputException;

public interface IBillPaymentService {

	public BillPayment addBillPayment(BillPayment payment) throws InvalidInputException;
	public BillPayment viewBillPayment(BillPayment payment);
	
}
