<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<title>Welcome</title>
<spring:url value="/resources/style1.css" var="schoolCSS" />
<link href="${schoolCSS}" rel="stylesheet" />
</head>
<body>
<div id="workingwindow">
<h1>Welcome to WildCoders.Please select from the Below Administrative Tasks</h1>
Welcome ${user}
<table>
<tr><td>1.<a href="/registerStudent">Register A Student</a></td></tr>
<tr><td>2.<a href="/listStudents">List All Students</a></td></tr>
<tr><td>3.<a href="/listTeacherAndCourses">List All Teachers/Courses</a></td></tr>
</table>
 

</div>
</body>
</html>
