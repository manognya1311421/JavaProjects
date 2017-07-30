package controller;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import entity.Product;
import model.ProductDao;

import java.io.*;
import java.sql.SQLException;
import java.util.*;
@WebServlet("/productmodifyAdmin")
public class ProductModifyAdminServlet extends HttpServlet {
	public void  doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException {
		String productname = req.getParameter("productname");
		String productcost = req.getParameter("productcost");
		int cost = Integer.parseInt(productcost);
		String name="";
		HttpSession session = req.getSession(false);
		
		if(session!=null)
		{	name = (String) session.getAttribute("name");
		}
		List<Product> productlist;
		productlist = (List<Product>) session.getAttribute("productlist");
		Product product =new Product();
		product.setProductName(productname);
		product.setProductCost(cost);
		productname = productname.replaceAll("\\s","");
		for(Product product1: productlist)
		{
			String pname=product1.getProductName();
			pname = pname.replaceAll("\\s","");
			if(pname.equals(productname))
			{product1.setProductCost(cost);
			}
		}
		int i = ProductDao.modifyprice(product);
		if(i > 0)
		{	res.sendRedirect("ViewProductsAdmin.jsp");
		}else{
			res.sendRedirect("Productmodify-admin.jsp");
		}
	}
}
