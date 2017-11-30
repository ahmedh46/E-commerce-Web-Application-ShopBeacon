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

<div style="
	margin-left: auto;
	margin-right: auto;
	width: 50%;
	text-align: center;
	font-size: 20px;
	background-color: rgba(27, 207, 215, 0.42);
	margin-top: 10px;
	padding: 5px;
	border-radius: 10px;
	">
<h1> ${phonename} </h1> <br>
<img src=${picture} id="index_images"> <br>
<h5> ${price}</h5> <br>
</div>
</body>
</html>