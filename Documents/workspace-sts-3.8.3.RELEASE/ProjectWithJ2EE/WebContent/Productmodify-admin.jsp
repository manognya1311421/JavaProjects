<%@page import="java.io.Console"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit form</title>
</head>
<body>
	<%@page import="entity.*" %>
	
	<% String productname = request.getParameter("name"); %>	
	<% String productcost = request.getParameter("productcost"); %>
		
		
		
	<center>
	<h1>Edit Product Price</h1>
	<form action="productmodifyAdmin" method="post">
		<table>
		<tr>
			<td>Product Name:</td>
			<td><input type="text" name="productname" id="productname" value="<%=productname%>" readonly></td>
		</tr>
		<tr>
			<td>Product price:</td>
			<td><input type="number" name="productcost" id="productcost" value="<%=productcost%>" ></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Update product price"/></td>
			
		</tr>
		</table>
	</form>
	</center>
	<br>
	<a href="ViewProductsAdmin.jsp">Back</a>
</body>
</html>