package com.ty.ecom.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.ecom.db.ConnectionPool;

@WebServlet("/reg")
public class Register extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String pwd = req.getParameter("password");
		long phone = Long.parseLong(req.getParameter("phone"));

		// First check whether user is registered or not if registered then return
		// already registered message. Else insert user info into the table then return
		// succ message

		try {
			Connection connection = ConnectionPool.giveConnection();

			// save user info and return 'Registered Successfully' message
			String insert = "INSERT INTO user_info VALUES(?,?,?,?)";
			PreparedStatement pstm = connection.prepareStatement(insert);
			pstm.setString(1, name);
			pstm.setString(2, email);
			pstm.setString(3, pwd);
			pstm.setLong(4, phone);

			int saved = pstm.executeUpdate();// insert record if not exists else throw SQL exception

			ConnectionPool.submitConnection(connection);
			if (saved > 0) {
				System.out.println("saved successfully");
				req.setAttribute("succmsg", "Registered Successfully");
				RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
				rd.forward(req, resp);
			} else {
				System.out.println("failed to save");
				req.setAttribute("errmsg", "failed to register");
				RequestDispatcher rd = req.getRequestDispatcher("register.jsp");
				rd.forward(req, resp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("already saved");
			req.setAttribute("errmsg", "Already Registered");
			RequestDispatcher rd = req.getRequestDispatcher("register.jsp");
			rd.forward(req, resp);
		}

	}
}
