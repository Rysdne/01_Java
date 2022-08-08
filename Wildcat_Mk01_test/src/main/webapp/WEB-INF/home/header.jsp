<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="/test/css/header/style.css" type="text/css" rel="stylesheet">

<header>
	<div id="header_profile">
		<img src="/test/img/profile.png" id="header_profileImg" alt="프로필">
		<h1 id="header_profile_sayHello">
		${sessionScope.id}
		</h1>
		<h5 id="header_profile_logout">
			<a href="#">로그아웃</a>
		</h5>
	</div>
	<div id="header_menu">
		<i class="fa-solid fa-bars"></i>
	</div>
</header>
