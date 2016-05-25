<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Registration Page</title>
<spring:url value="/resources/style1.css" var="schoolCSS" />
<link href="${schoolCSS}" rel="stylesheet" />
</head>
<body>


<!-- <a href="/register?siteLanguage=en">English</a><br>
<a href="/register?siteLanguage=fr">French</a> -->


<div id="workingwindow">
<h1><u>Registration Student </u></h1>
<form:errors path="studentReg.*"/>
 <form action="/registerStudent" method="post">
 <c:choose>
    <c:when test="${param.studentId > 0}">
       <input type="hidden" name="studentId" value="${param.studentId}" ><br>
    </c:when>
     <c:otherwise>
        <input type="hidden" name="studentId" value="-1" ><br>
    </c:otherwise>
</c:choose>
 
  <table border="0">
  <tr><td align="center">Student Name: </td><td> <input type="text" name="studentName" value="${editableStudent.studentName}"></td></tr>
  <tr></tr>
  <tr></tr>
  
  
 <tr><td align="center">Address :</td><td></td></tr>
<tr><td align="right">Street :</td> <td><input type="text" name="studentAddress.street" value="${editableStudent.studentAddress.street}"></td></tr>
<tr><td align="right">City :</td> <td><input type="text" name="studentAddress.city" value="${editableStudent.studentAddress.city}"></td></tr>
<tr><td align="right">State :</td> <td><input type="text" name="studentAddress.state" value="${editableStudent.studentAddress.state}"></td></tr>
<tr><td align="right">Zipcode :</td> <td><input type="text" name="studentAddress.zipcode" value="${editableStudent.studentAddress.zipcode}"></td></tr>


<tr><td align="center">Contact Number :</td><td></td></tr>
  <tr><td align="right">Type :</td> <td><input type="text" name="studentPhoneNumbers.phoneType" <%-- value="${editableStudent.studentPhoneNumbers.phoneType}" --%>></td></tr>
<tr><td align="right">Number :</td> <td> <input type="text" name="studentPhoneNumbers.phoneNumber" <%-- value="${editableStudent.studentPhoneNumbers.phoneNumber}" --%>></td></tr>
  
  
  <tr><td align="center">Class Teacher	 :</td><td></td></tr>
  <tr><td></td> <td>
  
  <form:select path="allTeachers" name="classTeacher">
  <form:options items="${allTeachers}"  itemValue="teacherId" itemLabel="teacherName" />
  </form:select> 
  
  
  </td></tr>
  
  
  <tr><td align="center">Course :</td><td></td></tr>
  <tr><td></td> <td><form:select path="allCourses" name="courses" items="${allCourses}" itemValue="courseId" itemLabel="courseName"  multiple="true"/>
  </td></tr>
  
  
  
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
  <tr><td></td> <td><input type="submit" value="Submit"></td></tr>
  <tr><td colspan="2"><form:errors path="studentReg.*"/></td></tr>
  </table>
  
  
</form> 
</div>

</body>
</html>