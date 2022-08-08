<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="tokens" value="a=10&b=20&op=*"/>
<c:forTokens var="item" items="${tokens}" delims="&">
${item}<br>
</c:forTokens>


