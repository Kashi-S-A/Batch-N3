<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Scanner"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<c:set var="a" value="50"></c:set>
	
	<c:set var="b" value="500"></c:set>

	<h1>
		<c:out value="${a}"></c:out>
	</h1>

	<c:choose>
		<c:when test="${a > b}"><p>a is greater than b</p>></c:when>
		<c:when test="${a < b}"><h1>a is less than b</h1></c:when>
		<c:otherwise> a equals b</c:otherwise>
	</c:choose>

	
</body>
</html>