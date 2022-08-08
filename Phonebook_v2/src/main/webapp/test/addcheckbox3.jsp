<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
tbody tr:hover{background-color:gray;}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(function() {
		// alert('test');
		$('#mode').click(function() {
			if ($(this).text() == '관리자모드') {
				$(this).html('사용자모드');
				// 첫 열 생성, checkbox 만들어져야 함
				// append : 뒤에 추가 / prepend : 앞에 추가
				// $('thead tr').prepend('<th>삭제</th>');
				// $('tbody tr').prepend('<td><input type="checkbox"></td>');
				// 체크박스 삭제를 위해 클래스명 기입 
				$('thead tr').prepend('<th class="checkboxs"><button id="allcheck">all</button></th>');
				$('tbody tr').prepend('<td class="checkboxs"><input type="checkbox" name="delchecks"onclick="event.cancelBubble=true"></td>');
				
			} else {
				$(this).html('관리자모드');
				$('.checkboxs').remove();
			}});
		
		// 코드 관리적인 측면에서 봤을 때 코드를 기능적인 면으로 분류해놓는게 좋음
		$('#allcheck').click(function() {
			// alert('test');
			if($(this).text()=='전체선택'){
				$('input:checkbox').prop('checked',true);
				$(this).html('전체해제');
			}else{
				$('input:checkbox').prop('checked',false);
				$(this).html('전체선택');
			}});
		$('tbody tr').click(function(){
			alert('test');
		});
		// 문제사항 : 관리자모드에서 checkbox를 체크할 때 이벤트 발생 문제
		// onclick="event.cancelBubble=true"
		// 클릭 이벤트가 발생할 때 이벤트를 취소하는 기능
		// 위의 delchecks에 넣기
		// 결국 클릭했을 때 발생하는 이벤트를 없애서 체크박스를 변경하기 쉽도록 함
		
		
	});
</script>
</head>
<body>
	<button id="allcheck">전체선택</button>
	<button id="mode">관리자모드</button>
	
	<form action="addcheckbox2proc.jsp" method="post">
	<!-- 위에 name="delchecks"를 체크박스에 미리 부여함 -->
	<table border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>전화번호</th>
				<th>메모</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>1<input type="hidden" name="ids" value="1"></td>
				<td>굔욷1</td>
				<td>01011111111</td>
				<td>없음</td>
			</tr>
			<tr>
				<td>2<input type="hidden" name="ids" value="2"></td>
				<td>굔욷2</td>
				<td>01011111111</td>
				<td>없음</td>
			</tr>
			<tr>
				<td>3<input type="hidden" name="ids" value="3"></td>
				<td>굔욷3</td>
				<td>01011111111</td>
				<td>없음</td>
			</tr>
			<tr>
				<td>4<input type="hidden" name="ids" value="4"></td>
				<td>굔욷4</td>
				<td>01011111111</td>
				<td>없음</td>
			</tr>
			<tr>
				<td>5<input type="hidden" name="ids" value="5"></td>
				<td>굔욷5</td>
				<td>01011111111</td>
				<td>없음</td>
			</tr>
			<tr>
				<td>6<input type="hidden" name="ids" value="6"></td>
				<td>굔욷6</td>
				<td>01011111111</td>
				<td>없음</td>
			</tr>
		</tbody>
	</table>
	<input type="submit" value="삭제전송">
</form>
</body>
</html>