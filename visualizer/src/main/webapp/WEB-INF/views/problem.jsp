<%@page contentType="text/html; charset=UTF-8" language="java"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>

<html lang="hu">

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
	<title><spring:message code="title.new.graph" /></title>

</head>

<body>

<%@include file="header.jsp" %>

<div class="container pageContainer">
	<div class="row">
	
		<h1>Új probléma</h1>
		
		<c:choose>
			<c:when test="${errorMessage != null}">
				<div class="panel panel-danger response">
					<div class="panel-heading">Hiba!</div>
					<div class="panel-body">${errorMessage}</div>
				</div>
			</c:when>
		</c:choose>
		
		<form:form method="POST" modelAttribute="problemForm" action="">
		<table class="table table-responsive problemTable">
			<tr>
				<td>Állapottér :</td>
				<td><form:textarea path="stateSpace" rows="10" cols="60" class="form-control problemTextarea" resizeable="false" /></td>
			</tr>
			<tr>
				<td>Keresők :</td>
				<td>
					<form:checkbox path="algorithms" value="BackTrackSimple" />Backtrack<br/>
					<form:checkbox path="algorithms" value="BackTrackCircle" />Backtrack with cycle detection<br/>
					<form:checkbox path="algorithms" value="BackTrackPathLengthLimitation" />Backtrack with pathlength limitation<br/>
					<form:checkbox path="algorithms" value="BackTrackOptimal" />Backtrack branch and bound<br/>
					<form:checkbox path="algorithms" value="BreadthFirst" />Breadth-first<br/>
					<form:checkbox path="algorithms" value="DepthFirst" />Depth-first<br/>
					<form:checkbox path="algorithms" value="Optimal" />Optimal<br/>
					<form:checkbox path="algorithms" value="BestFirst" />Best-first<br/>
					<form:checkbox path="algorithms" value="A" />A<br/>
				</td>
			</tr>
			<tr>
				<td>Heurisztika :</td>
				<td><form:textarea path="heuristic" rows="10" cols="60" class="form-control problemTextarea" /></td>
			</tr>
			<tr>
				<td colspan="2"><button type="submit" class="btn btn-primary problemSubmitButton">Küldés</button></td>
			</tr>
		</table>
		</form:form>
		
	</div>
</div>

</body>

</html>