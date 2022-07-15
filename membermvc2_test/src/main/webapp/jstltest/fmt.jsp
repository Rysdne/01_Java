<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%-- fmt : 표시 포맷 관련 명령 --%>
<fmt:parseDate var="date" value="2022-01-01" pattern="yyyy-MM-dd"/>
<fmt:formatDate value="${date}" pattern="MM/dd/yy"/><br>
<fmt:formatNumber value="12345678.987"/><br>
<fmt:formatNumber value="0.5" type="percent"/><br>
<fmt:formatNumber value="10000" type="currency"/><br>
<fmt:formatNumber value="12345678.987" pattern=".000"/><br>
<fmt:formatNumber value="12345678.987" pattern=".00"/><br>
<fmt:formatNumber value="12345678.98765" pattern=".000#"/><br>
<%-- 
참고사항 : #채워야할 자리에 비해서 데이터가 모자란 경우 공백으로표시
0:빈자리 만큼 0으로 채운다 
--%>