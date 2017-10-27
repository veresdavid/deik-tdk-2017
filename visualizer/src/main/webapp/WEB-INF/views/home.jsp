<%@page contentType="text/html; charset=UTF-8" language="java"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<title><spring:message code="title.home" /></title>

</head>

<body>

<%@include file="header.jsp" %>

<div class="container pageContainer">
	<div class="row">

		<h1><spring:message code="home.welcome" /></h1>

		<div id="pageDescription">

		    <h2><spring:message code="home.desc.header.general" /></h2>
		    <p><spring:message code="home.desc.p.general" /><p>

		    <h2><spring:message code="home.desc.header.reglog" /></h2>
            <p><spring:message code="home.desc.p.reglog" /><p>

		    <h2><spring:message code="home.desc.header.profile" /></h2>
            <p><spring:message code="home.desc.p.profile" /><p>

		    <h2><spring:message code="home.desc.header.problem" /></h2>
            <p><spring:message code="home.desc.p.problem" /><p>

		    <h2><spring:message code="home.desc.header.graph" /></h2>
            <p><spring:message code="home.desc.p.graph" /><p>

		    <h2><spring:message code="home.desc.header.github" /></h2>
            <p><spring:message code="home.desc.p.github" /><p>

            <h2><spring:message code="home.desc.header.lang" /></h2>
            <p><spring:message code="home.desc.p.lang" /><p>

		</div>

	</div>
</div>

</body>

</html>