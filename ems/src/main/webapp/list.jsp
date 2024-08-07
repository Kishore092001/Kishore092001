<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<meta charset="ISO-8859-1">
<title>LIST PAGE</title>
<style>
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}

tr {
	
}
</style>
</head>
<jsp:include page="header.jsp"></jsp:include>
<body>

	<h2 style="text-align: center"><b><u>List Employees</u></b></h2>
	<br>

	<form:form action="search" method="post" modelAttribute="employee">
		<label>Employee Name : </label>
		<form:input path="employeeName" />
		<input type="submit" value="SEARCH">
	</form:form>

	<h3 style="text-align: center; color: green">${successMessage}</h3>
	<h3 style="text-align: center; color: red">${errorMessage}</h3>
	
	<br>
	<br>
	
	<c:if test="${!empty employeeList}">
	
	<table style="text-align: center; width: 100%">
		<tr >
			<th>S.No</th>
			<th>Employee Name</th>
			<th>Email</th>
			<th>Password</th>
			<th>Mobile Number</th>
			<th>Gender</th>
			<th>Date of Birth</th>
			<th>Address</th>
			<th>City</th>
			<th>Country</th>
			<th>View</th>
			<th>Edit</th>
			<th>Delete</th>

		</tr>
		<%
			int count = 0;
		%>
		<c:forEach var="employee" items="${employeeList}">
			<tbody>
				<tr>
					<td><%=++count%>
					<td>${employee.employeeName}</td>
					<td>${employee.email}</td>
					<td>${employee.password}</td>
					<td>${employee.mobileNumber}</td>
					<td>${employee.gender}</td>
					<td>${employee.dateOfBirth}</td>
					<td>${employee.address}</td>
					<td>${employee.city}</td>
					<td>${employee.country}</td>
					<td><a href="view?id=${employee.employeeId}"><i class="fa fa-eye"
							style="color: blue"></i></a></td>
					<td><a href="edit?id=${employee.employeeId}"><i class="fa fa-edit"
							style="color: blue"></i></a></td>
					<td><a href="delete?id=${employee.employeeId}"><i
							class="fa fa-trash-o" style="color: blue"></i></a></td>
				</tr>
			</tbody>
		</c:forEach>
	</table>
	
	</c:if>
	
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<h3 style="text-align: center;">
		<a href='home'>Back To Home Page</a>
	</h3>
	<br>
	<br>
	<br>

</body>
<jsp:include page="footer.jsp"></jsp:include>
</html>