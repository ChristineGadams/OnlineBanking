<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <%@ page import="com.claim.model.*" %>
    <%@ page import="java.util.*" %>
    <% Customer customer = (Customer) session.getAttribute("customer"); %>
    <% Account bankaccount = (Account) session.getAttribute("bankaccount"); %>
    <% ArrayList<Transaction> transactions = (ArrayList<Transaction>)session.getAttribute("accounttransactions"); %>
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
				<h1><a href="index3.jsp"><span class="fa fa-university"> Bank of <Strong><% out.print(" "+customer.getFirstName()); %></Strong></a></h1>
			</div>
			<label for="drop" class="toggle"><span class="fa fa-bars"></span></label>
			<input type="checkbox" id="drop" />
			<ul class="menu ml-auto mt-1">
				<li class=""><a href="index3.jsp">Home</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" style="display: inline; color: #fff;" data-toggle="dropdown" href="#"
						role="button" aria-haspopup="true" aria-expanded="false">Accounts</a>
						<div class="dropdown-menu" >
							<%
								for (Account account : customer.getAccounts())
								{
									out.print("<a class=\"dropdown-item\" href=\"account?accountnumber=" + account.getAccountNumber()
											+ "\">" + account.getAccountType() + " | Acct#: " + account.getAccountNumber() + " | Balance $"
											+ account.getAccountBalance());
									out.print("</a>");
								}
							%>
						</div></li>
					<li class=""><a href="profile.jsp">Profile</a></li>
					<li class=""><a href="signout">Signout</a></li>
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
			<li class="breadcrumb-item" aria-current="page">Account Detail</li>
		</ol>
	</nav>
	</div>
</div>
<!-- //breadcrumb -->

<!-- content -->


<section class="container py-1">
	<div class="container2 py-lg-1">
		<h3 class="container2 mb-sm-1 mb-1">Your Account Details</h3>
		<div class="row">
			<div class="col-lg-4 col-md-6 py-1"><h5 class="w3f_title my-1">Account Type: <%out.print(bankaccount.getAccountType()); %> </h5></div>
			<div class="col-lg-4 col-md-6 py-1"><h5 class="w3f_title my-1">Account Number: <%out.print(bankaccount.getAccountNumber()); %> </h5>
			</div>
			<div class="col-lg-4 col-md-6 py-1"><h5 class="w3f_title my-1">Account Type: $  <%out.print(bankaccount.getAccountBalance()); %> </h5></div>
			
		</div>
	</div>
</section>

<!-- Action Buttons  -->
<section class="container">
<nav class="navbar navbar-expand-lg mx-md-auto navbar-light">
<!--   <a class="navbar-brand" href="#">Navbar</a> -->
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav1" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav1">
    <ul class="navbar-nav ">
      <li class="nav-item active mx-1">
        <button type="button" class="btn btn-info btn-round" data-toggle="modal" data-target="#makeDepositModal">Make Deposit</button>
      </li>
      <li class="nav-item mx-1">
       <button type="button" class="btn btn-info btn-round" data-toggle="modal" data-target="#withdrawalModal">Withdrawal</button>
      </li>
      <li class="nav-item mx-1" >
      	<a href="transfer" class="btn btn-info btn-round" type="button" id="transferbutton" style="color: #fff;">Transfer Funds</a>
      </li>
      <li class="nav-item mx-1">
       <button type="button" class="btn btn-info btn-round" data-toggle="modal" data-target="#MonthlyStatementModal">Get Monthly Statement</button>
      </li>
      <li class="nav-item mx-1">
       <button type="button" class="btn btn-info btn-round" data-toggle="modal" data-target="#orderChecksModal">Order Checks</button>
      </li>
      <li class="nav-item mx-1">
        <button type="button" class="btn btn-info btn-round" data-toggle="modal" data-target="#DeleteAccountModal">Close Account</button>
      </li>
    </ul>
  </div>
</nav>	
</section>
	


