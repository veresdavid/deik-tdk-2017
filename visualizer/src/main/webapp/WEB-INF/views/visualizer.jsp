<%@page contentType="text/html; charset=UTF-8" language="java"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html lang="hu">

<head>

	<c:url value="/resources/js/jquery-3.1.1.min.js" var="jQuery" />
	<c:url value="/resources/css/bootstrap.min.css" var="bootstrapCss" />
	<c:url value="/resources/js/bootstrap.min.js" var="bootstrapJs" />
	<c:url value="/resources/css/pagestyle.css" var="pageStyle" />
	<c:url value="/resources/js/d3.min.js" var="d3js" />

	<link rel="stylesheet" type="text/css" href="${bootstrapCss}" />
	<link rel="stylesheet" type="text/css" href="${pageStyle}" />
	<script src="${jQuery}"></script>
	<script src="${bootstrapJs}"></script>
	<script src="${d3js}"></script>

	<meta charset="UTF-8">
	<title><spring:message code="title.graphs" /></title>

</head>

<body>

<%@include file="header.jsp" %>

<div class="container pageContainer">
	<div class="row">
		
		<h1>Eredmények</h1>
		
		<c:if test="${processIdentifiers != null}">

		<!--
		<ul>
			<c:forEach var="processIdentifier" items="${processIdentifiers}">
				<li><a href="${pageContext.request.contextPath}/graph/view/${processIdentifier}">${processIdentifier}</a></li>
			</c:forEach>
		</ul>
		-->
		
		<ul>
			<c:forEach var="processIdentifier" items="${processIdentifiers}" varStatus="status">
				<li>${algorithms[status.index]} : <a href="${pageContext.request.contextPath}/graph/view/${processIdentifier}">${processIdentifier}</a></li>
			</c:forEach>
		</ul>

		</c:if>
		
	</div>
</div>

</body>

</html>