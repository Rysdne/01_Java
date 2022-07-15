<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- (param,paramValues), pageScope, requestScope, sessionScope, applicationScope --%>

<%--
<c:set var="num" value="100"/>
--%>
<%
request.setAttribute("num", "200");

session.setAttribute("num", "300");
// request.getSession().setAttribute("num","300");

application.setAttribute("num", "400");
// request.getServletContext().setAttribute("num","400");
%>


<%-- c:set 부분 출력 --%>
<%-- 현재 페이지의 설정값 --%>
<%-- 만약 c:set 값이 없다면 입력된 아래 값들 중 첫 번째 놈이 출력됨 --%>
<%-- 우선순위 : page > request > session > application --%>
page : ${num}
<br>

<%-- request.setAttribute 부분 출력 --%>
<%-- 전달된 페이지의 설정값  --%>
request : ${requestScope.num}
<br>

<%-- session.setAttribute 부분 출력 --%>
<%-- 세션에 저장된 설정값  --%>
session : ${sessionScope.num}
<br>

<%-- application.setAttribute 부분 출력 --%>
<%-- 전역에서 사용 가능한 설정값  --%>
application : ${applicationScope.num}
<br>
