<!DOCTYPE html>
<html>
	<head>
		<title>anime_tag</title>
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
				</div>
				
			</nav>
			<h2>${animeTag.name}</h2>
			<ul>
				<li>
					介绍：<#if animeTag.information??>
						${anime.information}
					</#if>
				</li>
				<li>
					标签：<#list animeTag.anime as anime>
						<a href="/get/${anime.id}">${anime.nameChinese}、</a>
					</#list>
				</li>
				
			</ul>
		</div>
	</div>
</div>
	</body>
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</html>