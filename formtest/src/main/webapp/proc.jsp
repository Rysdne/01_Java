<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%= request.getParameter("msg") %>

<%--  
<%= request.getAttribute("test") %>
--%>


<%
// 자동으로 리다이렉트됨
response.sendRedirect("index.jsp");
%>

</body>
</html>