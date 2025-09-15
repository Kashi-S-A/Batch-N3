package com.tyss;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/pageb")
public class PageB extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("This is PageB servlet");

		PrintWriter pw = resp.getWriter();
		pw.print("<html>" 
				+ "<body>" 
				+ "<h1>Welcome to Servlet PageB</h1>" 
				+ "</body>" 
				+ "</html>");

		// send data to pagec
		req.setAttribute("name", "Penga");
		req.setAttribute("age", 34);

		Student student = new Student(101, "Manga");
		req.setAttribute("stud", student);

		RequestDispatcher rd = req.getRequestDispatcher("display.jsp");// to which servlet you want to dispatch req provide
																	// url of that servlet
		rd.forward(req, resp);

	}
}
