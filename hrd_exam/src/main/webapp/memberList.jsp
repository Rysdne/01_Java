<%@page import="java.text.DateFormat"%>
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
<style>
* {
	margin: 0;
	padding: 0;
}

li {
	list-style: none;
}

#wrap {
	width: 100%;
	height: 100vh;
	background-color: gray;
}

header {
	width: 100%;
	height: 10vh;
	background-color: slateblue;
	color: white;
	font-weight: bold;
	font-size: 20pt;
	display: flex;
	justify-content: center;
	align-items: center;
}

nav {
	width: 100%;
	height: 5vh;
	background-color: skyblue;
}

nav ul {
	display: flex;
	width: 100%;
}

nav ul li {
	height: 5vh;
	flex: 1;
	display: flex;
	font-weight: bold;
	color: white;
	justify-content: center;
	align-items: center;
}

section {
	width: 100%;
	height: 75vh;
	background-color: lightgray;
	width: 100%;
}

table {
	margin: 0 auto;
}

footer {
	width: 100%;
	height: 10vh;
	background-color: slateblue;
	display: flex;
	color: white;
	justify-content: center;
	align-items: center;
	color: white;
}
</style>
</head>
<body>
	<%
	String _custno = request.getParameter("custno");
	int custno = Integer.parseInt(_custno);
	String custname = request.getParameter("custname");
	String phone = request.getParameter("phone");
	String address = request.getParameter("address");
	String joindate = request.getParameter("joindate");
	String grade = request.getParameter("grade");
	String city = request.getParameter("city");
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");

	String sql = "select * from member_tbl_02 order by custno asc";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	ResultSet rs = pstmt.executeQuery();

	%>
	<div id="wrap">
		<header>쇼핑몰 회원관리 ver 1.0</header>
		<nav>
			<div style="width: 50%; display: flex;">
				<ul>
					<li>회원등록</li>
					<li>회원목록조회/수정</li>
					<li>회원대출조회</li>
					<li>홈으로.</li>
				</ul>
			</div>
		</nav>
		<section>
			<br>
			<h3 style="text-align: center;">홈쇼핑 회원등록</h3>
			<br>
			<form id="form" action="#">
				<table border="1">
					<tr>
						<th>회원번호</th>
						<th>회원성명</th>
						<th>전화번호</th>
						<th>주소</th>
						<th>가입일자</th>
						<th>고객등급</th>
						<th>거주지역</th>
					</tr>
					<%
					while(rs.next()){
						
					%>
					<tr>
						<td><%=rs.getInt("custno") %></td>
						<td><%=rs.getString("custname") %></td>
						<td><%=rs.getString("phone") %></td>
						<td><%=rs.getString("address") %></td>
						<td><%=rs.getString("joindate") %></td>
						<td><%=rs.getString("grade") %></td>
						<td><%=rs.getString("city") %></td>
					</tr>
					<%
					}
					%>
				</table>
			</form>
		</section>
		<footer> HRDKOREA Copyrightⓒ2016 All rights reserved. Human
			Resources Development Service of Korea. </footer>
	</div>
</body>
</html>