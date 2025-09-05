package com.tyss.stm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

			String sql = "insert into employee values(?,?,?,?)";

			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, 105);
			pstm.setString(2, "Martin");
			pstm.setString(3, "martin@gmail.com");
			pstm.setDouble(4, 78000);

			System.out.println("statement is created");

			pstm.execute();
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
