package controller;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import entity.Product;
import model.ProductDao;

import java.io.*;
import java.sql.SQLException;
import java.util.*;
@WebServlet("/DeleteProductAdmin")
public class DeleteProductAdmin extends HttpServlet {
	public void  doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException {
		String productname = req.getParameter("productname");
		String name="";
		HttpSession session = req.getSession(false);
		if(session!=null)
		{
			name = (String) session.getAttribute("name");

		}
		List<Product> productlist;
		productlist = (List<Product>) session.getAttribute("productlist");
		Product product =new Product();
		product.setProductName(productname);
		productname = productname.replaceAll("\\s","");
		for (Iterator<Product> iter = productlist.listIterator(); iter.hasNext(); ) {
		    Product product1 = iter.next();
		    String pname=product1.getProductName();
			pname = pname.replaceAll("\\s","");
			if(pname.equals(productname)) 
		    {iter.remove();
		    }
		}
		session.setAttribute("productlist", productlist);
		int i = ProductDao.deleteproduct(product);
		if(i > 0)
		{	res.sendRedirect("ViewProductsAdmin.jsp");
		}else{
			res.sendRedirect("deleteproductadmin.jsp");
			}
	}
}
