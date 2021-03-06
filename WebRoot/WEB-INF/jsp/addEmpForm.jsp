<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
	<head>
		<title>Add Employee</title>
		<link rel="stylesheet"
			href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
		<!--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
		-->
		<style>
.error {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}
</style>
	</head>

	<body>
	<div class = "page-header">
   		<h2> Add New Employee<small></small></h2>
	</div>
	
<div class="col-sm-6">
		<form:form method="post" cssClass="form-horizontal" action="saveData" commandName="emp">

			<div class="form-group">
				<label class="control-label col-sm-3">Name :</label>
				<div class="col-sm-5">
					<form:input path="name" cssClass="form-control" placeholder="Enter name" />
					<form:errors path="name" cssClass="error" />
				</div>
		  </div>

				<div class="form-group">
					<label class="control-label col-sm-3">Designation :</label>
					<div class="col-sm-5">
						<form:input path="des" cssClass="form-control" placeholder="Enter designation" />
						<form:errors path="des" cssClass="error" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-3">Salary :</label>
					<div class="col-sm-5">
						<form:input path="salary" cssClass="form-control" placeholder="Enter salary" />
						<form:errors path="salary" cssClass="error" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-3 col-sm-10">
						<button type="submit" class="btn btn-default">Submit</button>
					</div>
				</div>
		</form:form>
		</div>
	</body>
</html>
