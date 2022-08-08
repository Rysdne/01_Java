<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>
<%@page import="javax.naming.spi.DirStateFactory.Result"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<script src="/Wildcat_Mk01/jquery-3.6.0.min.js"></script>
<%
request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	$(document).ready(function() {
		$('tr').click(function() {
			var state = confirm("정말 삭제하시겠습니까");
			if(state){
				var idx = $(this).find("td").eq(0).text();
				var id = $(this).find("td").eq(1).text();
				var subFolderName = $(this).find("td").eq(2).text();
				location.href = "/Wildcat_Mk01/list/deleteProc.jsp?idx=" + idx + "&id=" + id + "&subFolderName=" + subFolderName;	
			};
		});
		
		$('#listMonth').click(function(){
			var i=0;
			var _month=$('#month').val();
			var mArray = _month.split("-");
			var selectMonth = mArray[0] + "-" + mArray[1];
			var idxMonth=mArray[0]+mArray[1];			
			var url="deleteMonth.jsp?selectMonth=" + selectMonth + "&idxMonth=" + idxMonth;
			location.href=url;
		});

	});
</script>
<style>
a {
	color: black;
	text-decoration: none;
}
#tBody:hover {
	color: white;
	background-color: gray;
}
.idxHidden>*:first-child {
	display: none;
}
</style>
</head>
<body>
	<%
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "rysdne", "3882");

	String selectMonth=request.getParameter("selectMonth");
	String idxMonth=request.getParameter("idxMonth");
	
	String sql = "select * from Wildcat_Mk01 where idx like ? order by idx desc";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, idxMonth + "%");
	ResultSet rs = pstmt.executeQuery();
	%>
	<div>
	<input type="month" id="month" name="month" value="<%=selectMonth%>">
	<input type="button" id="listMonth" value="검색">
	<button onclick="location.href='delete.jsp'">초기화</button>
	<button onclick='location.href="/Wildcat_Mk01/login/logout.jsp"'>로그아웃</button>
	</div>
	<table border="1">
		<tr class="idxHidden">
			<th>idx</th>
			<th>계정</th>
			<th>폴더</th>
			<th>타이틀</th>
			<th>생성일</th>
			<th>생성시간</th>
		</tr>
		<%
		while (rs.next()) {
		%>
		<tr id="tBody" class="idxHidden">
			<td><%=rs.getLong("idx")%></td>
			<td><%=rs.getString("id")%></td>
			<td><%=rs.getString("subfolder")%></td>
			<td><%=rs.getString("title")%></td>
			<td><%=rs.getString("cdate")%></td>
			<td><%=rs.getString("ctime")%></td>
		</tr>
		<%
		}
		
		pstmt.close();
		conn.close();
		
		%>
	</table>
	<button onclick="location.href='/Wildcat_Mk01/index.jsp'">메인 메뉴</button>
</body>
</html>