package com.revature.gamestore.dl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import com.revature.gamestore.models.Game;
import com.revature.gamestore.models.Game.consoleType;
import com.revature.gamestore.storage.GameList;
import com.revature.gamestore.ui.ConnectionFactory;

public class GameDAO implements DAO<Game> {

	@Override
	public void addInstance(Game newInstance) {
		// TODO Auto-generated method stub
		try(Connection conn = ConnectionFactory.getConnection()){
			String query = "Insert into games(product_id_g	, game_name, game_console_type, game_price, game_rating, game_num_players) values (DEFAULT,?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(query);
			//pstmt.setInt(1, newInstance.getProductId());
			pstmt.setString(1, newInstance.getName());
			pstmt.setDouble(2, newInstance.getPrice());
			pstmt.setString(3, newInstance.getRating());
			pstmt.setInt(4, newInstance.getNumPlayers());
			pstmt = conn.prepareStatement("Update games SET consoleType = ? Where id = 5");
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
		
	


	@Override
	public Game[] getAll() {
		// TODO Auto-generated method stub
		GameList games = new GameList();
		try(Connection conn = ConnectionFactory.getConnection()){
			String query = "select * from games";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				  games.add(new Game(rs.getInt("product_Id"), rs.getString("game_name"), rs.getDouble("game_price"), rs.getString("game_rating"), rs.getInt("game_num_players"), Game.consoleType.valueOf(query)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return games.getAllElements();
	}

}
