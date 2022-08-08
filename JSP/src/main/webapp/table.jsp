<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>이름</th>
		</tr>
		<%
		for (int i = 1; i < 11; i++) {
		%>
		<tr>
			<td><%=i%></td>
			<td>rysdne<%=i%></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>