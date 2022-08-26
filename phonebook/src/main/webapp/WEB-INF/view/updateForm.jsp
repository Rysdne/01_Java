<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<button onclick="updateProc(${phonebook.idx})" style="background-color:slateblue; color:white; border:1px solid lightgray;">수정완료</button>
<button onclick="deletePhonebook('${phonebook.idx}')">삭제</button>
<div id="findOneView">
	이름 : <input id="updName" type="text" value="${phonebook.name}" placeholder="${phonebook.name}">
	<br>
	HP : <input id="updHp" type="text" value="${phonebook.hp}" placeholder="${phonebook.hp}">
	<br>
	메모 : <input id="updMemo" type="text" value="${phonebook.memo}" placeholder="${phonebook.memo}">
</div>

