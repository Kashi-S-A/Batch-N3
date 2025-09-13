package com.tyss;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/pagea")
public class PageA extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet is triggered");
		PrintWriter pw = resp.getWriter();
		pw.print("<html>"
				+ "<body>"
				+ "<h1>Welcome to the Get service</h1>"
				+ "</body>"
				+ "</html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost is triggered");
		
		String username = req.getParameter("un");
		String email = req.getParameter("ue");
		String password = req.getParameter("pwd");
		
		System.out.println(username);
		System.out.println(email);
		System.out.println(password);
		
		PrintWriter pw = resp.getWriter();
		pw.print("<html>"
				+ "<body>"
				+ "<h1>Hey,"+username+" Welcome to Http Servlet</h1>"
				+ "</body>"
				+ "</html>");
	}
}
