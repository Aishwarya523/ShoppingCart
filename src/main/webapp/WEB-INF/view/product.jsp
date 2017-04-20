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
<title>Product_ShoopingCart</title>
</head>
<script type="text/javascript">
function editproduct(id,name,description,quantity,price,category,supplier){
	alert(category);
	document.getElementById("Id").value=id;
	document.getElementById("Name").value=name;
	document.getElementById("description").value=description;
	document.getElementById("quantity").value=quantity;
	document.getElementById("price").value=price;
	
	
	}
</script>
<body>
<br><br>
<form action="product" method="post" id="opeation">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<table><tr>
<td>
Id:</td><td><input type="text" name="id" id="Id"></td>

<td>
Name:</td><td><input type="text" name="name" id="Name"></td>


<td align='right'>
description:</td><td><input type="text" name="description" id="description"></td>

</tr>
<tr height='10'><td></td></tr>
<tr>
<td>
quantity:</td><td><input type="text" name="productquantity" id="quantity"></td>

<td>
price:</td><td><input type="text" name="productprice" id="price">
</td>

<td>
&nbsp;
<select name="categoryId" id="category">
<option value=category>Category</option>
<c:forEach var="categoryM" items="${category_dropdown}"> 
<option value="${categoryM.productid}">${categoryM.name} </option>
 </c:forEach>
</select>
</td>
<td>
<select name="supplierId" id="supplier">
<option value=supplier>Supplier</option>
<c:forEach var="supplierM" items="${supplier_dropdown}"> 
<option value="${supplierM.id}">${supplierM.name} </option>
 </c:forEach>
</select>
</td>
</table>	
<input type="submit" name="operation" value="Retrive">

<input type="submit" name="operation" value="Add" >




<br><br><br>
</form>
<table border="2" width="70%" cellpadding="2">  
<c:if test="${result!=null}">
<tr><th>Id</th><th>Name</th><th>Description</th><th>Quantity</th><th>Price</th><th colspan='2'>Operation</th></tr>
</c:if>
 <c:forEach var="productM" items="${result}"> 
    	<tr>
    		<td>${productM.id}</td>
    		<td>${productM.name}</td>
    		<td>${productM.description}</td>
    		<td>${productM.productquantity}</td>
    		<td>${productM.productprice}</td>
    		<td><a href="#" onclick="editproduct('${productM.id}','${productM.name}','${productM.description}','${productM.productquantity}','${productM.productprice}','${productM.categoryId}','${productM.supplierId}');">Edit</a></td>
    		<td><a href="deleteproduct?id=${productM.id}">Delete</a></td>
    		</tr>
    		</c:forEach>
    		 
</table>
</body>
<script>
$(function() {
	$("li#home").removeClass("active");
    $("#product").addClass("active");
});
</script>
</html>