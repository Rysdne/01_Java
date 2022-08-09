<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="annyang.js"></script>
		<script src="jquery-3.6.0.min.js"></script>
		<script>
			function start() {
				console.log("start");

				var recognition = annyang.getSpeechRecognizer();
				recognition.interimResults = true;
				var interim_transcript = "";
				var final_transcript = "";
				



			}



	// http://localhost:8080/Wildcat_annyang.js/recorder3.jsp
		</script>
	</head>

	<body>
		<div id="interim" style="width: 600px; height: 100px;"></div>
		<div id="result" style="width: 600px; height: 300px;"></div>
		<button id="start" onclick="start()">녹음</button>
		<button id="pause" onclick="pause()">정지</button>
	</body>

	</html>