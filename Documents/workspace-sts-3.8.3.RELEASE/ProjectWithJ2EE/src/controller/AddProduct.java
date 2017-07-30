package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Product;
import model.ProductDao;
@WebServlet("/addproductform")
public class AddProduct extends HttpServlet {
	public void  doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException {
		String productname = req.getParameter("productname");
		String productcost = req.getParameter("productcost");
		int cost = Integer.parseInt(productcost);
		Product product =new Product();
		List<Product> productlist;
		HttpSession session=req.getSession(false);
		productlist = (List<Product>) session.getAttribute("productlist");
		productlist.add(product);
		try {
			product.setProductName(productname);
			product.setProductCost(cost);
			int i = ProductDao.add(product);
			if(i > 0)
			{
				res.sendRedirect("ProductAdd-Success.jsp");
			}else{
				res.sendRedirect("ProductAdd-Fail.jsp");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}
