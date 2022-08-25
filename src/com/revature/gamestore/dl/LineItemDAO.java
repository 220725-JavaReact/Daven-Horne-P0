package com.revature.gamestore.dl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.gamestore.models.LineItem;
import com.revature.gamestore.storage.LineItemList;
import com.revature.gamestore.ui.ConnectionFactory;

public class LineItemDAO implements DAO<LineItem> {

	@Override
	public void addInstance(LineItem newInstance) {
		// TODO Auto-generated method stub
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "Insert into line_item(item_id, order_id, price, quantity) values (?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, newInstance.getItemId());
			pstmt.setInt(2, newInstance.getOrderId());
			pstmt.setDouble(3, newInstance.getPrice());
			pstmt.setInt(4, newInstance.getQuantity());
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	@Override
	public LineItem[] getAll() {
		// TODO Auto-generated method stub
		LineItemList lineItems = new LineItemList();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "select * from line_item";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				  lineItems.add(new LineItem(rs.getInt("item_id"), rs.getInt("order_id"), rs.getDouble("price"), rs.getInt("quantity")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lineItems.getAllElements();
	}
	}

