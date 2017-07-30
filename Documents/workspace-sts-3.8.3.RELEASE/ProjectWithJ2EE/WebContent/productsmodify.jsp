<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Selected Products</title>
</head>
<style>
body {
background-image: url("./images/VUSER.jpg");
    
}
</style>
<body>
	<%@page import="controller.*,entity.*,java.util.*" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
	<center>
	<h1>Edit Cart</h1>
	<%
	    List<Product> list;
		list = (List<Product>) session.getAttribute("list");
	%>
	<table border="1" width="90%" style="text-align:center">
		<tr>
			<th bgcolor="#FF6347">Product Name</th>
			<th bgcolor="#FF6347">Price</th>
			<th bgcolor="#FF6347">Quantity</th>
			<th bgcolor="#FF6347">Total</th>
		</tr>
		
		<c:forEach items="${list}" var="p">
			<tr>
				<td bgcolor="#FFFEE0">${p.getProductName()}</td>
				<td bgcolor="#FFFEE0">${p.getProductCost()}</td>
				<td bgcolor="#FFFEE0">${p.getQuantity()}</td>
				<td bgcolor="#FFFEE0">${p.getTotal()}</td>
				<td bgcolor="#FFFEE0"><a href="editproduct.jsp?productname=${p.getProductName()} &productcost=${p.getProductCost()}&quantity=${p.getQuantity()}">Edit</a></td>
				<td bgcolor="#FFFEE0"><a href="deleteproductuser.jsp?productname=${p.getProductName()}&productcost=${p.getProductCost()}&quantity=${p.getQuantity()}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	</center>
	<a href="ViewProducts.jsp">Back</a>
	<a href="ConfirmProduct.jsp">CheckOut</a>
	<a href="LogoutServlet">Logout</a>
</body>
</html>