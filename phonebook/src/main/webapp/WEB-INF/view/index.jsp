<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#wrap{
width:300px;
}
#content {
	width: 300px;
	height: 15vh;
	border: 1px solid gray;
	float: left;
}

#listBox {
	width: 300px;
	height: 60vh;
	border: 1px solid blue;
	overflow: scroll;
}

#inputBox {
	width: 300px;
	height: 15vh;
	border: 1px solid black
}

</style>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	function getlist() {
		$.ajax({
			url : "/list",
			success : function(result) {
				$("#list").html(result);
			}
		});
	}

	function search(search) {
		$.ajax({
			url : "/find?search=" + search,
			success : function(result) {
				$("#list").html(result);
			}
		});
	};

	function insert() {
		var name = document.getElementById("name").value
		var hp = document.getElementById("hp").value
		var memo = document.getElementById("memo").value
		$.ajax({
			url : "/insert",
			type : "post",
			dataType : "text",
			data : {
				"name" : name,
				"hp" : hp,
				"memo" : memo
			},
			success : function(result) {
				$("#list").html(result);
			}
		});

		document.querySelector("#name").value = "";
		document.querySelector("#hp").value = "";
		document.querySelector("#memo").value = "";
	}
	
	function getPhonebook(idx) {
		console.log(idx);
		$.ajax({
			url : "/findOne?idx=" + idx,
			success : function(result) {
				$("#content").html(result);
			}
		});
	};
	
	function deletePhonebook(idx) {
		alert("삭제되었습니다");
		$.ajax({
			url : "/delete?idx=" + idx,
			success : function(result) {
				$("#list").html(result);
			}
		});
		document.querySelector("#findResult").innerHTML = "";
	};

	function updateForm(idx) {
		$.ajax({
			url : "/updateForm?idx=" + idx,
			success : function(result) {
				$("#content").html(result);
			}
		});
	};

	function updateProc(idx) {
		var name = $("#updName").val();
		var hp = $("#updHp").val();
		var memo = $("#updMemo").val();
		$.ajax({
			url : "/updateProc?idx=" + idx + "&name=" + name + "&hp=" + hp
					+ "&memo=" + memo,
			success : function(result) {
				$("#list").html(result);
			}
		});
		$.ajax({
			url : "/findOne?idx=" + idx,
			success : function(result) {
				$("#content").html(result);
			}
		});

	};
</script>

</head>
<body onload="getlist()">
	<div id="wrap">
		<div id="content">선택 결과</div>
		<div id="listBox">
			<div id="search">
				검색<input type="text" name="search" onkeyup="search(this.value)">
			</div>
			<div id="list">리스트</div>
		</div>
		<div id="inputBox">
			입력
			<form action="/insertProc" method="post">
				<lable for="name">이름:</lable>
				<input type="text" id="name" name="name"> <br>
				<lable for="hp">전화번호:</lable>
				<input type="text" id="hp" name="hp"> <br>
				<lable for="memo">메모:</lable>
				<input type="text" id="memo" name="memo"> <br>
			</form>
			<input type="button" value="전화번호입력" onclick="insert()">
		</div>

	</div>
</body>
</html>