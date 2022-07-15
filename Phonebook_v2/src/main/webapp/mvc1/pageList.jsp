<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%@ page import="phonebook.vo.Phonebook"%>
<%
// --------------------- 필요한 변수 선언 ---------------------
//전체게시물 수, 페이지당 글의 수, 전체페이지수, 시작페이지, 끝페이지,글의 시작번호, 글의 끝번호
int totalCount = 0;
int countPerPage = 10;
int totalPage = 0;
int startPage = 0;
int endPage = 0;
int startRow = 0;
int endRow = 0;
int currentPage = 1;
//--------------------- DB 관련 변수 선언 ---------------------
Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
String sql = null;

//--------------------- 현재 페이지에 대해 request(페이지 받아오는 부분) ---------------------
//자신의 페이지를 호출하여 현재페이지를 다시 받음
if (request.getParameter("currentPage") != null)
	currentPage = Integer.parseInt(request.getParameter("currentPage"));

if (currentPage < 1)
	currentPage = 1;

System.out.println("현재페이지번호:" + currentPage);

//////////////데이터베이스 접속////////////////////////
Class.forName("oracle.jdbc.driver.OracleDriver");
conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "test", "1111");

//////////////글의 전체 갯수/////////////////
sql = "select count(*) from phonebook";
pstmt = conn.prepareStatement(sql);
rs = pstmt.executeQuery();
if (rs.next()) {
	//필드명을 이용하는 방법과 필드 순서를 이용하는 방법이 있음
	//totalCount=rs.getInt("count(*)");
	totalCount = rs.getInt(1);
	System.out.println("전체게시물수:" + totalCount);
}

//////////////전체페이지수/////////////////
totalPage = (totalCount / countPerPage) + 1;
//전체게시물수가 나머지 0이될 경우 페이지는 1페이지가 작아짐
if ((totalCount % countPerPage) == 0)
	totalPage = (totalCount / countPerPage);

System.out.println("전체페이지수:" + totalPage);

//////////////글의 시작범위 끝범위//////////////
//글의 범위
//현재페이지를 기준으로 계산
//예) 현재페이지:1page, 글의 범위 1(startRow)-10(endRow)
//예) 현재페이지:2page, 글의 범위 11(startRow)-20(endRow)
startRow = (currentPage - 1) * countPerPage + 1;
endRow = startRow + countPerPage - 1;
System.out.println("글페이지 시작 범위:" + startRow);
System.out.println("글페이지 끝 범위:" + endRow);

// --------------------- 글의 시작범위와 끝범위의 데이터를 가져오는 작업 ---------------------
sql = "select rownum,b.* from ";
sql += "(select rownum rn,a.* from ";
sql += "(select * from phonebook order by idx)a ";
sql += "where rownum <=? ";
sql += "order by rownum desc) b ";
//sql+="where rownum between 1 and 10 ";
sql += "where rownum between 1 and ? ";
sql += "order by b.rn asc";
pstmt = conn.prepareStatement(sql);
pstmt.setInt(1, endRow);
// --------------------- 마지막 페이지가 10개의 게시물이 아닌 경우 나머지 값을 활용하여 범위 확정 ---------------------
if (totalPage == currentPage) {
	pstmt.setInt(2, totalCount % 10);
} else {
	pstmt.setInt(2, 10);
}
rs = pstmt.executeQuery();

// --------------------- 문제 소지가 발생할 경우 ---------------------
// sql 구문에서 추출할 수 있는 데이터가 있을 경우 먼저 선언된 sql문의 데이터를 받아올 수 없음
// ㄴ> 해당 데이터를 별도의 변수로 담아놓으면 사용 가능 -> 배열 변수!
// -------------------------------------------------------------

List<Phonebook> list = new ArrayList();
while (rs.next()) {
	Phonebook pb = new Phonebook();
	pb.setIdx(rs.getInt("idx"));
	pb.setName(rs.getString("name"));
	pb.setHp(rs.getString("hp"));
	pb.setMemo(rs.getString("memo"));
	list.add(pb);
}

