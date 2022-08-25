package com.revature.gamestore.dl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.gamestore.models.Merchandise;
import com.revature.gamestore.storage.MerchandiseList;
import com.revature.gamestore.ui.ConnectionFactory;

public class MerchandiseDAO implements DAO<Merchandise> {

	@Override
	public void addInstance(Merchandise newInstance) {
		try(Connection conn = ConnectionFactory.getConnection()){
			String query = "Insert into inventory(item_id, item_name, store_id, quantity, item_type,) values (?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, newInstance.getItemId());
			pstmt.setString(2, newInstance.getName());
			pstmt.setInt(3, newInstance.getStoreId());
			pstmt.setInt(4, newInstance.getQuantity());
			pstmt = conn.prepareStatement("Update inventory SET item_type = ? Where id = 5");
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	@Override
	public Merchandise[] getAll() {
		MerchandiseList inventory = new MerchandiseList();
		try(Connection conn = ConnectionFactory.getConnection()){
			String query = "select * from inventory";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				  inventory.add(new Merchandise(rs.getInt("item_id"), rs.getString("item_name"), rs.getInt("store_id"), rs.getInt("quantity"), Merchandise.category.valueOf(query)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return inventory.getAllElements();
	}
}
