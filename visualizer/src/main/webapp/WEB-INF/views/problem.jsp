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

	<link rel="stylesheet" type="text/css" href="${bootstrapCss}" />
	<link rel="stylesheet" type="text/css" href="${pageStyle}" />
	<script src="${jQuery}"></script>
	<script src="${bootstrapJs}"></script>
	<script>var demosJson = "${demosJson}";</script>
	<script src="${formJs}"></script>
	<script src="${problemJs}"></script>
	<script>var context = "${pageContext.request.contextPath}";</script>
	<link rel="stylesheet" type="text/css" href="${fontAwesome}" />

	<meta charset="UTF-8">
	<title>New problem</title>

</head>

<body>

<%@include file="header.jsp" %>

<div id="success" class="panel panel-success">
    <div class="panel-heading">Success</div>
    <div class="panel-body"></div>
</div>

<div id="serverSideError" class="panel panel-danger">
    <div class="panel-heading">Server-side error</div>
    <div class="panel-body">Please try again, or come back later.</div>
</div>

<div id="information" class="panel panel-default">
    <div class="panel-heading">Loading</div>
    <div class="panel-body">
        <center><i class="fa fa-spinner fa-spin" style="font-size:40px;"></i></center>
    </div>
</div>

<div class="container pageContainer">
	<div class="row">

		<table class="table table-responsive problemTable">
		    <tr>
		        <td>Name: *</td>
		        <td>
		            <input type="text" class="form-control" id="name" />
		            <div id="nameErrors" class="alert alert-danger fieldErrors"></div>
		        </td>
		    </tr>
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
				<td>
                    <textarea rows="20" cols="60" class="form-control problemTextarea" resizeable="false" id="stateSpace"></textarea>
                    <div id="stateSpaceErrors" class="alert alert-danger fieldErrors"></div>
				</td>
			</tr>
			<tr>
				<td>Search algorithms: *</td>
				<td>
					<input type="checkbox" class="algorithmCheckbox" value="BackTrackSimple" />Backtrack<br/>
					<input type="checkbox" class="algorithmCheckbox" value="BackTrackCircle" />Backtrack with cycle detection<br/>
					<input type="checkbox" class="algorithmCheckbox" value="BackTrackPathLengthLimitation" />Backtrack with pathlength limitation , Limit: <input type="number" min="1" class="form-control" id="backTrackPathLengthLimitationLimit" /><br/>
					<input type="checkbox" class="algorithmCheckbox" value="BackTrackOptimal" />Backtrack branch and bound , Limit: <input type="number" min="1" class="form-control" id="backTrackOptimalLimit" /><br/>
					<input type="checkbox" class="algorithmCheckbox" value="BreadthFirst" />Breadth-first<br/>
					<input type="checkbox" class="algorithmCheckbox" value="DepthFirst" />Depth-first<br/>
					<input type="checkbox" class="algorithmCheckbox" value="Optimal" />Optimal<br/>
					<input type="checkbox" class="algorithmCheckbox" value="BestFirst" />Best-first<br/>
					<input type="checkbox" class="algorithmCheckbox" value="A" />A<br/>
					<div id="algorithmErrors" class="alert alert-danger fieldErrors"></div>
				</td>
			</tr>
			<tr>
				<td>Visualize the traversed state-space tree:</td>
				<td><input type="checkbox" value="true" id="doTree" /></td>
			</tr>
			<tr>
				<td>Heuristic:</td>
				<td><textarea rows="2" cols="60" class="form-control problemTextarea" id="heuristic"></textarea></td>
			</tr>
			<tr>
				<td>Variables in heuristic function:</td>
				<td><textarea rows="2" cols="60" class="form-control problemTextarea" id="variablesInHeuristicFunction"></textarea></td>
			</tr>
			<tr>
				<td colspan="2" class="formInformation">* Denotes required field</td>
			</tr>
			<tr>
			    <td colspan="2"><button id="problemSubmitButton" onclick="newProblem()" class="btn btn-primary problemSubmitButton">Submit</button></td>
			</tr>
		</table>
		
	</div>
</div>

</body>

</html>