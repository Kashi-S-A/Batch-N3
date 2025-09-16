<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Here are the details of User</h1>
	
	<%
		String un = request.getParameter("username");
		String email = request.getParameter("useremail");
		String pwd = request.getParameter("userpwd");
	%>
	
	<h4>UserName : <%=un %></h4>
	<h4>UserEmail : <%=email %></h4>
	
</body>
</html>