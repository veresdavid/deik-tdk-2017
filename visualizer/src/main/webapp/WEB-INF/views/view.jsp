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
	<c:url value="/resources/js/d3.min.js" var="d3js" />

	<link rel="stylesheet" type="text/css" href="${bootstrapCss}" />
	<link rel="stylesheet" type="text/css" href="${pageStyle}" />
	<script src="${jQuery}"></script>
	<script src="${bootstrapJs}"></script>
	<script src="${d3js}"></script>

	<meta charset="UTF-8">
	<title>Graph</title>

</head>

<body>

<%@include file="header.jsp" %>

<div class="container pageContainer">
	<div class="row">
		
		<h1>Graph visualizer</h1>
		
		<c:choose>
		
		<c:when test="${processDTO.done == false}">
			<h3>In progress...</h3>
		</c:when>
		
		<c:when test="${processDTO.done == true && processDTO.error == false}">

		<div class="graphControl">
			<button class="btn btn-primary graphControlButton" id="stepButton">Step</button>
			<button class="btn btn-primary graphControlButton" id="backButton">Back</button>
			<button class="btn btn-primary graphControlButton" id="solutionButton">Solution</button>
		</div>
		<div class="graphControl"><h4>Step: <span id="actualStepNumber">0</span> / <span id="allStepsNumber"></span></h4><div>

		<svg width="960" height="600"></svg>

		<div id="operatorDescription"></div>
		<div id="nodeDescription"></div>

		<c:url value="/resources/js/graph.js" var="graphJs" />
		<script src="${graphJs}"></script>
		<script>
			initGraph("${pageContext.request.contextPath}/file/json/${processDTO.processIdentifier}");
		</script>
		
		<table class="table table-responsive informationTable">
			<tr>
				<td colspan="2"><h3>Informations</h3></td>
			</tr>
			<tr>
				<td>Graph identifier:</td>
				<td>${processDTO.processIdentifier}</td>
			</tr>
			<tr>
				<td>Search algorithm:</td>
				<td><span id="searchAlgorithm"></span></td>
			</tr>
			<tr>
				<td>Solution found:</td>
				<td><span id="solutionInformation"></span></td>
			</tr>
			<tr>
				<td>Number of nodes:</td>
				<td><span id="numberOfNodes"></span></td>
			</tr>
			<tr>
				<td>Number of edges:</td>
				<td><span id="numberOfEdges"></span></td>
			</tr>
			<tr>
				<td>Number of steps:</td>
				<td><span id="numberOfSteps"></span></td>
			</tr>
			<tr>
				<td>State-space representation:</td>
				<td><a href="${pageContext.request.contextPath}/file/statespace/${processDTO.stateSpaceFileName}" target="_blank">${processDTO.stateSpaceFileName}.txt</a></td>
			</tr>
			<tr>
				<td>Java files:</td>
				<td>
					<c:forEach var="javaFileName" items="${javaFileNames}">
						<a href="${pageContext.request.contextPath}/file/java/${processDTO.javaPackageName}/${javaFileName}" target="_blank">${javaFileName}.java</a><br/>
					</c:forEach>
				</td>
			</tr>
			<tr>
				<td>Solution output:</td>
				<td><a href="${pageContext.request.contextPath}/file/solution/${processDTO.solutionFileName}" target="_blank">${processDTO.solutionFileName}.txt</a></td>
			</tr>
			<tr>
				<td>JSON output:</td>
				<td><a href="${pageContext.request.contextPath}/file/json/${processDTO.processIdentifier}" target="_blank">${processDTO.processIdentifier}.json</a></td>
			</tr>
		</table>
		
		</c:when>
		
		<c:when test="${processDTO.done == true && processDTO.error == true}">
			<div class="panel panel-danger response">
				<div class="panel-heading">Error!</div>
				<div class="panel-body">${processDTO.errorMessage}</div>
			</div>
		</c:when>

		</c:choose>
		
	</div>
</div>

</body>

</html>