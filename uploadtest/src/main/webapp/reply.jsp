<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%
request.setCharacterEncoding("utf-8");

System.out.println(request.getParameter("reply"));
System.out.println(request.getParameter("idx"));

Class.forName("oracle.jdbc.driver.OracleDriver");

Connection conn
=DriverManager.getConnection
("jdbc:oracle:thin:@localhost:1521:xe", "test","1111");
System.out.println(conn);

String sql="insert into reply values(reply_idx_seq.nextval,?,?)";
PreparedStatement pstmt=conn.prepareStatement(sql);
pstmt.setString(1, request.getParameter("reply"));
pstmt.setInt(2, Integer.parseInt(request.getParameter("idx")));
int rs=pstmt.executeUpdate();

%>
메모가 입력되었습니다.
