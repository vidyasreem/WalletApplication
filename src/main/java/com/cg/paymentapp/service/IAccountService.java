package com.cg.paymentapp.service;

import java.util.List;

import com.cg.paymentapp.beans.BankAccount;
import com.cg.paymentapp.beans.Wallet;
import com.cg.paymentapp.exception.InvalidInputException;

public interface IAccountService {

	public BankAccount addAccount(BankAccount bacc) throws InvalidInputException;

	public BankAccount removeAccount(BankAccount bacc) throws InvalidInputException;

	public BankAccount viewAccount(int accountNo) throws InvalidInputException;

	public List<BankAccount> viewAllAccounts(Wallet wallet);

}
