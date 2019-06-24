<!DOCTYPE html>
<html>
	<head>
		<title>Result</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body>
		<div class="container">
	<div class="row clearfix">
		<div class="col-md-2 column">
			<h2>
				搜索
			</h2>
			<p>
				----------------------------
			</p>
			<p>
				 <a class="btn" href="/">Index »</a>
			</p>
		</div>
		<div class="col-md-6 column">
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
			<#list result as item>
				<div class="media">
				<a href="/get/${item.id}" class="pull-left"><img src="rearch.png" class="media-object" alt='' /></a>
				<div class="media-body">
					<h4 class="media-heading">
						${item.nameChinese}
					</h4> ${item.nameForeign}
				</div>
				</div>
			</#list>
		</div>
		<div class="col-md-2 column">
			<h2>
				结果
			</h2>
			<p>
				---------------------------------
			</p>
			
		</div>
	</div>
</div>
	</body>
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</html>