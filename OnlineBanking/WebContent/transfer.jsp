<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <%@ page import="com.claim.model.*" %>
    <%@ page import="java.util.*" %>
    <% Customer customer = (Customer) session.getAttribute("customer"); %>
    <% Account bankaccount = (Account) session.getAttribute("bankaccount"); %>
    <% ArrayList<Transaction> transactions = (ArrayList<Transaction>)session.getAttribute("accounttransactions"); %>
    <% ArrayList<Customer> customers = (ArrayList<Customer>)session.getAttribute("customers"); %>
<!--
author: W3layouts
author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bank of Everyone</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Bank Card Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />

    <script>
        addEventListener("load", function () {
            setTimeout(hideURLbar, 0);
        }, false);

        function hideURLbar() {
            window.scrollTo(0, 1);
        }
    </script>
	
	<!-- css files -->
    <link href="css/css_slider.css" rel="stylesheet"><!-- Slider css -->
    <link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"><!-- bootstrap css -->
    <link href="css/style.css" rel='stylesheet' type='text/css' /><!-- custom css -->
    <link href="css/font-awesome.min.css" rel="stylesheet"><!-- fontawesome css -->
	<!-- //css files -->
	
	<!-- google fonts -->
	<link href="//fonts.googleapis.com/css?family=Niramit:200,200i,300,300i,400,400i,500,500i,600,600i,700,700i&amp;subset=latin-ext,thai,vietnamese" rel="stylesheet">
	<!-- //google fonts -->
	
</head>
<body>


<!-- header -->
<header>
	<div class="container">
		<!-- nav -->
		<nav class="py-3 d-lg-flex">
			<div id="logo">
<!-- 			<h1> <a href="index.jsp"><span class="fa fa-university"></span> Bank of Everyone </a></h1>-->
				<h1><a href="index3.jsp"><span class="fa fa-university"> Bank of </span><% out.print(customer.getFirstName()); %></a></h1>
			</div>
			<label for="drop" class="toggle"><span class="fa fa-bars"></span></label>
			<input type="checkbox" id="drop" />
			<ul class="menu ml-auto mt-1">
				<li class="active"><a href="index3.jsp">Home</a></li>
				<li class="nav-item dropdown">
				    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Accounts</a>
				    <div class="dropdown-menu">
				      <% for(Account account:customer.getAccounts()){
				    	  out.print("<a class=\"dropdown-item\" href=\"account.jsp?accountnumber="+account.getAccountNumber()+"\">"+account.getAccountType()+" | Acct#: "+account.getAccountNumber()+" | Balance $"+account.getAccountBalance());out.print("</a>");
				      }
				      %>
				    </div>
				 </li>
<!--				<li class=""><a href="services.jsp">Services</a></li>
 				<li class=""><a href="blog.jsp">Blog</a></li>  
				<li class=""><a href="contact.jsp">Contact</a></li>
				<li class=""><a href="openaccount.jsp"><strong>Open New Account</strong></a></li>
				<li class="last-grid"><a href="#">Call Now</a></li> -->
			</ul>
		</nav>
		<!-- //nav -->
	</div>
</header>
<!-- //header -->

<!-- inner-banner -->
<section class="inner-banner" id="home">
	<div class="inner-layer">
		<div class="container">
		</div>
	</div>
</section>
<!-- //inner-banner -->

<!-- breadcrumb -->
<div class="breadcrumb-w3pvt py-0">
	<div class="container py-1">
	<nav aria-label="breadcrumb">
		<ol class="breadcrumb">
			<li class="breadcrumb-item">
				<a href="index3.jsp">Home</a>
			</li>
			<li class="breadcrumb-item" aria-current="page">Transfer</li>
		</ol>
	</nav>
	</div>
</div>
<!-- //breadcrumb -->

