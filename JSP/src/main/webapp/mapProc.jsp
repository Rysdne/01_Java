<%@page import="java.util.Map"%>
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
Map map=request.getParameterMap();
String[] imsi=(String[])map.get("name");
%>
<%=imsi[0]%><br>

<%
imsi=(String[])map.get("pet");
%>

<%for(String p:imsi){ %>
<%=p%><br>
<%} %>
</body>
</html>


