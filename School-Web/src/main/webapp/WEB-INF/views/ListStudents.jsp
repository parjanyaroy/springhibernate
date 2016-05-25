<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List All Registered Students</title>
<spring:url value="/resources/style1.css" var="schoolCSS" />
<link href="${schoolCSS}" rel="stylesheet" />
<style type="text/css">
table.tftable {font-family: sanchezfont;font-size:15px;color:#333333;width:100%;border-width: 1px;border-color: #9dcc7a;border-collapse: collapse;}
table.tftable th {font-family: sanchezfont;font-size:15px;background-color:#abd28e;border-width: 1px;padding: 8px;border-style: solid;border-color: #9dcc7a;text-align:left;}
table.tftable tr {font-family: sanchezfont;background-color:#ffffff;}
table.tftable td {font-family: sanchezfont;font-size:15px;border-width: 1px;padding: 8px;border-style: solid;border-color: #9dcc7a;}
</style>
</head>
<body>
	<div id="workingwindow">
		<h1>List All Registered Students</h1>
		<%-- List ${customerList} --%>
		<table class="tftable" border="1">
			<tr>
				<th>Student Name</th>
				<th>City</th>
				<th>Phone</th>
				<th>Teacher Name</th>
				<th>Enrolled Courses</th>
				<th></th>
				<th></th>
			</tr>
			<c:forEach items="${studentsList}" var="element">

				<tr>
					<td>${element.studentName}</td>
					<td>${element.studentAddress.city}</td>
					<td><c:forEach items="${element.studentPhoneNumbers}"
							var="subElement1">
				${subElement1.phoneNumber}<br />
						</c:forEach></td>
					<td>${element.classTeacher.teacherName}</td>
					<td><c:forEach items="${element.courses}" var="subElement2">
				${subElement2.courseName}<br />
						</c:forEach></td>
				<td><a href="/editStudentData?studentId=${element.studentId}" >Edit Student</a></td>
				<td><%-- <sec:authorize access="hasRole('ADMIN')"> --%><a href="/deleteStudentData?studentId=${element.studentId}" >Delete Student</a><%-- </sec:authorize> --%></td> 
				</tr>

			</c:forEach>
		</table>
		<br/><a href="/registerStudent">Register A Student</a>
		<br/><a href="/welcome">Home</a><br/>
	</div>
</body>
</html>