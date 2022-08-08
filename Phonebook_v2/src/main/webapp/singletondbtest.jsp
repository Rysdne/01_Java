<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="db.SingletonDB" %>

<%
PreparedStatement pstmt = SingletonDB.getConnection().prepareStatement("select * from phonebook where idx=1");
ResultSet rs=pstmt.executeQuery();
if(rs.next()){
	out.println(rs.getInt(1));
	out.println(rs.getString(2));
	out.println(rs.getString(3));
	out.println(rs.getString(4));
}

%>