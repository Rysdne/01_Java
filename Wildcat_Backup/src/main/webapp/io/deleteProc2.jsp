<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="org.apache.tomcat.jni.Local"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- io포트 기능 포함 -->
<%@ page import="java.io.*"%>
<%@ page import="java.sql.*"%>
<%
request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	// =============================================================================

	// 1) idx
	String idx = request.getParameter("idx");
	// 2) 사용자 이름
	String id = request.getParameter("id");
	// 3) 타이틀
	// 3-1) 기존 타이틀
	String title = request.getParameter("title");
	// 4) 메모
	String memo = request.getParameter("memo");
	// 5) 파일 이름
	// parsing을 통해 검색은 idx로 하고 title은 보여줄 때 사용
	// 5-1) 기존 타이틀
	String fileName = idx + "_" + title;
	// 6) 파일 경로
	// 폴더를 만들어야 함
	// 폴더명 : 입력받은 id로 자동 설정
	// 경로 설정
	// 	// 일반적인 경로로 선택
	// 	String filePath = "C:/Users/Rysdne/Desktop/Rysdne/Document/00_Documents/" + id;
	// 프로젝트 내부에 저장
	String folderPath = application.getRealPath("/WEB-INF/" + id);
	// 저장 경로 : C:\Users\Rysdne\Desktop\Rysdne\Document\01_Java\work\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\Wildcat\WEB-INF
	String filePath = folderPath + "/" + fileName;
	
	// 이전 파일 존재 확인
	File file = new File(folderPath+"/"+fileName);
	// 파일 삭제
	if (file.exists()) {
		file.delete();
		System.out.println("파일 삭제됨");
	}

	// =============================================================================
	// 테이블 등록
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "rysdne", "3882");
	PreparedStatement pstmt;
	String sql;
	ResultSet rs;
	
	// 기존 목록 삭제
	sql = "delete from find where idx=?";
	pstmt=conn.prepareStatement(sql);
	pstmt.setString(1, idx);
	rs=pstmt.executeQuery();
	
	System.out.println("DB 삭제됨");
	
	pstmt.close();
	conn.close();
	
	// =============================================================================
	%>
	파일이 삭제되었습니다
	<br>
	<button onclick="location.href='/Wildcat_Mk01/index.jsp'">돌아가기</button>
</body>
</html>