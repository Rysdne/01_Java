<%@ page import="java.time.format.DateTimeFormatter"%>
<%@ page import="java.time.LocalDate"%>
<%@ page import="javax.naming.spi.DirStateFactory.Result"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="/wMemo/css/content/style.css" type="text/css"
	rel="stylesheet" />
<script>
	$(function() {
		var uId = $('#optionId').val();
		// var now = new Date();
		// var splitYear = now.getFullYear();
		// var splitMonth = ("0" + (now.getMonth() + 1)).slice(-2);
		// var currentMonth = splitYear + "-" + splitMonth;
		// $('#month').val(currentMonth);
		$('#listMonth').click(function() {
			// var i = 0;
			var _month = $('#month').val();
			var mArray = _month.split("-");
			// var selectMonth = mArray[0] + "-" + mArray[1];
			var idxMonth = mArray[0] + mArray[1];
			$.ajax({
				url : "/wMemo/list/listMonth",
				type : "post",
				dataType : "text",
				data : {"id":uId, "idxMonth":idxMonth},
				success : function(result) {
					$('#aside_box').html(result);
				}
			});
			// var url = "listMonth.jsp?selectMonth=" + selectMonth + "&idxMonth=" + idxMonth;
			// location.href = url;
		});
		$('#listClear').click(function() {
			$.ajax({
				url : "/wMemo/list/listOption",
				success : function(result) {
					$('#aside_option').html(result);
				}
			});
			$.ajax({
				url : "/wMemo/list/listAll",
				type : "post",
				dataType : "text",
				data : {"id":uId},
				success : function(result) {
					$('#aside_box').html(result);
				}
			});
		});
	});
</script>
<input type="hidden" id="optionId" name="optionId" value="${sessionScope.id}">
<input type="month" id="month" name="month">
<button id="listMonth">검색</button>
<button id="listClear">초기화</button>