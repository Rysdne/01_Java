<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<main>
	<div class="container mt-3">
		<button type="button" class="btn btn-success" onclick="location.href='/index.jsp'">HOME</button>
		<h2>글쓰기</h2>
		<form action="/board/writeFormProc" method="post" enctype="multipart/form-data">
			<label for="idx">글번호 : </label>
			<input class="form-control" type="text" name="idx">
			<label for="writeName">작성자 : </label>
			<input class="form-control" type="text" name="writeName">
			${id}
			<label for="title">제목 : </label>
			<input class="form-control" type="text" name="title">
			<label for="content">내용 : </label>
			<input class="form-control" type="text" name="content">
			<label for="file">첨부파일 : </label>
			<input class="form-control" type="file" name="file">
		<button type="submit" class="btn btn-primary">글쓰기</button>
		<button type="button" class="btn btn-primary">취소</button>
		</form>
	</div>
</main>
