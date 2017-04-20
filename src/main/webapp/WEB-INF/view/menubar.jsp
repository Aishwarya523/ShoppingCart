<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <c:if test="${pageContext.request.userPrincipal.name != null}">
    	 <%@page session ="true" %>
    </c:if>
   
<html>
<head>
  <title>Online Store</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
  
  .carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
      width: 100%;
	  margin: auto;
      
  }
    /* Remove the navbar's default rounded borders and increase the bottom margin */ 
    .navbar {
      margin-bottom: 50px;
      border-radius: 0;
    }
    
    /* Remove the jumbotron's default bottom margin */ 
     .jumbotron {
      margin-bottom: 0;
    }
   
    /* Add a gray background color and some padding to the footer */
    footer {
      background-color: #f2f2f2;
      padding: 25px;
    }
	#myCarousel {
	  height: 290px;
	}
  </style>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#">Simply Shop</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li id="home" class="active"><a href="http://localhost/ShoppingCart/">Home</a></li>
        <c:if test="${pageContext.request.isUserInRole('ADMIN')}">
	        <li id="product"><a href="product">Products</a></li>
	        <li id="supplier"><a href="supplier">Supplier</a></li>
	        <li id="category"><a href="category">Category</a></li>
        </c:if>
        <li><a href="#">Contact</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
      <c:if test="${pageContext.request.userPrincipal.name != null}">
      <form action="<c:url value='/j_spring_security_logout' />" method="post">
       <ul class="nav navbar-nav navbar-right">
       <li><a href="#"><span class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>
      	<li><a href="<c:url value='/j_spring_security_logout' />"><span class="glyphicon glyphicon-user"></span>Logout</a></li>
      	
      	</ul>
      	</form>
      </c:if>
      <c:if test="${pageContext.request.userPrincipal.name==null}">
      <ul class="nav navbar-nav navbar-right">
        <li><a href="login"><span class="glyphicon glyphicon-user"></span> Login</a></li>
        <li><a href="#"><span class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>
        </ul>
        </c:if>
        
      </ul>
    </div>
  </div>
</nav>
</body>
</html>