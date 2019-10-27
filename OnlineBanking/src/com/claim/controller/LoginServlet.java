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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Bank bank = new Bank();
		Customer customer=null;
		String loginemail = request.getParameter("loginemail");
		String loginpassword = request.getParameter("loginpassword");
		ArrayList<Customer> customers = bank.getCustomers();
		for (int i = 0; i < customers.size(); i++)
		{
			if(customers.get(i).getEmail().equalsIgnoreCase(loginemail)&&customers.get(i).getPassword().equalsIgnoreCase(loginpassword))
			{
				customer = customers.get(i);
			}
		}
		
		
		HttpSession session = request.getSession(true);
		if(customer!=null) 
		{
		session.setAttribute("customer", customer);
		
		RequestDispatcher rs = request.getRequestDispatcher("index3.jsp");
		rs.forward(request,  response);
		}else {
			String invalidloginmsg = "Sorry your login failed, please try again.";
			session.setAttribute("invalidloginmsg", invalidloginmsg);
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
