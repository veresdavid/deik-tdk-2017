<%@page contentType="text/html; charset=UTF-8" language="java"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>

<html>

<head>

    <spring:message code="registration.placeholder.username" var="placeholderUsername" />
    <spring:message code="registration.placeholder.password" var="placeholderPassword" />
    <spring:message code="registration.placeholder.confirmPassword" var="placeholderConfirmPassword" />
    <spring:message code="registration.placeholder.email" var="placeholderEmail" />
    <spring:message code="registration.tooltip.username" var="tooltipUsername" />
    <spring:message code="registration.tooltip.password" var="tooltipPassword" />
    <spring:message code="registration.tooltip.confirmPassword" var="tooltipConfirmPassword" />
    <spring:message code="registration.tooltip.email" var="tooltipEmail" />

	<c:url value="/resources/js/jquery-3.1.1.min.js" var="jQuery" />
	<c:url value="/resources/css/bootstrap.min.css" var="bootstrapCss" />
	<c:url value="/resources/js/bootstrap.min.js" var="bootstrapJs" />
	<c:url value="/resources/css/pagestyle.css" var="pageStyle" />
	<c:url value="/resources/js/registration.js" var="registrationJs" />
	<c:url value="/resources/css/jquery-ui.min.css" var="jQueryUICss" />
	<c:url value="/resources/js/jquery-ui.min.js" var="jQueryUIJs" />
	<c:url value="/resources/js/jquery.i18n.properties.js" var="jQueryi18n" />

	<link rel="stylesheet" type="text/css" href="${bootstrapCss}" />
	<link rel="stylesheet" type="text/css" href="${pageStyle}" />
	<script src="${jQuery}"></script>
	<script src="${bootstrapJs}"></script>
	<script src="${registrationJs}"></script>
	<script>var context = "${pageContext.request.contextPath}";</script>
	<link rel="stylesheet" type="text/css" href="${jQueryUICss}" />
	<script src="${jQueryUIJs}"></script>
	<script>var locale = "${pageContext.response.locale}";</script>
    <script src="${jQueryi18n}"></script>

	<meta charset="UTF-8">
	<title><spring:message code="title.registration" /></title>

</head>

<body>

<%@include file="header.jsp" %>

<div class="container pageContainer">
	<div class="row">

	    <div id="registrationHeader"><h1><spring:message code="registration.heading" /></h1></div>

        <table id="registrationTable" class="table table-responsive registrationTable">
            <tr>
                <td>
                    <div class="input-group">
                        <input type="text" id="username" class="form-control" placeholder="${placeholderUsername}" />
                        <span class="input-group-addon"><span class="glyphicon glyphicon-info-sign" aria-hidden="true" title="${tooltipUsername}"></span></span>
                    </div>
                    <div id="usernameErrors" class="alert alert-danger fieldErrors"></div>
                </td>
            </tr>
            <tr>
                <td>
                    <div class="input-group passwordField">
                        <input type="password" id="password" class="form-control" placeholder="${placeholderPassword}" />
                        <span class="input-group-addon"><span class="glyphicon glyphicon-info-sign" aria-hidden="true" title="${tooltipPassword}"></span></span>
                    </div>
                    <div class="input-group">
                        <input type="password" id="confirmPassword" class="form-control" placeholder="${placeholderConfirmPassword}" />
                        <span class="input-group-addon"><span class="glyphicon glyphicon-info-sign" aria-hidden="true" title="${tooltipConfirmPassword}"></span></span>
                    </div>
                    <div id="passwordErrors" class="alert alert-danger fieldErrors"></div>
                </td>
            </tr>
            <tr>
                <td>
                    <div class="input-group">
                        <input type="text" id="email" class="form-control" placeholder="${placeholderEmail}" />
                        <span class="input-group-addon"><span class="glyphicon glyphicon-info-sign" aria-hidden="true" title="${tooltipEmail}"></span></span>
                    </div>
                    <div id="emailErrors" class="alert alert-danger fieldErrors"></div>
                </td>
            </tr>
            <tr>
                <td><button onclick="registration()" class="btn btn-primary registrationSubmitButton"><spring:message code="registration.button" /></button></td>
            </tr>
        <table>

	</div>
</div>

</body>

</html>