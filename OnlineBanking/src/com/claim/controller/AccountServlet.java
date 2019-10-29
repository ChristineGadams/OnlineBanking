package com.claim.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.claim.model.*;

/**
 * Servlet implementation class Account
 */
@WebServlet("/account")
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Bank bank = new Bank();
		HttpSession session = request.getSession(true);
		if(session.getAttribute("bankaccount")!=null) {}session.removeAttribute("bankaccount");
		int accountnumber = Integer.parseInt(request.getParameter("accountnumber"));
		Customer customer = (Customer) session.getAttribute("customer");
		
		Account bankaccount = null;
		for(Account account:customer.getAccounts()){
    		if(accountnumber==account.getAccountNumber()){
    			bankaccount = account;
    		}
    	}
		
		ArrayList<Transaction> accounttransactions=new ArrayList<Transaction>();
		for(Transaction t:bank.getTransactions()) {
			if(bankaccount.getAccountNumber()==t.getFromAccount().getAccountNumber()||bankaccount.getAccountNumber()==t.getToAccount().getAccountNumber()) {
				accounttransactions.add(t);
			}
		}
		

		
		for (int i = 0; i < bank.getCustomers().size(); i++)
		{
			if(customer.getPersonid()==bank.getCustomers().get(i).getPersonid()) {
				customer = bank.getCustomers().get(i);
			}
		}

		session.setAttribute("customer", customer);
		session.setAttribute("bankaccount", bankaccount);
		session.setAttribute("accounttransactions", accounttransactions);
		RequestDispatcher rs = request.getRequestDispatcher("account.jsp");
		rs.forward(request,  response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
