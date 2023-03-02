package com.minimart.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.minimart.domain.Order;
import com.minimart.domain.OrderItem;
import com.minimart.domain.Product;

public class OrderRepository {
	String urlDb = "jdbc:mysql://localhost:3306/javaDb";
	String userDb = "root";
	String passDb = "root";
	Repository repo = new Repository();
	int lastOrder;
	String orderId;
	double totalPrice;
	ArrayList order = new ArrayList<Order>(); 
	Order getOrder;
	ArrayList orderItem  = new ArrayList<OrderItem>();


	public void buatOrderId() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlDb, userDb, passDb);

			Statement stm = conn.createStatement();

			ResultSet rs = stm.executeQuery("SELECT id FROM order_tbl ORDER BY id DESC LIMIT 1");

			while (rs.next()) {
				this.lastOrder = Integer.parseInt(rs.getString("id"));
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(this.lastOrder == 0) {
			this.orderId = "Order-001";
		}else {
			this.lastOrder = this.lastOrder+1;
			this.orderId = "Order-00" + this.lastOrder;
		}
		
	}

	public int orderItemSave(OrderItem item) {

		String sql = "INSERT INTO order_item (order_id, code, name, type, price, quantity, total_price) VALUES ('"
				+ item.getOrderId() + "','" + item.getCode() + " ',' " + item.getName() + " ',' " + item.getType()
				+ " ',' " + item.getPrice() + " ',' " + item.getQuantity() + " ',' " + item.getTotalPrice() + "')";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlDb, userDb, passDb);

			Statement stm = conn.createStatement();

			int rs = stm.executeUpdate(sql);

			if (rs > 0) {
				return 1;
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public int orderSave(double totalPrice) {
		Order order = new Order(this.orderId);
		String sql = "INSERT INTO order_tbl (id, order_id, total_price, date) VALUES ('"+ this.lastOrder +"','"+ this.orderId +"','"+ totalPrice +"','" + order.getOrderDate() + "')";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlDb, userDb, passDb);

			Statement stm = conn.createStatement();

			int rs = stm.executeUpdate(sql);

			if (rs > 0) {
				return 1;
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}


	public void orderNew(HttpServletRequest req) {
		buatOrderId();
		ArrayList<Product> products = repo.findAll();
		for (int i = 0; i < products.size(); i++) {
			if(req.getParameter(products.get(i).getCode()) == "") {
				continue;
			}
			int quantity = Integer.parseInt(req.getParameter(products.get(i).getCode()));
			String code = products.get(i).getCode();
			String name = products.get(i).getName();
			String type = products.get(i).getType();
			double price = products.get(i).getPrice();
			double totalPrice = price * quantity;
			this.totalPrice += totalPrice;
			OrderItem item = new OrderItem(this.orderId, code, name, type, price, quantity, totalPrice);
			orderItemSave(item);
		}
		if(this.totalPrice != 0) {
			orderSave(this.totalPrice);
		}
		
	}
	
	public void getData() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlDb, userDb, passDb);
			
			Statement stm = conn.createStatement();
			String sql = "SELECT * FROM order_tbl ORDER BY id ASC";
			ResultSet rs =  stm.executeQuery(sql);
			
			while(rs.next()) {
				String order_id = rs.getString("order_id");
				double totalPrice = Integer.parseInt(rs.getString("total_price"));
				String orderDate = rs.getString("date");
				Order order = new Order(order_id, orderDate, totalPrice);
				this.order.add(order);
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
	
	public  ArrayList<Order> findAll(){
		getData();
		return this.order;
	}
	
	public void getD(String codeGet) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlDb, userDb, passDb);
			
			Statement stm = conn.createStatement();
			
			ResultSet rs =  stm.executeQuery("SELECT order_id, total_price, date FROM order_tbl WHERE order_id='" + codeGet + "' LIMIT 1");
			
			while(rs.next()) {
				String orderNumber = rs.getString("order_id");
				double totalPrice = Integer.parseInt(rs.getString("total_price"));
				String date = rs.getString("date");
				
				this.getOrder = new Order(orderNumber, date, totalPrice);
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
	
	public Order show(String codeGet) {
		getD(codeGet);
		return this.getOrder;
	}
	
	public void getOrderItem(String codeGet) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlDb, userDb, passDb);
			
			Statement stm = conn.createStatement();
			
			ResultSet rs =  stm.executeQuery("SELECT order_id, code, name, type, price, quantity, total_price FROM order_item WHERE order_id='" + codeGet + "'");
			
			while(rs.next()) {
				String code = rs.getString("code");
				String name = rs.getString("name");
				String type = rs.getString("type");
				int quantity = Integer.parseInt(rs.getString("quantity"));
				double price = Integer.parseInt(rs.getString("price"));
				double totalPrice = Integer.parseInt(rs.getString("total_price"));
				
				OrderItem item = new OrderItem(codeGet, code, name, type, price, quantity, totalPrice);
				
				this.orderItem.add(item);
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
	
	public ArrayList<OrderItem> getItems(String codeGet){
		getOrderItem(codeGet);
		return this.orderItem;
	}
}
