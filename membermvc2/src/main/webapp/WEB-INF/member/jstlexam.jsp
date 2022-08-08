<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<main>
	${memberlist}<br>
	---------------------------------------------------------------------------------------------<br>
	${memberlist[0]}<br> ${memberlist.get(0)}<br>
	${memberlist[1]}<br>
	---------------------------------------------------------------------------------------------<br>
	${memberlist[0].idx}<br> ${memberlist[0].id}<br>
	${memberlist[0].password}<br>
	---------------------------------------------------------------------------------------------<br>
	${memberlist.size()}<br>
	---------------------------------------------------------------------------------------------<br>
	<%--
리스트화하는 내용(for문)은 jstl을 사용하여 해결
 --%>

	<!-- 1번째 방법 -->
	<c:forEach var="i" begin="0" end="${memberlist.size()-1}">
	${i}
	${memberlist[i].idx}|${memberlist[i].id}|
	${memberlist[i].password}|
	<c:set var="complex" value="아이디${memberlist[i].id}"/>
	<c:out value="${complex}"/>
	</c:forEach>
	---------------------------------------------------------------------------------------------<br>
	<!-- 2번째 방법 -->
	<c:forEach var="m" items="${memberlist}">
	${m.idx}|
	${m.id}|
	${m.password}<br>
	</c:forEach>
	---------------------------------------------------------------------------------------------<br>
</main>