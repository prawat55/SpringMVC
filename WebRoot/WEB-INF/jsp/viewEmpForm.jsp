<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<html>
	<head>
		<title>View Employee</title>
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
	</head>

<body> 
<div class="container23">
   		<h2> Employees List</h2>

	<table class="table table-striped">  
		<tr>
			<th>Id</th><th>Name</th><th>Designation</th><th>Salary</th><th>Edit</th><th>Delete</th>
		</tr> 
	 
   		<c:forEach var="emp" items="${list}">   
   			<tr>  
	   			<td>${emp.id}</td>
	   			<td>${emp.name}</td>  
	  			<td>${emp.des}</td>  
	   			<td>${emp.salary}</td>  
	  			<td><a href="editEmp/${emp.id}">Edit</a></td>  
	   			<td><a href="deleteEmp/${emp.id}">Delete</a></td>  
   			</tr> 
   		</c:forEach> 
   		 
   </table> 
   <br/>  
  </div> 
   <h4><a href="addEmp">Add New Employee</a> </h4> 
   </body>
   </html>