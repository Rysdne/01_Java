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
	<%
	String id = request.getParameter("id");

	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "test", "1111");

	String sql = "select * from member where id=?";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, id);
	ResultSet ex = pstmt.executeQuery();
	if (ex.next()) {
		sql = "delete from member where id=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		int rs = pstmt.executeUpdate();
		response.sendRedirect("deleteSuccess.jsp");
	} else {
		response.sendRedirect("deleteFail.jsp");

	}
	

	pstmt.close();
	conn.close();
	
	%>


</body>
</html>