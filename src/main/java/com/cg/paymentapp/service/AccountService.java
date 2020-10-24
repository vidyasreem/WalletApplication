package com.cg.paymentapp.service;

import java.util.List;

import com.cg.paymentapp.beans.BankAccount;
import com.cg.paymentapp.beans.Wallet;
import com.cg.paymentapp.exception.InvalidInputException;
import com.cg.paymentapp.repo.AccountRepository;
import com.cg.paymentapp.repo.IAccountRepository;

public class AccountService implements IAccountService {
	private IAccountRepository repo;

	public AccountService() {
		repo = new AccountRepository();
	}

	public BankAccount addAccount(BankAccount bacc) throws InvalidInputException {

		return repo.addAccount(bacc);
	}

	public BankAccount removeAccount(BankAccount bacc) throws InvalidInputException{
		return repo.removeAccount(bacc);
	}

	public BankAccount viewAccount(int accountNo) throws InvalidInputException {
		return repo.viewAccount(accountNo);
	}

	public List<BankAccount> viewAllAccounts(Wallet wallet) {
		return repo.viewAllAccounts(wallet);
	}

}
