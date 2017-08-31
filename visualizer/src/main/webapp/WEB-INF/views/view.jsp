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
	<c:url value="/resources/js/jquery.i18n.properties.js" var="jQueryi18n" />
	<c:url value="/resources/css/font-awesome.min.css" var="fontAwesome" />

	<link rel="stylesheet" type="text/css" href="${bootstrapCss}" />
	<link rel="stylesheet" type="text/css" href="${pageStyle}" />
	<script src="${jQuery}"></script>
	<script src="${bootstrapJs}"></script>
	<script src="${d3js}"></script>
	<script>var locale = "${pageContext.response.locale}";</script>
    <script src="${jQueryi18n}"></script>
    <link rel="stylesheet" type="text/css" href="${fontAwesome}" />

	<meta charset="UTF-8">
	<title><spring:message code="title.view" /></title>

</head>

<body>

<%@include file="header.jsp" %>

<div class="container pageContainer">
	<div class="row">
		
		<h1>${processDTO.name}</h1>
		
		<c:choose>
		
		<c:when test="${processDTO.done == false}">
			<h3><i class="fa fa-spinner fa-spin" style="font-size: 30px;"></i> <spring:message code="view.in.progress" /></h3>
		</c:when>
		
		<c:when test="${processDTO.done == true && processDTO.error == false}">

		<div class="graphControl">
			<button class="btn btn-primary graphControlButton" id="stepButton"><spring:message code="view.button.step" /></button>
			<button class="btn btn-primary graphControlButton" id="backButton"><spring:message code="view.button.back" /></button>
			<button class="btn btn-primary graphControlButton" id="solutionButton"><spring:message code="view.button.solution" /></button>
		</div>
		<div class="graphControl"><h4><spring:message code="view.count.step" />: <span id="actualStepNumber">0</span> / <span id="allStepsNumber"></span></h4><div>

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
				<td colspan="2"><h3><spring:message code="view.table.information" /></h3></td>
			</tr>
			<tr>
				<td><spring:message code="view.table.graph.identifier" />:</td>
				<td>${processDTO.processIdentifier}</td>
			</tr>
			<tr>
				<td><spring:message code="view.table.algorithm" />:</td>
				<td><span id="searchAlgorithm"></span></td>
			</tr>
			<tr>
				<td><spring:message code="view.table.solution.found" />:</td>
				<td><span id="solutionInformation"></span></td>
			</tr>
			<tr>
				<td><spring:message code="view.table.nodes" />:</td>
				<td><span id="numberOfNodes"></span></td>
			</tr>
			<tr>
				<td><spring:message code="view.table.edges" />:</td>
				<td><span id="numberOfEdges"></span></td>
			</tr>
			<tr>
				<td><spring:message code="view.table.steps" />:</td>
				<td><span id="numberOfSteps"></span></td>
			</tr>
			<tr>
				<td><spring:message code="view.table.statespace" />:</td>
				<td><a href="${pageContext.request.contextPath}/file/statespace/${processDTO.stateSpaceFileName}" target="_blank">${processDTO.stateSpaceFileName}.txt</a></td>
			</tr>
			<tr>
				<td><spring:message code="view.table.java" />:</td>
				<td>
					<c:forEach var="javaFileName" items="${javaFileNames}">
						<a href="${pageContext.request.contextPath}/file/java/${processDTO.javaPackageName}/${javaFileName}" target="_blank">${javaFileName}.java</a><br/>
					</c:forEach>
				</td>
			</tr>
			<tr>
				<td><spring:message code="view.table.solution" />:</td>
				<td><a href="${pageContext.request.contextPath}/file/solution/${processDTO.solutionFileName}" target="_blank">${processDTO.solutionFileName}.txt</a></td>
			</tr>
			<tr>
				<td><spring:message code="view.table.json" />:</td>
				<td><a href="${pageContext.request.contextPath}/file/json/${processDTO.processIdentifier}" target="_blank">${processDTO.processIdentifier}.json</a></td>
			</tr>
		</table>
		
		</c:when>
		
		<c:when test="${processDTO.done == true && processDTO.error == true}">
			<div class="panel panel-danger response">
				<div class="panel-heading"><spring:message code="view.error.heading" /></div>
				<div class="panel-body">${processDTO.errorMessage}</div>
			</div>
		</c:when>

		</c:choose>
		
	</div>
</div>

</body>

</html>