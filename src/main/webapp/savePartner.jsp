<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<link href="https://fonts.googleapis.com/css?family=Roboto"
	rel="stylesheet">
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<link rel="stylesheet" href="css/application.css" type="text/css" />
</head>
<body>

	<s:if test="hasActionErrors()">
		<div class="errors">
			<s:actionerror />
		</div>
	</s:if>
	<s:form action="/register" method="post" cssClass="form-signin">
		<h2 class="form-signin-heading">Request a new CIAT Institution</h2>
		<blockquote>
			<p>Please enter the institution as a "Partner", the legal entity.
				The name of the institution should be in its official language(e.g.
				for CIAT: Centro Internacional de Agricultura Tropical).</p>
		</blockquote>

		<div class="container-fluid">
			<div class="row">
				<div class="col-md-2">
					<label for="branch">Is this institution a branch?</label>
				</div>
				<div class="col-md-3">
					<s:radio id="branch" name="institution_branch" list="options"
						value="institution.branch" onChange="genderChange(this.value)" />
				</div>
			</div>
			<div class="row">
				<div class="col-md-2" id="headquarterLabel">
					<label>Headquarter</label>
				</div>
				<div class="col-md-3" id="headquarterValue">
					<s:select label="Select an institution headquarter" headerKey="-1"
						headerValue="Select an institution headquarter"
						list="institutionsList" name="institution.headquarter"
						value="institution.headquarter" />
				</div>
			</div>
			<div class="row">
				<div class="col-md-2">
					<label for="institution_name">Name</label>
				</div>
				<div class="col-md-3">
					<input size="29" type="text" id="institution_name" name="institution.name"
						value="<s:property value='institution.name'/>" />
				</div>
			</div>
			<div class="row">
				<div class="col-md-2">
					<label for="institution_acronym">Acronym</label>
				</div>
				<div class="col-md-3">
					<input size="29" type="text" id="institution_acronym"
						name="institution.acronym" max="10"
						value="<s:property value='institution.acronym'/>" />
				</div>
			</div>
			<div class="row">
				<div class="col-md-2">
					<label>Institution type</label>
				</div>
				<div class="col-md-3">
					<s:select label="Select an institution type" headerKey="-1"
						headerValue="Select an institution type" list="institutionTypes"
						name="institution.type" value="institution.type" />
				</div>
			</div>
			<div class="row">
				<div class="col-md-2">
					<label>Country</label>
				</div>
				<div class="col-md-3">
					<s:select label="Country" headerKey="-1"
						headerValue="Select a country" list="countries"
						name="institution.country" value="institution.country" />
				</div>
			</div>
			<div class="row">
				<div class="col-md-2">
					<label for="institution_city">City</label>
				</div>
				<div class="col-md-3">
					<input size="29" type="text" id="institution_city" name="institution.city"
						value="<s:property value='institution.city'/>" />
				</div>
			</div>
			<div class="row">
				<div class="col-md-2">
					<label for="institution_url">URL</label>
				</div>
				<div class="col-md-3">
					<input size="29" placeholder="http://" type="text" id="institution_url" name="institution.url"
						value="<s:property value='institution.url'/>" />
				</div>
			</div>
			<div class="row"></div>
			<div class="row">
				<div class="col-md-2"></div>
				<div class="col-md-3">
					<p>
						<a class="btn btn-lg btn-success" href="institution" role="button">Request to add a new partner</a>
					</p>
				</div>
			</div>
		</div>
	</s:form>
	<footer class="footer">
		<p>&copy; 2017 CIAT, CGIAR research program.</p>
	</footer>

	<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/application.js"></script>
</body>
</html>
