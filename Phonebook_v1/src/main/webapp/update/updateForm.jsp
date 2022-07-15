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

	String sql = "select * from phonebook where hp=?";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, hp);
	ResultSet rs = pstmt.executeQuery();

	rs.next();
	String id = rs.getString("id");
	%>
	<form action="/update/update.jsp" method="post">
		<table border="1">
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>전화번호</th>
				<th>비고</th>
			</tr>
			<tr>
				<td><input type="text" name="id" readonly value="<%=id%>"></td>
				<td><input type="text" name="name"></td>
				<td><input type="text" name="hp"></td>
				<td><input type="textarea" name="memo"></td>
			</tr>
			<tr>
				<td colspan="4"><input type="submit" value="수정"></td>
			</tr>
		</table>
	</form>
	<button onclick="location.href='/index.html'">메인 메뉴</button>
	<%
	pstmt.close();
	conn.close();
	%>

</body>
</html>