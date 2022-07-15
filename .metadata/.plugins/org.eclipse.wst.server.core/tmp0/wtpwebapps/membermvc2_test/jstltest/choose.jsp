<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<c:set var="num" value="2" />

<c:choose>
	<c:when test="${num==1}">
number의 값은 1<br>
	</c:when>
	<c:when test="${num==2}">
number의 값은 2<br>
	</c:when>
	<c:otherwise>
number값을 찾을 수 없습니다<br>
	</c:otherwise>
</c:choose>


<c:set var="id" value="robot" />

<c:choose>
	<c:when test="${id=='admin'}">
		<script>
			alert('관리자 페이지로 이동합니다');
		</script>
	</c:when>
	<c:otherwise>
		<script>
			alert('${id}로 로그인되었습니다');
		</script>
	</c:otherwise>
</c:choose>