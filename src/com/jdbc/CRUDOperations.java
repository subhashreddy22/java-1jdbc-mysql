package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CRUDOperations {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/subhash", "root", "root");
		PreparedStatement prepareStatement = null;

		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Please choose the below option to perform the desired operation");
			System.out.println("C - Create");
			System.out.println("R - Retrieve");
			System.out.println("U - Update");
			System.out.println("D - Delete");

			String input = sc.next();

			if (input.startsWith("C") || input.startsWith("c")) {
				prepareStatement = con.prepareStatement("insert into Student values (?, ?)");
				System.out.println("Please enter id");
				int id = sc.nextInt();
				System.out.println("Please enter name");
				String name = sc.next();
				prepareStatement.setInt(1, id);
				prepareStatement.setString(2, name);
				int i = prepareStatement.executeUpdate();
				if (i != 0) {
					System.out.println("Record created successfully");
				} else {
					System.out.println("Record could not be created");
				}
			} else if (input.startsWith("R") || input.startsWith("r")) {
				prepareStatement = con.prepareStatement("select * from student where id = ?");
				System.out.println("Please enter an id to retrieve the record");
				int id = sc.nextInt();
				prepareStatement.setInt(1, id);
				ResultSet resultSet = prepareStatement.executeQuery();
				if (resultSet.next()) {
					System.out.println("Record retrieved successfully");
					System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2));
				} else {
					System.out.println("Record not found");
				}
			} else if (input.startsWith("U") || input.startsWith("u")) {
				prepareStatement = con.prepareStatement("update student set name = ? where id = ?");
				System.out.println("Please enter the id to be updated");
				int id = sc.nextInt();
				System.out.println("Please enter the updated name");
				String name = sc.next();
				prepareStatement.setString(1, name);
				prepareStatement.setInt(2, id);
				int i = prepareStatement.executeUpdate();
				if (i != 0) {
					System.out.println("Record updated successfully");
				} else {
					System.out.println("Record could not be updated");
				}
			} else if (input.startsWith("D") || input.startsWith("d")) {
				prepareStatement = con.prepareStatement("delete from student where id = ?");
				System.out.println("Please enter the id to be deleted");
				int id = sc.nextInt();
				prepareStatement.setInt(1, id);
				int i = prepareStatement.executeUpdate();
				if (i != 0) {
					System.out.println("Record deleted successfully");
				} else {
					System.out.println("Record could not be deleteds");
				}
			}
			System.out.println("Do you want to perfor more operations: y/n");
			String feedback = sc.next();
			if(feedback.startsWith("n") || feedback.startsWith("N")) {
				break;
			}
		} while (true);
	}
}
