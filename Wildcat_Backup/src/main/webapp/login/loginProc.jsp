<%@ page import="oracle.jdbc.proxy.annotation.Pre"%>
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

	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "rysdne", "3882");
	String sql = "select * from wTestID where id=? and password=?";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, id);
	pstmt.setString(2, password);
	ResultSet rs = pstmt.executeQuery();
	if (rs.next()) {
		session.setAttribute("id", id);
		System.out.println(session.getAttribute("id")+"계정으로 로그인");
	%>
	<script>
		alert("로그인되었습니다");
		location.href = "/Wildcat_Mk01/index.jsp";
	</script>
	<%
	} else {
	%>
	<script>
		alert("로그인에 실패하였습니다");
		history.back();
	</script>
	<%
	}
	%>


</body>
</html>