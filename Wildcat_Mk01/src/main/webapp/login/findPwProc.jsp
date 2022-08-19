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
	String email = request.getParameter("email");

	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "rysdne", "3882");
	String sql = "select * from wTestID where id=? and email=?";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, id);
	pstmt.setString(2, email);
	ResultSet rs = pstmt.executeQuery();
	if (rs.next()) {
	%>
	<script>
		alert('비밀번호를 재설정합니다');
		location.href="pwReset.jsp?id=<%=id%>";
	</script>
	<%
	} else {
	%>
	<script>
		alert('해당 계정 정보를 찾을 수 없습니다');
		history.back();
	</script>
	<%
	}
	
	pstmt.close();
	conn.close();
	
	%>


</body>
</html>