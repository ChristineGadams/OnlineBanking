package com.claim.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.claim.model.*;

/**
 * Servlet implementation class NewAccountServlet
 */
@WebServlet("/NewAccountServlet")
public class NewAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewAccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Bank bank = new Bank();
		//String firstName, String lastName, String telephoneNumber, String email, String password, String street, String city, String state, String zipCode
		Customer customer = new Customer(request.getParameter("firstname"), request.getParameter("lastname"), request.getParameter("telephone"),
				request.getParameter("email"), request.getParameter("password"), request.getParameter("street"), request.getParameter("city"), request.getParameter("state"), request.getParameter("zip") );
		System.out.println(customer);
		Account account = new CheckingAccount(Long.parseLong(request.getParameter("initialdeposit")));
		customer.addAccountToAccounts(account);
		bank.AddCustomerToBank(customer);
		bank.saveTofilePrintWriter();
		
		HttpSession session = request.getSession(true);
		session.setAttribute("customer", customer);
		
		RequestDispatcher rs = request.getRequestDispatcher("index2.jsp");
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
