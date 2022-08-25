package com.revature.gamestore.ui;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.revature.gamestore.util.SecretClass;


public class ConnectionFactory {
	private static ConnectionFactory connectionFactory;
	
	static {
		try {
			
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private ConnectionFactory(){
		
	}
	
	public static ConnectionFactory getInstance() {
		// lazy loading - create instance when it's needed
		if(connectionFactory == null) connectionFactory = new ConnectionFactory();
		return connectionFactory;
	}
	
	// factories are characterized by some method that contains logic for object creation
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(SecretClass.url(),SecretClass.userName(),SecretClass.password());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	}
