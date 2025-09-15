package com.tyss;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/pagec")
public class PageC extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("This is PageC servlet");

		String name = (String) req.getAttribute("name");
		int age = (Integer) req.getAttribute("age");

		System.out.println(name);
		System.out.println(age);
		
		Student student =(Student) req.getAttribute("stud");
		System.out.println(student.name);
		System.out.println(student.sid);
		
		PrintWriter pw = resp.getWriter();
		pw.print("<html>" + "<body>" 
				+ "<h1>" + name + " Welcome to Servlet PageC</h1>" 
				+"<h1>=============Student Details=============</h1>" 
				+"<h3> Sid : "+student.sid+"</h3>"
				+"<h3> Name : "+student.name+"</h3>"
				+ "</body>" + "</html>");
	}
}