<!-- content -->
<section class="container py-2">
	<div class="container py-lg-1">
		<ul class="nav nav-tabs" id="myTab" role="tablist">
		  <li class="nav-item">
		    <a class="nav-link active" id="home-tab" data-toggle="tab" href="#transfer1" role="tab" aria-controls="home" aria-selected="true">Transfer Between Your Accounts</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" id="profile-tab" data-toggle="tab" href="#transfer2" role="tab" aria-controls="profile" aria-selected="false">Transfer to Another Bank Customer</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" id="contact-tab" data-toggle="tab" href="#transfer3" role="tab" aria-controls="contact" aria-selected="false">Transfer Outside to a Customer at Another Bank</a>
		  </li>
		</ul>
		
		<div class="tab-content" id="myTabContent">
		  <div class="tab-pane fade show active" id="transfer1" role="tabpanel" aria-labelledby="transfer1-tab">
		  		<form action="SelfTransferServlet" method="post">
			  		<h4 class="container mb-sm-5 mb-2">Transfer Between Your Accounts</h4>
			  		<div><span>From your account: </span><% out.print(bankaccount.getAccountNumber());%><span> | Balance: $ <% out.print(bankaccount.getAccountBalance());%></span></div>
			  		<div>
			  		<div class="form-group">
					  <label for="sel1">To your account:</label>
					  <select class="form-control" name="transferToAccount" id="sel1">
						<%for(Account account:customer.getAccounts()){if(account.getAccountNumber()!=bankaccount.getAccountNumber()){out.print("<option>"+account.getAccountNumber()+"</option>");}} %>
					  </select>
					</div>
			  		</div>
			  		<div><label for="initialdeposit">Trasnfer Amount</label></div>
		            <div class="form-group input-group mb-3">	
						 <div class="input-group-prepend">
						   <span class="input-group-text">$</span>
						 </div>
						 <input type="text" class="form-control" name="transferamount" id="transferamount" placeholder="Amount to Transfer" data-rule="minlen:1" data-msg="Please enter at least 1 chars" aria-label="Amount (to the nearest dollar)">
					 	 <div class="input-group-append">
						   <span class="input-group-text">.00</span>
						 </div>
						 <div class="validation"></div>
					</div>
		            <button type="submit" class="btn btn-info btn-block btn-round">Transfer Funds</button>
			  	</form>
		  </div>
		  <div class="tab-pane fade" id="transfer2" role="tabpanel" aria-labelledby="transfer2-tab"> 
		  <form action="TransferToCustomerServlet" method="post">
			  		<h4 class="container mb-sm-5 mb-2">Transfer From Your Account to Another Bank Customer</h4>
			  		<div><span>From your account: </span><% out.print(bankaccount.getAccountNumber());%><span> | Balance: $ <% out.print(bankaccount.getAccountBalance());%></span></div>
			  		<div>
			  		<div class="form-group">
					  <label for="sel1">To Customer:</label>
					  <select class="form-control" name="transferToCustomer" id="sel2">
						<%for(Customer tocustomer:customers){out.print("<option>"+tocustomer.getFullName()+"</option>");} %>
					  </select>
					</div>
<!-- remove select customer account, defaulting to first account in a customer -->
			  		</div>
			  		<div><label for="transferamount">Transfer Amount</label></div>
		            <div class="form-group input-group mb-3">	
						 <div class="input-group-prepend">
						   <span class="input-group-text">$</span>
						 </div>
						 <input type="text" class="form-control" name="transferamount" id="transferamount" placeholder="Amount to Transfer" data-rule="minlen:1" data-msg="Please enter at least 1 chars" aria-label="Amount (to the nearest dollar)">
					 	 <div class="input-group-append">
						   <span class="input-group-text">.00</span>
						 </div>
						 <div class="validation"></div>
					</div>
		            <button type="submit" class="btn btn-info btn-block btn-round">Transfer Funds</button>
			  	</form>
		  
		  
		  </div>
		  <div class="tab-pane fade" id="transfer3" role="tabpanel" aria-labelledby="transfer3-tab">
		  	<form action="TransferToExternalCustomerServlet" method="post">
			  		<h4 class="container mb-sm-5 mb-2">Transfer From Your Account to Another Customer at Another Bank</h4>
			  		<div><span>From your account: </span><% out.print(bankaccount.getAccountNumber());%><span> | Balance: $ <% out.print(bankaccount.getAccountBalance());%></span></div>
			  		<div>
					  	<div class="form-group">
							<label for="ToExternalRouter">External Customer Routing Code</label>
		                  	<input type="text" class="form-control" name="ToExternalRouter" id="ToExternalRouter" placeholder="Routing Code for External Customer's Account" data-rule="minlen:10" data-msg="Please enter at least 5 chars" />
		                 	<div class="validation"></div>
		                </div>
						<div class="form-group">
							<label for="ToExternalRouter">External Customer Account Number</label>
		                  	<input type="text" class="form-control" name="ToExternalNumber" id="ToExternalRouter" placeholder="Account Number for External Customer's Account" data-rule="minlen:10" data-msg="Please enter at least 5 chars" />
		                 	<div class="validation"></div>
		                </div>

			  		</div>
			  		<div><label for="transferamount">Transfer Amount</label></div>
		            <div class="form-group input-group mb-3">	
						 <div class="input-group-prepend">
						   <span class="input-group-text">$</span>
						 </div>
						 <input type="text" class="form-control" name="transferamount" id="transferamount" placeholder="Amount to Transfer" data-rule="minlen:1" data-msg="Please enter at least 1 chars" aria-label="Amount (to the nearest dollar)">
					 	 <div class="input-group-append">
						   <span class="input-group-text">.00</span>
						 </div>
						 <div class="validation"></div>
					</div>
		            <button type="submit" class="btn btn-info btn-block btn-round">Transfer Funds</button>
			</form>
		  
		  </div>
		</div>

</section>

<!-- //Content -->

