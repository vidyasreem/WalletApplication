package com.cg.paymentapp.service;

import java.util.List;

import com.cg.paymentapp.beans.BillPayment;
import com.cg.paymentapp.beans.Wallet;
import com.cg.paymentapp.exception.InvalidInputException;
import com.cg.paymentapp.repo.BillPaymentRepository;
import com.cg.paymentapp.repo.IBillPaymentRepository;

public class BillPaymentService implements IBillPaymentService {
	private IBillPaymentRepository repo;
	public BillPaymentService() {
		repo=new BillPaymentRepository();
	}

	public BillPayment addBillPayment(BillPayment payment) throws InvalidInputException {
		return repo.addBillPayment(payment);
	}

	public BillPayment viewBillPayment(BillPayment payment) {
		// TODO Auto-generated method stub
		return repo.viewBillPayment(payment);
	}
	
}
