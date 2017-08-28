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
	<c:url value="/resources/css/jquery-ui.min.css" var="jQueryUICss" />
	<c:url value="/resources/js/jquery-ui.min.js" var="jQueryUIJs" />

	<link rel="stylesheet" type="text/css" href="${bootstrapCss}" />
	<link rel="stylesheet" type="text/css" href="${pageStyle}" />
	<script src="${jQuery}"></script>
	<script src="${bootstrapJs}"></script>
	<script src="${registrationJs}"></script>
	<script>var context = "${pageContext.request.contextPath}";</script>
	<link rel="stylesheet" type="text/css" href="${jQueryUICss}" />
	<script src="${jQueryUIJs}"></script>

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
                <td>
                    <div class="input-group">
                        <input type="text" id="username" class="form-control" placeholder="Username" />
                        <span class="input-group-addon"><span class="glyphicon glyphicon-info-sign" aria-hidden="true" title="TODO"></span></span>
                    </div>
                    <div id="usernameErrors" class="alert alert-danger fieldErrors"></div>
                </td>
            </tr>
            <tr>
                <td>
                    <div class="input-group passwordField">
                        <input type="password" id="password" class="form-control" placeholder="Password" />
                        <span class="input-group-addon"><span class="glyphicon glyphicon-info-sign" aria-hidden="true" title="TODO"></span></span>
                    </div>
                    <div class="input-group">
                        <input type="password" id="confirmPassword" class="form-control" placeholder="Confirm password" />
                        <span class="input-group-addon"><span class="glyphicon glyphicon-info-sign" aria-hidden="true" title="TODO"></span></span>
                    </div>
                    <div id="passwordErrors" class="alert alert-danger fieldErrors"></div>
                </td>
            </tr>
            <tr>
                <td>
                    <div class="input-group">
                        <input type="text" id="email" class="form-control" placeholder="E-mail" />
                        <span class="input-group-addon"><span class="glyphicon glyphicon-info-sign" aria-hidden="true" title="TODO"></span></span>
                    </div>
                    <div id="emailErrors" class="alert alert-danger fieldErrors"></div>
                </td>
            </tr>
            <tr>
                <td><button onclick="registration()" class="btn btn-primary registrationSubmitButton">Registration</button></td>
            </tr>
        <table>

	</div>
</div>

</body>

</html>