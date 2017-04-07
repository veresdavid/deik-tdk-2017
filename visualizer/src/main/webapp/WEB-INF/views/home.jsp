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
	<title><spring:message code="title.home" /></title>

</head>

<body>

<%@include file="header.jsp" %>

<div class="container pageContainer">
	<div class="row">
		<h1>TODO</h1>
		<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed rutrum dignissim felis et luctus. Vivamus ac sollicitudin orci. Maecenas finibus vehicula lacus. Aliquam erat volutpat. Fusce congue velit in tellus cursus tincidunt. Maecenas quis tellus vitae ligula ornare varius. Donec a purus ex.</p>
		<p>Maecenas consequat mauris massa, ut aliquam metus tempus accumsan. Aenean ultricies eget tortor vitae placerat. Proin odio erat, sodales in accumsan vitae, aliquam vitae massa. Vivamus semper, velit nec luctus facilisis, sem purus tincidunt enim, id bibendum nisi nisl quis sapien. Pellentesque nec justo vitae arcu lacinia imperdiet. Proin dictum augue a ligula finibus porta a sed ex. Donec aliquet porta justo quis dignissim. Cras venenatis facilisis erat ut rutrum. Vivamus est enim, porttitor sed consequat sed, ornare non dolor. Maecenas efficitur non ligula a blandit. Vestibulum non porttitor erat.</p>
		<p>Duis non sapien augue. Morbi rhoncus a neque at vehicula. Sed vulputate ullamcorper felis, ac vestibulum tortor interdum in. Vestibulum luctus nulla et sagittis placerat. Morbi quis congue nulla. Mauris convallis pulvinar leo et viverra. Cras semper nulla eget dictum gravida. Sed iaculis, felis non mattis elementum, nunc turpis faucibus nisl, sed facilisis elit ex nec sapien.</p>
		<p>Vestibulum vel nunc risus. Integer in scelerisque tortor. Praesent eget arcu sit amet odio lacinia sollicitudin. Morbi quis lacus vestibulum, maximus eros at, dapibus leo. Mauris mauris mi, tristique vitae turpis ut, fermentum ornare felis. Vivamus nibh erat, vehicula et dapibus vitae, accumsan sit amet nisi. Pellentesque commodo libero urna, eget sodales ante tincidunt malesuada. Praesent vel nisi sit amet tellus dapibus porttitor ac vel eros. Donec fringilla euismod urna, sagittis porta est accumsan id. Ut id elit id orci dictum euismod. Suspendisse euismod ante non lorem congue, eu molestie mauris blandit. Phasellus vitae imperdiet orci. Aenean consectetur, erat in laoreet molestie, purus augue mollis enim, condimentum congue tellus odio non libero. Sed et sapien eget augue facilisis tempor. Donec hendrerit viverra sagittis.</p>
	</div>
</div>

</body>

</html>