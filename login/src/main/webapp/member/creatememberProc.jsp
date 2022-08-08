<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!-- try catch()문이 있는 페이지는 errorPage를 지원안함 -->
<%@ page errorPage="/error/error.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 어떤 처리를 해야하는가? 데이터베이스 입력 -->
<!-- 전달된 값을 받고 데이터베이스 입력처리 -->
<%

String id=null;
String password=null;
Connection conn=null;
PreparedStatement pstmt=null;

try{
id=request.getParameter("id");
password=request.getParameter("password");

Class.forName("oracle.jdbc.driver.OracleDriver");
conn=
DriverManager.getConnection
("jdbc:oracle:thin:@localhost:1521:xe","test","1111");
System.out.println(conn);
//String sql="insert into member values(?,?)";
//필드가 생성되고 시퀸스를 이용하여 sql변경

//데이터베이스에 필드가 추가되었으므로 시퀸스는 가장 뒤에 위치
//데이터베이스 필드를 변경해야 함.
//테이블 복사
//create table member_back as select idx,id,password from member;
//alter table member_back rename to member;
String sql="insert into member values(member_idx_seq.nextval,?,?)";

pstmt=conn.prepareStatement(sql);
pstmt.setString(1,id);
pstmt.setString(2,password);

int result=pstmt.executeUpdate();

if(result>0){
//response.sendRedirect("sucess.jsp");
//페이지가 줄어듦, script는 html코드이므로 스크립트릿을 닫아줘야함
%>
<script>
alert("회원가입이 되셨습니다.");
location.href="/login/login.jsp";
</script>
<%
}else{
//response.sendRedirect("fail.jsp");
%>
<script>
alert("회원가입에 실패했습니다.다시 확인하세요.")
location.href="/member/createmember.html";
</script>
<%
}


}catch(Exception e){
	e.printStackTrace();
}finally{
	pstmt.close();
	conn.close();
}
%>
</body>
</html>