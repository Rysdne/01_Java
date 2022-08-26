<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	width : 100%;
	height: 75vh;
	background-color: lightgray;
	width: 100%;
}

footer {
	width: 100%;
	height: 10vh;
	background-color: slateblue;
	display: flex; color : white;
	justify-content: center;
	align-items: center;
	color: white;
}
</style>
</head>
<body>
	<div id="wrap">
		<header>쇼핑몰 회원관리 ver 1.0</header>
		<nav>
			<div style="width: 50%; display: flex;">
				<ul>
					<li onclick="location.href='memberform.jsp'">회원등록</li>
					<li>회원목록조회/수정</li>
					<li>회원대출조회</li>
					<li>홈으로.</li>
				</ul>
			</div>
		</nav>
		<section>
			<br>
			<h3 style="text-align: center;">쇼핑몰 회원관리 프로그램</h3>
			<br> 쇼핑몰 회원정보와 회원매출정보 데이터베이스를 구축하고 회원관리 프로그램을 작성하는 프로그램이다.<br>
			프로그램 작성 순서<br> 1. 회원정보 테이블을 생성한다.<br> 2. 매출정보 테이블을 생성한다.<br>
			3. 회원정보, 매출정보 테이블에 제시된 문제지의 참조데이터를 추가 생성한다.<br> 4. 회원정보 입력
			화면프로그램을 작성한다.<br> 5. 회원정보 조회 프로그램을 작성한다.<br> 6. 회원매출정보 조회
			프로그램을 작성한다.<br>
		</section>
		<footer> HRDKOREA Copyrightⓒ2016 All rights reserved. Human
			Resources Development Service of Korea. </footer>
	</div>
</body>
</html>