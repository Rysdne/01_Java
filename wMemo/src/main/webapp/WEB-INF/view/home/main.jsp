<%@ page import="java.time.format.DateTimeFormatter"%>
<%@ page import="java.time.LocalDate"%>
<%@ page import="javax.naming.spi.DirStateFactory.Result"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 기본 context에 wMemo가 설정되어있으므로 리소스 사용 시엔 앞에 기본 context를 붙여줘야 함 -->
<link href="/wMemo/css/content/style.css" type="text/css"
	rel="stylesheet">
<script>
	$(function() {
		var uId = $('#id').val();
		var now = new Date();
		var splitYear = now.getFullYear();
		var splitMonth = ("0" + (now.getMonth() + 1)).slice(-2);
		var currentMonth = splitYear + "-" + splitMonth;
		$('.aside_sideMenu_butt').click(function() {
			var currId = $(this).attr('id');
			if(currId=="bookmark"){
				$.ajax({
					url : "/wMemo/list/listOption",
					success : function(result) {
						$('#aside_option').html(result);
					}
				});
				$.ajax({
					url : "/wMemo/list/listAll",
					type : "post",
					dataType : "text",
					data : {"id":uId},
					success : function(result) {
						$('#aside_box').html(result);
					}
				});
			}
			if ($('#aside_sideMenu_cursor').val() == "") {
				$('#aside_sideMenu_cursor').val(currId);
				$('aside').toggleClass('aside_open');

			} else if ($('#aside_sideMenu_cursor').val() != currId) {
				$('#aside_sideMenu_cursor').val(currId);

			} else {
				$('#aside_sideMenu_cursor').val("");
				$('aside').toggleClass('aside_open');
			}
		});
	});
</script>
<div id="content">
	<aside>
		<input type="hidden" id="aside_sideMenu_cursor" value="">
		<div>
			<div id="aside_sideMenu">
				<ul>
					<li>
						<div id="bookmark" class="aside_sideMenu_butt">
							<i class="fa-solid fa-book-bookmark"></i>
						</div>
					</li>
					<li>
						<div id="microphone" class="aside_sideMenu_butt">
							<i class="fa-solid fa-microphone"></i>
						</div>
					</li>
					<li>
						<div id="language" class="aside_sideMenu_butt">
							<i class="fa-solid fa-language"></i>
						</div>
					</li>
					<li>
						<div id="paste" class="aside_sideMenu_butt">
							<i class="fa-solid fa-paste"></i>
						</div>
					</li>
				</ul>
			</div>
			<div id="aside_slide">
				<div id="aside_option">옵션</div>
				<div id="aside_box">폴더메뉴</div>
			</div>
		</div>
	</aside>
	<main>
		<div id="main_loginCover_back"></div>
		<div id="main_memo">
			<div id="main_memoHeader">
				<ul>
					<li onclick="location.href='/wMemo/'">공지</li>
					<li onclick="location.href='/wMemo/memo/create'">새 메모</li>
					<li>수정</li>
					<li>삭제</li>
				</ul>
			</div>
			<div id="main_memoBody">
				<form id="form" action="/wMemo/memo/createProc" method="post">
					<input type="hidden" id="id" name="id" value="${sessionScope.id}">
					<input type="text" id="title_disabled" name="title_disabled" placeholder="공지사항">
					<div id="input" style="font-size:12pt;">
					<div>=======================================================</div><div># wMemo (구 Wildcat_Mk01)</div><div>=======================================================</div><div># 버전 관리</div><div>&nbsp;@ v0.53 - 20220823 (*wMemo)</div><div>&nbsp; - Spring MVC 적용 중</div><div>&nbsp; - 로그인 관련 기능 구현</div><div><span style="white-space:pre">	</span>- 회원 등록, 아이디 찾기, 패스워드 찾기, 세션 로그인, 로그아웃 기능 구현</div><div><span style="white-space:pre">	</span>* 로그인 후 패스워드, 이메일 변경 기능 미구현(X)</div><div><span style="white-space:pre">	</span>* 계정 삭제 기능은 '회원 탈퇴' 기능으로 대체하며 추후 추가 예정&nbsp;</div><div>&nbsp; - AJAX 기능 구현 중</div><div>&nbsp; <span style="white-space:pre">	</span>- 세션 계정을 받아와 해당 계정이 만든 메모 리스트 출력기능 구현</div><div>&nbsp; <span style="white-space:pre">	</span>* 추후 폴더 별로 정리하는 형태로 발전시켜야 할 듯</div><div>---------------------------------------------------------------------</div><div>&nbsp;@ v0.52 - 20220816 (*wMemo)</div><div>&nbsp; - Spring MVC 적용 중</div><div>&nbsp; - 현재 View 측면만 적용</div><div>&nbsp; &nbsp; - css, img같은 리소스 부분은 폴더 앞에 기본 context를 같이 적어줘야 함</div><div>&nbsp; <span style="white-space:pre">	</span> ㄴ&gt; '/wMemo/css/header/style.css'</div><div>---------------------------------------------------------------------</div><div>&nbsp;@ v0.51 - 20220812 (*Mk01 프로젝트)</div><div>&nbsp; - 계정 정보에 이메일 추가</div><div>&nbsp; - 이메일을 통한 아이디 찾기 기능 구현</div><div>&nbsp; - 아이디와 이메일을 통한 패스워드 변경 기능 구현</div><div>&nbsp; - 로그인 후 패스워드, 이메일 변경 기능 구현</div><div>---------------------------------------------------------------------</div><div>&nbsp;@ v0.5 - 20220808 (*annyang.js 프로젝트)</div><div>&nbsp; - 음성인식 기능 구현</div><div><span style="white-space:pre">	</span>- 연속적인 음성입력에 대한 텍스트 저장 기능 구현</div><div>---------------------------------------------------------------------</div><div>&nbsp;@ v0.43 - 20220724 (*test 프로젝트)</div><div>&nbsp; - MVCv2 적용 중</div><div><span style="white-space:pre">	</span>- 메인 화면 Controller 및 View 구현</div><div><span style="white-space:pre">	</span>- 사이드메뉴 토글 구현</div><div>---------------------------------------------------------------------</div><div>&nbsp;@ v0.42 - 20220715</div><div>&nbsp; - 로그인 계정 기반 파일 관리 구현</div><div>&nbsp; - 하위 폴더 관리 기능 구현</div><div>&nbsp; &nbsp; ㄴ&gt; DB 테이블에 subfolder 컬럼 추가</div><div>&nbsp; - 파일 이름을 idx로 통합</div><div>&nbsp; &nbsp; ㄴ&gt; &lt;idx&gt;_&lt;title&gt; -&gt; &lt;idx&gt;&nbsp;</div><div>---------------------------------------------------------------------</div><div>&nbsp;@ v0.41 - 20220714</div><div>&nbsp; - txt 형태에서 확장자 없는 단순 파일로 구현</div><div>&nbsp; &nbsp; ㄴ&gt; &lt;idx&gt;_&lt;title&gt;.txt -&gt; &lt;idx&gt;_&lt;title&gt;</div><div>&nbsp; - overwrite에 계정 및 타이틀 공란 제한 jQuery 명령어 추가</div><div>&nbsp; - 로그인 및 로그아웃 기능 추가</div><div>---------------------------------------------------------------------</div><div>&nbsp;@ v0.3 - 20220701</div><div>&nbsp; - 초기 구현(프로토타입)</div><div>=======================================================</div>
					</div>
				</form>
			</div>
		</div>
	</main>
</div>