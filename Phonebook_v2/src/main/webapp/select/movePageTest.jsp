<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<%
	// 페이지 번호 확인
	// 전체 게시글 수, 페이지당 글의 수, 전체 페이지 수, 시작페이지, 끝 페이지
	int totalCount = 0;
	int countPerPage = 10;
	int totalPage = 0;
	int startPage = 0;
	int endPage = 0;

	// 	//현재 글번호 = rownum 기준
	// 	System.out.println("=========================");
	// 	int currentNum = 10;
	// 	System.out.println("현재 글번호 : " + currentNum);

	//현재 글번호를 이용하여 현재 페이지를 구함
	int currentPage = 1;
	if (request.getParameter("currentPage") != null)
		currentPage = Integer.parseInt(request.getParameter("currentPage"));

	// 	// 글번호가 10의 배수인 경우를 처리하는 조건식 생성
	// 	if (currentNum % countPerPage == 0) {
	// 		currentPage = (currentNum / countPerPage);
	// 	} else {
	// 		currentPage = (currentNum / countPerPage) + 1;
	// 	}
	// 	System.out.println("현재 페이지 번호 : " + currentPage);

	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "test", "1111");

	String sql = "select count(*) from phonebook";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	ResultSet rs = pstmt.executeQuery();

	if (rs.next()) {
		// 필드명을 이용하는 방법과 필드 순서를 이용하는 방법이 있음
		// totalCount=rs.getInt("count(*)");
		totalCount = rs.getInt(1);
		System.out.println("전체 게시물 수 : " + totalCount);

	}

	// 남은 게시물 수를 저장하기 위해 한 페이지를 더해줘야 함 
	// 전체 게시물 수의 나머지값이 0일 경우 페이지는 1페이지가 작아짐
	totalPage = (totalCount / countPerPage) + 1;
	if ((totalCount % countPerPage) == 0)
		totalPage = (totalCount / countPerPage);
	System.out.println("전체 페이지 수 : " + totalPage);

	// 페이지 네비게이터를 표시하기 위해 아래가 필요함
	// 표시할 시작페이지
	startPage = currentPage - 2;
	// 전체 페이지가 표현하려는 페이지보다 작을 경우 1부터 모두 표시
	if (totalPage < 5)
		startPage = 1;

	// 표시할 끝페이지
	endPage = currentPage + 2;
	// 전체 페이지가 표현하려는 페이지보다 클 경우 전체 페이지 수까지 표시
	if (endPage > totalPage)
		endPage = totalPage;

	if (totalPage >= 5 && currentPage < 3) {
		startPage = 1;
		endPage = 5;
	} else if (currentPage < 3) {
		startPage = 1;
	}
	if (totalPage >= 5 && currentPage > (endPage - 2)) {
		startPage = endPage - 4;
	}

		System.out.println("네비게이터 페이지 시작 번호 : " + startPage);
		System.out.println("네비게이터 페이지 끝 번호 : " + endPage);

		// 글의 범위
		int startRow = (currentPage - 1) * countPerPage + 1;
		int endRow = startRow + countPerPage - 1;

		System.out.println("글페이지 시작 범위 : " + startRow);
		System.out.println("글페이지 끝 범위 : " + endRow);

		System.out.println("=========================");

		sql = "	select b.* from	(select rownum arn,a.* from (select * from phonebook order by idx) a where rownum <= ? order by arn desc) b where arn >= ? order by arn asc";
		// 강의에서는 이 부분을 마지막 'where arn' 조건식을 between 1-10으로 설정해서 마지막 장에서 문제가 발생
		// 이 부분을 해결하기 위해서는 아래 * 참조
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, endRow);
		pstmt.setInt(2, startRow);
		rs = pstmt.executeQuery();

		// 	// *참조
		// 	// sql의 'where arn' 조건식을 between 1-10으로 설정했을 경우
		// 	// sql : select b.* from (select rownum arn,a.* from (select * from phonebook order by idx) a where rownum <= ? order by arn desc) b where arn >= ? order by arn asc
		// 	pstmt.setInt(1, endRow);
		// 	if(totalPage==currentPage){
		// 		pstmt.setInt(2,totalCount%10);
		// 	}else{
		// 		pstmt.setInt(2,10);
		// 	}
	%>
	<div class="container mt-3">
		<h2>전화번호부</h2>
		<div class="input-group mt-3 mb-3">
			<button type="button" name="kind" id="kind"
				class="btn btn-primary dropdown-toggle" data-toggle="dropdown">검색선택</button>
			<div class="dropdown-menu">
				<a class="dropdown-item" href="#">이름</a> <a class="dropdown-item"
					href="#">전화번호</a> <a class="dropdown-item" href="#">메모</a> <a
					class="dropdown-item" href="#">전체검색</a>
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
				%>
			</tbody>
		</table>

		<%
		String prevPageLocation = null;
		if (currentPage == 1) {
			prevPageLocation = "#";
		} else {
			prevPageLocation = "movePageTest.jsp?currentPage=" + (currentPage - 1);
		}
		String nextPageLocation = null;
		if (currentPage == endPage) {
			nextPageLocation = "#";
		} else {
			nextPageLocation = "movePageTest.jsp?currentPage=" + (currentPage + 1);
		}
		
		%>

		<ul class="pagination">
			<li class="page-item"><a class="page-link" href="movePageTest.jsp?currentPage=1">&lt&lt</a></li>
			<li class="page-item"><a class="page-link" href="<%=prevPageLocation%>">Prev</a></li>
			<%
			String highlight;
			for (int p = startPage; p <= endPage; p++) {
			if(currentPage==p){
				highlight="page-item active";
			}else{
				highlight="page-item";
			}
			%>
			<li class="<%=highlight%>"><a class="page-link"
				href="movePageTest.jsp?currentPage=<%=p%>"><%=p%></a></li>
			<%
			}
			%>
			<li class="page-item"><a class="page-link" href="<%=nextPageLocation%>">Next</a></li>
			<li class="page-item"><a class="page-link" href="movePageTest.jsp?currentPage=<%=totalPage%>">&gt&gt</a></li>
		</ul>
		<br>
</body>
</html>