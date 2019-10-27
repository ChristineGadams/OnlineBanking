package com.claim.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Bank
{
	private static final String PATH = "C:\\Users\\mpaul\\Documents\\eclipse-workspace\\FileStorage\\streams\\";
	private ArrayList<Customer> customers = new ArrayList<Customer>();
	public static int personidCounter = 0;
	public static int accountNumberCounter=0;
	
	public Bank()
	{
		this.customers = LoadCustomersFromFile();
	}
	
	
	public void AddCustomerToBank(Customer customer)
	{
		System.out.println(" ");
		customers.add(customer);
	}

	
	public int getPersonidCounter()
	{
		return personidCounter;
	}


	public void setPersonidCounter(int personidCounter)
	{
		this.personidCounter = personidCounter;
	}


	public int getAccountNumberCounter()
	{
		return accountNumberCounter;
	}


	public void setAccountNumberCounter(int accountNumberCounter)
	{
		this.accountNumberCounter = accountNumberCounter;
	}


	public ArrayList<Customer> getCustomers()
	{
		return customers;
	}


	public void setCustomers(ArrayList<Customer> customers)
	{
		this.customers = customers;
	}


	public void saveTofilePrintWriter() throws FileNotFoundException
	{
		PrintWriter out = new PrintWriter(PATH + "bank.txt");
		out.print(this.toString());
		out.flush();
		out.close();
	
	}
	
	public ArrayList<Customer> LoadCustomersFromFile()
	{
		int personidCounter = 0;
		int accountNumberCounter=0;
		ArrayList<Customer> tempcustomers = new ArrayList<Customer>();
		Path path = Paths.get(PATH + "bank.txt");
		
		try (BufferedReader read = Files.newBufferedReader(path);)
		{
			String line="";
			while ((line = read.readLine())!=null)
			{
				
				String[] parsedLine = line.split(":AccountsSplit:");
				String[] customercomponents = parsedLine[0].split(",");
				Customer customer = new Customer(Integer.parseInt(customercomponents[0]), customercomponents[1],customercomponents[2], customercomponents[3], customercomponents[4],customercomponents[5], customercomponents[6], customercomponents[7], customercomponents[8], customercomponents[9]);
				if(Integer.parseInt(customercomponents[0])>personidCounter) {personidCounter=Integer.parseInt(customercomponents[0])+1;}
				String[] accounts = parsedLine[1].split("Account:");
				for(String account:accounts)
				{
					if(account.isEmpty())
						{
						}
					else 
						{
							String[] accountcomponents = account.split(",");
							if (accountcomponents[1].equals("Checking"))
								{
									CheckingAccount caccount = new CheckingAccount(Integer.parseInt(accountcomponents[0]),Integer.parseInt(accountcomponents[2]));
									if(Integer.parseInt(accountcomponents[0])>accountNumberCounter) {accountNumberCounter=Integer.parseInt(accountcomponents[0])+1;}
									customer.addAccountToAccounts(caccount);
								}
						}
				}
				tempcustomers.add(customer);
			}
			
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tempcustomers;
		
	}
	
	
	@Override
	public String toString()
	{
		String stringCustomers="";
		for(Customer customer:customers)
		{
			stringCustomers += customer.toString()+"\n";
		}
		return stringCustomers;
	}
	
	
}
