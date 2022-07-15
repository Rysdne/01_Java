<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String[] delchecks = request.getParameterValues("delchecks");
	for(String a:delchecks){
		out.print(a+"<br>");
	}
	String[] ids = request.getParameterValues("ids");
	for(String a:ids){
		out.print(a+"<br>");
	}
	%>
</body>
</html>