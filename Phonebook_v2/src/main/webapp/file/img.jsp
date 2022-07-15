<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
img {
	width: 50px;
	height: 50px;
	border-radius: 25px;
	/* 브라우저마다 적용하는 법 */
	-moz-border-radius: 25px;
	-khtml-border-radius: 25px;
	-webkit-border-radius: 25px;
}
</style>
</head>
<body>
	<img src="/file/uploadFolder/tkfr1.png">
	<%
	String path = "C:\\Users\\Rysdne\\Desktop\\Rysdne\\Document\\01_Java\\work\\Phonebook_v2\\src\\main\\webapp\\file\\uploadFolder";
	File dir = new File(path);
	File files[] = dir.listFiles();

	// Q1) 파일별로 확장자만 출력하는 코드를 작성하시오

	// 파일의 이름을 출력하는 명령

	for (File f : files) {
		// out.println(f.getName());
		String getName = f.getName();
		String form = getName.substring(getName.lastIndexOf(".") + 1);
		System.out.println(form);
		if (form.equals("png")) {
			out.println("돼");
			// 		String savePath="C:\\Users\\Rysdne\\Desktop\\Rysdne\\Document\\01_Java\\work\\Phonebook_v2\\src\\main\\webapp\\file\\uploadFolder";
			// 		// 파일 사이즈 : 10mb까지 가능
			// 		int fileSize=10*1024*1024;
			// 		MultipartRequest multi=new MultipartRequest(request,savePath,fileSize,"utf-8",new DefaultFileRenamePolicy());
			// 		// 변수형이 Enumeration
			// 		Enumeration filess=multi.getFileNames();
			// 		// 이 함수로 파일이 업로드 됨
			// 		String file=(String)filess.nextElement();
			// 		System.out.println(file);

		} else {
			out.println("안돼");
		}
	}
	%>
</body>
</html>