<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<% request.setCharacterEncoding("utf-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<%
	String idx = request.getParameter("idx");

	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "test", "1111");

	String sql = "select * from phonebook where idx=?";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, idx);
	ResultSet rs = pstmt.executeQuery();

	if (rs.next()) {
		%>
		<div class="container mt-3">
			<h2>전화번호 조회</h2>
			<form action="/update/updateForm.jsp">
				<label for="idx">번호 : </label>
				<input class="form-control" type="text" name="idx" readonly value="<%=rs.getInt("idx")%>">
				<label for="name">이름 : </label>
				<input class="form-control" type="text" name="name" readonly value="<%=rs.getString("name")%>">
				<label for="hp">전화번호 : </label>
				<input class="form-control" type="text" name="hp" readonly value="<%=rs.getString("hp")%>">
				<label for="memo">메모 : </label>
				<input class="form-control" type="text" name="memo" readonly value="<%=rs.getString("memo")%>">
				<button type="submit" class="btn btn-primary">수정</button>
				<button type="button" class="btn btn-success" onclick="location.href='/delete/delete.jsp?idx=<%=rs.getInt("idx")%>'">삭제</button>
				<button type="button" class="btn btn-secondary" onclick="location.href='/index.jsp'">취소</button>
			</form>
		</div>
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
</body>
</html>