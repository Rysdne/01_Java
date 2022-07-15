
<!-- Java -->
<!-- @, = 등의 기호가 각각의 기능을 표시 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- HTML -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>홈페이지 메인</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>

<%--
<!-- include를 통해 AJAX 형태 구현 -->
<%@ include file="/include/header.jsp" %> <br>
<%@ include file="/include/main.jsp" %> <br>
<%@ include file="/include/footer.jsp" %> <br>
 --%>

<!-- jsp 명령어 사용 : 확인 필요 -->
<jsp:include page="/include/header.jsp" flush="true"></jsp:include>
<jsp:include page="/include/main.jsp" flush="true"></jsp:include>
<jsp:include page="/include/footer.jsp" flush="true"></jsp:include>


</body>
</html>