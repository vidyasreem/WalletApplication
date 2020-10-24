package com.cg.paymentapp.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cg.paymentapp.beans.BankAccount;
import com.cg.paymentapp.beans.Wallet;
import com.cg.paymentapp.exception.InsufficientBalanceException;
import com.cg.paymentapp.exception.InvalidInputException;

public class AccountRepository implements IAccountRepository {

	private EntityManagerFactory emf;

	public AccountRepository() {
		emf = Persistence.createEntityManagerFactory("WalletApplication");
	}
	//Checking the inputs given are not null and empty 
	public boolean checknullorempty(BankAccount bacc) throws InvalidInputException, InsufficientBalanceException{
		if (bacc.getBankName() == null || bacc.getBankName().isEmpty()) {
			throw new InvalidInputException("Bank name is null or is empty");
		} else if (bacc.getIfscCode() == null || bacc.getIfscCode().isEmpty()) {
			throw new InvalidInputException("IFSC code is null or is empty");
		} else if(bacc.getBalance()<0){
			throw new InsufficientBalanceException("Balance is insufficient");
		}else {
			return true;
		}
	}
	// Adding bank account details
	public BankAccount addAccount(BankAccount bacc) throws InvalidInputException {
		EntityManager em = emf.createEntityManager();
		 EntityTransaction transaction=em.getTransaction();
		checknullorempty(bacc);
		try {
				transaction.begin();
				em.persist(bacc);
				transaction.commit();
		} finally {
				em.close();
		}
		return bacc;
	}

	// Removing bank account details
	public BankAccount removeAccount(BankAccount bacc) throws InvalidInputException {
		EntityManager em = emf.createEntityManager();
		 EntityTransaction transaction=em.getTransaction();
		 BankAccount account;
		try {
			transaction.begin();
			 account = em.find(BankAccount.class, bacc.getAccountNo());
			Query query=em.createQuery("delete from BankAccount b where b.accountNo="+bacc.getAccountNo());
			query.executeUpdate();
			
			//em.remove(em.contains(bacc) ? bacc : em.merge(bacc));
			transaction.commit();
		} finally {
			em.close();
		}
		return account;
	}

	// View bank details wrt account no
	public BankAccount viewAccount(int accountNo) throws InvalidInputException{
		EntityManager em = emf.createEntityManager();
		BankAccount account = em.find(BankAccount.class, accountNo);
			return account;
	}

	// View all details using wallet id
	public List<BankAccount> viewAllAccounts(Wallet wallet) {
		EntityManager em = emf.createEntityManager();
			Wallet w = em.find(Wallet.class, wallet.getWalletId());
			List<BankAccount> list = w.getBacc();
			return list;
	}

}
