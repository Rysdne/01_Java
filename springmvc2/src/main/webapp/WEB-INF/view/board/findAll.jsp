<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- pagelist라는 객체의 데이터만 표현(VIEW) -->    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전화번호 전체보기</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
  
  <script>
  
   $(document).ready( function() {
		$('tr').click(function(){
			var idx=$(this).find("td").eq(0).text();
			//alert(idx);
			if(idx!=""){
			location.href="/select/findOne.jsp?idx="+idx;
			}
		})
		
		$('.dropdown-item').click(function(){
			//alert('test');
			//#kind=버튼, $(this)=a태그
			$('#kind').html($(this).text());
		});
		
		$('#searchbtn').click(function(){
			//alert('test');
			
			var kind=$('#kind').text();
			var search=$('#search').val();
			//alert(kind+ " "+search);
			//alert(`${kind}`);
			//var url=`/select/searchList?kind=${kind}&search=${search}`;
			var url="/select/searchList.jsp?kind="+kind+"&search="+search;
			//alert(url);
			
			location.href=url;
			});
		
	});
	</script>
	
<style>
thead tr:first-child{background-color:lightGray;}
tr:hover{background-color:yellow;
		/* font-size:20px; font-weight: bold; */
		}
</style>

</head>
<body>
<main>
<div class="container mt-3">
<h2>전화번호부</h2>
 <div class="input-group mt-3 mb-3"> 
  <button name="kind" id="kind" type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
    검색선택
  </button>
  <div class="dropdown-menu">
    <a class="dropdown-item" href="#">이름</a>
    <a class="dropdown-item" href="#">전화번호</a>
    <a class="dropdown-item" href="#">메모</a>
    <a class="dropdown-item" href="#">전체검색</a>
  </div>
<input type="text" class="form-control" id="search" name="search">
<input id="searchbtn" type="button" class="btn btn-info" value="검색">
</div>

<table class="table">
<thead><tr><th>번호</th><th>이름</th><th>전화번호</th><th>메모</th></tr></thead>
<tbody>
<c:forEach var="pb" items="${pagelist.list}">
<tr>
<td>${pb.idx}</td>
<td>${pb.name}</a></td>
<td>${pb.hp}</td>
<td>${pb.memo}</td>
</tr>
</c:forEach>
</tbody>
</table>

<ul class="pagination">
   <c:if test="${pagelist.startPage>1}">	
  <li class="page-item"><a class="page-link" href="/findAll?currentPage=${pagelist.startPage-5}">이전</a></li>
  </c:if>
  <c:forEach var="pno" begin="${pagelist.startPage}" 
  end="${pagelist.endPage}" step="1">
  <li class="page-item"><a class="page-link" href="/findAll?currentPage=${pno}">${pno}</a></li>
  </c:forEach>
  <c:if test="${pagelist.endPage<pagelist.totalPage}">
  <li class="page-item"><a class="page-link" href="/findAll?currentPage=${pagelist.startPage+5}">다음</a></li>
  </c:if>
</ul>


<button type="button" class="btn btn-success" onclick="location.href='/insert/insert.jsp'">전화번호추가</button>
</div>
</main>
</body>
</html>