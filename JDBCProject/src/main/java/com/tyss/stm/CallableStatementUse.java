package com.tyss.stm;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CallableStatementUse {

	public static void main(String[] args) {
		String driver = "org.postgresql.Driver";
		String url = "jdbc:postgresql://localhost:5432/company?user=postgres&password=root";

		try {
			Class.forName(driver);

			Connection con = DriverManager.getConnection(url);

			String sql = "call procedure_name(?,?,?,?,?)";// command to call procedure or
									// function=> select function_name(?,?);

			CallableStatement cstm = con.prepareCall(sql);
			cstm.setInt(1, 101);
			cstm.setString(2, "Cooper");
			cstm.setString(3, "cooper@gmail.com");
			cstm.setString(4, "10th Std");
			cstm.setLong(5, 98765456);

			cstm.execute();
			System.out.println("procedure is executed");

			con.close();

			System.out.println("conn closed");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
