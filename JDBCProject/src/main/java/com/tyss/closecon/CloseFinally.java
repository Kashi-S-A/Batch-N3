package com.tyss.closecon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CloseFinally {

	public static void main(String[] args) {
		String driver = "org.postgresql.Driver";
		String url = "jdbc:postgresql://localhost:5432/company";
		String username = "postgres";
		String passwrod = "roo";

		Connection con = null;
		try {
			Class.forName(driver);
			System.out.println("driver loaded");

			con = DriverManager.getConnection(url, username, passwrod);
			System.out.println("connection is created");

			Statement stm = con.createStatement();
			System.out.println("statement is created");

			String sql = "elect * from employee";

			ResultSet rs = stm.executeQuery(sql);

			System.out.println("============Employees============");
			while (rs.next()) {
				System.out.println("Eid : " + rs.getInt(1));
				System.out.println("name : " + rs.getString(2));
				System.out.println("Email : " + rs.getString(3));
				System.out.println("Salary : " + rs.getDouble(4));
				System.out.println("=========================");
			}

			System.out.println("record is fetched");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
					System.out.println("connection is closed");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
