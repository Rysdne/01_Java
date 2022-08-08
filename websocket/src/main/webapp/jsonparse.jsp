<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	//const json = '{"result":true, "count":42}';
	const json = '{"one":10, "two":20, "three":30, "four":40}';
	const obj = JSON.parse(json);
	//console.log(obj.count);
	//console.log(obj.result);
	
	console.log(obj.one);
	console.log(obj.two);
	console.log(obj.three);
	console.log(obj.four);
	
	// 데이터에 \가 붙어서 나옴
	// \" : 쌍따옴표를 
	// 보낼 때는 이런 형태로 보내야 함
	const str=JSON.stringify(json);
	console.log(str);
	
	// 데이터에 \가 붙지 않은 채로 나옴
	const str1=JSON.stringify(obj);
	console.log(str1);
</script>
</head>
<body>
</body>
</html>