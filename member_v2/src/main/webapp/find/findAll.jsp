<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page errorPage="/error/error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
tr:hover {
	background-color: yellowgreen;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(document).ready(function() {

		$('tr').click(function() {

			// 			// 활용 방식에 따라 여러 형태로 출력이 가능			
			// 모든 값을 탭+줄바꿈을 포함해 출력
			alert($(this).eq(0).text());
			// 			// 모든 값을 나열하며 출력
			// 			alert($(this).children().text());
			// 			// 값들 중 가장 먼저 입력된 td만 출력
			// 			alert($(this).find("td:first").text());
			// 			// 값들 중 첫 번째 값만 출력
			// 			alert($(this).children().eq(0).text());
			// 			// 값들 중 두 번째 값만 출력
			// 			alert($(this).children().eq(1).text());
			// 			// 값들 중 세 번째 값만 출력
			// 			alert($(this).children().eq(2).text());
		});
	});
</script>
</head>
<body>
	<%
	// 드라이버 불러오기(ojdbc8.jar 파일을 lib 폴더에 복사)
	Class.forName("oracle.jdbc.driver.OracleDriver");

	// DB와의 커넥션 생성
	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "test", "1111");

	// SQL문 생성
	String sql = "select * from member";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	ResultSet rs = pstmt.executeQuery();
	%>
	<table border="1">
		<tr>
			<th>IDX</th>
			<th>ID</th>
			<th>PW</th>
		</tr>
		<%
		while (rs.next()) {
		%>
		<tr>
			<td><%=rs.getString("idx")%></td>
			<td><a href="/find/findOne.jsp?id=<%=rs.getString("id")%>"><%=rs.getString("id")%></a></td>
			<td><%=rs.getString("password")%></td>
		</tr>
		<%
		}

		pstmt.close();
		conn.close();
		%>
	</table>
	<button onclick="location.href='/index.html'">돌아가기</button>

</body>
</html>