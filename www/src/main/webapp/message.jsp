<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>jsp form</title>
</head>
<body>

<form action="/messageProc" method="get">
메시지:<input type="text" name="message">
<input type="submit" value="메시지 전송">
</form>

</body>
</html>