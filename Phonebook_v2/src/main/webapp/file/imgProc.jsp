<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Enumeration" %>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%


// 경로를 properties에서 복사하여 붙여넣기
// \는 특수문자이므로, 각 \마다 \를 하나 더 붙임
String savePath="C:\\Users\\Rysdne\\Desktop\\Rysdne\\Document\\01_Java\\work\\Phonebook_v2\\src\\main\\webapp\\file\\uploadFolder";

// 파일 사이즈 : 10mb까지 가능
int fileSize=10*1024*1024;

MultipartRequest multi=new MultipartRequest(request,savePath,fileSize,"utf-8",new DefaultFileRenamePolicy());

// 변수형이 Enumeration
Enumeration files=multi.getFileNames();

// 이 함수로 파일이 업로드 됨
String file=(String)files.nextElement();
System.out.println(file);

// 중복될 경우 1이 증가하는 형태
// 서버에서 저장되는 파일명을 출력
String filename=multi.getFilesystemName(file);
System.out.println(filename);

// 실제 올린 사람의 파일명
String origfilename=multi.getOriginalFileName(file);
System.out.println(origfilename);

%>