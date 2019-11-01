package com.claim.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.claim.model.Account;
import com.claim.model.Bank;
import com.claim.model.Customer;
import com.claim.model.Transaction;

/**
 * Servlet implementation class MonthlyStatementModal
 */
@WebServlet("/MonthlyStatementModal")
public class MonthlyStatementModal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MonthlyStatementModal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String month = request.getParameter("statementmonth");
		String year = request.getParameter("statementyear");
		ArrayList<Transaction> accounttransactions=(ArrayList<Transaction>) session.getAttribute("accounttransactions");
		
		
		Bank bank = new Bank();
		Customer sessioncustomer = (Customer) session.getAttribute("customer");
		
		Customer customer=null;
		for (int i = 0; i < bank.getCustomers().size(); i++)
		{
			if(sessioncustomer.getPersonid()==bank.getCustomers().get(i).getPersonid()) {
				customer = bank.getCustomers().get(i);
			}
		}
		
		Account sessionaccount = (Account) session.getAttribute("bankaccount");
		Account account=null;
		for (int i = 0; i < customer.getAccounts().size(); i++)
		{
			if(sessionaccount.getAccountNumber()==customer.getAccounts().get(i).getAccountNumber()) {
				account = customer.getAccounts().get(i);
			}
		}
		

		
		
		//create statement file
		String filePath = account.createMonthlyStatement(accounttransactions, month, year, customer, account);
		
		// reads input file from an absolute path
//        String filePath = "C:\\Users\\mpaul\\Documents\\eclipse-workspace\\FileStorage\\phonebook.txt";
        File downloadFile = new File(filePath);
        FileInputStream inStream = new FileInputStream(downloadFile);
         
        // if you want to use a relative path to context root:
//        String relativePath = getServletContext().getRealPath("");
//        System.out.println("relativePath = " + relativePath);
         
        // obtains ServletContext
        ServletContext context = getServletContext();
         
        // gets MIME type of the file
        String mimeType = context.getMimeType(filePath);
        if (mimeType == null) {        
            // set to binary type if MIME mapping not found
            mimeType = "application/octet-stream";
        }
        System.out.println("MIME type: " + mimeType);
         
        // modifies response
        response.setContentType(mimeType);
        response.setContentLength((int) downloadFile.length());
         
        // forces download
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
        response.setHeader(headerKey, headerValue);
         
        // obtains response's output stream
        OutputStream outStream = response.getOutputStream();
         
        byte[] buffer = new byte[4096];
        int bytesRead = -1;
         
        while ((bytesRead = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }
         
        inStream.close();
        outStream.close();  
		
		
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


