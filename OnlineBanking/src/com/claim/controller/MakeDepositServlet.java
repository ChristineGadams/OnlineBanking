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
import com.claim.model.TransferManager;

/**
 * Servlet implementation class MakeDepositServlet
 */
@WebServlet("/MakeDepositServlet")
public class MakeDepositServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MakeDepositServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		Bank bank = new Bank();
		Account account = (Account) session.getAttribute("bankaccount");
		Customer customer = (Customer) session.getAttribute("customer");
		long amount = Long.parseLong(request.getParameter("deposit"));
		TransferManager.Transfer(bank.getCustomers().get(0), bank.getCustomers().get(0).getAccounts().get(0), customer, account, amount);
		
			bank.saveTofilePrintWriter();

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
