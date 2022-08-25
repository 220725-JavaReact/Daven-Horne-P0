package com.revature.gamestore.dl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.gamestore.models.Order;
import com.revature.gamestore.storage.OrderList;
import com.revature.gamestore.ui.ConnectionFactory;

public class OrderDAO implements DAO<Order> {
	

@Override
public void addInstance(Order newInstance) {
	// TODO Auto-generated method stub
	try(Connection conn = ConnectionFactory.getInstance().getConnection()){
		String query = "Insert into store_Order(Order_id, store_id, customer_id, product_ordered, total_price) values (Default,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(query);
		pstmt.setInt(1, newInstance.getStoreId());
		pstmt.setInt(2, newInstance.getCustomerId());
		pstmt.setInt(3, newInstance.getProductsOrderedId());
		pstmt.setDouble(4, newInstance.getTotalprice());
		pstmt.execute();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
}





@Override
public Order[] getAll() {
	// TODO Auto-generated method stub
	OrderList orders = new OrderList();
	try(Connection conn = ConnectionFactory.getInstance().getConnection()){
		String query = "select * from store_Order";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while(rs.next()) {
			  orders.add(new Order(rs.getInt("Order_Id"), rs.getInt("store_id"), rs.getInt("customer_id"), rs.getInt("product_ordered"), rs.getDouble("total_price")));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return orders.getAllElements();
}
}


