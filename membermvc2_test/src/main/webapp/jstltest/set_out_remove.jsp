<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- 변수 설정 --%>

<%-- <c:set var="" value=""> </c:set> --%>
<c:set var="a" value="10" />
<c:set var="b" value="20" />
${a} / ${b}
<br>
<c:set var="b" value="${a}" />
${b}<br>
<c:out value="1000"/><br>
<c:out value="${a}"/><br>

<%-- 변수 제거 --%>
변수 제거 전 값 : ${b}<br>
<c:remove var="b"/>
변수 제거 후 값 : ${b}<br>
