package com.claim.model;

public abstract class Account implements ITransferSource, ITransferDestination
{
	public int accountNumberCounter=1;
	int accountNumber = 0;
	
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
}
