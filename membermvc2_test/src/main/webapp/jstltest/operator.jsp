<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- 

<%-- 산술연산자 --%>
${10+20}
<br>
${10/20}, ${10 div 20}<br>
<br>
${10%3}, ${10 mod 3}<br>

<%-- 논리연산자 --%>
${true && true}, ${true and true}<br>
${true || true}, ${true or true}<br>
${!true}, ${not true}<br>

<%-- 관계연산자 --%>
<%-- > --%>
${10 gt 11}<br>
<%-- < --%>
${10 lt 11}<br>
<%-- >= --%>
${10 ge 11}<br>
<%-- <= --%>
${10 le 11}<br>
<%-- == --%>
${10 eq 11}<br>
<%-- != --%>
${10 ne 11}<br>

<%-- 이외 연산자 --%>
<%-- empty --%>
<%-- not empty --%>
<%-- null --%>
<%-- instanceof --%>

-->