<!-- //Nav  -->
<hr>
<section class="container py-2">
	<div class="container py-lg-1">
		<h4 class="container mb-sm-5 mb-2">Account Transaction Details for the Past 30 Days</h4>
	</div>
		<div class="table-responsive">
		  <table class="table">
		    <thead>
		    <tr>
		      <th scope="col">Transaction Date</th><th scope="col">From</th><th scope="col">Account</th><th scope="col">To Customer</th><th scope="col">To Account</th><th scope="col">Amount</th><th scope="col">Description</th>
		    </tr>
		  </thead>
		  <tbody>
			<% 
			Date date = new Date();
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			c.add(Calendar.DATE, -31);
			Date thirtydaysago = c.getTime();
			for(Transaction t:transactions){
				long tamount=0;
				if(t.getFromAccount().getAccountNumber()==2||t.getToAccount().getAccountNumber()==bankaccount.getAccountNumber()){tamount = -t.getAmount();}else{tamount = t.getAmount();}

				if(t.getTransactiondate().after(thirtydaysago))
				{
					out.print("<tr><td>"+t.getTransactiondate()+"</td>"
								+"<td>"+t.getToCustomer().getFullName()+"</td>"
								+"<td>"+t.getToAccount().getAccountNumber()+"</td>"
								+"<td>"+t.getFromCustomer().getFullName()+"</td>"
								+"<td>"+t.getFromAccount().getAccountNumber()+"</td>"
								+"<td>"+tamount+"</td>"
								+"<td>"+t.getExternalTransferDetails()+"</td>"
								+"</tr>");
				}
			}
			
			%>

		
		  </tbody>
		 </table>
		 </div>
</section>

<!-- //content -->

<!-- Make Deposit Modal -->
<div class="modal fade" id="makeDepositModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header border-bottom-0">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <div class="form-title text-center">
          <h4>Make A Depost</h4>
        </div>
        <div class="d-flex flex-column text-center">
          <form action="MakeDepositServlet" method="post">
            <div class="form-group">
            <label for="accountnumber">Account Number</label>
              <input type="text" name="accountnumber" class="form-control" id="accountnumber" value=<%out.print(bankaccount.getAccountNumber());%> readonly>
            </div>
            <div><label for="initialdeposit">Deposit Amount</label></div>
            <div class="form-group input-group mb-3">	
				 <div class="input-group-prepend">
				   <span class="input-group-text">$</span>
				 </div>
				 <input type="text" class="form-control" name="deposit" id="deposit" placeholder="Your Deposit Amount" data-rule="minlen:1" data-msg="Please enter at least 1 chars" aria-label="Amount (to the nearest dollar)">
			 	 <div class="input-group-append">
				   <span class="input-group-text">.00</span>
				 </div>
				 <div class="validation"></div>
			</div>
            <button type="submit" class="btn btn-info btn-block btn-round">Make Deposit</button>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>
<!-- //Make Deposit Modal -->

<!-- Withdrawal Modal -->
<div class="modal fade" id="withdrawalModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header border-bottom-0">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <div class="form-title text-center">
          <h4>Withdraw Cash</h4>
        </div>
        <div class="d-flex flex-column text-center">
          <form action="WithdrawalServlet" method="post">
            <div class="form-group">
            <label for="accountnumber">Account Number</label>
              <input type="text" name="accountnumber" class="form-control" id="accountnumber" value=<%out.print(bankaccount.getAccountNumber());%> readonly>
            </div>
            <div><label for="initialdeposit">Cash Amount</label></div>
            <div class="form-group input-group mb-3">	
				 <div class="input-group-prepend">
				   <span class="input-group-text">$</span>
				 </div>
				 <input type="text" class="form-control" name="deposit" id="deposit" placeholder="Your Deposit Amount" data-rule="minlen:1" data-msg="Please enter at least 1 chars" aria-label="Amount (to the nearest dollar)">
			 	 <div class="input-group-append">
				   <span class="input-group-text">.00</span>
				 </div>
				 <div class="validation"></div>
			</div>
            <button type="submit" class="btn btn-info btn-block btn-round">Withdraw Cash</button>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>
<!-- //Withdrawal Modal -->


<!-- Delete Account Modal -->
<div class="modal fade" id="DeleteAccountModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header border-bottom-0">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <div class="form-title text-center">
          <h4>Close/Delete Bank Account</h4>
        </div>
        <div class="d-flex flex-column text-center">
          <form action="DeleteAccountServlet" method="post">
            <div class="form-group">
              <input type="text" name="accountnumber" class="form-control" id="accountnumber" value=<%out.print(bankaccount.getAccountNumber());%> readonly>
            </div>
            <button type="submit" class="btn btn-info btn-block btn-round">Are you sure?</button>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>
