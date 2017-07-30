<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Products</title>
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
	<h1>Select your Product</h1>
	<%
	List<Product> productlist;
	productlist = (List<Product>) session.getAttribute("productlist");
	%>
	<table border="1" width="80%" style="text-align:center">
		<tr>
			<th bgcolor="#FF6347">Product Name</th>
			<th bgcolor="#FF6347">product cost</th>
			<th bgcolor="#FF6347">Add Quantity</th>
		</tr>
		<c:forEach items="${productlist}" var="p">
			<tr>
				<td bgcolor="#FFFEE0">${p.getProductName()}</td>
				<td bgcolor="#FFFEE0">${p.getProductCost()}</td>
				<td bgcolor="#FFFEE0"><a href="editQntity.jsp?name=${p.getProductName()}&productcost=${p.getProductCost()}" style="text-align:center">Add</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	</center>
	<a href="productsmodify.jsp">View Cart</a>
	<a href="LogoutServlet">Logout</a>
</body>
</html>