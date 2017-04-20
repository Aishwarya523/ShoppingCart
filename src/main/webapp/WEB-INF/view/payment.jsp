<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>  
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="menubar.jsp" %>
<html>
<head>
<style>
	
	.panel-title {display: inline;font-weight: bold;}
	.checkbox.pull-right { margin: 0; }
	.pl-ziro { padding-left: 0px; }
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment</title>
</head>
<body >
<div class="container"  style="margin-left:450px">
   
 	<h3 class="panel-title">
          Name: ${order.username}
    </h3>
    &nbsp;&nbsp;&nbsp;
    <h3 class="panel-title">
         Email: ${order.email}
    </h3>
    &nbsp;&nbsp;&nbsp;
    <h3 class="panel-title">
         Mobile: ${order.mobile}
    </h3>
    <br>
    <br>
    <h3 class="panel-title">
        Address: ${order.address}
    </h3>
    <br><br>
    <div class="row" >
   
        <div class="col-xs-12 col-md-4">
            <div class="panel panel-default" >
                <div class="panel-heading">
                    <h3 class="panel-title">
                        Payment Details
                    </h3>
                    <div class="checkbox pull-right">
                        <label>
                            <input type="checkbox" />
                            Remember
                        </label>
                    </div>
                </div>
                <div class="panel-body">
                    <form role="form">
                    <div class="form-group">
                        <label for="cardNumber">
                            CARD NUMBER</label>
                        <div class="input-group">
                            <input type="text" class="form-control" id="cardNumber" placeholder="Valid Card Number"
                                required autofocus />
                            <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-7 col-md-7">
                            <div class="form-group">
                                <label for="expityMonth">
                                    EXPIRY DATE</label>
                                <div class="col-xs-6 col-lg-6 pl-ziro">
                                    <input type="text" class="form-control" id="expityMonth" placeholder="MM" required />
                                </div>
                                <div class="col-xs-6 col-lg-6 pl-ziro">
                                    <input type="text" class="form-control" id="expityYear" placeholder="YY" required /></div>
                            </div>
                        </div>
                        <div class="col-xs-5 col-md-5 pull-right">
                            <div class="form-group">
                                <label for="cvCode">
                                    CV CODE</label>
                                <input type="password" class="form-control" id="cvCode" placeholder="CV" required />
                            </div>
                        </div>
                    </div>
                    </form>
                </div>
            </div>
            <ul class="nav nav-pills nav-stacked">
                <li class="active"><a href="#"><span class="badge pull-right">&#x20B9;${order.amount}</span> Final Payment</a>
                </li>
            </ul>
            <br/>
            <form:form name="payNow" action="paymentConfirm?order=${order}" method="POST">
                <input type="hidden" name="username" value="${order.username}"/>
                <input type="hidden" name="amount" value="${order.amount}"/>
                <input type="hidden" name="mobile" value="${order.mobile}"/>
                <input type="hidden" name="email" value="${order.email}"/>
                <input type="hidden" name="address" value="${order.address}"/>
            	<a href="javascript:document.payNow.submit()" class="btn btn-success btn-lg btn-block" role="button">Pay</a>
            </form:form>
        </div>
    </div>
</div>

</body>
</html>