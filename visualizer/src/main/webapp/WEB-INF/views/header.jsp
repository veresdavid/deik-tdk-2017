<%@page contentType="text/html; charset=UTF-8" language="java"%>
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
			<a class="navbar-brand headerBrand" href="${pageContext.request.contextPath}">TDK 2017</a>
		</div>
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse" id="navbar-collapse">
			<ul class="nav navbar-nav">
				<li>
					<a href="${pageContext.request.contextPath}">
						<spring:message code="title.home" />
					</a>
				</li>
				<!-- <li>
					<a href="${pageContext.request.contextPath}/upload">
						<spring:message code="title.new.graph" />
					</a>
				</li> -->
				<li>
					<a href="${pageContext.request.contextPath}/problem">
						Új probléma
					</a>
				</li>
				<li>
					<a href="${pageContext.request.contextPath}/graph">
						<spring:message code="title.graphs" />
					</a>
				</li>
				<li>
					<a href="#">
						<spring:message code="title.other" />
					</a>
				</li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="?locale=hu"><img src="http://www.free-country-flags.com/countries/Hungary/4/tiny/Hungary.png"></a></li>
				<li><a href="?locale=en"><img src="http://www.free-country-flags.com/countries/United_Kingdom/4/tiny/United_Kingdom.png"></a></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
</nav>

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
			<img src="https://s-media-cache-ak0.pinimg.com/originals/7d/0b/25/7d0b25b065091c9c88d1e8f39dbbe7f8.jpg" alt="Chania">
			<div class="carousel-caption">
				<h3>Innovatív</h3>
				<p>A vízeséses modell terminológiája szerint ajánlott hash-elni a flexibilis erőforrás-leíró keretrendszert.</p>
			</div>
		</div>
		<div class="item">
			<img src="https://s-media-cache-ak0.pinimg.com/originals/7d/0b/25/7d0b25b065091c9c88d1e8f39dbbe7f8.jpg" alt="Chania">
			<div class="carousel-caption">
				<h3>Hatékony</h3>
				<p>A felhasználói szokásokat figyelembe véve ajánlott kommentelni a flexibilis futási időt.</p>
			</div>
		</div>
		<div class="item">
			<img src="https://s-media-cache-ak0.pinimg.com/originals/7d/0b/25/7d0b25b065091c9c88d1e8f39dbbe7f8.jpg" alt="Flower">
			<div class="carousel-caption">
				<h3>Felhasználóbarát</h3>
				<p>A gördülékeny, felhasználóbarát működés miatt kívánatos optimalizálni az alapértelmezett lekérdezéseket.</p>
			</div>
		</div>
	</div>
	<!-- Left and right controls -->
	<a class="left carousel-control" href="#headerCarousel" role="button" data-slide="prev">
	<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
	<span class="sr-only">Previous</span>
	</a>
	<a class="right carousel-control" href="#headerCarousel" role="button" data-slide="next">
	<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
	<span class="sr-only">Next</span>
	</a>
</div>