<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id=findOneView>
	<button onclick="updateForm('${phonebook.idx}')">수정</button>
	<button onclick="deletePhonebook('${phonebook.idx}')">삭제</button>
	<div id="findResult">
		${phonebook.name} <br> ${phonebook.hp} <br>
		${phonebook.memo} <br>
	</div>
</div>

