<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HOME PAGE</title>
</head>
<body >
<jsp:include page="header.jsp"></jsp:include>
<br><br><br>
<h2 style="text-align: center; color:green">${successMessage}</h2>
<h2 style="text-align: center; color:red">${errorMessage}</h2>
<br><br><br>
<fieldset style="margin:auto; width:350px; text-align:left;">
<legend style="text-align:center"><b><u>MENUS</u></b></legend>
<a href="create" style="font-size:30px"> Create Employee </a>
<br><br>
<a href="list" style="font-size:30px">  Employees List</a>
<br><br>
<a href="logout" style="font-size:30px"> Logout</a>
<br>
</fieldset>
<br><br><br><br><br><br><br><br>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>