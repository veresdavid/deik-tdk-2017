<%@page contentType="text/html; charset=UTF-8" language="java"%>

<c:url value="/resources/images/header_universe.jpg" var="headerUniverse" />

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
					<a href="${pageContext.request.contextPath}">Home</a>
				</li>
				<li>
					<a href="${pageContext.request.contextPath}/graph">Graphs</a>
				</li>
				<li>
					<a href="https://github.com/veresdavid/deik-tdk-2017" target="_blank">Code on GitHub</a>
				</li>
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
			<img src="${headerUniverse}" alt="State-space Modelling Language">
			<div class="carousel-caption">
				<h3>Problem Representation Modelling Component</h3>
				<p>Describe your problems&#39;s state-space representation with an easy-to-use modelling language.</p>
			</div>
		</div>
		<div class="item">
			<img src="${headerUniverse}" alt="Solution Provider">
			<div class="carousel-caption">
				<h3>Solution Searcher Component</h3>
				<p>Search solutions for your problems with various built-in algorithms.</p>
			</div>
		</div>
		<div class="item">
			<img src="${headerUniverse}" alt="State Space Graph Visualizer">
			<div class="carousel-caption">
				<h3>Graph Visualizer Component</h3>
				<p>Visualize and interact with graphs traversed by search algorithms.</p>
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