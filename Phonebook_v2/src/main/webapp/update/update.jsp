<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String _idx = request.getParameter("idx");
	int idx = Integer.parseInt(_idx);
	String name = request.getParameter("name");
	String hp = request.getParameter("hp");
	String memo = request.getParameter("memo");

	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "test", "1111");
	String sql = "update phonebook set name=?, hp=?, memo=? where idx=?";

	PreparedStatement pstmt = conn.prepareStatement(sql);

	pstmt.setString(1, name);
	pstmt.setString(2, hp);
	pstmt.setString(3, memo);
	pstmt.setInt(4, idx);

	int result = pstmt.executeUpdate();

	if (result > 0) {
	%>
	<script>
		alert("수정이 완료되었습니다");
		location.href = "/index.jsp";
	</script>
	<%
	} else {
	%>
	<script>
		alert("수정에 실패하였습니다");
		window.history.go(-1);
		// location.href="/index.jsp";
	</script>
	<%
	}

	pstmt.close();
	conn.close();
	%>



</body>
</html>