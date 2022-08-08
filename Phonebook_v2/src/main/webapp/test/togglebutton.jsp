<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(function() {

		// 실행되는지 확인
		// alert('test');
		// 버튼을 클릭했을 때

		// 	$('button').click(function(){
		// 		// text 값을 가져와라
		// 		// alert($(this).text());
		// 		if($(this).text()=='ON');{
		// 			$(this).html('OFF');
		// 		}else{
		// 			$(this).html('ON');
		// 		};
		// 	});
		var state = 0;
		var data = [ 'ZERO', 'ONE', 'TWO', 'THREE' ]
		$('button').click(function() {
			// alert('test');
			state++;
			// state%4 : state값을 4로 나눴을 때의 나머지값
			// 결국 0~3까지밖에 안나옴
			$(this).html(data[state%4]);
			
// 			if((state%4)==0}){
// 				$(this).html(data[0]);
// 			}else if((state%4)==1}){
// 				$(this).html(data[1]);
// 			}else if((state%4)==2}){
// 				$(this).html(data[2]);
// 			}else if((state%4)==3}){
// 				$(this).html(data[3]);
// 			}
		});
		
		
		
		
		
		
	});
</script>
</head>
<body>
	<!-- 
	<button>OFF</button>
	 -->
	<button>ZERO</button>
</body>
</html>