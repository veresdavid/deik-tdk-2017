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
	<title>Graphs</title>

</head>

<body>

<%@include file="header.jsp" %>

<div class="container pageContainer">
	<div class="row">
		
		<h1>Load graph</h1>
		
		<div>Load a graph by typing it's identifier to the input field below. You can generate new graphs by navigating back to the <a href="./problem">Home</a> page.</div>
		
		<c:choose>
		<c:when test="${error != null}">
			<div class="panel panel-danger response">
				<div class="panel-heading">Error!</div>
				<div class="panel-body">${error}</div>
			</div>
		</c:when>
		</c:choose>
		
		<div class="formDiv">
			<form method="GET" action="">
				<div class="row">
					<div class="col-sm-10">
						<input class="form-control" type="text" name="processIdentifier" id="processIdentifier" placeholder="Graph identifier" />
					</div>
					<div class="col-sm-2">
						<button class="btn btn-primary" type="submit">Load</button>
					</div>
				</div>
			</form>
		</div>
		
	</div>
</div>

</body>

</html>