package com.claim.model;

import java.sql.Date;

public class Transaction
{
	Date transactiondate;
	Customer toCustomer;
	Account toAccount;
	Customer fromCustomer;
	Account fromAccount;
	long amount;
}
