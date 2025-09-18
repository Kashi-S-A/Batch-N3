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

@WebServlet("/login")
public class Login extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String pwd = req.getParameter("password");

		try {
			Connection connection = ConnectionPool.giveConnection();
			String select = "SELECT * FROM user_info WHERE email=? AND password=?";
			PreparedStatement pstm = connection.prepareStatement(select);
			pstm.setString(1, email);
			pstm.setString(2, pwd);

			ResultSet rs = pstm.executeQuery();

			ConnectionPool.submitConnection(connection);

			if (rs.next()) {
				// Login Succ
				RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
				rd.forward(req, resp);
			} else {
				// invalid cred
				req.setAttribute("errmsg", "Invalid credentials");
				RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
				rd.forward(req, resp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			req.setAttribute("errmsg", "Something went wrong please try again later.........!");
			RequestDispatcher rd = req.getRequestDispatcher("register.jsp");
			rd.forward(req, resp);
		}
	}
}
