<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%if(session.getAttribute("id")!=null){ %>
홈페이지에 오신것을 환영합니다.<br>
<a href="/login/logout.jsp">로그아웃</a>
<%}else{
response.sendRedirect("/login/login.jsp");
}
%>
</body>
</html>