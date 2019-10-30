package com.claim.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.claim.model.Bank;
import com.claim.model.Customer;

/**
 * Servlet implementation class ProfileUpdateServlet
 */
@WebServlet("/ProfileUpdateServlet")
public class ProfileUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Bank bank = new Bank();
		HttpSession session = request.getSession(true);
		Customer sessioncustomer = (Customer) session.getAttribute("customer");
		Customer customer=null;
		for (int i = 0; i < bank.getCustomers().size(); i++)
		{
			if(sessioncustomer.getPersonid()==bank.getCustomers().get(i).getPersonid()) {
				customer = bank.getCustomers().get(i);
			}
		}
		String fname = request.getParameter("firstname");
		if(fname!="") {customer.setFirstName(fname);}
		String lname = request.getParameter("lastname");
		if(lname!="") {customer.setLastName(lname);}
		String telephone = request.getParameter("telephone");
		if(telephone!="") {customer.setTelephoneNumber(telephone);}
		String email = request.getParameter("email");
		if(email!="") {customer.setEmail(email);}
		String password= request.getParameter("password");
		if(password!="") {customer.setPassword(password);}
		String street = request.getParameter("street");
		if(street!="") {customer.getAddress().setStreet(street);}
		String city = request.getParameter("city");
		if(city!="") {customer.getAddress().setCity(city);}
		String state = request.getParameter("state");
		if(state!="") {customer.getAddress().setState(state);}
		String zip = request.getParameter("zip");
		if(zip!="") {customer.getAddress().setZipCode(zip);}
		boolean overdraftProtection = Boolean.parseBoolean(request.getParameter("overdraftProtection"));
		if(overdraftProtection!=customer.getOverdraftProtect()) {customer.setOverdraftProtection(overdraftProtection);}
		
		bank.saveTofilePrintWriter();
		
		session.setAttribute("customer", customer);
		RequestDispatcher rs = request.getRequestDispatcher("profile.jsp");
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
