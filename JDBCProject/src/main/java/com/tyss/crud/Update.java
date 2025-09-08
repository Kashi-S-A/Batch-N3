package com.tyss.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Update {

	public static void main(String[] args) {
		String driver = "org.postgresql.Driver";
		String url = "jdbc:postgresql://localhost:5432/company";
		String username = "postgres";
		String passwrod = "root";

		try {
			Class.forName(driver);

			Connection con = DriverManager.getConnection(url, username, passwrod);

			Statement stm = con.createStatement();

			String sql = "update employee set email='ramesh@gmail.com' where name='Ramesh'";

			System.out.println(stm.executeUpdate(sql));

			System.out.println("record is updated");

			con.close();

			System.out.println("connection is closed");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
