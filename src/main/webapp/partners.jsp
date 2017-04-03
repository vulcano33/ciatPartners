<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<link href="https://fonts.googleapis.com/css?family=Roboto"
	rel="stylesheet">
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<link rel="stylesheet" href="css/application.css" type="text/css" />
</head>
<body>
	<s:form action="/institution" method="post">
		<div class="container">

			<h1>CIAT Institutions</h1>
			<table class="table">
				<thead>
					<tr>
						<th>Branch</th>
						<th>Acronym</th>
						<th>Name</th>
						<th>Type</th>
						<th>Country</th>
						<th>City</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="institutions">
						<tr>
							<td><s:property value="branch" /></td>
							<td><s:property value="acronym" /></td>
							<td><s:property value="name" /></td>
							<td><s:property value="type" /></td>
							<td><s:property value="country" /></td>
							<td><s:property value="city" /></td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
			<p>
				<a class="btn btn-lg btn-success" href="institution" role="button">Add
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
