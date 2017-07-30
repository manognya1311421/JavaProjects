package controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Product;


@WebServlet("/addpurchaseform")
public class AddPurchaseServlet extends HttpServlet {
	public void  doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException {
		String productname = req.getParameter("productname");
		String productcost = req.getParameter("productcost");
		String quantity = req.getParameter("quantity");
		int cost = Integer.parseInt(productcost);
		int qnty = Integer.parseInt(quantity);
		int total=cost*qnty;
		String name="";
		HttpSession session = req.getSession(false);
		List<Product> list;
		list = (List<Product>)session.getAttribute("list");
		if(session!=null)
		{name = (String) session.getAttribute("name");
		}
		Product product =new Product();
		product.setProductName(productname);
		product.setProductCost(cost);
		product.setQuantity(qnty);
		product.setTotal(total);
		list.add(product);
		productname=productname.replaceAll("\\s","");
		session.setAttribute("list", list);
		List<Product> productlist;
		productlist = (List<Product>) session.getAttribute("productlist");
		
		for (Iterator<Product> iter = productlist.listIterator(); iter.hasNext(); ) {
		    Product product1 = iter.next();
		    String pname=product1.getProductName();
			pname = pname.replaceAll("\\s","");
			if(pname.equals(productname)) 
		    {iter.remove();
		    }
		}
		{res.sendRedirect("usersuccess-addproduct.jsp");
		}
	}
}
