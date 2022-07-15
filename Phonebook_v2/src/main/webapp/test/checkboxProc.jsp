<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String[] checks=request.getParameterValues("checkboxes");

// checks 변수에 값이 있는 경우 a에 담는다
for(String a:checks){
	// a를 출력한다
	out.print(a+"<br>");
}

%>