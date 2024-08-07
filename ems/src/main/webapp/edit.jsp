<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EDIT PAGE</title>
</head>
<body >
<jsp:include page="header.jsp"></jsp:include> 
<form:form action="edit" method="post" modelAttribute="employee">
<form:hidden name="employeeId" path="employeeId"/>
<fieldset style="margin:auto; width:450px">
<legend style="text-align:center"><b><u>Updation Form</u></b></legend>
<pre>
<label style="font-size:22px"><b>Employee Name  : </b></label> <form:input path="employeeName"/>
<form:errors path="employeeName" style="color:red"></form:errors>				
<label style="font-size:22px"><b>Email          : </b></label> <form:input path="email"/>
<form:errors path="email" style="color:red"></form:errors>	
<label style="font-size:22px"><b>Password       : </b></label> <form:input type="password" path="password"/>
<form:errors path="password" style="color:red"></form:errors>	
<label style="font-size:22px"><b>Mobile Number  : </b></label> <form:input type="number" path="mobileNumber"/>
<form:errors path="mobileNumber" style="color:red"></form:errors>	
<label style="font-size:20px"><b>Gender         : </b></label>
		           <b> Male:</b><form:radiobutton  path="gender" name="gender" value="male" />
	                 <b>   Female:</b><form:radiobutton  path="gender" name="gender" value="female" />	
<form:errors path="gender" style="color:red"></form:errors>		
<label style="font-size:22px"><b>Date of Birth  : </b></label> <form:input type="date" path="dateOfBirth"/>
<form:errors path="dateOfBirth" style="color:red"></form:errors>	
<label style="font-size:22px"><b>Address        : </b></label> <form:input path="address"/>
<form:errors path="address" style="color:red"></form:errors>	
<label style="font-size:22px"><b>City           : </b></label> <form:input path="city"/>
<form:errors path="city" style="color:red"></form:errors>	
<label style="font-size:22px"><b>Country        : </b></label> <form:input path="country"/>
<form:errors path="country" style="color:red"></form:errors>
			
			        <input type="submit" value="UPDATE">
</pre>
</fieldset>
</form:form>
<jsp:include page="footer.jsp"></jsp:include> 
</body>
</html>