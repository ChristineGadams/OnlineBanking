package com.claim.model;

import java.util.Date;

public class Transaction
{

	Date transactiondate = new Date();
	Customer toCustomer;
	Account toAccount;
	Customer fromCustomer;
	Account fromAccount;
	long amount;
	
	public Transaction(Customer toCustomer, Account toAccount, Customer fromCustomer,
			Account fromAccount, long amount)
	{
		super();
		this.toCustomer = toCustomer;
		this.toAccount = toAccount;
		this.fromCustomer = fromCustomer;
		this.fromAccount = fromAccount;
		this.amount = amount;
	}
	
	public Transaction(Date date, Customer toCustomer, Account toAccount, Customer fromCustomer,
			Account fromAccount, long amount)
	{
		super();
		this.toCustomer = toCustomer;
		this.toAccount = toAccount;
		this.fromCustomer = fromCustomer;
		this.fromAccount = fromAccount;
		this.amount = amount;
	}

	public Date getTransactiondate()
	{
		return transactiondate;
	}

	public void setTransactiondate(Date transactiondate)
	{
		this.transactiondate = transactiondate;
	}

	public Customer getToCustomer()
	{
		return toCustomer;
	}

	public void setToCustomer(Customer toCustomer)
	{
		this.toCustomer = toCustomer;
	}

	public Account getToAccount()
	{
		return toAccount;
	}

	public void setToAccount(Account toAccount)
	{
		this.toAccount = toAccount;
	}

	public Customer getFromCustomer()
	{
		return fromCustomer;
	}

	public void setFromCustomer(Customer fromCustomer)
	{
		this.fromCustomer = fromCustomer;
	}

	public Account getFromAccount()
	{
		return fromAccount;
	}

	public void setFromAccount(Account fromAccount)
	{
		this.fromAccount = fromAccount;
	}

	public long getAmount()
	{
		return amount;
	}

	public void setAmount(long amount)
	{
		this.amount = amount;
	}

	@Override
	public String toString()
	{
		return "Transaction:"+transactiondate+","+toCustomer.getPersonid()+","+toAccount.getAccountNumber()+","+fromCustomer.getPersonid()+","+fromAccount.getAccountNumber()+","+amount;
		
	}
	
	
}