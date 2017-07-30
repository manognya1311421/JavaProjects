<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Products</title>
</head>
<body>
	<%@page import="controller.*,entity.*,java.util.*" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
	<center>
	<h1>Product List</h1><p>	</p>
	<%
	List<Product> productlist;
	productlist = (List<Product>) session.getAttribute("productlist");
	%>
	<table border="1" width="90%" style="text-align:center">
		<tr>
			<th>Product Name</th>
			<th>Price</th>
		</tr>
		<c:forEach items="${productlist}" var="p">
			<tr>
				<td>${p.getProductName()}</td>
				<td>${p.getProductCost()}</td>
				<td><a href="Productmodify-admin.jsp?name=${p.getProductName()}&price=${p.getProductCost()}" style="text-align:center">Modify</a></td>
				<td><a href="deleteproductadmin.jsp?name=${p.getProductName()}&price=${p.getProductCost()}" style="text-align:center">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	</center>
	<a href="AdminProfile.html">Profile</a>
	<a href="LogoutServlet">Logout</a>
</body>
</html>