<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>

<script src="https://kit.fontawesome.com/1791a43b28.js"
	crossorigin="anonymous"></script>

</head>
<body>
	<jsp:include page="/WEB-INF/home/header.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/${content}"></jsp:include>
</body>
</html>
