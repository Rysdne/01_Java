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
	String id = request.getParameter("id");

	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "test", "1111");

	String sql = "select * from member where id=?";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, id);
	ResultSet ex = pstmt.executeQuery();
	if (ex.next()) {
	%>
	<form action="update.jsp" method="post">
		<table border="1">
			<tr>
				<th>ID</th>
				<th>PW</th>
			</tr>
			<tr>
				<!-- html에서 받은 id값을 출력 -->
				<td><%=ex.getString("id")%></td>
				<td><input type="password" name="password"></td>
			</tr>
		</table>
		<!-- 다음 jsp로 id 값을 보내줘야 하기 때문에 hidden 형식으로 넣어서 날려줘야 함 -->
		<input hidden readonly type="text" name="id" value='<%=id%>'>
		<input type="submit" value="정보 수정">
	</form>
	<a href="index.html">돌아가기</a>
	<%
	} else {
	%>
	입력되지 않은 아이디입니다<br>
	<button onclick="location.href='update.html'">다시 입력</button>
	<button onclick="location.href='index.html'">돌아가기</button>
	

	<%
	}
	%>
</body>
</html>