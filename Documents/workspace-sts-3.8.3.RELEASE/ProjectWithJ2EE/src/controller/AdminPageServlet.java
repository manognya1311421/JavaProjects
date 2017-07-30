package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/AdminPageServlet")
public class AdminPageServlet extends HttpServlet{
	protected void  doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		request.getRequestDispatcher("AdminProfile.html").include(request, response);
		
		HttpSession session = request.getSession(false);
		if(session!=null)
		{
			String name = (String) session.getAttribute("name");
			
		}
		else{
			pw.print("Please login first");
			request.getRequestDispatcher("main.html").include(request, response);
		}
		pw.close();
	}
}