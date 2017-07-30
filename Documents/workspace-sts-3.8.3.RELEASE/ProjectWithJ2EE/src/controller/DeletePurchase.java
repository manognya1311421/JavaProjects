package controller;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import entity.Product;

import java.io.*;
import java.sql.SQLException;
import java.util.*;
@WebServlet("/deletepurchase")
public class DeletePurchase extends HttpServlet {
	public void  doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException {
		String productname = req.getParameter("productname");
		String productcost= req.getParameter("productcost");
		String quantity = req.getParameter("quantity");
		int cost = Integer.parseInt(productcost);
		int qnty = Integer.parseInt(quantity);
		int total=cost*qnty;
		String name="";
		HttpSession session = req.getSession(false);
		if(session!=null)
		{name = (String) session.getAttribute("name");
		}
		List<Product> list;
		list = (List<Product>) session.getAttribute("list");
		Product product =new Product();
		product.setProductName(productname);
		product.setProductCost(cost);
		product.setQuantity(qnty);
		product.setTotal(total);
		productname = productname.replaceAll("\\s","");
		List<Product> productlist;
		productlist = (List<Product>) session.getAttribute("productlist");
		productlist.add(product);
		session.setAttribute("productlist", productlist);
		for (Iterator<Product> iter = list.listIterator(); iter.hasNext(); ) {
		    Product product1 = iter.next();
		    String pname=product1.getProductName();
			pname = pname.replaceAll("\\s","");
			if(pname.equals(productname)) 
		    { iter.remove();
		    }
		}
			res.sendRedirect("productsmodify.jsp");
		}
}
