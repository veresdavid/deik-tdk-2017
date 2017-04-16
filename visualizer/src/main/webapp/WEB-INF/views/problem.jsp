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
	<c:url value="/resources/js/form.js" var="formJs" />
	<c:url value="/resources/demo/demos.json" var="demosJson" />

	<link rel="stylesheet" type="text/css" href="${bootstrapCss}" />
	<link rel="stylesheet" type="text/css" href="${pageStyle}" />
	<script src="${jQuery}"></script>
	<script src="${bootstrapJs}"></script>
	<script>var demosJson = "${demosJson}";</script>
	<script src="${formJs}"></script>

	<meta charset="UTF-8">
	<title>New problem</title>

</head>

<body>

<%@include file="header.jsp" %>

<div class="container pageContainer">
	<div class="row">
		
		<c:choose>
			<c:when test="${errorMessages != null}">
				<div class="panel panel-danger response">
					<div class="panel-heading">Error!</div>
					<div class="panel-body">
						<c:forEach var="errorMessage" items="${errorMessages}">
							${errorMessage}<br/>
						</c:forEach>
					</div>
				</div>
			</c:when>
		</c:choose>
		
		<form:form method="POST" modelAttribute="problemForm" action="">
		<table class="table table-responsive problemTable">
			<!-- <tr>
				<td colspan="2"><h1>New problem</h1></td>
			</tr> -->
			<tr>
				<td>Demos:</td>
				<td>
					<span class="btn btn-primary" id="demoHanoi">Hanoi towers</span>
					<span class="btn btn-primary" id="demoKnight">Knight's tour</span>
					<span class="btn btn-primary" id="demoQueens">N-queens</span>
					<span class="btn btn-primary" id="demoJugs">Three jugs</span>
				</td>
			</tr>
			<tr>
				<td>State-space: *</td>
				<td><form:textarea path="stateSpace" rows="20" cols="60" class="form-control problemTextarea" resizeable="false" id="stateSpace" /></td>
			</tr>
			<tr>
				<td>Search algorithms: *</td>
				<td>
					<form:checkbox path="algorithms" value="BackTrackSimple" />Backtrack<br/>
					<form:checkbox path="algorithms" value="BackTrackCircle" />Backtrack with cycle detection<br/>
					<form:checkbox path="algorithms" value="BackTrackPathLengthLimitation" />Backtrack with pathlength limitation , Limit: <form:input type="number" min="1" path="backTrackPathLengthLimitationLimit" class="form-control" id="backTrackPathLengthLimitationLimit" /><br/>
					<form:checkbox path="algorithms" value="BackTrackOptimal" />Backtrack branch and bound , Limit: <form:input type="number" min="1" path="backTrackOptimalLimit" class="form-control" id="backTrackOptimalLimit" /><br/>
					<form:checkbox path="algorithms" value="BreadthFirst" />Breadth-first<br/>
					<form:checkbox path="algorithms" value="DepthFirst" />Depth-first<br/>
					<form:checkbox path="algorithms" value="Optimal" />Optimal<br/>
					<form:checkbox path="algorithms" value="BestFirst" />Best-first<br/>
					<form:checkbox path="algorithms" value="A" />A<br/>
				</td>
			</tr>
			<tr>
				<td>Visualize the traversed state-space tree:</td>
				<td><form:checkbox path="doTree" value="true" /></td>
			</tr>
			<tr>
				<td>Heuristic:</td>
				<td><form:textarea path="heuristic" rows="2" cols="60" class="form-control problemTextarea" /></td>
			</tr>
			<tr>
				<td>Variables in heuristic function:</td>
				<td><form:textarea path="variablesInHeuristicFunction" rows="2" cols="60" class="form-control problemTextarea" /></td>
			</tr>
			<tr>
				<td colspan="2" class="formInformation">* Denotes required field</td>
			</tr>
			<tr>
				<td colspan="2"><button type="submit" class="btn btn-primary problemSubmitButton">Submit</button></td>
			</tr>
		</table>
		</form:form>
		
	</div>
</div>

</body>

</html>