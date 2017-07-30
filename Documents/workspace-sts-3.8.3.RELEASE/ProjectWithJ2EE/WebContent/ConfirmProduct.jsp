<%@ page import="java.sql.*"%>
<%@ page session="true"%>
<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	Class.forName("oracle.jdbc.driver.OracleDriver");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<style>
body {
background-image: url("./images/CO1.jpg");
background-repeat: no-repeat;
background-attachment: fixed;
background-position: 1000px,1000px; 
background-size: 400px 400px;   
}
</style>
<body>
	<%@page import="entity.*,java.util.*,java.io.*"%>
	
	<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<center>
		<h1 style="text-align: center">Thanks for Shopping</h1>
		<%
			List<Product> list;
			list = (List<Product>) session.getAttribute("list");

			Connection connection = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "cogent",
					"root");
			Statement statement = connection.createStatement();
		%>
		<%
			String name = (String) request.getSession().getAttribute("name");
			
		%>
		<%
			int completeTotal = 0;
			StringBuffer sb = new StringBuffer();
			for (Product p : list) {
				String productname = p.getProductName();
				productname = productname.replaceAll("\\s", "");
				sb.append(productname+" . ");
				int total = p.getTotal();
				completeTotal += total;
			}
			String productList = sb.toString();
			String sql = "insert into purchase (firstname,Productlist,total) values ('"
					+ name
					+ "','"
					+ productList
					+ "','"
					+ completeTotal + "')";

			if(!list.isEmpty())
			statement.executeUpdate(sql);
		%>
		<p>
			Your transaction is completed.
		</p>
		<table border="1" width="50%" style="text-align: center" >
			<tr>
				<th>Product Name</th>
				<th>Product Cost</th>
				<th>Quantity</th>
				<th>Total</th>
			</tr>
			<c:forEach items="${list}" var="p">
				<tr>
					<td>${p.getProductName()}</td>
					<td>${p.getProductCost()}</td>
					<td>${p.getQuantity()}</td>
					<td>${p.getTotal()}</td>
				</tr>
			</c:forEach>
		</table>
		
		<p>Total amount of Transaction is:</p>
		
		<p><%=completeTotal%></p>
		
	</center>

	<a href="LogoutServlet">Logout</a>
</body>
</html>