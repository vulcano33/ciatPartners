<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<link href="https://fonts.googleapis.com/css?family=Roboto"
	rel="stylesheet">
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<link rel="stylesheet" href="css/application.css" type="text/css" />
</head>
<body>
	<s:form action="/list" method="post">
		<div class="container">

			<h1>CIAT Institutions</h1>
			<h3>List of partners</h3>
			<p>
				<a class="btn btn-lg btn-success" href="#" role="button">Add
					institution</a>
			</p>
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
