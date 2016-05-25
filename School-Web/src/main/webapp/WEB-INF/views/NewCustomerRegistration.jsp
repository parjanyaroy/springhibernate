<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Registration Page</title>
</head>
<body>
<a href="/register?siteLanguage=en">English</a><br>
<a href="/register?siteLanguage=fr">French</a>
<h1><u>This is the customer Registration Page </u></h1>
<form:errors path="customerReg.*"/>
 <form action="/register" method="post">
 
 <c:choose>
    <c:when test="${param.customerId > 0}">
       <input type="hidden" name="customerId" value="${param.customerId}" ><br>
    </c:when>
     <c:otherwise>
        <input type="hidden" name="customerId" value="-1" ><br>
    </c:otherwise>
</c:choose>
 
  
  Customer Name1: <br>
  <input type="text" name="customerName" value="${CusDetail.customerName}"><br>
  Email :<br>
  <input type="text" name="customerEmail" value="${CusDetail.customerEmail}"><br>
  Mobile :<br>
  <input type="text" name="mobile" value="${CusDetail.mobile}"><br>
  DateOfBirth :<br>
  <input type="text" name="dateOfBirth" value="${CusDetail.dateOfBirth}"><br>
   Password :<br>
  <input type="password" name="customerPassword" value="${CusDetail.customerPassword}"><br>
  
  
  House Number:<br>
  <input type="text" name="customerAddress.houseNumber" value="${CusDetail.customerAddress.houseNumber}"><br>
  Street Name / Number:<br>
  <input type="text" name="customerAddress.streetNameNumber" value="${CusDetail.customerAddress.streetNameNumber}"><br>
  City:<br>
  <input type="text" name="customerAddress.city" value="${CusDetail.customerAddress.city}"><br>
  Pincode:<br>
  <input type="text" name="customerAddress.pincode" value="${CusDetail.customerAddress.pincode}"><br>
  State:<br>
  <input type="text" name="customerAddress.state" value="${CusDetail.customerAddress.state}"><br>
  Country:<br>
  <input type="text" name="customerAddress.country" value="${CusDetail.customerPassword}"><br>
  
  <input type="submit" value="Submit">
</form> 


</body>
</html>