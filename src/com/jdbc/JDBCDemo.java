package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBCDemo
 * 
 * @author Subhash
 *
 */
public class JDBCDemo {
	
	public static void main(String[] args) throws SQLException {
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/employees_db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
				"root", "root");
		
		Statement statement = conn.createStatement();
		ResultSet resultSet = statement.executeQuery("show tables");
		while(resultSet.next()) {
			System.out.println(resultSet.getString(1));
		}
		
		ResultSet employeeSet = statement.executeQuery("select * from employees_tbl");
		while(employeeSet.next()) {
			System.out.println(employeeSet.getString(2) + " " + employeeSet.getString("dept"));
		}
		
		statement.executeUpdate("insert into employees_tbl values(1, 'Test', 'Test', 12000)");
	}
}
