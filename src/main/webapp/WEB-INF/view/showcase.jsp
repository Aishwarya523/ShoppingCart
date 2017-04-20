<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <c:if test="${pageContext.request.userPrincipal.name != null}">
    	 <%@page session ="true" %>
    </c:if>
   
<html>
<head>
<script type="text/javascript">
function buynow(index){
	document.getElementById("qty"+index).value;
	document.getElementById("confirmation").action="buynow?qty="+document.getElementById("qty"+index).value+"&pid="+document.getElementById("pid"+index).value;
	document.getElementById("confirmation").submit();
	
	
}
</script>
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
        <li class="active"><a href="#">Home</a></li>
        
        
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
<div id="myCarousel" class="carousel slide" data-ride="carousel" >
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">

      <div class="item active">
        <img src="imgs/samsungJ3.jpg" alt="Chania" width="900" height="250">
        <div class="carousel-caption">
          <h3>Simply Shop</h3>
          
        </div>
      </div>

      <div class="item" >
        <img src="imgs/kindle.jpg" alt="Chania" width="900" height="250">
        <div class="carousel-caption">
          <h3>Simply Shop</h3>
        </div>
      </div>
    
      <div class="item">
        <img src="imgs/1.jpg" alt="Flower" width="900" height="250">
        <div class="carousel-caption">
          <h3>Simply Shop</h3>
        </div>
      </div>

 
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>



<div class="container">
<br><br><br><br><br>
  	<form id="confirmation" method="post">
  <div class="row">
	   <c:forEach var="product" items="${result}" varStatus="loop"> 
		   <a href="#">
		    <div class="col-sm-4">
		      <div class="panel panel-primary">
		        <div class="panel-heading">${product.name} &nbsp; <b><font size="3" color="orange">Rs.${product.productprice}</font></b></div>
		        <input type="hidden" id="pid${loop.index}" value="${product.id}"/>
		        <div class="panel-body"><img src="imgs/${product.name}.jpg" class="img-responsive" style="width:100%" alt="Image"></div>
				<div class="panel-footer">Quantity: <input type="text" id="qty${loop.index}" maxlength="1" size="1" value="1"> &nbsp; <input type="button" value="Buy Now" onclick="buynow(${loop.index});return;"> &nbsp; <input type="submit" value="Add to Cart"></div>
		      </div>
		    </div>
		    </a>
			
		</c:forEach>
		</div>
	</form>
</div>
<br>
<br><br><br>

<footer class="container-fluid text-center">
  <p>Online Store Copyright</p>  
  <form class="form-inline">Get deals:
    <input type="email" class="form-control" size="50" placeholder="Email Address">
    <button type="button" class="btn btn-danger">Sign Up</button>
  </form>
</footer>

</body>
</html>