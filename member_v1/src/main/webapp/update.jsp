<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%=request.getParameter("id")%>
	<%=request.getParameter("password")%>

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
	String sql = "update member set password=? where id=?";

	// SQL문 보충 설명
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, password);
	pstmt.setString(2, id);

	// 기입한 내용을 바탕으로 데이터 입력
	int result = pstmt.executeUpdate();

	// 입력한 데이터 여부를 확인 후 결과값 출력
	if (result > 0) {
		response.sendRedirect("updateSuccess.jsp");
	} else {
		response.sendRedirect("updateFail.jsp");
	}
	

	pstmt.close();
	conn.close();
	
	%>



</body>
</html>