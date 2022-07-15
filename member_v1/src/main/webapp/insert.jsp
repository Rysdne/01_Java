<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- JSP에서 자바 SQL 문법을 사용하기 위해 자바 명령어 임포트 -->
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	Connection conn;
	PreparedStatement pstmt;

	// 입력값 받아오기
	String id = request.getParameter("id");
	String password = request.getParameter("password");

	// 드라이버 불러오기(ojdbc8.jar 파일을 lib 폴더에 복사)
	Class.forName("oracle.jdbc.driver.OracleDriver");

	// DB와의 커넥션 생성
	conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "test", "1111");

	// SQL문 생성
	String sql = "insert into member values(?,?)";

	// SQL문 보충 설명
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, id);
	pstmt.setString(2, password);

	// 기입한 내용을 바탕으로 데이터 입력
	int result = pstmt.executeUpdate();

	// 입력한 데이터 여부를 확인 후 결과값 출력
	if (result > 0) {
		response.sendRedirect("insertSuccess.jsp");
	} else {
		response.sendRedirect("insertFail.jsp");
	}
	
	pstmt.close();
	conn.close();
	
	%>


</body>
</html>