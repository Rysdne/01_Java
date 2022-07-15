<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String message=request.getParameter("message");
%>
<!-- 1) 변수에서 출력 -->
<%=message%><br>

<!-- 2) EL Tag -->
<!-- jsp 내의 일반변수는 받아올 수 없음 -->
<!-- 2-1) action으로 전달된 파라미터 -->
${param.message}<br>
<!-- 2-2) 서블릿의 request에 저장하여 일반객체화 -->
<%
request.setAttribute("message", message+" attri");
%>
${message}<br>
<!-- 서블릿 영역까지 표시 -->
${requestScope.message}<br>

<!-- 3) 걍 변수 가져옴 -->
<jsp:expression>message</jsp:expression><br>