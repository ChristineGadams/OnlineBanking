package com.claim.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Bank
{
	private static final String PATH = "C:\\Users\\mpaul\\Documents\\eclipse-workspace\\FileStorage\\streams\\";
	private  ArrayList<Customer> customers = new ArrayList<Customer>();
	private  ArrayList<Transaction> transactions = new ArrayList<Transaction>();
	public static int personidCounter = 0;
	public static int accountNumberCounter = 0;

	public Bank()
	{
		this.customers = LoadCustomersFromFile();
		this.transactions = LoadTransactionsFromFile();
	}
	
	public void AddCustomerToBank(Customer customer)
	{
		System.out.println(" ");
		customers.add(customer);
	}

	public void AddTransactionToBank(Transaction transaction)
	{
		System.out.println(" ");
		transactions.add(transaction);
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

	public ArrayList<Transaction> getTransactions()
	{
		return transactions;
	}

	public void setTransactions(ArrayList<Transaction> transactions)
	{
		this.transactions = transactions;
	}

	public void saveTofilePrintWriter() throws FileNotFoundException
	{
		PrintWriter out = new PrintWriter(PATH + "bankcustomers.txt");
		out.print(printCustomersToString());
		out.flush();
		out.close();
		
		PrintWriter out2 = new PrintWriter(PATH + "banktransactions.txt");
		out2.print(printTransactionsToString());
		out2.flush();
		out2.close();

	}

	public ArrayList<Customer> LoadCustomersFromFile()
	{
		int personidCounter = 0;
		int accountNumberCounter = 0;
		ArrayList<Customer> tempcustomers = new ArrayList<Customer>();
		Path path = Paths.get(PATH + "bankcustomers.txt");

		// Load Accounts
		try (BufferedReader read = Files.newBufferedReader(path);)
		{
			String line = "";
			while ((line = read.readLine()) != null)
			{

				String[] parsedLine = line.split(":AccountsSplit:");
				String[] customercomponents = parsedLine[0].split(",");
				Customer customer = new Customer(Integer.parseInt(customercomponents[0]), customercomponents[1],
						customercomponents[2], customercomponents[3], customercomponents[4], customercomponents[5],
						Boolean.parseBoolean(customercomponents[6]), customercomponents[7], customercomponents[8], customercomponents[9], customercomponents[10]);
				if (Integer.parseInt(customercomponents[0]) > personidCounter)
				{
					personidCounter = Integer.parseInt(customercomponents[0]) + 1;
				}
				String[] accounts = parsedLine[1].split("Account:");
				for (String account : accounts)
				{
					if (account.isEmpty())
					{
					} else
					{
						String[] accountcomponents = account.split(",");
						if (accountcomponents[1].equals("Checking"))
						{
							CheckingAccount caccount = new CheckingAccount(Integer.parseInt(accountcomponents[0]),
									Integer.parseInt(accountcomponents[2]));
							if (Integer.parseInt(accountcomponents[0]) > accountNumberCounter)
							{
								accountNumberCounter = Integer.parseInt(accountcomponents[0]) + 1;
							}
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

	public ArrayList<Transaction> LoadTransactionsFromFile()
	{
		SimpleDateFormat f = new SimpleDateFormat("MMM dd yyyy HH:mm:ss");
		ArrayList<Transaction> temptransactions = new ArrayList<Transaction>();
		Path path = Paths.get(PATH + "banktransactions.txt");
		Customer customer1 = null;
		Customer customer2 = null;
		Account account1 = null;
		Account account2 = null;

		// Load Accounts
		try (BufferedReader read = Files.newBufferedReader(path);)
		{
			String line = "";
			while ((line = read.readLine()) != null)
			{

				String[] transactioncomponents = line.split(",");
//				String[] transactioncomponents = parsedLine.split(",");
				
				Date tdate = f.parse(transactioncomponents[0]);
				
				for (int i = 0; i < customers.size(); i++)
				{
					if (Integer.parseInt(transactioncomponents[1]) == customers.get(i).getPersonid())
					{
						customer1 = customers.get(i);
					}
					if (Integer.parseInt(transactioncomponents[3]) == customers.get(i).getPersonid())
					{
						customer2 = customers.get(i);
					}
				}
				for (int i = 0; i < customer1.getAccounts().size(); i++)
				{
					if (Integer.parseInt(transactioncomponents[2]) == customer1.getAccounts().get(i).getAccountNumber())
					{
						account1 = customer1.getAccounts().get(i);
					}
				}
				for (int i = 0; i < customer2.getAccounts().size(); i++)
				{
					if (Integer.parseInt(transactioncomponents[4]) == customer2.getAccounts().get(i).getAccountNumber())
					{
						account2 = customer2.getAccounts().get(i);
					}
				}
				Transaction transaction = new Transaction(tdate, customer1,account1, customer2,
												account2,Long.parseLong(transactioncomponents[5]),transactioncomponents[6]);
				temptransactions.add(transaction);
			}

		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temptransactions;

	}

	public String printCustomersToString()
	{
		String stringCustomers = "";
		for (Customer customer : customers)
		{
			stringCustomers += customer.toString() + "\n";
		}
				
		return stringCustomers;
	}
	
	public String printTransactionsToString()
	{

		String stringTransactions = "";
		for (Transaction transaction : transactions)
		{
			stringTransactions += transaction.toString() + "\n";
		}
		
		return stringTransactions;
	}
	
	@Override
	public String toString()
	{
		String stringCustomers = "";
		for (Customer customer : customers)
		{
			stringCustomers += customer.toString() + "\n";
		}
		String stringTransactions = "";
		for (Transaction transaction : transactions)
		{
			stringTransactions += transaction.toString() + "\n";
		}
		
		return stringCustomers+stringTransactions;
	}

}
