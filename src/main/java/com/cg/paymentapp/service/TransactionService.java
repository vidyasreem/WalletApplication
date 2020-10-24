package com.cg.paymentapp.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.paymentapp.beans.Transaction;
import com.cg.paymentapp.beans.Wallet;
import com.cg.paymentapp.repo.ITransactionRepository;
import com.cg.paymentapp.repo.TransactionRepository;

public class TransactionService implements ITransactionService {
	
	private ITransactionRepository repo ;
	
	public TransactionService() {
		repo = new TransactionRepository();
	}
	public Transaction addTransaction(Transaction tran) {
		
		return repo.addTransaction(tran);
	}

	public List<Transaction> viewAllTransactions(Wallet wallet) {
		
		return repo.viewAllTransactions(wallet);
	}

	public List<Transaction> viewTransactionsByDate(LocalDate from, LocalDate to) {
		
		return repo.viewTransactionsByDate(from, to);
	}

	public List<Transaction> viewAllTransactions(String type) {
		
		return repo.viewAllTransactions(type);
	}

}
