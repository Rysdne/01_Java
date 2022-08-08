<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<div class="container mt-3">
		<button type="button" class="btn btn-success" onclick="location.href='/index.jsp'">HOME</button>
		<h2>전화번호부 입력</h2>
		<form action="insertProc.jsp" method="post">
			<label for="name">이름 : </label>
			<input class="form-control" type="text" name="name">
			<label for="hp">전화번호 : </label>
			<input class="form-control"  type="number" name="hp">
			<label for="memo">메모 : </label>
			<input class="form-control"  type="text" name="memo">
		<button type="submit" class="btn btn-primary">입력</button>
		<button type="button" class="btn btn-secondary" onclick="location.href='/index.jsp'">취소</button>
		</form>
	</div>
</body>
</html>