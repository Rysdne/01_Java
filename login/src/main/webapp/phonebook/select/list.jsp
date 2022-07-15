<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전화번호 전체보기</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		$('tr').click(function() {
			var idx=$(this).find("td").eq(0).text();
			// $(this) : a 태그
			if(idx!=""){
			location.href="findOne.jsp?idx="+idx;
			}
		});
		
		$('.dropdown-item').click(function(){
			// $(this) : a 태그
			$('#kind').html($(this).text());
		});
		
		$('#searchbtn').click(function(){
			var kind=$('#kind').text();
			var search=$('#search').val();
			// alert(kind+" "+search);
			var url="searchList.jsp?kind="+kind+"&search="+search;
			location.href=url;
			
		});
	});
</script>
<style>
	tbody>tr:hover {color: blue; text-decoration: underline;}
</style>

</head>
<body>
	<%
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "test", "1111");

	String sql = "select * from phonebook order by idx";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	ResultSet rs = pstmt.executeQuery();
	%>
	<div class="container mt-3">
		<h2>전화번호부</h2>
		<div class="input-group mt-3 mb-3"> 
			<button type="button" name="kind" id="kind" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">검색선택</button>
			<div class="dropdown-menu">
				<a class="dropdown-item" href="#">이름</a>
				<a class="dropdown-item" href="#">전화번호</a>
				<a class="dropdown-item" href="#">메모</a>
				<a class="dropdown-item" href="#">전체검색</a>
			</div>
			<input type="text" id="search" name="search" class="form-control">
			<input type="button" id="searchbtn" class="btn btn-info" value="검색">
		</div>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>번호</th>
					<th>이름</th>
					<th>전화번호</th>
					<th>메모</th>
				</tr>
			</thead>
			<tbody>
			<%
			while (rs.next()) {
			%>
			<tr>
				<td><%=rs.getInt("idx")%></td>
				<td><%=rs.getString("name")%></td>
				<td><%=rs.getString("hp")%></td>
				<td><%=rs.getString("memo")%></td>
			</tr>
			<%
			}
			pstmt.close();
			conn.close();
			%>
			</tbody>
		</table>
		<button type="button" class="btn btn-success" onclick="location.href='/phonebook/insert/insert.jsp'">전화번호부 추가</button>
		<button type="button" class="btn btn-secondary" onclick="location.href='/phonebook/delete/adminList.jsp'">선택 삭제</button>
	</div>

</body>
</html>