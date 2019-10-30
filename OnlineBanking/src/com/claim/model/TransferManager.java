package com.claim.model;

import java.io.FileNotFoundException;

public class TransferManager
{

	public static String Transfer(Bank bank, Customer c, Account s, Customer c2, Account d, Long value,
			String externalTransferDetails)
	{
		String transferStatus = "";

		if(s.getAccountType()==AccountType.House) {
			Transaction t = new Transaction(c, s, c2, d, value, externalTransferDetails);
			s.RemoveFunds(value);
			bank.AddTransactionToBank(t);
			d.AddFunds(value);
			transferStatus = "success";
		}else {
			
			if(c.getOverdraftProtect()==false) {
				if (s.getAccountBalance() - value > 0) {
					Transaction t = new Transaction(c, s, c2, d, value, externalTransferDetails);
					s.RemoveFunds(value);
					bank.AddTransactionToBank(t);
					d.AddFunds(value);
					transferStatus = "success";
				}else if (s.getAccountBalance() - value > -500) {
					Transaction t = new Transaction(c, s, c2, d, value, externalTransferDetails);
					s.RemoveFunds(value);
					bank.AddTransactionToBank(t);
					d.AddFunds(value);
					
					Transaction t2 = new Transaction(c, s, bank.getCustomers().get(1), bank.getCustomers().get(1).getAccounts().get(0),c.getTransactionFee(), "Overdraft Fee");
					s.RemoveFunds(c.getTransactionFee());
					bank.AddTransactionToBank(t2);
					d.AddFunds(c.getTransactionFee());
					transferStatus = "success";
				}else {
					transferStatus = "failed";
				}
			}else {
				if (s.getAccountBalance() - value > -500) {
					Transaction t = new Transaction(c, s, c2, d, value, externalTransferDetails);
					s.RemoveFunds(value);
					bank.AddTransactionToBank(t);
					d.AddFunds(value);
					transferStatus = "success";
				}else {
					transferStatus = "failed";
				}
				
			}
		}
	



	return transferStatus;
}

}
