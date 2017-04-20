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
<div class="container"  style="margin-left:50px">
   
 	<h3 class="panel-title">
          Congratulations !!
          <br> ${order.username} Your Order id ${order.orderId} has been placed successfully !!
    </h3>
    <br><br>
    <h3 class="panel-title">
         We will update the tracking details on ${order.email} and in your mobile ${order.mobile}
    </h3>
    <br>
    <br>
    <h3 class="panel-title">
     Shipment address is: 
        ${order.address}
    </h3>
    <br><br>
    
</div>

</body>
</html>