<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Driver"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%-- <%@ page errorPage="/error/error.jsp" %> --%>
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
	String hp = request.getParameter("hp");

	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "test", "1111");

	String sql = "delete from phonebook where hp=?";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, hp);
	int rs = pstmt.executeUpdate();

	pstmt.close();
	conn.close();
	%>
	<script>
		alert("삭제가 완료되었습니다");
		location.href = "/index.html";
	</script>
	
</body>
</html>