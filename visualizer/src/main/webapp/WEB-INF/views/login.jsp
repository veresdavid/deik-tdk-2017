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

	<link rel="stylesheet" type="text/css" href="${bootstrapCss}" />
	<link rel="stylesheet" type="text/css" href="${pageStyle}" />
	<script src="${jQuery}"></script>
	<script src="${bootstrapJs}"></script>

	<meta charset="UTF-8">
	<title>Login</title>

</head>

<body>

<%@include file="header.jsp" %>

<div class="container pageContainer">
	<div class="row">

		<div id="loginHeader"><h1>Login</h1></div>

        <div id="loginDiv">

            <c:if test="${param.error != null}">
                <div class="alert alert-danger">${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message}</div>
            </c:if>

            <form class="loginForm" method="POST">
                <input type="text" name="username" placeholder="Username" class="form-control loginElement" />
                <input type="password" name="password" placeholder="Password" class="form-control loginElement" />
                <button class="btn btn-primary loginButton loginElement">Login</button>
            </form>

		</div>

	</div>
</div>

</body>

</html>