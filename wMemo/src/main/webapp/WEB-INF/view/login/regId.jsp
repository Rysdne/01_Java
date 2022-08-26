<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link href="/wMemo/css/content/style.css" type="text/css" rel="stylesheet"/>
<script>
$(function() {
	var regEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/;
	// 이메일 주소 시작은 숫자나 알파벳(소/대문자)로 시작
	// 이메일 첫째자리 뒤에는 -_.을 포함하여 들어올 수 있음
	// 도메인 주소 전에는 @가 들어와야 함
	// .이 최소한 하나는 있어야 하며 마지막 마디는 2-3자리여야 함

	$('#create').click(function() {
		var id = $('#id').val();
		var password = $('#password').val();
		if (id == "" || id > 20 || password == "" || password > 20) {
			alert('계정 정보를 확인해주세요');
			return;
		}
		var email = $('#email').val();
		if (email == "" || email > 40 || regEmail.test(email) === false) {
			alert('이메일 정보를 확인해주세요');
			return;
		}
		$('#regIdForm').submit();
	})
})
</script>
</script>
<div id="content">
	<aside>
		<input type="hidden" id="aside_sideMenu_cursor" value="">
		<div>
			<div id="aside_sideMenu">
				<ul>
					<li>
						<div id="bookmark" class="aside_sideMenu_butt_disabled">
							<i class="fa-solid fa-book-bookmark"></i>
						</div>
					</li>
					<li>
						<div id="microphone" class="aside_sideMenu_butt_disabled">
							<i class="fa-solid fa-microphone"></i>
						</div>
					</li>
					<li>
						<div id="language" class="aside_sideMenu_butt_disabled">
							<i class="fa-solid fa-language"></i>
						</div>
					</li>
					<li>
						<div id="paste" class="aside_sideMenu_butt_disabled">
							<i class="fa-solid fa-paste"></i>
						</div>
					</li>
				</ul>
			</div>
			<div id="aside_slide">
				<div id="aside_folder_option">옵션</div>
				<div class="aside_folder">폴더메뉴</div>
			</div>
		</div>
	</aside>
	<main>
		<div id="main_loginCover_back"></div>
		<div id="main_memo">
			<div id="main_memoHeader">
				<ul>
					<li>공지</li>
					<li>새 메모</li>
					<li>수정</li>
					<li>삭제</li>
				</ul>
			</div>
			<div id="main_memoBody">
				<div id="form_frame">
					<input readonly type="text" id="title_disabled" name="title_disabled" placeholder="로그인">
					<div id="postit_box">
						<div id="postit_login">
							<form id="regIdForm" action="/wMemo/login/regIdProc" method="post">
								<span style="font-weight: bold">ID : </span><br>
								<input type="text" id="id" name="id" placeholder="ID"><br>
								<span style="font-weight: bold">PW : </span><br>
								<input type="password" id="password" name="password" placeholder="Password"><br>
								<span style="font-weight: bold">Email : </span><br>
								<input type="text" id="email" name="email" placeholder="Email Address"><br>
								<input type="button" id="create" name="create" value="계정 생성">
							</form>
							<a href="/wMemo/login/findId">아이디 찾기</a> | <a href="/wMemo/login/findPw">비밀번호
								찾기</a><br>
							<button onclick="location.href='/wMemo/'">메인 화면</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</main>
</div>