<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page errorPage="/error/error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function delconfirm(id) {
		var state = confirm("정말 삭제하시겠습니까")
		{
			if (state) {
				location.href = '/delete/delete.jsp?id=' + id;
			} else {
				// location.href = "/find/findOne.jsp?id=" + id;
			}
		}
	}
</script>
</head>
<body>
	<%
	// 드라이버 불러오기(ojdbc8.jar 파일을 lib 폴더에 복사)

	String id = request.getParameter("id");

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
			<th>IDX</th>
			<th>ID</th>
			<th>PW</th>
		</tr>
		<%
		if (rs.next()) {
		%>
		<tr>
			<td><%=rs.getString("idx")%></td>
			<td><%=rs.getString("id")%></td>
			<td><%=rs.getString("password")%></td>
		</tr>
		<tr>
			<td colspan="3"><button
					onclick="location.href='/update/updateForm.jsp?id=<%=rs.getString("id")%>'">수정</button>
				<button id="del_butt"
					onclick="delconfirm('<%=rs.getString("id")%>')">삭제</button>
				<button onclick="location.href='/index.html'">돌아가기</button></td>

		</tr>

		<%
		} else {
		%>
		<script>
			alert("해당 id로 검색된 정보가 없습니다");
			location.href = 'findOne.html';
		</script>
		<%
		}

		pstmt.close();
		conn.close();
		%>
	</table>


</body>
</html>