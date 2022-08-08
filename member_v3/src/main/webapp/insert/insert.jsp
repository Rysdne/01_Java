<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String savePath = "C:\\Users\\Rysdne\\Desktop\\Rysdne\\Document\\01_Java\\work\\member_v3\\src\\main\\webapp\\insert\\uploadFolder";
int fileSize = 10 * 1024 * 1024;
MultipartRequest multi = new MultipartRequest(request, savePath, fileSize, "utf-8", new DefaultFileRenamePolicy());

// type file을 제외하고 넘겨받는 파라미터 리스트
Enumeration params = multi.getParameterNames();

while(params.hasMoreElements()){
	String name=(String)params.nextElement();
	String value=multi.getParameter(name);
	//* name은 params에서 가져오지만 value는 multi에서 참조
	out.print("전달파라미터 이름 : "+name+"<br>");
	out.print("전달파라미터 값 : "+value+"<br>");
	out.print("----------------------------<br>");
}


//type file을 제외하고 넘겨받는 파일 리스트
Enumeration files = multi.getFileNames();
while(files.hasMoreElements()){
	// 파일의 이름을 nextElement() 함수로 가져돈 뒤 multi에서 이름을 참조하여 시스템에 저장된 파일명과 전달된 파일명을 로드
	String file=(String)files.nextElement();
	// 호출하는 것으로 파일이 자동 저장됨
	
	String saveFileName=multi.getFilesystemName(file);
	String realFileName=multi.getOriginalFileName(file);
	out.print("전달파라미터 파일 이름 : "+saveFileName+"<br>");
	out.print("서버 시스템에 저장되는 파일 명 : "+realFileName+"<br>");
	out.print("----------------------------<br>");

	// Q1) DB를 구성
	// DB의 필드 중 저장되는 파일명에 관한 필드 존재
	// 추가적으로 경로까지 포함할지 여부 결정
	
	// Q2) 멤버상세보기에서 사진을 포함한 정보보기를 추가할 것인지
	
}



%>