package com.ty;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/read")
public class ReadData extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("reading data");

		String uname = req.getParameter("name");
		String uemail = req.getParameter("email");
		String uaddress = req.getParameter("address");

		System.out.println(uname);
		System.out.println(uemail);
		System.out.println(uaddress);
		
		PrintWriter pw = res.getWriter();
		pw.print("<html>");
		pw.print("<body>");
		pw.print("<h1>"+uname+" Welcome to Servlet Classess </h1>");
		pw.print("</body>");
		pw.print("</html>");
	}
}
