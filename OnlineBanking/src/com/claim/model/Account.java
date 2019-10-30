package com.claim.model;

import java.util.ArrayList;

public abstract class Account implements ITransferSource, ITransferDestination
{
	public int accountNumberCounter = 1;
	int accountNumber = 0;
	private AccountType accountType;
	long accountBalance = 0;



	public int getAccountNumberCounter()
	{
		return accountNumberCounter;
	}

	public void setAccountNumberCounter(int accountNumberCounter)
	{
		this.accountNumberCounter = accountNumberCounter;
	}

	public int getAccountNumber()
	{
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber)
	{
		this.accountNumber = accountNumber;
	}

	public AccountType getAccountType()
	{
		return accountType;
	}

	public void setAccountType(AccountType accountType)
	{
		this.accountType = accountType;
	}

	public long getAccountBalance()
	{
		return accountBalance;
	}

	public void setAccountBalance(long accountBalance)
	{
		this.accountBalance = accountBalance;
	}


}
