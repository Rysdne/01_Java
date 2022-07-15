<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
for (int i = 0; i < 10; i++) {
%>
% 표현 : <%=i%>
<br>
el표현 : ${i}
<br>
declaration 표현 :
<jsp:expression>i</jsp:expression>
<br>
===================================<br>
<%
}
%>