<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.LinkedList"%>
<%@ page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
// el태그로 사용할 수 있도록 등록하는 명령어
pageContext.setAttribute("jumsu", new int[] { 100, 90, 80, 70 });

// LinkedList<>()와 ArrayList()는 비슷한 기능
List<String> list = new LinkedList<>();
list.add("사과");
list.add("배");
list.add("오렌지");
//el태그로 사용할 수 있도록 등록하는 명령어
pageContext.setAttribute("list", list);

// key값으로 접근하는 배열
Map<String, String> map=new HashMap<>();
map.put("naver","http://naver.com");
map.put("daum","http://daum.net");
map.put("google","http://google.com");
//el태그로 사용할 수 있도록 등록하는 명령어
pageContext.setAttribute("map", map);

%>

${jumsu[0]}<br>
${list[0]}<br>
${map["daum"]}<br>