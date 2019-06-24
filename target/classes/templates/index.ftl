<!DOCTYPE html>
<html>
	<head>
		<title>index</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body>
		<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<h2 class="text-center">
				Bangumi_Community
			</h2>
			<nav class="navbar navbar-default" role="navigation">
				<div class="navbar-header">
					 <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button> <a class="navbar-brand" href="/">BANGUMI</a>
				</div>
				
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li class="active">
							 <a href="/getAllAnime">ANIME</a>
						</li>
						<li>
							 <a href="/getAllAnimeCharacter">ANIMECHARACTER</a>
						</li>
						<li>
							 <a href="/getAllVoiceActor">VOICEACTOR</a>
						</li>
					</ul>
					<form class="navbar-form navbar-left" role="search" action="/search" method="post">
						<div class="form-group">
							<input type="text" class="form-control" name="keyword"/>
						</div> <button type="submit" class="btn btn-default">Search</button>
					</form>
					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown">
							 <a href="#" class="dropdown-toggle" data-toggle="dropdown">关于用户<strong class="caret"></strong></a>
							<ul class="dropdown-menu">
							
								<#if isLogin>
									<li>
									 <a>${user.name}</a>
									</li>
								<#else>
									<li>
									 <a href="/login">登陆</a>
									</li>
								</#if>
								<li class="divider">
								</li>
								<li>
									 <a href="/logout">注销</a>
								</li>
							</ul>
						</li>
					</ul>
				</div>
				
			</nav>
			<div class="carousel slide" id="carousel-24139">
				<ol class="carousel-indicators">
					<li class="active" data-slide-to="0" data-target="#carousel-24139">
					</li>
					<li data-slide-to="1" data-target="#carousel-24139">
					</li>
					<li data-slide-to="2" data-target="#carousel-24139">
					</li>
				</ol>
				<div class="carousel-inner">
					<#list indexAnime as item>
						<#if item_index=0>
						<div class="item active">
						<a href="/get/${item.id}"><img alt="" src="/indexpicture/${item.cover}" /></a>
						<div class="carousel-caption">
							<h4>
								${item.nameChinese}
							</h4>
							<p>
								${item.nameForeign}
							</p>
						</div>
						</div>
						<#else>
						<div class="item">
						<a href="/get/${item.id}"><img alt="" src="/indexpicture/${item.cover}" /></a>
						<div class="carousel-caption">
							<h4>
								${item.nameChinese}
							</h4>
							<p>
								${item.nameForeign}
							</p>
						</div>
						</div>
						</#if>
					</#list>
					
				</div> <a class="left carousel-control" href="#carousel-24139" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a> <a class="right carousel-control" href="#carousel-24139" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
			</div> <address> <strong>Bangumi, Inc.</strong><br /><abbr title="Phone">P:</abbr>17551029712</address>
		</div>
	</div>
</div>
	</body>
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</html>