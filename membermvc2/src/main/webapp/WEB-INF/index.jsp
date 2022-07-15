<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<link href="/css/style.css" type="text/css" rel="stylesheet">
<!--
<script src="/js/javascript.js"></script>
-->
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="/jquery-3.6.0.min.js"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/home/header.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/${page}"></jsp:include>
	<jsp:include page="/WEB-INF/home/footer.jsp"></jsp:include>
</body>
</html>
