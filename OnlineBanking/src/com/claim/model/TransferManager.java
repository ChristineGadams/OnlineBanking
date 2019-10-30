package com.claim.model;

import java.io.FileNotFoundException;

public class TransferManager
{
	 
	    
	    public static void Transfer(Bank bank, Customer c, Account s, Customer c2, Account d, Long value, String externalTransferDetails)
	    {
	    	Transaction t = new Transaction(c, s, c2, d, value, externalTransferDetails);
	        s.RemoveFunds(value);
	        bank.AddTransactionToBank(t);
	        d.AddFunds(value);
//	        try
//			{
//				Bank.saveTofilePrintWriter();
//			} catch (FileNotFoundException e)
//			{
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}

	    }

	    
}
