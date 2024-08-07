<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>VIEW PAGE</title>


<style>
table, th, td {
	
}

th{
	text-align:left;
	
}

td{
	text-align:left;
	
}

</style>
</head>
<body >
	<jsp:include page="header.jsp"></jsp:include>
	<h2 style="text-align: center"><b><U>View Employee</U></b></h2>
	<br>
	<br>
	<br>
	
	<table>
	
	<tr>
	
	<th> Employee Name :</th>
	<td> ${employee.employeeName}</td>
	
	</tr>
	
	
	
	<tr>
	
	<th> Email Id :</th>
	<td>${employee.email}</td>
	
	</tr>
	
	<tr>
	
	<th> Password :</th>
	<td>${employee.password}</td>
	
	</tr>
	
	<tr>
	
	<th> Mobile Number :</th>
	<td>${employee.mobileNumber}</td>
	
	</tr>
	
	<tr>
	
	<th>Gender :</th>
	<td>${employee.gender}</td>
	
	</tr>
	
	<tr>
	
	<th> Date of Birth :</th>
	<td>${employee.dateOfBirth}</td>
	
	</tr>
	
	<tr>
	
	<th> Address :</th>
	<td>${employee.address}</td>
	
	</tr>
	
	<tr>
	
	<th> City :</th>
	<td>${employee.city}</td>
	
	</tr>
	
	<tr>
	
	<th> Country :</th>
	<td>${employee.country}</td>
	
	</tr>

	</table>
		
	<br>
	<br>
	<h3 style="text-align: center;"><a href='list'>Back To List</a></h3>
	<br>
	<br>
	<br>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>