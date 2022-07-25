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
	if (session.getAttribute("id") != null) {

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "rysdne", "3882");
		PreparedStatement pstmt;

		String sql = "select table_name from all_tables where table_name='WILDCAT_MK01'";
		pstmt = conn.prepareStatement(sql);
		ResultSet ex = pstmt.executeQuery();
		if (!ex.next()) {
			sql = "create table Wildcat_Mk01(idx number(14) primary key, id varchar2(50) not null, subfolder varchar2(50) not null, title varchar2(50) not null, cdate varchar2(10) not null, ctime varchar2(8) not null)";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			System.out.println("Wildcat_Mk01 생성");
		} else {
		}

		pstmt.close();
		conn.close();
	%>
	<h1>Memo_SendBox</h1>
	<h3>'<%=session.getAttribute("id")%>'님 환영합니다</h3>
	<button onclick='location.href="/Wildcat_Mk01/login/logout.jsp"'>로그아웃</button>
	<ul>
		<li><a href="/Wildcat_Mk01/io/create.jsp">새로 작성</a></li>
		<li><a href="/Wildcat_Mk01/list/listAll.jsp">목록 확인</a></li>
		<li><a href="/Wildcat_Mk01/list/delete.jsp">파일 삭제</a></li>
	</ul>
	<%
	} else {
	response.sendRedirect("login/login.jsp");
	}
	%>
</body>
</html>