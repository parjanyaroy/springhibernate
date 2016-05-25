<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<spring:url value="/resources/style1.css" var="schoolCSS" />
<link href="${schoolCSS}" rel="stylesheet" />
<title>Login page</title>
</head>

<body>
	<div id="workingwindow">
	<c:url var="loginUrl" value="/login" />
	<fieldset>
    <legend>Credentials:</legend>
	<table>
	<tr><td colspan="2">
	<form action="${loginUrl}" method="post" class="form-horizontal">
		<c:if test="${param.error != null}">
			<div class="alert alert-danger">
				<p>Invalid username and password.</p>
			</div>
		</c:if>
		<c:if test="${param.logout != null}">
			<div class="alert alert-success">
				<p>You have been logged out successfully.</p>
			</div>
		</c:if>
		</tr>
		<tr><td>
		Username :</td><td><input type="text" class="form-control" id="username" name="username"
			placeholder="Enter Username" required>
			</td></tr><tr><td>Password :</td><td><input type="password" class="form-control" id="password" name="password"
			placeholder="Enter Password" required> </td></tr>
			<input type="hidden"
			name="${_csrf.parameterName}" value="${_csrf.token}" /> 
			<tr><td></td><td></td></tr><tr><td colspan="2" align="left"><input
			type="submit" class="btn btn-block btn-primary btn-default"
			value="Log in"></td></tr>
	</form>
	</table>
	</fieldset>
	</div>
</body>
</html>