// 이후 아래에서 사용하는 while문을 for문이나 for each 문으로 바꿔줄 수 있음

//////////////네비게이트에 표시한 시작번호 끝번호/////////////////
//표시할 시작페이지와 끝페이지는 아래쪽 페이지를 표시하기 위한 네비게이트
//표시할 시작페이지
if (currentPage <= 5) {
	startPage = 1;
} else {
	if (currentPage % 5 == 0) {
		startPage = (currentPage / 5) * 5;
		// 10페이지일 때 문제 발생
	} else {
		startPage = (currentPage / 5) * 5 + 1;
	}

}
//전체페이지가 표현하려는 페이지보다 작을 경우 1부터 모두 표시
if (totalPage <= 5)
	startPage = 1;

//표시할 끝페이지
//endPage=5;
endPage = startPage + 4;
//전체페이지가 표현하려는 페이지보다 클 경우 전체페이지수까지 표시 
if (endPage > totalPage)
	endPage = totalPage;

System.out.println("네이비게이터 페이지 시작번호:" + startPage);
System.out.println("네이비게이터 페이지 끝번호:" + endPage);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전화번호 전체보기</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>

<script>
	$(document).ready(
			function() {
				$('tr').click(function() {
					var idx = $(this).find("td").eq(0).text();
					//alert(idx);
					if (idx != "") {
						location.href = "/select/findOne.jsp?idx=" + idx;
					}
				})

				$('.dropdown-item').click(function() {
					//alert('test');
					//#kind=버튼, $(this)=a태그
					$('#kind').html($(this).text());
				});

				$('#searchbtn').click(
						function() {
							//alert('test');

							var kind = $('#kind').text();
							var search = $('#search').val();
							//alert(kind+ " "+search);
							//alert(`${kind}`);
							//var url=`/select/searchList?kind=${kind}&search=${search}`;
							var url = "/select/searchList.jsp?kind=" + kind
									+ "&search=" + search;
							//alert(url);

							location.href = url;
						});

			});
</script>

<style>
thead tr:first-child {
	background-color: lightGray;
}

tr:hover {
	background-color: yellow;
	/* font-size:20px; font-weight: bold; */
}
</style>

</head>
<body>
	<div class="container mt-3">
		<h2>전화번호부</h2>
		<div class="input-group mt-3 mb-3">
			<button name="kind" id="kind" type="button"
				class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
				검색선택</button>
			<div class="dropdown-menu">
				<a class="dropdown-item" href="#">이름</a> <a class="dropdown-item"
					href="#">전화번호</a> <a class="dropdown-item" href="#">메모</a> <a
					class="dropdown-item" href="#">전체검색</a>
			</div>
			<input type="text" class="form-control" id="search" name="search">
			<input id="searchbtn" type="button" class="btn btn-info" value="검색">
		</div>

		<table class="table">
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
				// while문을 for 또는 for each 문으로 변경 가능

				for (Phonebook p : list) {
				%>
				<tr>
					<td><%=p.getIdx()%></td>
					<td><%=p.getName()%></a></td>
					<td><%=p.getHp()%></td>
					<td><%=p.getMemo()%></td>
				</tr>
				<%
				}
				%>


			</tbody>
		</table>

		<ul class="pagination">
			<%
			if (startPage > 1) {
			%>
			<li class="page-item"><a class="page-link"
				href="pageList.jsp?currentPage=<%=startPage - 5%>">이전</a></li>
			<%
			}
			%>
			<%
			for (int p = startPage; p <= endPage; p++) {
			%>
			<li class="page-item"><a class="page-link"
				href="pageList.jsp?currentPage=<%=p%>"><%=p%></a></li>
			<%
			}
			%>
			<%
			if (endPage < totalPage) {
			%>
			<li class="page-item"><a class="page-link"
				href="pageList.jsp?currentPage=<%=startPage + 5%>">다음</a></li>
			<%
			}
			%>
		</ul>


		<button type="button" class="btn btn-success"
			onclick="location.href='/insert/insert.jsp'">전화번호추가</button>
	</div>
</body>
</html>