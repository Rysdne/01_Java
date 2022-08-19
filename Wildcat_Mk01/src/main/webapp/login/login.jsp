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
			if (id == "" || id > 20 || password == "" || password > 20) {
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
		ResultSet tableEx = pstmt.executeQuery();
		if (!tableEx.next()) {
			sql = "create table wTestID(uidx number(5) primary key, id varchar2(20) unique not null, password varchar2(20) not null, email varchar2(40) not null)";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			System.out.println("wTestID 생성");
		}
		sql = "select sequence_name from all_sequences where sequence_name='WTESTID_UIDX_SEQ'";
		pstmt = conn.prepareStatement(sql);
		ResultSet seqEx = pstmt.executeQuery();
		if (!seqEx.next()) {
			sql = "create sequence wTestID_uidx_seq increment by 1 start with 1";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			System.out.println("idx 시퀀스 생성");
		}
		
		pstmt.close();
		conn.close();
	}
	%>
	<form id="loginForm" action="loginProc.jsp" method="post">
		<span style="font-weight: bold">ID : </span>
		<input type="text" id="id" name="id" placeholder="ID"><br>
		<span style="font-weight: bold">PW : </span>
		<input type="password" id="password" name="password" placeholder="Password"><br>
		<input type="button" id="login" name="login" value="로그인">
	</form>
	<a href="profCreate.jsp">회원가입</a> | 
	<a href="findId.jsp">아이디 찾기</a> | 
	<a href="findPw.jsp">비밀번호 찾기</a>
</body>
</html>