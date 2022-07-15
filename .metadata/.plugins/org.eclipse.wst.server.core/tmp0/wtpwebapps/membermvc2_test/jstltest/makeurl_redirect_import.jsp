<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- http://localhost:8080/member/findOne?idx=9&page=3 --%>
<c:url var="makeurl" value="http://localhost:8080/member/findOne">
<c:param name="idx" value="9"/>
<c:param name="page" value="3"/>
</c:url>
${makeurl}
<%-- <c:redirect url="${makeurl}"/> --%>

<%-- 페이지 내부에 포함시키기 --%>

<h1>My page</h1>
<textarea cols="200" rows="10">
<c:import url="${makeurl}"/>
</textarea>