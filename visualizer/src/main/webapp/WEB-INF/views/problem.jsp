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
	<c:url value="/resources/js/problem.js" var="problemJs" />
	<c:url value="/resources/css/font-awesome.min.css" var="fontAwesome" />
	<c:url value="/resources/js/jquery.i18n.properties.js" var="jQueryi18n" />

	<link rel="stylesheet" type="text/css" href="${bootstrapCss}" />
	<link rel="stylesheet" type="text/css" href="${pageStyle}" />
	<script src="${jQuery}"></script>
	<script src="${bootstrapJs}"></script>
	<script>var demosJson = "${demosJson}";</script>
	<script src="${formJs}"></script>
	<script src="${problemJs}"></script>
	<script>var context = "${pageContext.request.contextPath}";</script>
	<link rel="stylesheet" type="text/css" href="${fontAwesome}" />
	<script>var locale = "${pageContext.response.locale}";</script>
	<script src="${jQueryi18n}"></script>

	<meta charset="UTF-8">
	<title><spring:message code="title.problem" /></title>

</head>

<body>

<%@include file="header.jsp" %>

<div id="success" class="panel panel-success">
    <div class="panel-heading"><spring:message code="problem.success.heading" /></div>
    <div class="panel-body"><spring:message code="problem.success.description" /></div>
</div>

<div id="serverSideError" class="panel panel-danger">
    <div class="panel-heading"><spring:message code="problem.error.serverside.heading" /></div>
    <div class="panel-body"><spring:message code="problem.error.serverside.description" /></div>
</div>

<div id="information" class="panel panel-default">
    <div class="panel-heading"><spring:message code="problem.information.heading" /></div>
    <div class="panel-body">
        <center><i class="fa fa-spinner fa-spin" style="font-size:40px;"></i></center>
    </div>
</div>

<div class="container pageContainer">
	<div class="row">

		<table class="table table-responsive problemTable">
		    <tr>
		        <td><spring:message code="problem.form.name" />: *</td>
		        <td>
		            <input type="text" class="form-control" id="name" />
		            <div id="nameErrors" class="alert alert-danger fieldErrors"></div>
		        </td>
		    </tr>
			<tr>
				<td><spring:message code="problem.form.demos" />:</td>
				<td>
					<span class="btn btn-primary" id="demoHanoi"><spring:message code="problem.demo.hanoi" /></span>
					<span class="btn btn-primary" id="demoKnight"><spring:message code="problem.demo.knight" /></span>
					<span class="btn btn-primary" id="demoQueens"><spring:message code="problem.demo.nqueen" /></span>
					<span class="btn btn-primary" id="demoJugs"><spring:message code="problem.demo.jugs" /></span>
				</td>
			</tr>
			<tr>
				<td><spring:message code="problem.form.statespace" />: *</td>
				<td>
                    <textarea rows="20" cols="60" class="form-control problemTextarea" resizeable="false" id="stateSpace"></textarea>
                    <div id="stateSpaceErrors" class="alert alert-danger fieldErrors"></div>
				</td>
			</tr>
			<tr>
				<td><spring:message code="problem.form.algorithms" />: *</td>
				<td>
					<input type="checkbox" class="algorithmCheckbox" value="BackTrackSimple" /><spring:message code="problem.algorithm.backtrack.simple" /><br/>
					<input type="checkbox" class="algorithmCheckbox" value="BackTrackCircle" /><spring:message code="problem.algorithm.backtrack.circle" /><br/>
					<input type="checkbox" class="algorithmCheckbox" value="BackTrackPathLengthLimitation" /><spring:message code="problem.algorithm.backtrack.path.length.limit" /> , <spring:message code="problem.form.limit" />: <input type="number" min="1" class="form-control" id="backTrackPathLengthLimitationLimit" /><br/>
					<input type="checkbox" class="algorithmCheckbox" value="BackTrackOptimal" /><spring:message code="problem.algorithm.backtrack.optimal" /> , <spring:message code="problem.form.limit" />: <input type="number" min="1" class="form-control" id="backTrackOptimalLimit" /><br/>
					<input type="checkbox" class="algorithmCheckbox" value="BreadthFirst" /><spring:message code="problem.algorithm.breadth.first" /><br/>
					<input type="checkbox" class="algorithmCheckbox" value="DepthFirst" /><spring:message code="problem.algorithm.depth.first" /><br/>
					<input type="checkbox" class="algorithmCheckbox" value="Optimal" /><spring:message code="problem.algorithm.optimal" /><br/>
					<input type="checkbox" class="algorithmCheckbox" value="BestFirst" /><spring:message code="problem.algorithm.best.first" /><br/>
					<input type="checkbox" class="algorithmCheckbox" value="A" /><spring:message code="problem.algorithm.a" /><br/>
					<h4 class="customSearchAlgorithmsHeading"><spring:message code="problem.form.custom.search.algorithm" /></h4>
					<div id="customSearchAlgorithms">
					</div>
					<span id="newCustomSearchAlgorithm" onclick="addNewCustomSearchAlgorithm()" class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span>
					<div id="algorithmErrors" class="alert alert-danger fieldErrors"></div>
				</td>
			</tr>
			<tr>
				<td><spring:message code="problem.form.statespace.tree" />:</td>
				<td><input type="checkbox" value="true" id="doTree" /></td>
			</tr>
			<tr>
				<td><spring:message code="problem.form.heuristic" />:</td>
				<td><textarea rows="2" cols="60" class="form-control problemTextarea" id="heuristic"></textarea></td>
			</tr>
			<tr>
				<td><spring:message code="problem.form.heuristic.variables" />:</td>
				<td><textarea rows="2" cols="60" class="form-control problemTextarea" id="variablesInHeuristicFunction"></textarea></td>
			</tr>
			<tr>
				<td colspan="2" class="formInformation"><spring:message code="problem.form.required" /></td>
			</tr>
			<tr>
			    <td colspan="2"><button id="problemSubmitButton" onclick="postForm()" class="btn btn-primary problemSubmitButton"><spring:message code="problem.form.submit" /></button></td>
			</tr>
		</table>
		
	</div>
</div>

</body>

</html>