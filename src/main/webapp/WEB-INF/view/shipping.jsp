<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="menubar.jsp" %>
<html>
<head>
<style>
	 #contact{
    padding:10px 0 10px;
  }

  .contact-text{
    margin:45px auto;
  }

  .mail-message-area{
    width:100%;
    padding:0 15px;
  }

  .mail-message{
    width: 100%;
    background:rgba(255,255,255, 0.8) !important;
    -webkit-transition: all 0.7s;
    -moz-transition: all 0.7s;
    transition: all 0.7s;
    margin:0 auto;
    border-radius: 0;
  }

  .not-visible-message{
    height:0px;
    opacity: 0;
  }

  .visible-message{
    height:auto;
    opacity: 1;
    margin:25px auto 0;
  }

/* Input Styles */

  .form{
    width: 100%;
    padding: 15px;
    background:#f8f8f8;
    border:1px solid rgba(0, 0, 0, 0.075);
    margin-bottom:25px;
    color:#727272 !important;
    font-size:13px;
    -webkit-transition: all 0.4s;
    -moz-transition: all 0.4s;
    transition: all 0.4s;
  }

  .form:hover{
    border:1px solid #8BC3A3;
  }

  .form:focus{
    color: white;
    outline: none;
    border:1px solid #8BC3A3;
  }

  .textarea{
    height: 200px;
    max-height: 200px;
    max-width: 100%;
    rows: 5;
  }
  
/* Generic Button Styles */

  .button{
    padding:8px 12px;
    background:#0A5175;
    display: block;
    width:120px;
    margin:10px 0 0px 0;
    border-radius:3px;
    -webkit-transition: all 0.3s;
    -moz-transition: all 0.3s;
    transition: all 0.3s;
    text-align:center;
    font-size:0.8em;
    box-shadow: 0px 1px 4px rgba(0,0,0, 0.10);
    -moz-box-shadow: 0px 1px 4px rgba(0,0,0, 0.10);
    -webkit-box-shadow: 0px 1px 4px rgba(0,0,0, 0.10);
  }

  .button:hover{
    background:#8BC3A3;
    color:white;
  }

/* Send Button Styles */

  .form-btn{
    width:180px;
    display: block;
    height: auto;
    padding:15px;
    color:#fff;
    background:#8BC3A3;
    border:none;
    border-radius:3px;
    outline: none;
    -webkit-transition: all 0.3s;
    -moz-transition: all 0.3s;
    transition: all 0.3s;
    margin:auto;
    box-shadow: 0px 1px 4px rgba(0,0,0, 0.10);
    -moz-box-shadow: 0px 1px 4px rgba(0,0,0, 0.10);
    -webkit-box-shadow: 0px 1px 4px rgba(0,0,0, 0.10);
  }

  .form-btn:hover{
    background:#111;
    color: white;
    border:none;
  }

  .form-btn:active{
    opacity: 0.9;
  }
center{
  margin-top:330px;
}
input {
    position: relative;
    z-index: 9999;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>shipping_Page</title>
<script type="text/javascript">
var total=0.00;
</script>
</head>
<body>
<div class="container">
<p><h1>You Have Purchased</h1></p>
<form action="payNow" method="post">
<br>
<table border="0">

 <c:forEach var="product" items="${result}" varStatus="loop"> 
	<tr>
		<td width="30%">
			<img alt="${product.name}" src="imgs/${product.name}.jpg" width="100px" height="100px">
		</td>
		<td>
			<b>Quanity:</b> ${qty}

		</td>
		<td>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>Price:</b> &#x20B9;${product.productprice}
			<input type="hidden" name="productprice" value="${product.productprice}"/>
		</td>
		<td id='tot${loop.index}'>
		
			<script type="text/javascript">
			$( document ).ready(function() {
				document.getElementById('tot${loop.index}').innerHTML="&nbsp;&nbsp;&nbsp;&nbsp;<b>Total:</b> &#x20B9;"+${qty}*${product.productprice};
				total=total+${qty}*${product.productprice};
			});
			</script>
		</td>
	</tr>
 </c:forEach>

 <input type="hidden" name="amount" id="amount"/>
</table>
<H2 id='totalValue'></H2>

<script type="text/javascript">
			$( document ).ready(function() {
				document.getElementById('totalValue').innerHTML="Total: &#x20B9;"+total;
				document.getElementById('amount').value=total;
			});
			</script>
<br><br>

	<div class="inner contact">
                <!-- Form Area -->
                <div class="contact-form">
                    <!-- Form -->
                        <!-- Left Inputs -->
                        <div class="col-xs-6 wow animated slideInLeft" data-wow-delay=".5s">

                            <input type="text" name="username" id="name" required="required" class="form" placeholder="Name" />
                            <!-- Email -->
                            <input type="email" name="email" id="email" required="required" class="form" placeholder="Email" />
                            <!-- Subject -->
                            <input type="text" name="mobile" id="mobile" required="required" class="form" placeholder="Mobile" maxlength=10/>
                        </div><!-- End Left Inputs -->
                        <!-- Right Inputs -->
                        <div class="col-xs-6 wow animated slideInRight" data-wow-delay=".5s">
                            <!-- Message -->
                            <textarea name="address" id="address" class="form textarea"  placeholder="Address"></textarea>
                        </div><!-- End Right Inputs -->
                        <!-- Bottom Submit -->
                        <div class="relative fullwidth col-xs-12">
                            <!-- Send Button -->
                            <button type="submit" id="submit" name="submit" class="form-btn semibold">Place Order</button> 
                        </div><!-- End Bottom Submit -->
                        <!-- Clear -->
                        <div class="clear"></div>
                    </form>
                </div><!-- End Contact Form Area -->
            </div><!-- End Inner -->
</div>
<br>

</body>
</html>