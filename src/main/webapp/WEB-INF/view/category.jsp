<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="menubar.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Category_ShoppingCart</title>
</head>
<script type="text/javascript">
	function editcategoty(id, name, description) {

		document.getElementById("productid").value = id;
		document.getElementById("productid").disabled = true;
		document.getElementById("name").value = name;
		document.getElementById("description").value = description;

	}
</script>
<body>
	
	<br><br><br>
	<form action="category" method="post" id="operation" align='center'>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Id:<input
			type="text" id="productid" name="productid"> Name: <input
			type="text" id="name" name="Name"> Description:<input
			type="text" id="description" name="description"> <input
			type="submit" id="retrive" name="operation" value="Retrive">

		<input type="submit" id="add" name="operation" value="Add"
			onclick="document.getElementById('productid').disabled=false;">
		<br> <br> <br>

	</form>
	<br>
	<br>
	<br>
	<table border="2" width="70%" cellpadding="2" align='center'>
		<c:if test="${result!=null}">
			<tr>
				<th>Productid</th>
				<th>Name</th>
				<th>Description</th>
				<th colspan='2'>Operation</th>
			</tr>
		</c:if>
		<c:forEach var="categoryM" items="${result}">
			<tr>
				<td>${categoryM.productid}</td>
				<td>${categoryM.name}</td>
				<td>${categoryM.description}</td>
				<td><a href="#"
					onclick="editcategoty('${categoryM.productid}','${categoryM.name}','${categoryM.description}');">Edit</a></td>
				<td><a href="deletecategory?productId=${categoryM.productid}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
<script>
$(function() {
	$("li#home").removeClass("active");
    $("#category").addClass("active");
});
</script>
</html>