package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/UserProfileServlet")
public class UserProfileServlet extends HttpServlet{
	protected void  doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		HttpSession session = req.getSession(false);
		if(session!=null)
		{
			String name = (String) session.getAttribute("name");
			out.print("Welcome "+name);
		}
		else{
			out.print("Please login first");
			req.getRequestDispatcher("main.html").include(req, res);
		}
		
		req.getRequestDispatcher("ViewProducts.jsp").include(req, res);
		out.close();
	}
}