package com.tyss.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert {

	public static void main(String[] args) {

		String url = "jdbc:postgresql://localhost:5432/company?user=postgres&password=root";

		try {

			// step 1 : Load the driver
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver is loaded");

			// step 2 : Create a connection
			Connection con = DriverManager.getConnection(url);
			System.out.println("connection is created");

			// step 3 : Create a Statement
			Statement stm = con.createStatement();
			System.out.println("statement is created");

			String sql = "insert into employee values(104,'Suresh','suresh@gmail.com',95000)";

			// step 4 : Execute the query
			System.out.println(stm.execute(sql));
			System.out.println("query executed");

			// step 5 : close the connection
			con.close();
			System.out.println("connection is closed");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
