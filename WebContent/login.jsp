<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://www.w3schools.com/lib/w3.js"></script>
<link rel="stylesheet" type="text/css" href="stylesheets/login.css">
<link rel="stylesheet" type="text/css" href="stylesheets/style.css">
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
<title>ShopBeacon</title>
</head>
<body>
<div w3-include-html="header.jsp"></div> 
<div w3-include-html="footer.html"></div> 
<script>
w3.includeHTML(); 
</script>

<div class="wrapper">
<form method="POST" action="login">
<br>
<h1 id="toplogobar2"><a><img style="height: 40px;"src =images/logo/camera.jpg></a>Shop<span id="toplogobarBeacon2">Beacon</span> </h1>
<h5> Satisfy your shopping and cell phone needs on ShopBeacon! </h5>
<h4> Existing Customers </h4>
<h4> Login </h4>
<input id="input2" type="email" name="email" placeholder="Email Address" required> <br> <br>
<input id="input2"type="password" name="password" placeholder="Password" required> <br> <br>
<input id="input2" type="submit" value="Login"> <br>
<span style="color:red;"> ${loginerror} </span><br>
</form>

<form method="POST" action="register">
<div class="wrapper2">
<h1 id="toplogobar2"><a><img style="height: 40px;"src =images/logo/camera.jpg></a>Shop<span id="toplogobarBeacon2">Beacon</span> </h1>
<h4> New Customers </h4>
<h4> Register </h4>
<input id="input2" type="text" name="firstname" placeholder="Name" required> <br> <br>
<input id="input2" type="email" name="email" placeholder="Email Address" required> <br> <br>
<input id="input2"type="password" name="password" placeholder="Password" required> <br> <br>
<input id="input2"type="password" name="confirmpassword" placeholder="Confirm Password" required> <br> <br>
<input id="input2" type="submit" value="Register"> <br>
<span style="color:red;"> ${error} </span><br>
</div>

</form>
</div> <br>
</body>
</html>