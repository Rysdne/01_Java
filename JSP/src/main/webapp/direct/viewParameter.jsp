<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("euc-kr");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
name 파라미터 = <%=request.getParameter("name") %><br>
address 파라미터 = <%=request.getParameter("address") %>
</body>
</html>