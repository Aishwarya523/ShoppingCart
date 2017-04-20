<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ include file="menubar.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Supplier_ShoopingCart</title>
</head>
<script type="text/javascript">
function editsupplier(id,name,phonenumber,address){
	
	document.getElementById("Id").value=id;
	document.getElementById("Name").value=name;
	document.getElementById("PhoneNumber").value=phonenumber;
	document.getElementById("Address").value=address;
	
}
</script>
<body>
<br><br>
<form action="supplier" method="post" id="opeation">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Id:<input type="text" name="id" id="Id">

Name:<input type="text" name="name" id="Name">

PhoneNumber:<input type="text" name="phonenumber" id="PhoneNumber">

Address:<input type="text" name="address" id="Address">


<input type="submit" id="retrive" name="operation" value="Retrive">

<input type="submit" id="add" name="operation" value="Add" onclick="document.getElementById('id').disabled=false;">

<br><br><br>
</form>
<table border="2" width="70%" cellpadding="2">  
<c:if test="${result!=null}">
<tr><th>Id</th><th>Name</th><th>Phonenumber</th><th>Address</th><th colspan='2'>Operation</th>
</c:if>
 <c:forEach var="supplierM" items="${result}"> 
    	<tr>
    		<td>${supplierM.id}</td>
    		<td>${supplierM.name}</td>
    		<td>${supplierM.phonenumber}</td>
    		<td>${supplierM.address}</td>
    		<td><a href="#" onclick="editsupplier('${supplierM.id}','${supplierM.name}','${supplierM.phonenumber}','${supplierM.address}');">Edit</a></td>
    		<td><a href="deletesupplier?id=${supplierM.id}">Delete</a></td>
    		</tr>
  </c:forEach> 
</table>
</body>
<script>
$(function() {
	$("li#home").removeClass("active");
    $("#supplier").addClass("active");
});
</script>
</html>