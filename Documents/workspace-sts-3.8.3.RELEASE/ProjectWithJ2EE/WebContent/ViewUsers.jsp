<%@ page import="java.sql.*"%>
<%
	Class.forName("oracle.jdbc.driver.OracleDriver");
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
response.setHeader("Pragma","no-cache");
response.setDateHeader("Expires", 0);
%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Of Users</title>
</head>
<style>
h1 {
	text-align: center;
	font-size: 30px;    
}
body {
background-image: url("./images/VUSER.jpg");
    
}
</style>	
<body>

	<h1>List of Users</h1>
	<%
		Connection connection = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "cogent",
				"root");
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement
				.executeQuery("select * from purchase");
	%>
	
	<center>
	<table style="text-align: center"  border="2" width= 800px height = 100px>
		<tr>
			<th bgcolor="#FF6347">User Name</th>
			<th bgcolor="#FF6347">Purchased products</th>
			<th bgcolor="#FF6347">Total Cost</th>
		</tr>
		<%
			while (resultSet.next()) {
		%>
		<tr>
			<td bgcolor="#FFFEE0"><%=resultSet.getString(1)%></td>
			<td bgcolor="#FFFEE0"><%=resultSet.getString(2)%></td>
			<td bgcolor="#FFFEE0"><%=resultSet.getString(3)%></td>
			

		</tr>
		<%
			}
		%>		
	</table>
	</center>
	<br>
	<p></p>
	<br>
	<a style= "font-size: 25px" href="AdminProfile.html">Profile</a>
	<a style= "font-size: 25px" href="LogoutServlet">Logout</a>
</body>
</html>