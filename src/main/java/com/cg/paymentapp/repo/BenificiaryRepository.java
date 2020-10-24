package com.cg.paymentapp.repo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cg.paymentapp.beans.BenificiaryDetails;
import com.cg.paymentapp.beans.Customer;
import com.cg.paymentapp.exception.InvalidInputException;

public class BenificiaryRepository implements IBenificiaryRepository {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("WalletApplication");
	EntityManager em = emf.createEntityManager();

	public BenificiaryDetails addBenificiary(BenificiaryDetails bd) {

		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		try {
			if (bd.getName() == null || bd.getName().isEmpty()) {
				throw new InvalidInputException(" name cannot be empty");
			} else if (bd.getMobileNumber() == null || bd.getMobileNumber().isEmpty()) {
				throw new InvalidInputException("mobile number cannot be empty");
			} else {
				try {
					transaction.begin();
					em.persist(bd);
					transaction.commit();
				} finally {
					em.close();
				}
			}
		} catch (InvalidInputException e) {
			System.out.println(e.getMessage());
		}
		return bd;
	}

	public BenificiaryDetails deleteBenificiary(BenificiaryDetails bd) {

		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
//				
			bd = em.find(BenificiaryDetails.class, bd.getName());
			try {
				throw new InvalidInputException("nothing found" + bd.getName());
			} catch (InvalidInputException e) {
				System.out.println(e.getMessage());
			}
		} finally {
			em.close();
		}
		return bd;
	}

	public BenificiaryDetails updateBenificiary(BenificiaryDetails bd) {
		// TODO Auto-generated method stub
		BenificiaryDetails b = em.find(BenificiaryDetails.class, bd);
		EntityTransaction txn = em.getTransaction();
		if (b != null) {
			txn.begin();
			em.remove(b);
			txn.commit();
		}
		return null;
	}

	
	public BenificiaryDetails viewBenificiary(BenificiaryDetails bd) {
		BenificiaryDetails details;
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			details = em.find(BenificiaryDetails.class, bd.getName());
			transaction.commit();
		} finally {
			em.close();
		}
		return bd;
	}

	
	public BenificiaryDetails viewAllBenificiary(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

}