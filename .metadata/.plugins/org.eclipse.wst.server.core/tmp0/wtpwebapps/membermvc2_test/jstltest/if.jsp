<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${1>0}">
참입니다<br>
</c:if>

<c:if test="${1>0}" var="result">
${result}<br>
</c:if>

<c:if test="${1>0}" var="result">
</c:if>
${result}<br>


<%-- ${ } 안에서는 미리 선언된 변수를 사용할 수 있음 --%>
<c:set var="input1" value="30"/>
<c:if test="${input1>20}">
입력값이 더 크다
</c:if>
<br>

<%-- 객체가 비어 있는 경우 --%>
<%-- null이나 공백이나 모두 없다고 인식 --%>
<%
String name=null;
String title="";
String hp="01011111111";
request.setAttribute("name",name);
request.setAttribute("title",title);
request.setAttribute("hp",hp);

%>
<c:if test="${empty name}">
이름 객체가 생성되어있지 않습니다<br>
</c:if>

<c:if test="${empty title}">
타이틀 객체가 생성되어있지 않습니다<br>
</c:if>


<c:if test="${not empty hp}">
폰번호 객체가 생성되어있습니다<br>
</c:if>







