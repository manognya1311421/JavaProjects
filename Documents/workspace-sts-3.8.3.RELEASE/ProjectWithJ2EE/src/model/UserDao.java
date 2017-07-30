package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import entity.Product;
import entity.User;

public class UserDao {

	private static Connection connectionToDB() {
		Connection con = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("no Driver---class not found exception");
		}

		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "cogent", "root");
		} catch (SQLException e) {
			System.out.println("Check URL--");
		}
		return con;

	}

	
	public static int insert(User u) throws SQLException {
		int x = 0;
		try {
			Connection con = connectionToDB();
			PreparedStatement pst = con
					.prepareStatement("insert into users (firstname,lastname,username,password) values(?,?,?,?)");
			pst.setString(1, u.getFirstName());
			pst.setString(2, u.getLastName());
			pst.setString(3, u.getUserName());
			pst.setString(4, u.getPassword());
			x = pst.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}

		return x;
	}
	public static int getUser(String username,String password) throws SQLException {
		int x=0;
		try{
			Connection con = connectionToDB();
			PreparedStatement pst = con.prepareStatement("select * from users where username=? AND password=?");
			pst.setString(1, username);
			pst.setString(2, password);

			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{	
					x=1;
					
			}
		}catch(Exception e){System.out.println(e);}
		return x;
	}	

}