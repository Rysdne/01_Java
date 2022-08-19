<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Speech to Text</title>
<style>
body {
	text-align: center;
}

button {
	padding: 8px;
	/*border-radius: 6px;*/
}

#message {
	color: #996600;
}

.textWrapper {
	width: 800px;
	margin: 0 auto;
	display: flex;
	flex-direction: row;
}

.textbox {
	height: 100px;
	border: 1px solid #d3d3d3;
	flex: 1;
	margin: 5px 15px;
	border-radius: 6px;
	text-align: left;
	padding: 16px;
}
</style>
<!-- <script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.js"></script> -->
<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/annyang/2.6.0/annyang.min.js"></script> -->
</head>
<body>

	<h1>Speech to Text</h1>

	<button id="speech" onclick="speech_to_text()">Start</button>
	<button id="stop" onclick="stop()">Stop</button>
	<p id="message">대기중</p>

	<div class="textWrapper">
		<div id="slicedText" class="textbox"></div>
		<div id="stackText" class="textbox"></div>
	</div>

	<script type="text/javascript">
		var message = document.querySelector("#message");
		var button = document.querySelector("#speech");
		var slicedText = document.querySelector("#slicedText");
		var stackText = document.querySelector("#stackText");
		var isRecognizing = false;
		var lastText = "";
		var stopThatShit="";

		if ('SpeechRecognition' in window) {
			// Speech recognition support. Talk to your apps!
			console.log("음성인식을 지원하는 브라우저입니다.")
		}

		try {
			var recognition = new (window.SpeechRecognition
					|| window.webkitSpeechRecognition
					|| window.mozSpeechRecognition || window.msSpeechRecognition)();
		} catch (e) {
			console.error(e);
		}

		recognition.lang = 'ko-KR'; //선택하게 해줘야 할듯 .
		recognition.interimResults = false;
		recognition.maxAlternatives = 5;
		//recognition.continuous = true;

		function speech_to_text() {

			recognition.start();
			isRecognizing = true;

			recognition.onstart = function() {
				console.log("Listening..")
				message.innerHTML = "START";
				button.innerHTML = "onStart";
				button.disabled = true;
			}

// 			recognition.onspeechend = function() {
// 				message.innerHTML = "LISTENING";
// 				button.disabled = false;
// 				button.innerHTML = "onSpeechend";
// 			}

			recognition.onresult = function(event) {

				var resText = event.results[0][0].transcript;
				lastText = lastText + resText + "<br>";
				slicedText.innerHTML = resText;
				stackText.innerHTML = lastText;
			};

			recognition.onend = function() {
				if(message.innerHTML=="STOP"){
					return;
				}else{
				message.innerHTML = "END";
				button.disabled = false;
				button.innerHTML = "onEnd";
				 
				//isRecognizing = false;
				//*음성 입력이 꺼졌다 켜지는 것을 방지함
				
				recognition.start();
				}
			}
		}

		function stop() {
			recognition.stop();
			message.innerHTML = "STOP";
			button.disabled = false;
			button.innerHTML = "stop";
			isRecognizing = false;
			
		}

		// http://localhost:8080/Wildcat_annyang.js/recorder1.jsp
	</script>
</body>
</html>