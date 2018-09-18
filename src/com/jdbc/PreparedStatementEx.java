package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * This class is to demonstrate PreparedStatement
 * @author subhash
 *
 */
public class PreparedStatementEx {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/subhash", "root", "root");
		
		PreparedStatement prepareStatement = con.prepareStatement("insert into student values(?, ?)");
		prepareStatement.setInt(1, 5);
		prepareStatement.setString(2, "Arvind");
		int i = prepareStatement.executeUpdate();
		if(i != 0)
			System.out.println("Record inserted successfully");
		
	}
}
