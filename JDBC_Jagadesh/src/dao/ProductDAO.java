package dao;
import java.sql.*;

import ConnectionManager.ConnectionManager;
import model.Product;


public class ProductDAO {
	public void addProduct(Product product) throws ClassNotFoundException,SQLException
	{
		ConnectionManager conn = new ConnectionManager();
		Connection con = conn.establishmentConnection();
		String sql ="insert into product(productId,productName,minsellQuantity,price,quantity)values(?,?,?,?,?)";
	PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, product.getProductId());
		ps.setString(2, product.getProductName());
		ps.setInt(3, product.getMinSellQuantity());
		ps.setInt(4, product.getPrice());
		ps.setInt(5, product.getQuantity());
		ps.executeUpdate();
		conn.closeconnection();
		
	}
	public void display() throws ClassNotFoundException,SQLException
	{
		ConnectionManager conn = new ConnectionManager();
			
	Connection con = conn.establishmentConnection();
	Statement st = con.createStatement();
	ResultSet rs = st.executeQuery("select * from product");
	
	
	while(rs.next())
	{
		System.out.println("                                   ");
		System.out.println(rs.getInt("productId")+" | "+rs.getString("productName")+"| "+ rs.getInt("minSellQuantity")+" | "+rs.getInt("price")+" | "+rs.getInt("quantity"));
	}
conn.closeconnection();
		}
}
