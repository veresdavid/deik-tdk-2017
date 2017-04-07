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
		
		<h1>Gráf megtekintő</h1>
		
		<c:choose>
		<c:when test="${processDTO.done == true && processDTO.error == false}">

		<p>
		<button id="stepButton">STEP</button>
		<button id="backButton">BACK</button>
		<button id="solutionButton">SOLUTION</button>
		</p>

		<svg width="960" height="600"></svg>

		<div id="operatorDescription"></div>
		<div id="nodeDescription"></div>

		<c:url value="/resources/js/graph.js" var="graphJs" />
		<script src="${graphJs}"></script>
		<script>
			initGraph("${pageContext.request.contextPath}/file/json/${processDTO.processIdentifier}");
		</script>
		</c:when>
		<c:when test="${processDTO.done == true && processDTO.error == true}">
			<div class="panel panel-danger response">
				<div class="panel-heading">Hiba!</div>
				<div class="panel-body">${processDTO.errorMessage}</div>
			</div>
		</c:when>

		</c:choose>
		
	</div>
</div>

</body>

</html>