package com.ty;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/first")
public class PageA extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("PageA servlet is triggered");

//		PrintWriter pw = resp.getWriter();
//
//		pw.print("<html><body><h1>This is PageA</h1></body></html>");

		resp.sendRedirect("https://www.wikipedia.org/");//main use case
	}
}
