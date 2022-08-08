<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
</head>
<body>
<%
if(session.getAttribute("id")!=null){
	response.sendRedirect("/index.jsp");
}
%>

<div class="container">
<form action="/login/loginProc.jsp" method="post">
    <div class="form-group">
      <label for="id">ID:</label>
      <input type="text" class="form-control" id="id" name="id" placeholder="아이디">
    </div>
    <div class="form-group">
      <label for="password">Password:</label>
      <input type="password" class="form-control" id="password" name="password"placeholder="패스워드">
    </div>
    <a href="/member/createmember.html">회원가입</a>
    /<a href="#">아이디</a>
    <a href="#">비밀번호찾기</a>
    <button type="submit" class="btn btn-primary">로그인</button>
  </form>
  </div>
</body>
</html>