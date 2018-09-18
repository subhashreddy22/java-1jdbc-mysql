package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Simple JDBC connection to MySQL
 * 
 * @author subhash
 *
 */
public class JdbcConnection {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/subhash", "root", "root");

		Statement statement = con.createStatement();

		ResultSet resultSet = statement.executeQuery("select * from student");

		while (resultSet.next())
			System.out.println(resultSet.getInt(1) + "  " + resultSet.getString(2));
		
		con.close();

	}
}
