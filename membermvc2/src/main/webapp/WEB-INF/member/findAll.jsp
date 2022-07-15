<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<main>
	<!-- 전달받은 데이터 확인 : memberlist -->
	<div class="container">
		<h2>회원목록</h2>
		<p>전체 회원 목록</p>
		<table class="table table-dark table-striped">
			<thead>
				<tr>
					<th>번호</th>
					<th>아이디</th>
					<th>패스워드</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="member" items="${memberlist}">
					<tr onclick="location.href='/member/findOne?idx=${member.idx}'"}>
						<td>${member.idx}</td>
						<td>${member.id}</td>
						<td>${member.password}</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="3">
						<ul class="pagination">
						<c:if test="${2<11}">
							<li class="page-item"><a class="page-link" href="#">Previous</a></li>
							</c:if>
							<c:forEach var="pno" begin="1" end="10">
								<li class="page-item"><a class="page-link" href="#">${pno}</a></li>
							</c:forEach>
							<c:if test="${33!=33}">
							<li class="page-item"><a class="page-link" href="#">Next</a></li>
							</c:if>
						</ul>

					</td>
				</tr>

			</tbody>
		</table>
	</div>
	<div id="vfooter"></div>
</main>
