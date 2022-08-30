<%@ page import="javax.naming.spi.DirStateFactory.Result"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="/wMemo/css/content/style.css" type="text/css"
	rel="stylesheet" />
<script>
	$(function() {
		$('tr').click(function() {
			var idx = $(this).find("td").eq(0).text();
			var id = $(this).find("td").eq(1).text();
			var subfolder = $(this).find("td").eq(2).text();
			var title = $(this).find("td").eq(3).text();
			location.href = "/wMemo/memo/findOne?idx=" + idx + "&id=" + id + "&subfolder=" + subfolder + "&title=" + title;
		});
	});
</script>
<table style="background-color:white;">
	<tr class="idxHidden" style="border:1px solid lightgray; background-color:rebeccapurple; color:white;">
		<th class="idxIdHidden">idx</th>
		<th class="idxIdHidden">계정</th>
		<th>폴더</th>
		<th>타이틀</th>
		<th>수정일</th>
		<th>수정시간</th>
	</tr>
	<c:forEach var="memo" items="${memoList}">
	<tr id="tBody" style="border:1px solid lightgray;">
		<td class="idxIdHidden"><c:out value="${memo.idx}"/></td>
		<td class="idxIdHidden"><c:out value="${memo.id}"/></td>
		<td><c:out value="${memo.subfolder}"/></td>
		<td><c:out value="${memo.title}"/></td>
		<td><c:out value="${memo.cdate}"/></td>
		<td><c:out value="${memo.ctime}"/></td>
	</tr>
	</c:forEach>
</table>