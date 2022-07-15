<%@page import="javax.naming.spi.DirStateFactory.Result"%>
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
<style>
a {
	color: black;
	text-decoration: none;
}
</style>
</head>
<body>
	<%
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "test", "1111");

	String sql = "select * from phonebook";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	ResultSet rs = pstmt.executeQuery();
	%>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>전화번호</th>
			<th>비고</th>
		</tr>
		<%
		while (rs.next()) {
		%>
		<tr>
			<td><a href="/find/findOne.jsp?hp=<%=rs.getString("hp")%>"><%=rs.getString("id")%></a></td>
			<td><a href="/find/findOne.jsp?hp=<%=rs.getString("hp")%>"><%=rs.getString("name")%></a></td>
			<td><a href="/find/findOne.jsp?hp=<%=rs.getString("hp")%>"><%=rs.getString("hp")%></a></td>
			<td><a href="/find/findOne.jsp?hp=<%=rs.getString("hp")%>"><%=rs.getString("memo")%></a></td>
		</tr>
		<%
		}
		pstmt.close();
		conn.close();
		%>
	</table>
	<button onclick="location.href='/index.html'">메인 메뉴</button>
</body>
</html>