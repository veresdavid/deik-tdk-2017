<%@page contentType="text/html; charset=UTF-8" language="java"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>

<c:url value="/resources/images/header_universe.jpg" var="headerUniverse" />
<c:url value="/resources/images/flag-hu.png" var="flagHU" />
<c:url value="/resources/images/flag-gb.png" var="flagEN" />
<sec:authorize var="loggedIn" access="isAuthenticated()" />

<c:choose>
    <c:when test="${loggedIn}">
        <nav class="navbar navbar-inverse headerNavbar">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand headerBrand" href="${pageContext.request.contextPath}"><spring:message code="header.title" /></a>
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li>
                            <a href="${pageContext.request.contextPath}"><spring:message code="header.home" /></a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/profile"><spring:message code="header.profile" /></a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/problem"><spring:message code="header.problem" /></a>
                        </li>
                        <sec:authorize access="hasRole('ADMIN')">
                            <li>
                                <a href="${pageContext.request.contextPath}/admin"><spring:message code="header.admin" /></a>
                            </li>
                        </sec:authorize>
                        <li>
                            <a href="${pageContext.request.contextPath}/logout"><spring:message code="header.logout" /></a>
                        </li>
                        <li>
                            <a href="https://github.com/veresdavid/deik-tdk-2017" target="_blank"><spring:message code="header.github" /></a>
                        </li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="?locale=hu"><img src="${flagHU}" class="countryFlag" /></a></li>
                        <li><a href="?locale=en"><img src="${flagEN}" class="countryFlag" /></a></li>
                    </ul>
                </div>
                <!-- /.navbar-collapse -->
            </div>
            <!-- /.container-fluid -->
        </nav>
    </c:when>
    <c:otherwise>
        <nav class="navbar navbar-inverse headerNavbar">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand headerBrand" href="${pageContext.request.contextPath}"><spring:message code="header.title" /></a>
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li>
                            <a href="${pageContext.request.contextPath}"><spring:message code="header.home" /></a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/login"><spring:message code="header.login" /></a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/registration"><spring:message code="header.registration" /></a>
                        </li>
                        <li>
                            <a href="https://github.com/veresdavid/deik-tdk-2017" target="_blank"><spring:message code="header.github" /></a>
                        </li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="?locale=hu"><img src="${flagHU}" class="countryFlag" /></a></li>
                        <li><a href="?locale=en"><img src="${flagEN}" class="countryFlag" /></a></li>
                    </ul>
                </div>
                <!-- /.navbar-collapse -->
            </div>
            <!-- /.container-fluid -->
        </nav>
    </c:otherwise>
</c:choose>

<div id="headerCarousel" class="carousel slide" data-ride="carousel">
	<!-- Indicators -->
	<ol class="carousel-indicators">
		<li data-target="#headerCarousel" data-slide-to="0" class="active"></li>
		<li data-target="#headerCarousel" data-slide-to="1"></li>
		<li data-target="#headerCarousel" data-slide-to="2"></li>
	</ol>
	<!-- Wrapper for slides -->
	<div class="carousel-inner" role="listbox">
		<div class="item active">
			<img src="${headerUniverse}" alt="State-space Modelling Language">
			<div class="carousel-caption">
				<h3><spring:message code="header.carousel.title.1" /></h3>
				<p><spring:message code="header.carousel.description.1" /></p>
			</div>
		</div>
		<div class="item">
			<img src="${headerUniverse}" alt="Solution Provider">
			<div class="carousel-caption">
				<h3><spring:message code="header.carousel.title.2" /></h3>
				<p><spring:message code="header.carousel.description.2" /></p>
			</div>
		</div>
		<div class="item">
			<img src="${headerUniverse}" alt="State Space Graph Visualizer">
			<div class="carousel-caption">
				<h3><spring:message code="header.carousel.title.3" /></h3>
				<p><spring:message code="header.carousel.description.3" /></p>
			</div>
		</div>
	</div>
	<!-- Left and right controls -->
	<a class="left carousel-control" href="#headerCarousel" role="button" data-slide="prev">
	<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
	<span class="sr-only"><spring:message code="header.carousel.navigation.previous" /></span>
	</a>
	<a class="right carousel-control" href="#headerCarousel" role="button" data-slide="next">
	<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
	<span class="sr-only"><spring:message code="header.carousel.navigation.next" /></span>
	</a>
</div>