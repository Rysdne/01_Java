<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Driver"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%-- <%@ page errorPage="/error/error.jsp" %> --%>
<%
request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function delConfirm(hp) {
		var state = confirm("삭제하시겠습니까");
		if (state) {
			location.href = '/delete/delete.jsp?hp=' + hp;
		} else {

		}
	}
</script>
</head>
<body>
	<%
	String hp = request.getParameter("hp");

	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "test", "1111");

	String sql = "select * from phonebook where hp=?";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, hp);
	ResultSet rs = pstmt.executeQuery();
	%>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>전화번호</th>
			<th>비고</th>
		</tr>
		<%
		if (rs.next()) {
		%>
		<tr>
			<td><%=rs.getString("id")%></td>
			<td><%=rs.getString("name")%></td>
			<td><%=rs.getString("hp")%></td>
			<td><%=rs.getString("memo")%></td>
		</tr>
		<tr>
			<td colspan="4">
				<button
					onclick="location.href='/update/updateForm.jsp?hp=<%=rs.getString("hp")%>'">수정</button>
				<button onclick="delConfirm('<%=rs.getString("hp")%>')">삭제</button>
			</td>
		</tr>
	</table>
	<button onclick="location.href='/index.html'">메인 메뉴</button>
	<%
	} else {
	%>
	<script>
		alert("해당 전화번호가 등록되어있지 않습니다");
		location.href = "/find/findOne.html";
	</script>
	<%
	}
	pstmt.close();
	conn.close();
	%>

</body>
</html>