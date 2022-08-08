<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 한글깨짐 방지 -->
<% request.setCharacterEncoding("utf-8"); %>

<%
//1)다른페이지의 내용을 전달 받음
String id=request.getParameter("id"); 
String password=request.getParameter("password");
%>

<%@ page import="java.sql.*" %>
<%
//2)데이터베이스 접속관련 사항만 기재
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection conn=
DriverManager.getConnection
("jdbc:oracle:thin:@localhost:1521:xe","test","1111");
%>

<%
//3)처리할 sql문 작성
String sql="select * from member where id=? and password=?";
PreparedStatement pstmt=conn.prepareStatement(sql);
pstmt.setString(1,id);
pstmt.setString(2,password);

ResultSet rs=pstmt.executeQuery();
%>

<%
//4)결과에 대한 처리
if(rs.next()){
	session.setAttribute("id",id);
%>
<script>
alert("로그인되셨습니다.");
location.href="/index.jsp";
</script>
<%
}else{
%>
<script>
alert("로그인에 실패하셨습니다.")
window.history.go(-1);
</script>
<%
}
%>
</body>
</html>