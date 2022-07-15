<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	// 드라이버 불러오기(ojdbc8.jar 파일을 lib 폴더에 복사)
	
	String id=request.getParameter("id");
	
	Class.forName("oracle.jdbc.driver.OracleDriver");

	// DB와의 커넥션 생성
	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "test", "1111");

	// SQL문 생성
	String sql = "select * from member where id=?";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, id);
	ResultSet rs = pstmt.executeQuery();
	%>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>PW</th>
		</tr>
		<%
		if (rs.next()) {
		%>
		<tr>
			<td><%=rs.getString("id")%></td>
			<td><%=rs.getString("password")%></td>
		</tr>
		<%
		}
		

		pstmt.close();
		conn.close();
		
		%>
	</table>
	<a href="index.html">돌아가기</a>

</body>
</html>