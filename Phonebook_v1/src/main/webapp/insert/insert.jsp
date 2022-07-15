<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%-- <%@ page errorPage="/error/error.jsp" %> --%>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "test", "1111");

	String name = request.getParameter("name");
	String hp = request.getParameter("hp");
	String memo = request.getParameter("memo");

	String sql = "select * from phonebook where hp=?";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, hp);
	ResultSet ex = pstmt.executeQuery();
	if (!ex.next()) {

		sql="insert into phonebook values(phonebook_id_seq.nextval,?,?,?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, name);
		pstmt.setString(2, hp);
		pstmt.setString(3, memo);
		int rs=pstmt.executeUpdate();
		%>
	<script>
		alert("등록이 완료되었습니다");
		location.href = "/index.html";
	</script>
	<%
	} else {
		%>
	<script>
		alert("이미 등록된 전화번호입니다");
		location.href = "/insert/insert.html";
	</script>
	<%
	}
	%>
</body>
</html>