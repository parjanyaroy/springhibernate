<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Successful</title>
</head>
<body>
	<h1>
		<u>Registration Successful</u><br>${customerReg.customerName} has
		been registered with ${customerReg.customerEmail}
		
		${customerReg.customerEmail}<br>
		${customerReg.customerPassword}<br>
		${customerReg.mobile}<br>
		${customerReg.dateOfBirth}<br>
		${customerReg.customerAddress.city}<br>
		${customerReg.customerAddress.state}<br>
		${customerReg.customerAddress.country}<br>
		${customerReg.customerAddress.pincode}<br>
		
		
	</h1>
</body>
</html>