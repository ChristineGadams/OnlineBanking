package com.claim.model;

public class TransferManager
{
	 
	    
	    public static void Transfer(Customer c, Account s, Customer c2, Account d, Long value)
	    {
	    	Transaction t = new Transaction(c, s, c2, d, value);
	        s.RemoveFunds(value);

	        d.AddFunds(value);

	    }

	    
}
