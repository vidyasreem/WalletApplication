package com.cg.paymentapp.repo;

import java.time.LocalDate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.cg.paymentapp.beans.Transaction;
import com.cg.paymentapp.beans.TransactionType;
import com.cg.paymentapp.beans.Wallet;
import com.cg.paymentapp.exception.InsufficientBalanceException;
import com.cg.paymentapp.exception.InvalidInputException;

public class TransactionRepository implements ITransactionRepository {
	private EntityManagerFactory factory;

	public TransactionRepository() {
		// persistence-bootstrap class used to obtain an entityManagerFactory interface
		factory = Persistence.createEntityManagerFactory("WalletApplication");// contain name of persistence-unit file name
	}

	public Transaction addTransaction(Transaction tran) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {

			if (checkAddTransaction(tran)==1) {
				throw new InsufficientBalanceException("Balance is not sufficient");
			}

			else if (checkAddTransaction(tran)==2) {

				transaction.begin();
				manager.persist(tran); // make an instance managed and persistence
				transaction.commit();
			}

			else {

				throw new InvalidInputException("Transaction type must be withdraw or deposit only");

			}
			return tran;
		} finally {
			manager.close();
		}

	}
	///validity check addTransaction method

	public int checkAddTransaction(Transaction tran) {
		
			
						if (tran.getAmount() <= 500) {

							return 1;
						}
			
						else if (tran.getTransactionType().equalsIgnoreCase("deposit")
								|| tran.getTransactionType().equalsIgnoreCase("withDraw")) {
							return 2;
						}
			
						else {
							return 3;
						}
						
			
	}
	
	public List<Transaction> viewAllTransactions(Wallet wallet) {
		EntityManager manager = factory.createEntityManager();
		// EntityTransaction transaction = manager.getTransaction();
		try {

			Wallet w = manager.find(Wallet.class, wallet.getWalletId());
			if (w == null) {
				throw new InvalidInputException("Record not found");
			}

			else {
				//Query query=manager.createQuery("from Transaction t where t.walletid="+wallet.getWalletId());
				List<Transaction> list = w.getTransaction();
				return list;
				//return query.getResultList();
			}

		} finally {
			manager.close();
		}
	}

	public List<Transaction> viewTransactionsByDate(LocalDate from, LocalDate to) {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<Transaction> query = null;
		try {
			if (from.equals(null) || to.equals(null)) {
				throw new NullPointerException();
			} else if (from.plusDays(5) == to) {

				query = manager.createQuery(
						"select e from Transaction e where transactionDate between :from and :to", Transaction.class);
				

			} else {
				throw new InvalidInputException("Invalid Transaction period");
			}
		}
			catch(NullPointerException e) {
				e.printStackTrace();
				
			}
		 finally {
			manager.close();
			
		}
		return query.getResultList();

	}

	public List<Transaction> viewAllTransactions(String type) {
		EntityManager manager = factory.createEntityManager();

		try {
			if (type == "null") {

				throw new InvalidInputException("Transaction type cannot be null");

			} else if (type.equalsIgnoreCase("withdraw") || type.equalsIgnoreCase("deposit")) {
				TypedQuery<Transaction> query = manager.createQuery(
						"select e from Transaction e where e.transactionType = 'type' ", Transaction.class);
				return query.getResultList();
			} else {

				throw new InvalidInputException("The transaction type must be withdraw or deposit only");
			}

		} finally {
			manager.close();
		}

	}

}
