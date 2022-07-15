<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="db.Mydbdatasource"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.PreparedStatement"%>
<%
Mydbdatasource db = new Mydbdatasource();
// out.print(db.getConn());


PreparedStatement pstmt=db.getConn().prepareStatement("select * from phonebook where idx=1");
ResultSet rs=pstmt.executeQuery();

if(rs.next()){
	out.println(rs.getInt(1));
	out.println(rs.getString(2));
	out.println(rs.getString(3));
	out.println(rs.getString(4));
}

%>