<!-- footer -->
<footer class="footer py-5">
	<div class="container pt-lg-4">
		<div class="row">
			<div class="col-lg-3 col-sm-6 footer-top">
				<h4 class="mb-4 w3f_title">Contact Info</h4>
				<ul class="list-w3">
					<li><span class="fa mr-1 fa-map-marker"></span>2130 Fulton Street, San Diego, CA 94117-1080 USA</li>
					<li class="my-2"><span class="fa mr-1 fa-phone"></span>1-600-1234-567</li>
					<li class="my-2"><span class="fa mr-1 fa-phone"></span>1-600-1234-567</li>
					<li class=""><span class="fa mr-1 fa-envelope"></span><a href="mailto:info@example.com">info@example.com</a></li>
				</ul>
			</div>
			<div class="col-lg-3 col-sm-6 footv3-left mt-sm-0 mt-4">
				<h4 class="mb-4 w3f_title"> Share Holders</h4>
				<ul class="list-w3">
					<li class="my-2">
						<a href="#">
							Shareholders Information
						</a>
					</li>
					<li class="mb-2">
						<a href="#">
							Stock Information
						</a>
					</li>
					<li class="my-2">
						<a href="#">
							Financial Results
						</a>
					</li>
					<li class="my-2">
						<a href="#">
							Investors faq's
						</a>
					</li>
					<li>
						<a href="#">
							Regulatory Section
						</a>
					</li>
				</ul>
			</div>
			<div class="col-lg-2 col-sm-4 mt-lg-0 mt-sm-5 mt-4">
				<h4 class="mb-4 w3f_title">Media Center</h4>
				<ul class="list-w3">
					<li class="my-2">
						<a href="#">
							Press Release
						</a>
					</li>
					<li class="mb-2">
						<a href="#">
							Vision & Values
						</a>
					</li>
					<li class="my-2">
						<a href="#">
							Winning Awards
						</a>
					</li>
					<li class="my-2">
						<a href="#">
							Banking
						</a>
					</li>
				</ul>
			</div>

			<div class="col-lg-2 col-sm-4 mt-lg-0 mt-sm-5 mt-4">
				<h4 class="mb-4 w3f_title">Resources</h4>
				<ul class="list-w3">
					<li class="my-2">
						<a href="#">
							24/7 Help Line
						</a>
					</li>
					<li class="mb-2">
						<a href="#">
							Nearest Branch
						</a>
					</li>
					<li class="my-2">
						<a href="#">
							Guidance
						</a>
					</li>
					<li class="my-2">
						<a href="#">
							Download
						</a>
					</li>
					<li>
						<a href="#">
							Mobile App
						</a>
					</li>
				</ul>
			</div>
			
			<div class="col-lg-2 col-sm-4 mt-lg-0 mt-sm-5 mt-4">
				<h4 class="mb-4 w3f_title">Other Links</h4>
				<ul class="list-w3">
					<li class="my-2">
						<a href="#">
							Careers
						</a>
					</li>
					<li class="mb-2">
						<a href="#">
							All faq's
						</a>
					</li>
					<li class="my-2">
						<a href="#">
							Bank Group
						</a>
					</li>
					<li class="my-2">
						<a href="#">
							Credit Cards
						</a>
					</li>
					<li class="my-2">
						<a href="#">
							Loans
						</a>
					</li>
				</ul>
			</div>
			
		</div>
	</div>
	<!-- //footer bottom -->
</footer>
<!-- //footer -->

<!-- middle -->
<section class="middle py-4">
	<div class="container">
		<p><strong class="mr-2">Our Offerings & Calculators:</strong> Personal loans, Home and car loans, loan calculators, Savings accounts, Credit cards, Insurance.</p>
		<p><strong class="mr-2">Bank Smart:</strong> Internet Banking, Online Banking, Cardless transactions, Fixed deposits, Pin generation, Card active status.</p>
	</div>
</section>
<!-- //middle -->

<!-- copyright -->
<section class="copy-right py-4">
	<div class="container">
		<div class="row">
			<div class="col-lg-7">
				<p class="">© 2019 Bank of Everyone. All rights reserved | Design by
					<a href="http://w3layouts.com"> W3layouts.</a>
				</p>
			</div>
			<div class="col-lg-5 mt-lg-0 mt-3">
				<ul class="list-w3 d-sm-flex">
					<li>
						<a href="#">
							Privicy Policy
						</a>
					</li>
					<li class="mx-sm-4 mx-3">
						<a href="#">
							Terms & Conditions
						</a>
					</li>
					<li>
						<a href="#">
							Disclaimer.
						</a>
					</li>
					<li>
						<a href="#">
						</a>
					</li>
				</ul>
			</div>
		</div>
	</div>
</section>
<!-- //copyright -->

<!-- move top -->
<div class="move-top text-right">
	<a href="#home" class="move-top"> 
		<span class="fa fa-angle-up  mb-3" aria-hidden="true"></span>
	</a>
</div>
<!-- move top -->

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</body>
</html>