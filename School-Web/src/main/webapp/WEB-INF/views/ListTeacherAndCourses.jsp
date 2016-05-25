<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List All Registered Students</title>
<spring:url value="/resources/style1.css" var="schoolCSS" />
<link href="${schoolCSS}" rel="stylesheet" />
<style type="text/css">
table.tftable {
	font-family: sanchezfont;
	font-size: 15px;
	color: #333333;
	width: 100%;
	border-width: 1px;
	border-color: #9dcc7a;
	border-collapse: collapse;
}

table.tftable th {
	font-family: sanchezfont;
	font-size: 15px;
	background-color: #abd28e;
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #9dcc7a;
	text-align: left;
}

table.tftable tr {
	font-family: sanchezfont;
	background-color: #ffffff;
}

table.tftable td {
	font-family: sanchezfont;
	font-size: 15px;
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #9dcc7a;
}
</style>
</head>
<body>
	<div id="workingwindow">
		<h1>List All Registered Courses</h1>
		<%-- List ${customerList} --%>
		<table class="tftable" border="1">
			<tr>
				<th>Course ID</th>
				<th>Course Name</th>
				<th>Allocated Students</th>
				<th></th>
				<th></th>
			</tr>
			<c:forEach items="${allCourses}" var="element">
				<tr>
					<td>${element.courseId}</td>
					<td>${element.courseName}</td>
					<td><c:set var="len" value="${fn:length(element.studentsEnrolled)}"/>
					<c:choose>
					<c:when test="${len>0}">
					<table>
					<c:forEach items="${element.studentsEnrolled}" var="studentElement">
					<tr><td><b>${studentElement.studentName}</b></td></tr>
					</c:forEach>
					</table>
					</c:when>
					<c:otherwise>
					<i style="color:red;">Unallocated</i>
					</c:otherwise>
					</c:choose>
					</td>
					<td>
					<c:if test="${len > 0}">
						<table>
						<c:forEach items="${element.studentsEnrolled}" var="studentElement">
						<tr><td><b><a href="#">Remove ${studentElement.studentName}</a></b></td></tr>
						</c:forEach>
						</table>
					</c:if>
					</td>
					<td><c:if test="${len eq 0}">
						<%-- <sec:authorize access="hasRole('ADMIN')"> --%>
						<a href="/deleteCourseData?courseId=${element.courseId}">Delete
							Course </a><%-- </sec:authorize> --%>
					</c:if>
					<c:if test="${len > 0}">
						Unallocate To Delete
					</c:if>
					</td>
				</tr>
			</c:forEach>
		</table>
		<div id="addNewElement">
		<form action="/registerCourse" method="post">
		<table border="0">
  		<tr></tr>
  		<tr><td align="center">Course Name: </td><td> <input type="text" name="courseName"></td><td><input type="submit" value="Add Course"></td></tr>
  		<tr></tr>
 		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
  		<tr><td colspan="2"><form:errors path="studentReg.*"/></td></tr>
  		</table>
 		</form> 
		</div>
		
		
		<h1>List All Registered Teachers</h1>
		
		<table class="tftable" border="1">
			<tr>
				<th>Teacher ID</th>
				<th>Teacher Name</th>
				<th>Teacher Speciality</th>
				<th>Allocated Students</th>
				<th></th>
				<th></th>
			</tr>
			<c:forEach items="${allTeachers}" var="element">
				<tr>
					<td>${element.teacherId}</td>
					<td>${element.teacherName}</td>
					<td>${element.teacherSubject}</td>
					<td><c:set var="len" value="${fn:length(element.student)}"/>
					<c:choose>
					<c:when test="${len>0}">
					<table>
					<c:forEach items="${element.student}" var="studentElement">
					<tr><td><b>${studentElement.studentName}</b><br/></td></tr>
					</c:forEach>
					</table>
					</c:when>
					<c:otherwise>
					<i style="color:red;">Unallocated</i>
					</c:otherwise>
					</c:choose>
					</td>
					<td>
					<c:if test="${len > 0}">
						<table>
						<c:forEach items="${element.student}" var="studentElement">
						<tr><td><b><a href="#">Remove ${studentElement.studentName}</a></b></td></tr>
						</c:forEach>
						</table>
					</c:if>
					</td>
					<td><c:if test="${len eq 0}">
						<%-- <sec:authorize access="hasRole('ADMIN')"> --%>
						<a href="/deleteTeacherData?teacherId=${element.teacherId}">Delete
							Teacher </a><%-- </sec:authorize> --%>
					</c:if>
					<c:if test="${len > 0}">
						Unallocate To Delete
					</c:if>
					</td>
				</tr>
			</c:forEach>
		</table>
		<div id="addNewElement">
		<form action="/registerTeacher" method="post">
		<table border="0">
  		<tr></tr>
  		<tr><td align="center">Teacher Name: </td><td> <input type="text" name="teacherName"></td></tr>
  		<tr><td align="center">Teacher Subject: </td><td> <input type="text" name="teacherSubject"></td></tr>
  		<tr></tr>
 		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
  		<tr><td></td> <td><input type="submit" value="Submit"></td></tr>
  		<tr><td colspan="2"><form:errors path="studentReg.*"/></td></tr>
  		</table>
 		</form> 
		</div>
	</div>
</body>
</html>