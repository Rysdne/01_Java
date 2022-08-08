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
	String id = request.getParameter("id");
	String name = request.getParameter("name");
	String hp = request.getParameter("hp");
	String memo = request.getParameter("memo");

	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "test", "1111");

	String sql = "update phonebook set name=?, hp=?, memo=? where id=?";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, name);
	pstmt.setString(2, hp);
	pstmt.setString(3, memo);
	pstmt.setString(4, id);
	int rs = pstmt.executeUpdate();
	%>
	<script>
		alert("수정되었습니다");
		location.href = "/index.html";
	</script>
	<%
	pstmt.close();
	conn.close();
	%>

</body>
</html>