<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/home" method="post">
		<lable for="name">이름:</lable>
		<input type="text" id="name" name="name"> <br>
		<lable for="hp">전화번호:</lable>
		<input type="text" id="hp" name="hp"> <br>
		<lable for="memo">메모:</lable>
		<input type="text" id="memo" name="memo"> <br>
		<input type="button" value="전송" onclick="tran()">
	</form>
	<script>
	function tran() {
		var data = {
			name : $('#name').val(),
			hp : $('#hp').val(),
			memo : $('#memo').val()
		}
		$.ajax({
			url : "/formProc",
			type : "post",
			data : JSON.stringify(data),
			contentType : "application/json;charset=utf=8",
			dataType : "json",
			success : function(data){
				alert(data.name + ":" + data.hp + ":" + data.memo);
			}
		});
	}
	
	</script>
</body>
</html>