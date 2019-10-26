package com.claim.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

import com.claim.model.*;

public class SaveorLoadBank
{
	private static final String PATH = "C:\\Users\\mpaul\\Documents\\eclipse-workspace\\FileStorage\\streams\\";

	public static void SaveBankToFile(Bank bank)
	{
		Path path = Paths.get(PATH + "bank.txt");
		try (BufferedWriter writer = Files.newBufferedWriter(path, StandardOpenOption.CREATE,
				StandardOpenOption.WRITE);)
		{
			writer.write(bank.toString());
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void LoadBankFromFile()
	{
		Bank b1 = new Bank();
		Path path = Paths.get(PATH + "bank.txt");
		
		try (BufferedReader read = Files.newBufferedReader(path);)
		{
			while (read.readLine()!=null)
			{
				String line =read.readLine().substring(1, read.readLine().length()-1);
				String[] parsedLine = read.readLine().split(",[");
				String[] customercomponents = parsedLine[0].split(",");
				Customer customer = new Customer(Integer.parseInt(customercomponents[0]), customercomponents[1],customercomponents[2], customercomponents[3], customercomponents[4],customercomponents[5], customercomponents[6], customercomponents[7], customercomponents[8], customercomponents[9]);
				String[] accounts = parsedLine[1].split("Account:");
				for(String account:accounts)
				{
					String[] accountcomponents = account.split(",");
					if(accountcomponents[2].equals("Checking"))
					{
						CheckingAccount caccount = new CheckingAccount(Integer.parseInt(accountcomponents[3]));
						caccount.setAccountNumber(Integer.parseInt(accountcomponents[0]));
						customer.addAccountToAccounts(caccount);
					}
					b1.AddCustomerToBank(customer);	
				}
				
			}
			
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
}
