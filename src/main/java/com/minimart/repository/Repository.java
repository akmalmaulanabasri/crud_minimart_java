package com.minimart.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.minimart.domain.Product;


public class Repository {
	String urlDb = "jdbc:mysql://localhost:3306/javaDb";
	String userDb = "root";
	String passDb = "root";
	String sql = "SELECT * FROM product_tbl ORDER BY code ASC";
	ArrayList products = new ArrayList<Product>(); 
	Product getProduct;
	
	public void getData() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlDb, userDb, passDb);
			
			Statement stm = conn.createStatement();
			
			ResultSet rs =  stm.executeQuery(sql);
			
			while(rs.next()) {
				String code = rs.getString("code");
				String name = rs.getString("name");
				String type = rs.getString("type");
				double price = Integer.parseInt(rs.getString("price"));
				products.add(new Product(code, name, type, price));
			}
			
//			return this.products;
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public  ArrayList<Product> findAll(){
		getData();
		return this.products;
	}
	
	public int saveData(Product product) {
		String code = product.getCode();
		String name = product.getName();
		String type = product.getType();
		double price = product.getPrice();
		
		String sql = "INSERT INTO product_tbl (code, name, type, price) VALUES ('"+ code + "','"+ name +" ',' " + type +" ',' "+ price +"')";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlDb, userDb, passDb);
			
			Statement stm = conn.createStatement();
			
			int rs = stm.executeUpdate(sql);
			
			if(rs > 0) {
				return 1;
			}
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public void delete(String code) {
		String sql = "DELETE FROM product_tbl WHERE code ='"+code + "'";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlDb, userDb, passDb);
			
			Statement stm = conn.createStatement();
			
			int rs = stm.executeUpdate(sql);
			
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getD(String codeGet) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlDb, userDb, passDb);
			
			Statement stm = conn.createStatement();
			
			ResultSet rs =  stm.executeQuery("SELECT code, name, type, price FROM product_tbl WHERE code='" + codeGet + "' LIMIT 1");
			
			while(rs.next()) {
				String code = rs.getString("code");
				String name = rs.getString("name");
				String type = rs.getString("type");
				double price = Integer.parseInt(rs.getString("price"));
				this.getProduct  = new Product(code, name, type, price);
			}
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Product edit(String codeGet) {
		getD(codeGet);
		return this.getProduct;
	}
	
	public int update(String codeGet, Product product) {
		String code = product.getCode();
		String name = product.getName();
		String type = product.getType();
		double price = product.getPrice();
		
		String sql = "UPDATE product_tbl SET name='"+ name + "', type='"+ type + "', price='"+ price + "'WHERE code='" + codeGet + "'";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlDb, userDb, passDb);
			
			Statement stm = conn.createStatement();
			
			int rs = stm.executeUpdate(sql);
			
			if(rs > 0) {
				return 1;
			}
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	
}
