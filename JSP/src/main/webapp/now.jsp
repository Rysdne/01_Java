<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="false" %>

<%
Date now=new Date();
String imsi="aaaaa    aaaaa";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
현재 시각:    
<%=now%>
<%=imsi%>
</body>
</html>