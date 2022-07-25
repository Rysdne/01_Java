<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/Wildcat_Mk01/jquery-3.6.0.min.js"></script>
<script>
	$(function() {
		$('#login').click(function() {
			var id = $('#id').val();
			var password = $('#password').val();
			if (id == "" || id > 50 || password == "" || password > 20) {
				alert('계정 정보를 확인해주세요');
				return;
			}
			$('#loginForm').submit();
		})
	})
</script>
</head>
<body>

	<%
	if (session.getAttribute("id") != null) {
		response.sendRedirect("/Wildcat_Mk01/index.jsp");
	} else {

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "rysdne", "3882");
		PreparedStatement pstmt;

		String sql = "select table_name from all_tables where table_name='WTESTID'";
		pstmt = conn.prepareStatement(sql);
		ResultSet ex = pstmt.executeQuery();
		if (!ex.next()) {
			sql = "create table wTestID(uidx number(5) primary key, id varchar2(50) unique not null, password varchar2(20) not null)";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			System.out.println("wTestID 생성");
		} else {
		}

		pstmt.close();
		conn.close();
	}
	%>
	<form id="loginForm" action="loginProc.jsp" method="post">
		<span style="font-weight: bold">ID : </span> <input type="text"
			id="id" name="id" placeholder="ID"><br> <span
			style="font-weight: bold">PW : </span> <input type="password"
			id="password" name="password" placeholder="Password"><br>
		<input type="button" id="login" name="login" value="로그인">
	</form>
	<a href="#">회원가입</a> |
	<a href="#">아이디 찾기</a> |
	<a href="#">비밀번호 찾기</a>
</body>
</html>