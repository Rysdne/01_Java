<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/style.css" type="text/css">
<link rel="shortcut icon" href="/img/my.ico">
</head>
<body>
	<jsp:include page="/WEB-INF/home/header.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/home/${page}"></jsp:include>
	<jsp:include page="/WEB-INF/home/footer.jsp"></jsp:include>
</body>
</html>