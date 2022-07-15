<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%-- paramValues는 기본적으로 갖고있기 때문에 c태그를 사용하지 않아도 됨 --%>
<%--
${paramValues.lang[0]}<br>
${paramValues.lang[1]}<br>
${paramValues.lang[2]}<br>
${paramValues.lang[3]}<br>
${paramValues.lang[4]}<br>
 --%>


<%-- taglib를 이용하여 파라메타를 출력하세요 --%>
<%-- 1) 가장 쉬운 방법 --%>
<%--
<c:forEach var="lang" items="${paramValues.lang}">
${lang}<br>
</c:forEach>
--%>
<%-- 2) 길이 확인 후 forEach --%>
<%-- 2-1) 전송받은 Values길이 확인 --%>
${fn:length(paramValues.lang)}<br>
<c:forEach var="i" begin="0" end="${fn:length(paramValues.lang)-1}" step="1">
${paramValues.lang[i]}<br>
</c:forEach>

<%--
${fn:length(paramValues.lang)}<br>
 --%>

<%-- 안되는 코드들 --%>
<%--
1) size 함수를 사용한 길이 확인
${paramValues.lang.size()}<br>
 --%>



