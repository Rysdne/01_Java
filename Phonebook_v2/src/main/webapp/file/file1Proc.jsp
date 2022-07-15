<%@page import="java.io.InputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
// String message=request.getParameter("message");
// String file1=request.getParameter("file1");
// String file2=request.getParameter("file2");
// out.println(message);
// out.println(file1);
// out.println(file2);

// out.println(request.getContentType());

InputStream is=request.getInputStream();

int data=-1;
// 데이터가 없으면 data=-1;


// is.read() : 데이터를 읽음
// 숫자형이기 때문에 문자로 강제 형변환 
while((data=is.read())!=-1){
	out.print((char)data);
}

is.close();


%>
</body>
</html>