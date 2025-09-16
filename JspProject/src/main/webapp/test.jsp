<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>welcome to jsp tags</h1>
	
	<!-- Declaration tag -->
	<%!
		static int a = 10;
	
		String name = "Zinga";
	
		public String getMessage(){
			return "Hello";
		}
		
		public boolean sayHi(){
			return true;
		}
	%>
	<!-- Expression Tag -->
	<h2>value of a : <%= a %></h2>
	
	<h2>Name : <%= name %></h2>
	
	<h2><%=getMessage() %></h2>
	
	<h2><%= sayHi() %></h2>
	
	<!-- Scriptlet tag -->
	
	<%
		int z = 50;
	
		out.print("How are you ?");
		
	%>
	
	<h3>Z : <%=z %></h3>
	
</body>
</html>