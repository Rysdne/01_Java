<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/Wildcat_Mk01/jquery-3.6.0.min.js"></script>
<script>
	$(function() {
		var regEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/;
		// 이메일 주소 시작은 숫자나 알파벳(소/대문자)로 시작
		// 이메일 첫째자리 뒤에는 -_.을 포함하여 들어올 수 있음
		// 도메인 주소 전에는 @가 들어와야 함
		// .이 최소한 하나는 있어야 하며 마지막 마디는 2-3자리여야 함

		$('#findPw').click(function() {
			var id = $('#id').val();
			if (id == "" || id > 20) {
				alert('계정 정보를 확인해주세요');
				return;
			}
			var email = $('#email').val();
			if (email == "" || email > 40 || regEmail.test(email) === false) {
				alert('이메일 정보를 확인해주세요');
				return;
			}
			$('#findPwForm').submit();
		})
	})
</script>
</head>
<body>
	<form id="findPwForm" action="findPwProc.jsp" method="post">
		<span style="font-weight: bold">ID : </span>
		<input type="text" id="id" name="id"><br>
		<span style="font-weight: bold">E-mail : </span>
		<input type="text" id="email" name="email"><br>
		<input type="button" id="findPw" name="findPw" value="검색">
	</form>
	<a href="#">회원가입</a> | 
	<a href="findId.jsp">아이디 찾기</a>
</body>
</html>