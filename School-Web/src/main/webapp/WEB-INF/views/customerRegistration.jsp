<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Registration Page</title>
</head>
<body>
<a href="/register?siteLanguage=en">English</a><br>
<a href="/register?siteLanguage=fr">French</a>
<h6>${welcomeMessage}</h6>
<h1>This is the customer Registration Page</h1>
<form:errors path="customerReg.*"/>
<form action="/register" method="post">
  <spring:message code="label.studentName"/><br>
  <input type="text" name="name" value="${formMap.name}"><br>
  Email :<br>
  <input type="text" name="email" value="${formMap.email}"><br>
  Mobile :<br>
  <input type="text" name="mobile" value=""><br>
  DateOfBirth :<br>
  <input type="text" name="dateOfBirth" value=""><br>
  Family Members :<br>
  <select name="familyMembers" multiple>
  <option value="self">Self</option>
  <option value="husbandwife">Husband/Wife</option>
  <option value="children">Children</option>
  </select><br>
  
  Country:<br>
  <input type="text" name="customerAddress.country" value=""><br>
  Street:<br>
  <input type="text" name="customerAddress.street" value=""><br>
  City:<br>
  <input type="text" name="customerAddress.city" value=""><br>
  Pincode:<br>
  <input type="text" name="customerAddress.pincode" value=""><br>
  
  
  <input type="submit" value="Submit">
</form>


</body>
</html>