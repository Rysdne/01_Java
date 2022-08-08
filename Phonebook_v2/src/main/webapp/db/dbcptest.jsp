<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="db.SingletonDB"%>
<%@page import="db.Mydbdatasource"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 	
Connection conn=null;
PreparedStatement pstmt=null;
ResultSet rs=null;
	try{
	//pool.jocl파일위치 java파일이 위치한 메인위치에 둘것
	conn
	=DriverManager.getConnection("jdbc:apache:commons:dbcp:/pool");
	System.out.println("conn:"+conn);
	
	pstmt=
	conn.prepareStatement
	("select * from phonebook where idx=3");
	System.out.println("pstmt:"+pstmt);
	
	rs=pstmt.executeQuery();
	System.out.println("rs:"+rs);
	
	if(rs.next()){
		out.println(rs.getInt(1));
		out.println(rs.getString(2));
		out.println(rs.getString(3));
		out.println(rs.getString(4));
	}
	
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		rs.close();
		pstmt.close();
		conn.close();
	}
	
%>	