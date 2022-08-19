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
	String email = request.getParameter("email");

	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "rysdne", "3882");
	String sql = "select * from wTestID where email=?";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, email);
	ResultSet rs = pstmt.executeQuery();
	if (rs.next()) {
	%>
	조회하신 계정 아이디는<br>
	<h1><%=rs.getString("id")%></h1><br>
	입니다<br>
	<button onclick="location.href='/Wildcat_Mk01/index.jsp'">메인 메뉴</button>
	<button onclick="location.href='findPw.jsp'">비밀번호 찾기</button>
	<%
	} else {
	%>
	<script>
		alert('해당 계정을 찾을 수 없습니다');
		history.back();
	</script>
	<%
	}
	%>


</body>
</html>