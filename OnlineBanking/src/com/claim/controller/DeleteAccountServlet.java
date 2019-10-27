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

import com.claim.model.Account;
import com.claim.model.Bank;
import com.claim.model.Customer;

/**
 * Servlet implementation class DeleteAccountServlet
 */
@WebServlet("/DeleteAccountServlet")
public class DeleteAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		Account account = (Account) session.getAttribute("bankaccount");
		int accountnumber = account.getAccountNumber();
		Customer customer = (Customer) session.getAttribute("customer");
		int personid = customer.getPersonid();
		ArrayList<Account> accounts = customer.getAccounts();
		for (int i = 0; i < accounts.size(); i++)
		{
			if(accounts.get(i).getAccountNumber()==accountnumber) {
				accounts.remove(i);
			}
		}
		Bank bank = new Bank();
		if(accounts.size()!=0) 
		{
			ArrayList<Customer> customers = bank.getCustomers();
			for (int i = 0; i < customers.size(); i++)
			{
				if(personid==customers.get(i).getPersonid())
				{
					customers.set(i, customer);
				}
			}
			bank.saveTofilePrintWriter();
			session.removeAttribute("accountnumber");
			session.setAttribute("customer", customer);
			RequestDispatcher rs = request.getRequestDispatcher("index3.jsp");
			rs.forward(request,  response);
		} else {
			ArrayList<Customer> customers = bank.getCustomers();
			for (int i = 0; i < customers.size(); i++)
			{
				if(personid==customers.get(i).getPersonid())
				{
					customers.remove(i);
				}
			}
			bank.saveTofilePrintWriter();
			session.removeAttribute("accountnumber");
			session.removeAttribute("customer");
			session.removeAttribute("invalidloginmsg");
			RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
			rs.forward(request,  response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
