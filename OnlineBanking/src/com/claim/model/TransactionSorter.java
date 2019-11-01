package com.claim.model;

import java.util.ArrayList;
import java.util.Collections;

public class TransactionSorter
{
	  ArrayList<Transaction> transaction = new ArrayList<>();  
	  
	  public TransactionSorter(ArrayList<Transaction> transactions) {         
	    this.transaction = transactions;     
	  }
	  
	  public ArrayList<Transaction> getSortedTransactionByDate() {         
		    Collections.sort(transaction, Transaction.tDateComparator);         
		    return transaction;     
		  }  
	  
}
