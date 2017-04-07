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

	<link rel="stylesheet" type="text/css" href="${bootstrapCss}" />
	<link rel="stylesheet" type="text/css" href="${pageStyle}" />
	<script src="${jQuery}"></script>
	<script src="${bootstrapJs}"></script>

	<meta charset="UTF-8">
	<title><spring:message code="title.graphs" /></title>

</head>

<body>

<%@include file="header.jsp" %>

<div class="container pageContainer">
	<div class="row">
		
		<h1>Gráf keresése</h1>
		
		<div>A lenti szövegmezőbe add meg a gráfod azonosítóját, amit a feltöltés után kaptál. Ha még nem töltöttél fel gráfot, az <a href="./upload">Új gráf</a> gombra kattintva megteheted.</div>
		
		<c:choose>
		<c:when test="${error != null}">
			<div class="panel panel-danger response">
				<div class="panel-heading">HIBA!</div>
				<div class="panel-body">${error}</div>
			</div>
		</c:when>
		</c:choose>
		
		<div class="formDiv">
			<form method="GET" action="">
				<div class="row">
					<div class="col-sm-10">
						<input class="form-control" type="text" name="processIdentifier" id="processIdentifier" placeholder="Gráf azonosító" />
					</div>
					<div class="col-sm-2">
						<button class="btn btn-primary" type="submit">Betöltés</button>
					</div>
				</div>
			</form>
		</div>
		
	</div>
</div>

</body>

</html>