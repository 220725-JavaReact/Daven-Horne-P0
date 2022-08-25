package com.revature.gamestore.dl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.gamestore.models.Console;
import com.revature.gamestore.storage.ConsoleList;
import com.revature.gamestore.ui.ConnectionFactory;

public class ConsoleDAO implements DAO<Console> {

	@Override
	public void addInstance(Console newInstance) {
		// TODO Auto-generated method stub
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "Insert into games(product_Id, console_name, console_price, console_brand) values (Default,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(query);
			//pstmt.setInt(1, newInstance.getProductId());
			pstmt.setString(1, newInstance.getName());
			pstmt.setDouble(2, newInstance.getPrice());
			pstmt = conn.prepareStatement("Update consoles SET consoleBrand = ? Where id = 3");
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
		
	


	@Override
	public Console[] getAll() {
		// TODO Auto-generated method stub
		ConsoleList consoles = new ConsoleList();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "select * from consoles";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				  consoles.add(new Console(rs.getInt("product_Id"), rs.getString("console_name"), rs.getDouble("console_price"), Console.brand.valueOf(query)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return consoles.getAllElements();
	}
}
