package com.cg.paymentapp.repo;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.Session;

import com.cg.paymentapp.beans.BillPayment;
import com.cg.paymentapp.beans.BillType;
import com.cg.paymentapp.beans.Wallet;
import com.cg.paymentapp.exception.InvalidInputException;



public class BillPaymentRepository implements IBillPaymentRepository {
	private EntityManagerFactory factory;

	public BillPaymentRepository() {
		factory = Persistence.createEntityManagerFactory("WalletApplication");
	}
	
boolean checkValidation(BillPayment payment) throws InvalidInputException {
		
		if(payment.getAmount()==0)
			throw new InvalidInputException("Amount cannot be 0");
		//else if(payment.getBilltype()!=BillType.DTH ||payment.getBilltype()!=BillType.CreditCard || payment.getBilltype()!=BillType.LICPremium ||payment.getBilltype()!=BillType.LPG ||payment.getBilltype()!=BillType.MobilePostpaid || payment.getBilltype()!=BillType.MobilePrepaid)
		//throw new InvalidInputException("Bill Type is Invalid ");
		else
			return true;
	}

	// Add Bill Payment
	public BillPayment addBillPayment(BillPayment payment) throws InvalidInputException{
		EntityManager em = factory.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		
		// Validation based on BillId
		try {
			
					txn.begin();
					checkValidation(payment);
					em.persist(payment);
					txn.commit();
					return payment;
				} finally {
					em.close();
				}
			}

		

	// View Bill Payment
	public BillPayment viewBillPayment(BillPayment payment) {
		BillPayment payment1;
		EntityManager em = factory.createEntityManager();
		//EntityTransaction txn = em.getTransaction();
		payment = em.find(BillPayment.class, payment.getBillId());

		try {
				if(payment==null) {
				throw new com.cg.paymentapp.exception.InvalidInputException("Cannot View Payment");
			}
			return payment;
		}

		finally {
			em.close();
		}
	}
}
