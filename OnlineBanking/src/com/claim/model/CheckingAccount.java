package com.claim.model;

public class CheckingAccount extends Account
{
	
	public CheckingAccount(AccountType accountType, long accountBalance)
	{
		super();
		super.setAccountType(AccountType.Checking);
		this.accountBalance = accountBalance;
		this.accountNumber = (Bank.accountNumberCounter);
		Bank.accountNumberCounter=(this.accountNumber+1);


	}
	
	public CheckingAccount(long accountBalance)
	{
		super();
		super.setAccountType(AccountType.Checking);
		this.accountBalance = accountBalance;
		this.accountNumber = (Bank.accountNumberCounter);
		Bank.accountNumberCounter=(this.accountNumber+1);

	}
	public CheckingAccount(int accountNumber,long accountBalance)
	{
		super();
		super.setAccountType(AccountType.Checking);
		this.accountBalance = accountBalance;
		this.accountNumber = (accountNumber);
		Bank.accountNumberCounter=(this.accountNumber+1);

	}
	
	
	@Override
	public void RemoveFunds(long value)
	{
		accountBalance -= value;
		
	}
	@Override
	public void AddFunds(long value)
	{
		accountBalance += value;
		
	}

	@Override
	public String toString()
	{
		return "Account:"+accountNumber+","+this.getAccountType()+","+Long.toString(accountBalance);
		
	}



}
