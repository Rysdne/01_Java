<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
//위에서 전달받은 데이터를 데이터베이스 접속하여 처리
Class.forName("oracle.jdbc.driver.OracleDriver");

Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "test", "1111");
System.out.println(conn);
String sql = "select title, content, bookimg from book";
PreparedStatement pstmt = conn.prepareStatement(sql);
ResultSet rs = pstmt.executeQuery();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.book {
	width: 200px;
	height: 300px;
	border: 1px solid gray;
	text-align: center;
}

.book>img {
	width: 150px;
	height: 200px;
	border: 1px solid gray;
}

.book>h3 {
	border: 1px solid gray;
	text-align: center
}

.book>p {
	border: 1px solid gray;
	text-align: center
}
</style>
</head>
<body>
	<%
	while (rs.next()) {
	%>
	<div class="book">
		<img src="/file/<%=rs.getString("bookimg")%>">
		<h3><%=rs.getString("title")%></h3>
		<p><%=rs.getString("content")%></p>
	</div>
	<%
	}

	rs.close();
	pstmt.close();
	conn.close();
	%>

</body>
</html>