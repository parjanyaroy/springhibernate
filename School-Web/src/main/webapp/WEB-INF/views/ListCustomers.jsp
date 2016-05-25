<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List All Customers</title>
</head>
<body>
<h1>List All Customer</h1>
	<%-- List ${customerList} --%>
	<table border="1">
	<tr><th>Name</th><th>Email</th><th>Mobile</th><th>City</th><th>Country</th><th></th><th></th>
			</tr>
		<c:forEach items="${customerList}" var="element">
			
			<tr> 
				<td>${element.customerName}</td>
				<td>${element.customerEmail}</td>
				<td>${element.mobile}</td>
				<td>${element.customerAddress.city}</td>
				<td>${element.customerAddress.country} </td>
				<td><a href="/editCustomerData?customerId=${element.customerId}" >Edit Customer</a></td>
				<td><sec:authorize access="hasRole('ADMIN')"><a href="/deleteCustomerData?customerId=${element.customerId}" >Delete Customer</a></sec:authorize></td>
				</tr>
			
		</c:forEach>
	</table>

</body>
</html>