<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String[] check = request.getParameterValues("check");
	if (check != null) {
		for (int i = 0; i < check.length; i++) {
		out.println(check[i]);
		}
	}else{
		out.println("없음");
	}
	
	
	
	
	%>

</body>
</html>