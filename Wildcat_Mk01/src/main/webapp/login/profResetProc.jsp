<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>

<%
request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	String email = request.getParameter("email");
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "rysdne", "3882");
	String sql = "update wTestID set password=?, email=? where id=?";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, password);
	pstmt.setString(2, email);
	pstmt.setString(3, id);
	int update = pstmt.executeUpdate();
	
	pstmt.close();
	conn.close();
	
	%>
	정보가 수정되었습니다<br>
	<button onclick="location.href='/Wildcat_Mk01/index.jsp'">돌아가기</button>
</body>
</html>