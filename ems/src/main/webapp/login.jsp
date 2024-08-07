<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LOGIN PAGE</title>
</head>
<body >
<jsp:include page="header.jsp"></jsp:include>
<br><br><br><br><br><br>
	<form:form action="login" method="post" modelAttribute="user">
		<fieldset style="margin:auto; width:300px">
			<legend style="text-align:center"><b><u>LOGIN</u></b></legend>
			<pre>
<label style="font-size:22px"><b>User Name: </b></label> <form:input path="email"/>
<form:errors path="email" style="color:red"></form:errors>	
<label style="font-size:22px"><b>Password : </b></label> <form:input type="password" path="password"/>
<form:errors path="password" style="color:red"></form:errors>
			        <input type="submit" value="LOGIN">
			</pre>
		</fieldset>
	</form:form>
<br><br><br>
<h3 style="text-align:center; color:red">${errorMessage}</h3>
<br><br><br><br><br>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>