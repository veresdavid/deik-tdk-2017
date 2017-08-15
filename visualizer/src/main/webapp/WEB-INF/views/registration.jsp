<%@page contentType="text/html; charset=UTF-8" language="java"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>

<html>

<head>

	<c:url value="/resources/js/jquery-3.1.1.min.js" var="jQuery" />
	<c:url value="/resources/css/bootstrap.min.css" var="bootstrapCss" />
	<c:url value="/resources/js/bootstrap.min.js" var="bootstrapJs" />
	<c:url value="/resources/css/pagestyle.css" var="pageStyle" />
	<c:url value="/resources/js/registration.js" var="registrationJs" />

	<link rel="stylesheet" type="text/css" href="${bootstrapCss}" />
	<link rel="stylesheet" type="text/css" href="${pageStyle}" />
	<script src="${jQuery}"></script>
	<script src="${bootstrapJs}"></script>
	<script src="${registrationJs}"></script>
	<script>var context = "${pageContext.request.contextPath}";</script>

	<meta charset="UTF-8">
	<title>Registration</title>

</head>

<body>

<%@include file="header.jsp" %>

<div class="container pageContainer">
	<div class="row">

	    <div id="registrationHeader"><h1>Registration</h1></div>

        <table id="registrationTable" class="table table-responsive registrationTable">
            <tr>
                <td><input type="text" id="username" class="form-control" placeholder="Username" /><div id="usernameErrors" class="alert alert-danger fieldErrors"></div></td>
            </tr>
            <tr>
                <td><input type="password" id="password" class="form-control passwordField" placeholder="Password" /><input type="password" id="confirmPassword" class="form-control" placeholder="Confirm password" /><div id="passwordErrors" class="alert alert-danger fieldErrors"></div></td>
            </tr>
            <tr>
                <td><input type="text" id="email" class="form-control" placeholder="E-mail" /><div id="emailErrors" class="alert alert-danger fieldErrors"></div></td>
            </tr>
            <tr>
                <td><button onclick="registration()" class="btn btn-primary registrationSubmitButton">Registration</button></td>
            </tr>
        <table>

	</div>
</div>

</body>

</html>