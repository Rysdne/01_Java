<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.*"%>
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
<%
String idx=request.getParameter("idx");
String id=request.getParameter("id");
String title=request.getParameter("title");

// 기존 타이틀을 초기화해야 함
String preTitle=title;
// 미리 받아놓기

System.out.println(idx);

String folderPath = application.getRealPath("/WEB-INF/" + id);
// 저장 경로 : C:\Users\Rysdne\Desktop\Rysdne\Document\01. Java\work\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\Wildcat_Mk01\WEB-INF
String fileName = idx + "_" + title;
String filePath = folderPath + "/" + fileName;

// System.out.println(filePath);

// 이전 메모를 저장할 변수 선언
String loaded="";
//  
String line;
// 파일 내용 불러오기
BufferedReader br = new BufferedReader(new FileReader(new File(filePath)));
while((line=br.readLine())!=null) {
	// System.out.println(line);
	loaded+=line;
}
br.close();

%>
	<form id="form" action="/Wildcat_Mk01/io/overwriteProc.jsp" method="post">

		<input type="hidden" name="idx" value="<%=idx%>">
		<input type="hidden" name="preTitle" value="<%=preTitle%>">
		
		<span style="font-weight: bold">계정</span><br>
		<input readonly type="text" id="name" name="id" value="<%=id%>"><br>
		
		<span style="font-weight: bold">타이틀</span><br>
		<input type="text" id="title" name="title" value="<%=title%>"><br>
		
		<span style="font-weight: bold">메모</span><br>
		<div contentEditable="true" id="input" style="width: 400px; height: 600px; border: 1px solid black; overflow: auto;"><%=loaded%></div>
		<input type="hidden" id="memo" name="memo">
		<input type="button" id="save" name="save" value="저장">
		
	</form>
</body>
</html>