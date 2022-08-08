<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	var websocket = new WebSocket("ws://192.168.0.53:8080/datawsocket")
	websocket.onopen = function(message) {
		console.log('open');
	}
	websocket.onclose = function(message) {
		console.log('close');
	}
	websocket.onerror = function(message) {
		console.log('error');
	}
	websocket.onmessage = function(message) {
		console.log(message.data);
		var data = message.data.split(":");
		// data.forEach(element => console.log(element));
		document.querySelector('#one').innerHTML = data[0];
		document.querySelector('#two').innerHTML = data[1];
		document.querySelector('#three').innerHTML = data[2];
		document.querySelector('#four').innerHTML = data[3];

	}
	function send(num) {
		// 비어있으면 에러 뜸
		// websocket.send(17);
		websocket.send(num);
	}
</script>

<style>
button {
	width: 100px;
	height: 50px;
	background-color: orange;
	border-radius: 10px;
}
</style>
</head>
<body>
	<button onclick="send(1)">1</button>
	<button onclick="send(2)">2</button>
	<button onclick="send(3)">3</button>
	<button onclick="send(4)">4</button>
	<p>
	<button id="one"></button>
	<button id="two"></button>
	<button id="three"></button>
	<button id="four"></button>
</body>
</html>