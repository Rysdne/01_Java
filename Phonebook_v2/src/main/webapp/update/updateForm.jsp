<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<%
String idx=request.getParameter("idx");
String name = request.getParameter("name");
String hp = request.getParameter("hp");
String memo = request.getParameter("memo");
%>

	<div class="container mt-3">
		<h2>전화번호 조회</h2>
		<form action="/update/update.jsp" method="post">
			<label for="idx">번호 : </label>
			<input class="form-control" type="text" name="idx" readonly value="<%=idx%>">
			<label for="name">이름 : </label>
			<input class="form-control" type="text" name="name" value="<%=name%>">
			<label for="hp">전화번호 : </label>
			<input class="form-control" type="text" name="hp" value="<%=hp%>">
			<label for="memo">메모 : </label>
			<input class="form-control" type="text" name="memo" value="<%=memo%>">
			<button type="submit" class="btn btn-primary">수정 하기</button>
			<button type="button" class="btn btn-secondary" onclick="location.href='/select/findOne.jsp?idx=<%=idx%>'">취소</button>
		</form>
	</div>
</body>
</html>