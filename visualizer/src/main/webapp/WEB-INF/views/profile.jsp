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
	<c:url value="/resources/css/font-awesome.min.css" var="fontAwesome" />

	<link rel="stylesheet" type="text/css" href="${bootstrapCss}" />
	<link rel="stylesheet" type="text/css" href="${pageStyle}" />
	<script src="${jQuery}"></script>
	<script src="${bootstrapJs}"></script>
	<link rel="stylesheet" type="text/css" href="${fontAwesome}" />

	<meta charset="UTF-8">
	<title><spring:message code="title.profile" /></title>

</head>

<body>

<%@include file="header.jsp" %>

<div class="container pageContainer">

	<div class="row">

		<h1><span class="glyphicon glyphicon-user" aria-hidden="true"></span> ${pageContext.request.userPrincipal.name}</h1>

		<table class="table table-responsive profileTable">
            <tr>
                <td colspan="4"><h3><spring:message code="profile.table.processes" /></h3></td>
            </tr>
            <tr class="profileTableHeading">
                <td><spring:message code="profile.table.identifier" /></td>
                <td><spring:message code="profile.table.name" /></td>
                <td><spring:message code="profile.table.algorithm" /></td>
                <td class="processStatus"><spring:message code="profile.table.status" /></td>
            </tr>
            <c:forEach var="process" items="${processes}">
                <tr>
                    <td><a href="${pageContext.request.contextPath}/graph/view/${process.processIdentifier}">${process.processIdentifier}</a></td>
                    <td>${process.name}</td>
                    <td><spring:message code="${process.searchAlgorithm}" /></td>
                    <td class="processStatus">
                        <c:choose>
                            <c:when test="${process.done && !process.error}">
                                <span class="glyphicon glyphicon-ok-sign statusIcon" aria-hidden="true"></span>
                            </c:when>
                            <c:when test="${process.done && process.error}">
                                <span class="glyphicon glyphicon-remove-sign statusIcon" aria-hidden="true"></span>
                            </c:when>
                            <c:otherwise>
                                <i class="fa fa-spinner fa-spin" style="font-size: 20px;"></i>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </c:forEach>
        </table>

	</div>

</div>

</body>

</html>