<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(function() {

		// AJAX 적용

		// 		// 1) load 함수 사용
		// 		// 로드를 하면 내부 데이터가 삭제됨
		// 		// 아래에 div를 하나 더 만들어서 변경시킴
		// 		$('#add').click(function(){
		// 			// $('div').load("test.txt");		
		// 			$('div').load('/select/list.jsp');
		// 		})
		// 		// 단점은 초기 1번만 사용할 수 있음

		// 2) .ajax 함수 사용
		$('#list').click(function() {
			$.ajax({
				url : "/select/list.jsp",
				type : "get",
				dataType : "text",
				success : function(result) {
					$('div').append(result);
				}

			});
		});

		$('#findone').click(function() {
			$.ajax({
				url : "/select/findOne.jsp",
				type : "get",
				dataType : "text",
				data : {"idx":"1"},
				success : function(result) {
					$('div').append(result);
				}

			});
		});

	});
</script>
<title>Insert title here</title>
</head>
<body>

	<button id="list">보기</button><br>
	<button id="findone">상세보기</button><br>
	<div></div>
</body>
</html>