package com.revature.gamestore.dl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.gamestore.models.Order;
import com.revature.gamestore.models.Store;
import com.revature.gamestore.storage.OrderList;
import com.revature.gamestore.storage.StoreList;
import com.revature.gamestore.ui.ConnectionFactory;

public class StoreDAO implements DAO<Store> {

	@Override
	public void addInstance(Store newInstance) {
		// TODO Auto-generated method stub
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "Insert into store(store_id, store_name, store_address) values (Default,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, newInstance.getName());
			pstmt.setString(2, newInstance.getAddress());
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}





	@Override
	public Store[] getAll() {
		// TODO Auto-generated method stub
		StoreList stores = new StoreList();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "select * from store";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				  stores.add(new Store(rs.getInt("store_id"), rs.getString("store_name"), rs.getString("store_address")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stores.getAllElements();
	}
}
