package com.claim.model;

import java.util.ArrayList;

public class Customer extends Person 
{
	ArrayList<Account> accounts;

	public Customer()
	{
		super();
	}

	public Customer(String firstName, String lastName, String telephoneNumber, String email,
			String password, String street, String city, String state, String zipCode)
	{
		super(firstName, lastName, telephoneNumber, email, password, street, city, state, zipCode);
		this.accounts = new ArrayList<Account>();
		this.personid = (Bank.personidCounter);
		Bank.personidCounter = (this.personid+ 1);
	}
	
	public Customer(int personid, String firstName, String lastName, String telephoneNumber, String email,
			String password, String street, String city, String state, String zipCode)
	{
		super(firstName, lastName, telephoneNumber, email, password, street, city, state, zipCode);
		this.accounts = new ArrayList<Account>();
		this.personid = (personid);
		Bank.personidCounter = (this.personid+ 1);
		
	}

	public ArrayList<Account> getAccounts()
	{
		return accounts;
	}

	public void setAccounts(ArrayList<Account> accounts)
	{
		this.accounts = accounts;
	}

	public void addAccountToAccounts(Account account)
	{
		accounts.add(account);
	}
	
	public String PrintAccounts()
	{
		String stringAccounts=":AccountsSplit:";
		for(Account account:accounts)
		{
			stringAccounts += account.toString();
		}
		return stringAccounts;
	}

	@Override
	public String toString()
	{
		return personid+","+firstName+","+lastName+","+telephoneNumber+","+email+","+password+","+address.toString()+","+PrintAccounts();
		
	}



	
	
}
