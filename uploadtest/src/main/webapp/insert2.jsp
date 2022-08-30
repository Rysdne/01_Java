<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>

<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%
//주의사항:폴더경로를 복사하고 \는 특수문자이므로 \를 하나 더 추가해야함.
String savePath="C:\\hrdkorea\\test\\src\\main\\webapp\\file";
int fileSize=10*1024*1024;
MultipartRequest multi
=new MultipartRequest
(request,savePath,fileSize,"utf-8",new DefaultFileRenamePolicy());
/*
-------------------------------------------
multipartRequest는 전달된 데이터(text)와 file로 구분
---------------------------------------------
*/

/*
-------------------------------------------
전달된 데이터 처리
-------------------------------------------
*/
Enumeration params = multi.getParameterNames();
//여러개의 input상자가 Enumeration에 저장되어있음
while(params.hasMoreElements()){
	String name=(String)params.nextElement();
	String value=multi.getParameter(name);
	//* name은 params에서 가져오지만 value는 multi에서 참조
	out.print("전달파레미터 이름:"+name+"<br>");
	out.print("전달파레미터 값:"+value+"<br>");
	out.print("----------------------------<br>");
	
}

/*
--------------------------------------------
file관련 파일명 및 데이터처리
--------------------------------------------
*/

//type이 file인 내용을 넘겨받는 파일 리스트
Enumeration files=multi.getFileNames();
//여러개의 input file상자가 Enumeration에 저장되어있음
while(files.hasMoreElements()){
	//파일의 이름을 nextElement()함수로 가져와
	//multi에서 이름을 참조하여 
	//시스템에 저장된 파일명과 전달된 파일명을 찾음
	String file=(String)files.nextElement();
	String savefilename=multi.getFilesystemName(file);
	String realfilename=multi.getOriginalFileName(file);
	out.print("전달파레미터 파일이름:"+file+"<br>");
	out.print("서버시스템에 저장되는 파일명:"+savefilename+"<br>");
	out.print("실제파일명:"+realfilename+"<br>");
	out.print("----------------------------<br>");
	
}


-------------------------------------------
Enumeration files=multi.getFileNames();
//아래 함수만으로 파일이 업로드 됨
String file=(String)files.nextElement();
System.out.println(file);

//중복될 경우 1이 증가하는 형태가 되므로
//서버에서 저장되는 파일명을 출력
String filename = multi.getFilesystemName(file);
System.out.println(filename);

//실제올린사람의 파일명
String origfilename = multi.getOriginalFileName(file);
System.out.println(origfilename);

 %>
 
<%
//Class.forName("oracle.jdbc.OracleDriver");
Class.forName("oracle.jdbc.driver.OracleDriver");

Connection conn
=DriverManager.getConnection
("jdbc:oracle:thin:@localhost:1521:xe", "test","1111");
System.out.println(conn);

String sql="insert into book(idx,author,title,content,price,bookimg,regdate)values(book_seq_idx.NEXTVAL,?,?,?,?,?,?)";

PreparedStatement pstmt
=conn.prepareStatement(sql);

pstmt.setString(1, request.getParameter("author"));
System.out.println(request.getParameter("author"));

pstmt.setString(2, request.getParameter("title"));
System.out.println(request.getParameter("title"));

pstmt.setString(3, request.getParameter("content"));
System.out.println(request.getParameter("content"));

pstmt.setInt(4,Integer.parseInt(request.getParameter("price")));
System.out.println(request.getParameter("price"));

pstmt.setString(5, request.getParameter("bookimg"));
System.out.println(request.getParameter("bookimg"));

System.out.println(request.getParameter("regdate"));
SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
java.util.Date dt=df.parse(request.getParameter("regdate"));
long t=dt.getTime();
System.out.println("t:"+t);
System.out.println("sql time:"+new java.sql.Date(t));
System.out.println("dt:"+dt);
pstmt.setDate(6, new java.sql.Date(t));


int result=pstmt.executeUpdate();
if(result>0){
%>
<script>
	alert("데이터베이스 입력이 성공하였습니다.");
</script>
<%	
}
%>

