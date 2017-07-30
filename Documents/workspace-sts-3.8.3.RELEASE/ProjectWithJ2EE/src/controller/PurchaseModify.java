package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Product;
@WebServlet("/modifypurchase")
public class PurchaseModify extends HttpServlet {
	public void  doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException {
		String productname = req.getParameter("productname");
		String productcost = req.getParameter("productcost");
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
		for(Product product1:list)
		{
			String pname=product1.getProductName();
			pname = pname.replaceAll("\\s","");
			if(pname.equals(productname))
			{product1.setQuantity(qnty);
			 product1.setTotal(total);
			}
		}res.sendRedirect("productsmodify.jsp");
		
	}
}
