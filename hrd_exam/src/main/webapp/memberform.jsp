<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%
request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
* {
	margin: 0;
	padding: 0;
}

li {
	list-style: none;
}

#wrap {
	width: 100%;
	height: 100vh;
	background-color: gray;
}

header {
	width: 100%;
	height: 10vh;
	background-color: slateblue;
	color: white;
	font-weight: bold;
	font-size: 20pt;
	display: flex;
	justify-content: center;
	align-items: center;
}

nav {
	width: 100%;
	height: 5vh;
	background-color: skyblue;
}

nav ul {
	display: flex;
	width: 100%;
}

nav ul li {
	height: 5vh;
	flex: 1;
	display: flex;
	font-weight: bold;
	color: white;
	justify-content: center;
	align-items: center;
}

section {
	width: 100%;
	height: 75vh;
	background-color: lightgray;
	width: 100%;
}

table {
	margin: 0 auto;
}

footer {
	width: 100%;
	height: 10vh;
	background-color: slateblue;
	display: flex;
	color: white;
	justify-content: center;
	align-items: center;
	color: white;
}
</style>
<script>
	function reg() {
		
		// document.quertySelector("#custname").value 사용 가능
		var custname = document.getElementById("custname");
		var phone = document.getElementById("phone");
		var address = document.getElementById("address");
		var joindate = document.getElementById("joindate");
		var grade = document.getElementById("grade");
		var city = document.getElementById("city");
		if(custname.value==""){
			alert('회원성명이 입력되지 않았습니다.');
			custname.focus();
			return;
		}
		if(phone.value==""){
			alert('회원전화가 입력되지 않았습니다.');
			phone.focus();
			return;
		}
		if(address.value==""){
			alert('회원주소가 입력되지 않았습니다.');
			address.focus();
			return;
		}
		if(joindate.value==""){
			alert('가입일자가 입력되지 않았습니다.');
			joindate.focus();
			return;
		}
		if(grade.value==""){
			alert('고객등급이 입력되지 않았습니다.');
			grade.focus();
			return;
		}
		if(city.value==""){
			alert('도시코드가 입력되지 않았습니다.');
			city.focus();
			return;
		}
		form.submit();
	}
</script>
</head>
<body>
	<%
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");

	String sql = "select * from member_tbl_02 where custno = (select max(custno) from member_tbl_02)";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	ResultSet rs = pstmt.executeQuery();

	int max = 0;

	if (rs.next()) {
		max = rs.getInt("custno") + 1;
	}
	%>
	<div id="wrap">
		<header>쇼핑몰 회원관리 ver 1.0</header>
		<nav>
			<div style="width: 50%; display: flex;">
				<ul>
					<li>회원등록</li>
					<li>회원목록조회/수정</li>
					<li>회원대출조회</li>
					<li>홈으로.</li>
				</ul>
			</div>
		</nav>
		<section>
			<br>
			<h3 style="text-align: center;">홈쇼핑 회원등록</h3>
			<br>
			<form id="form" action="memberformProc.jsp" method="post">
				<table border="1">
					<tr>
						<th>회원번호(자동발생)</th>
						<td><input id="custno" readonly type="text"
							style="width: 100px;" value="<%=max%>"></td>
					</tr>
					<tr>
						<th>회원성명</th>
						<td><input type="text" id="custname" name="custname"
							style="width: 100px;"></td>
					</tr>
					<tr>
						<th>회원전화</th>
						<td><input type="text" id="phone" name="phone" type="text"
							style="width: 150px;"></td>
					</tr>
					<tr>
						<th>회원주소</th>
						<td><input type="text" id="address" name="address" type="text"
							style="width: 200px;"></td>
					</tr>
					<tr>
						<th>가입일자</th>
						<td><input type="text" id="joindate" name="joindate" type="text"
							style="width: 100px;"></td>
					</tr>
					<tr>
						<th>고객등급[A:VIP,B:일반,C:직원]</th>
						<td><input type="text" id="grade" name="grade" type="text"
							style="width: 100px;"></td>
					</tr>
					<tr>
						<th>도시코드</th>
						<td><input type="number" id="city" name="city" type="text"
							style="width: 100px;"></td>
					</tr>
					<tr>
						<td colspan="2">
							<div style="padding-left: 185px;">
								<input type="button" value="등록" onclick="reg()">
								<button>조회</button>
							</div>
						</td>
					</tr>
				</table>
			</form>
		</section>
		<footer> HRDKOREA Copyrightⓒ2016 All rights reserved. Human
			Resources Development Service of Korea. </footer>
	</div>
</body>
</html>