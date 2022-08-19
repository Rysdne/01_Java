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
	String email = request.getParameter("email");
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "rysdne", "3882");
	String sql = "select * from wTestID where id=?";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, id);
	ResultSet exId = pstmt.executeQuery();

	sql = "select * from wTestID where email=?";
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, email);
	ResultSet exEmail = pstmt.executeQuery();

	if (exId.next()) {
	%>
	<script>
		alert('등록된 ID가 존재합니다');
		history.back();
	</script>
	<%
	} else if (exEmail.next()) {
	%>
	<script>
		alert('등록된 Email 계정이 존재합니다');
		history.back();
	</script>
	<%
	} else {
	sql = "insert into wTestID values(wTestID_uidx_seq.nextval,?,?,?)";
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, id);
	pstmt.setString(2, password);
	pstmt.setString(3, email);
	ResultSet rs = pstmt.executeQuery();
	%>
	<script>
		alert('계정을 생성하였습니다');
		location.href = '/Wildcat_Mk01/index.jsp';
	</script>
	<%
	}
	pstmt.close();
	conn.close();
	%>
</body>
</html>