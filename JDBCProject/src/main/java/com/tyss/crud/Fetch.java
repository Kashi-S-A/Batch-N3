package com.tyss.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Fetch {

	public static void main(String[] args) {
		String driver = "org.postgresql.Driver";
		String url = "jdbc:postgresql://localhost:5432/company";
		String username = "postgres";
		String passwrod = "root";

		try {
			Class.forName(driver);

			Connection con = DriverManager.getConnection(url, username, passwrod);

			Statement stm = con.createStatement();

			String sql = "select * from employee where eid=101";

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

			con.close();

			System.out.println("connection is closed");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
