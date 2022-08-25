package com.revature.gamestore.dl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.gamestore.models.Customer;
import com.revature.gamestore.storage.CustomerList;
import com.revature.gamestore.ui.ConnectionFactory;

public class CustomerDAO implements DAO<Customer>{

	@Override
	public void addInstance(Customer newInstance) {
		// TODO Auto-generated method stub
		try(Connection conn = ConnectionFactory.getConnection()){
			String query = "Insert into customers(first_name, last_name, customer_age, email, customer_password, customer_address) values (?,?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(query);
			//pstmt.setInt(1, newInstance.getCustomerId());
			pstmt.setString(1, newInstance.getFirstName());
			pstmt.setString(2, newInstance.getLastName());
			pstmt.setInt(3, newInstance.getAge());
			pstmt.setString(4, newInstance.getEmail());
			pstmt.setString(5, newInstance.getPassword());
			pstmt.setString(6, newInstance.getAddress());
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
		
	


	@Override
	public Customer[] getAll() {
		CustomerList customers = new CustomerList();
		try(Connection conn = ConnectionFactory.getConnection()){
			String query = "select * from customers";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				 customers.add(new Customer(rs.getInt("customer_id"), rs.getString("first_name"),rs.getString("last_name"), rs.getInt("customer_age"), rs.getString("email"), rs.getString("customer_password"), rs.getString("customer_address")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customers.getAllElements();
	}

	// search Customer by Email
	public static Customer searchCustomerByEmail(String email) {
		try(Connection conn = ConnectionFactory.getConnection()){
			String query = "select * from customers where email = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();
			
				if(rs.next()) {
					 return new Customer(rs.getInt("customer_id"), rs.getString("first_name"), rs.getString("last_name"), rs.getInt("customer_age"), rs.getString("email"), rs.getString("customer_password"), rs.getString("customer_address"));
				}
			
		}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
	
}



//	@Override
//	public void updateInstance(Customer updateInstance) {
//		// TODO Auto-generated method stub
//		
//	}
//
//
//
//
//	@Override
//	public void deleteInstance(Customer deleteInstance) {
//		// TODO Auto-generated method stub
//		
//	}

	


