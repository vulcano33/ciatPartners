<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<link href="https://fonts.googleapis.com/css?family=Roboto"
	rel="stylesheet">
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<link rel="stylesheet" href="css/application.css" type="text/css" />
</head>
<body>

	<s:if test="hasActionMessages()">
		<div class="alert alert-success">
			<strong>Success!</strong><s:actionmessage />
		</div>
	</s:if>
	<s:form action="/list" method="post">
		<div class="container">

			<div class="jumbotron">
				<h1>CIAT Partners 2</h1>
				<p class="lead">Welcome to the CIAT partners website.</p>
				<p>
					<a class="btn btn-lg btn-success" href="list" role="button">View the list</a>
				</p>
			</div>

			<footer class="footer">
				<p>&copy; 2017 CIAT, CGIAR research program.</p>
			</footer>

		</div>
		<!-- /container -->
	</s:form>

	<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>
