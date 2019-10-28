package com.claim.model;

import java.io.FileNotFoundException;

public class TransferManager
{
	 
	    
	    public static void Transfer(Customer c, Account s, Customer c2, Account d, Long value)
	    {
	    	Transaction t = new Transaction(c, s, c2, d, value);
	        s.RemoveFunds(value);
//	        Bank.AddTransactionToBank(t);
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
