<%@ page import="model.*" %>
<%@ page isELIgnored="false" %>
<jsp:useBean id="p"  class="entity.Product"></jsp:useBean>    
<jsp:setProperty property="*" name="u"/>
<%
	//int i= ProductDao.addquantity(p,"");
	response.sendRedirect("ViewProducts.jsp");
	
%>