<!-- //Delete Account Modal -->

<!-- Order Checks Modal -->
<div class="modal fade" id="orderChecksModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header border-bottom-0">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <div class="form-title text-center">
          <h4>Order Checks</h4>
        </div>
        <div class="d-flex flex-column text-center">
          <form action="OrderChecksServlet" method="post">
            <div class="form-group">
            	<label for="accountnumber">Account Number</label>
              <input type="text" name="accountnumber" class="form-control" id="accountnumber" value=<%out.print(bankaccount.getAccountNumber());%> readonly>
            </div>
            <div><label for="startingCheck">Starting Check Number</label></div>
            <input type="text" class="form-control" name="startingCheck" id="startingCheck" placeholder="Starting Check Number" data-rule="minlen:1" data-msg="Please enter at least 1 chars" aria-label="Amount (to the nearest dollar)" required>
             <div class="form-group">
			    <label for="exampleFormControlSelect2">Select Check Style</label>
			    <select name="checkStyle" multiple class="form-control" id="exampleFormControlSelect2" required>
			      <option>Batman</option>
			      <option>Celebrate Earth</option>
			      <option>Gone with the Wind</option>
			      <option>Looney Tunes</option>
			      <option>Pebbles</option>
			      <option>Scooby-Doo Mystery Inc</option>
			      <option>Superman</option>
			      <option>Taz</option>
			      <option>The Flintstones</option>
			      <option>The Hobbit</option>
			      <option>The Wizard of Oz</option>
			      <option>Tom and Jerry</option>
			    </select>
		  	</div>
			<a href="./images/warner.png" class="img-fluid" target="_blank"><img src="./images/warner.png" class="img-fluid" alt="Responsive image"></a>
            <button type="submit" class="btn btn-info btn-block btn-round">Order More Checks</button>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>
<!-- //Order Checks Modal -->

<!-- Monthly Statement Modal -->
<div class="modal fade" id="MonthlyStatementModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header border-bottom-0">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <div class="form-title text-center">
          <h4>Monthly Statement</h4>
        </div>
        <div class="d-flex flex-column text-center">
          <form action="MonthlyStatementModal" id="monthlystatementmodal" method="post">
            <div class="form-group">
            	<label for="accountnumber">For Account Number</label>
              <input type="text" name="accountnumber" class="form-control" id="accountnumber" value=<%out.print(bankaccount.getAccountNumber());%> readonly>
            </div>
            <div class="form-group">
			    <label for="exampleFormControlSelect2">Year</label>
			    <select name="statementyear" multiple class="form-control" id="statementYear" required>
			      <option>2019</option>
			    </select>
			 </div>
             <div class="form-group">
			    <label for="exampleFormControlSelect2">Month</label>
			    <select name="statementmonth" multiple class="form-control" id="statementMonth" required>
			      <option>Jan</option>
			      <option>Feb</option>
			      <option>Mar</option>
			      <option>Apr</option>
			      <option>May</option>
			      <option>Jun</option>
			      <option>Jul</option>
			      <option>Aug</option>
			      <option>Sep</option>
			      <option>Oct</option>
			      <option>Nov</option>
			      <option>Dec</option>
			    </select>
		  	</div>
			
            <button type="submit" id="statementmodalsubmit" class="btn btn-info btn-block btn-round">Get Statement</button>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>
<!-- //MOnthly Statement Modal -->

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
<script type="text/javascript">
$('#statementmodalsubmit').on('click', function(e){
    e.preventDefault();
    $('#MonthlyStatementModal').modal('toggle'); //or  $('#IDModal').modal('hide');
    $('#monthlystatementmodal').submit();
});
</script>
<script type="text/javascript">
$(document).ready(function(){
    $("#makeDepositModal").on('shown.bs.modal', function(){
        $(this).find('#deposit').focus();
    });
    $("#withdrawalModal").on('shown.bs.modal', function(){
        $(this).find('#deposit').focus();
    });
    $("#orderChecksModal").on('shown.bs.modal', function(){
        $(this).find('#startingCheck').focus();
    });
    $("#MonthlyStatementModal").on('shown.bs.modal', function(){
        $(this).find('#statementYear').focus();
    });
});
</script>


</body>
</html>