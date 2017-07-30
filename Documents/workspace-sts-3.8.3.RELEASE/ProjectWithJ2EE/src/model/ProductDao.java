package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Product;

public class ProductDao {
	
	private static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "cogent",
					"root");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public static int add(Product product) throws SQLException {
		int x = 0;
		try {
			Connection con = getConnection();
			PreparedStatement pst = con
					.prepareStatement("insert into Product (productname,productCost) values(?,?)");
			pst.setString(1, product.getProductName());
			pst.setInt(2, product.getProductCost());
			x = pst.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}

		return x;
	}
	public static List<Product> getAllRecords(){
		List<Product> productlist = new ArrayList<Product>();
		try{
			Connection con = getConnection();
			PreparedStatement pst = con.prepareStatement("select productname,productCost from Product");
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				Product product =new Product();
				product.setProductName(rs.getString("productname"));
				product.setProductCost(rs.getInt("productCost"));
				productlist.add(product);
			}
		}catch(Exception e){System.out.println(e);}
		return productlist;
	}
	
	public static int modifyprice(Product p){
		int status = 0;
		try{
			
			Connection con = getConnection();
			PreparedStatement pst = con.prepareStatement("update product set productcost=? where productname=?");
			pst.setInt(1,p.getProductCost());
			pst.setString(2, p.getProductName());
			status=pst.executeUpdate();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	public static int deleteproduct(Product p){
		int status = 0;
		try{
			
			Connection con = getConnection();
			PreparedStatement pst = con.prepareStatement("delete from product where productname=?");
			pst.setString(1, p.getProductName());
			status=pst.executeUpdate();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
}
