package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.User;
import model.UserDao;

@WebServlet("/adduser")
public class AddUserServlet extends HttpServlet {
	public void  doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException {
		
		String fname = req.getParameter("firstname");
		String lname = req.getParameter("lastname");
		String uname = req.getParameter("username");
		String pwd = req.getParameter("password");
		User user =new User();
		try {
			user.setFirstName(fname);
			user.setLastName(lname);
			user.setUserName(uname);
			user.setPassword(pwd);
			int i = UserDao.insert(user);
			if(i > 0)
			{
				res.sendRedirect("SignupSuccess.jsp");
			}else{
				res.sendRedirect("SignupFail.jsp");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	}

