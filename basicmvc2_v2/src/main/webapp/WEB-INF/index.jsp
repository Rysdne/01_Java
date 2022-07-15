<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link href="/css/style.css" type="text/css" rel="stylesheet">
<link rel="shortcut icon" href="/img/my.ico">
</head>
<body>
	<jsp:include page="/WEB-INF/home/header.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/home/${page}"></jsp:include>
	<jsp:include page="/WEB-INF/home/footer.jsp"></jsp:include>
</body>
</html>
