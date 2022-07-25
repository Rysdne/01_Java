<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/Wildcat_Mk01/jquery-3.6.0.min.js"></script>
<script>
$(document).ready(function () {
	// 이 부분을 $('div').click(function(){}) 같은 형식으로 사용할 수도 있음
    $('#save').click(function () {
    	var id=$('#id').val();
    	var title=$('#title').val();
    	var input=$('#input').val();
    	if(id==""){
    		alert('계정 정보를 입력해주세요');
    		return;
    	}
    	if(title==""){
    		alert('타이틀을 입력해주세요');
    		return;
    	}
        $('#memo').val($('#input').html());
        $('#form').submit();
    });
	
});
</script>
</head>
<body>
	<form id="form" action="/Wildcat_Mk01/io/createProc.jsp" method="post">
		
		<span style="font-weight: bold">계정</span><br>
		<input readonly type="text" id="id" name="id" value="<%=session.getAttribute("id")%>"><button onclick='location.href="/Wildcat_Mk01/login/logout.jsp"'>로그아웃</button><br>

		<span style="font-weight: bold">폴더</span><br>
		<input type="text" id="subFolderName" name="subFolderName"><br>
		
		<span style="font-weight: bold">타이틀</span><br>
		<input type="text" id="title" name="title"><br>
		
		<span style="font-weight: bold">메모</span><br>
		<div contentEditable="true" id="input" style="width: 400px; height: 600px; border: 1px solid black; overflow: auto;"></div>
		<input type="hidden" id="memo" name="memo">
		<input type="button" id="save" name="save" value="저장">
	</form>
</body>
</html>