<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	// 클라이언트 소켓 생성
	var websocket = new WebSocket("ws://192.168.0.52:8080/wsocket");
	// 웹소켓 열시 기능
	websocket.onopen = function(message) {
		console.log('open');
	}
	// 웹소켓 닫을시 기능
	websocket.onclose = function(message) {
		console.log('close');
	}
	// 웹소켓 에러시 기능
	websocket.onerror = function(message) {
		console.log('error');
	}
	// 웹소켓 메시지 수신시 기능
	websocket.onmessage = function(message) {
		// document.querySelector('#message').innerHTML += message + "<br>";
		// 이때 message는 객체이므로 값이 [object MessageEvent]로 출력됨
		// 따라서 message 객체에서 데이터만 뽑아와야 함
		// document.querySelector('#message').innerHTML += message.data + "<br>";
		var msg = message.data.split(":");

		console.log(msg[0]);
		console.log(msg[1]);

		if (msg[0] == "00") {
			document.querySelector('#message').innerHTML += msg[1] + "<br>";
		} else if (msg[0] == "11") {
			document.querySelector('#connection').innerHTML = "접속자수 : "
					+ msg[1];
		}

	}
	// 기능 추가
	function sendmessage() {
		// alert(document.querySelector('#smsg').value);
		websocket.send(document.querySelector('#smsg').value);
		document.querySelector('#smsg').value = "";
	}
</script>
</head>
<body>
	<div id="connection"></div>
	<input type="text" id="smsg" name="smsg">
	<input type="button" value="전송" onclick="sendmessage()">
	<div id="message"
		style="width: 400px; height: 500px; background-color: lightgray;">
	</div>
</body>
</html>