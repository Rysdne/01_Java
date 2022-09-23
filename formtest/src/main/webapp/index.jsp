<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function check(){
	// alert(document.getElementById("msg").value);
	if (document.getElementById("msg").value=="") {
		alert("null");
		codument.getElementById("msg").focus();
		return null;
	}
	// 1. 폼 배열에 저장하는 방법
	// 폼은 스크립트 자체에서 관리하기 때문에 form 개수에 따라서 자동 저장됨
	// 생성된 순서에 따라서 0부터 저장됨
	// document.forms[0].submit();
	
	// 2. 이름으로 동작
	// document.inputForm.submit();
	
	// 3. ID로 동작
	document.getElementById("Form").submit();
	
}

</script>
</head>
<body>
	<form action="proc.jsp" id = "Form" name="inputForm">
		<input type="text" id="msg" name="msg">
		<br>
		<input type="button" value="전송" onclick="check()">
	</form>
	<%
	// 포워드로 값 넘기는 법 
	//request.setAttribute("test","test");
	//request.getRequestDispatcher("proc.jsp").forward(request,response);
	%>
	
</body>
</html>