<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
String message=request.getParameter("message");
if(message.equals("hello"))
response.sendRedirect("map.html");
%>
메시지가 잘못되어 페이지를 이동할 수 없습니다.<br>
http://localhost:8080/
sendpage1.jsp?message=aaa 잘못된 전달자 일 경우
리다이렉션이 동작하지 않게 가능