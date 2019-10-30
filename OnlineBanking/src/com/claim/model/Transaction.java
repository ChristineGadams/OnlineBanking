package com.claim.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction
{
	private SimpleDateFormat f=new SimpleDateFormat("MMM dd yyyy HH:mm:ss");
	private Date transactiondate;
	private Customer toCustomer;
	private Account toAccount;
	private Customer fromCustomer;
	private Account fromAccount;
	private long amount;
	private String externalTransferDetails;
	
	public Transaction() {
		
	}
	
	public Transaction(Customer toCustomer, Account toAccount, Customer fromCustomer,
			Account fromAccount, long amount, String externalTransferDetails)
	{
		super();
		this.toCustomer = toCustomer;
		this.toAccount = toAccount;
		this.fromCustomer = fromCustomer;
		this.fromAccount = fromAccount;
		this.amount = amount;
		this.transactiondate = new Date();
		this.externalTransferDetails=  externalTransferDetails;
	}
	
	public Transaction(Date date, Customer toCustomer, Account toAccount, Customer fromCustomer,
			Account fromAccount, long amount, String externalTransferDetails)
	{
		super();
		this.toCustomer = toCustomer;
		this.toAccount = toAccount;
		this.fromCustomer = fromCustomer;
		this.fromAccount = fromAccount;
		this.amount = amount;
		this.transactiondate=date;
		this.externalTransferDetails=  externalTransferDetails;
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

	public String getExternalTransferDetails()
	{
		return externalTransferDetails;
	}

	public void setExternalTransferDetails(String externalTransferDetails)
	{
		this.externalTransferDetails = externalTransferDetails;
	}

	@Override
	public String toString()
	{
		return f.format(transactiondate)+","+toCustomer.getPersonid()+","+toAccount.getAccountNumber()+","
				+fromCustomer.getPersonid()+","+fromAccount.getAccountNumber()+","+amount+","+externalTransferDetails;
		
	}
	
	
}
