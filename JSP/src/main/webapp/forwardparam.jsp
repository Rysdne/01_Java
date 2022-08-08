<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--  response.sendRedirect("forwareProc.jsp?message=hello") -->
<jsp:include page="forwardProc.jsp">
	<jsp:param value="hello" name="message"/> 
</jsp:include>
</body>
</html>