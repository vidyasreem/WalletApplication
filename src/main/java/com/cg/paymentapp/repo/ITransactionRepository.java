package com.cg.paymentapp.repo;

import java.time.LocalDate;
import java.util.List;

import com.cg.paymentapp.beans.Transaction;
import com.cg.paymentapp.beans.Wallet;

public interface ITransactionRepository {

	public Transaction addTransaction (Transaction tran);
	public List<Transaction> viewAllTransactions (Wallet wallet);
	public List<Transaction> viewTransactionsByDate(LocalDate from,LocalDate to);
	public List<Transaction> viewAllTransactions(String type);
}
