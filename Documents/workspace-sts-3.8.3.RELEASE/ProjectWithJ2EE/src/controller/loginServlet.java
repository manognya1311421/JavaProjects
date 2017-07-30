package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import entity.Product;
import entity.User;
import model.ProductDao;
import model.UserDao;

@WebServlet("/login")
public class loginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session; 
			if(username.equals("admin")&&password.equals("admin"))
			{
			session = request.getSession(true);
			session.setAttribute("name", username);
			List<Product> productlist = new ArrayList<Product>(); 
			productlist=ProductDao.getAllRecords();
			session.setAttribute("productlist", productlist);
			response.sendRedirect("AdminPageServlet");
			}
			else {
				try {
					int i = UserDao.getUser(username, password);
					if (i > 0) {
						session = request.getSession(true);
						session.setAttribute("name", username);
						List<Product> list =new ArrayList<Product>();
						session.setAttribute("list", list);
						List<Product> productlist = new ArrayList<Product>(); 
								productlist=ProductDao.getAllRecords();
						session.setAttribute("productlist", productlist);
						response.sendRedirect("UserProfileServlet");
						
					} else {
						response.sendRedirect("login-error.jsp");
					}
				} catch (SQLException e) {

					e.printStackTrace();
				}

			}
			
		}

	}