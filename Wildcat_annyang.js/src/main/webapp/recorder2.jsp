<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src='http://cdnjs.cloudflare.com/ajax/libs/annyang/2.6.0/annyang.min.js'></script>
<script>
    annyang.start({ autoRestart: false, continuous: true })
	var recognition = annyang.getSpeechRecognizer();
	var final_transcript = '';
	recognition.interimResults = true;
	recognition.onresult = function(event) {
		var interim_transcript = '';
		final_transcript = '';
		for (var i = event.resultIndex; i < event.results.length; ++i) {
			if (event.results[i].isFinal) {
				final_transcript += event.results[i][0].transcript;
				console.log("final_transcript="+final_transcript);
				//annyang.trigger(final_transcript); //If the sentence is "final" for the Web Speech API, we can try to trigger the sentence
			} else {
				interim_transcript += event.results[i][0].transcript;
				console.log("interim_transcript="+interim_transcript);
			}
		}
		document.getElementById('result').innerHTML =  '중간값:='+interim_transcript+'<br/>결과값='+final_transcript;
		console.log('interim='+interim_transcript+'|final='+final_transcript);
	};
	// http://localhost:8080/Wildcat_annyang.js/recorder2.jsp
</script>
</head>
<body class="" id="grid">
<br/><br/>
한국어 음성 처리 테스트<br/><br/>
<div id='result'>
결과가 없습니다.
</div>
</body>
</html>