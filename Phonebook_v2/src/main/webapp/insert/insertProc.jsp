<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<%
	
	String name = null;
	String hp = null;
	String memo = null;
	Connection conn = null;
	PreparedStatement pstmt = null;

	
	name = request.getParameter("name");
	hp = request.getParameter("hp");
	memo = request.getParameter("memo");
	
	Class.forName("oracle.jdbc.driver.OracleDriver");

	conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "test", "1111");

	String sql = "insert into phonebook values(phonebook_idx_seq.nextval,?,?,?)";

	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, name);
	pstmt.setString(2, hp);
	pstmt.setString(3, memo);

	int result = pstmt.executeUpdate();

	if (result > 0) {
	%>
	<script>
		alert("저장 완료");
		location.href = "/index.jsp";
	</script>
	<%
	} else {
	%>
	<script>
		alert("저장 실패");
		location.href = "insert.jsp";
	</script>

	<%
	}
	pstmt.close();
	conn.close();
	%>

</body>
</html>