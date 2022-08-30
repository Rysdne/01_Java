<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="/wMemo/css/content/style.css" type="text/css" rel="stylesheet" />
<script>
	$(function() {
		
		
		
		
// 		var uId = $('#optionId').val();
// 		$('#listMonth').click(function() {
// 			var _month = $('#month').val();
// 			alert(_month);
// 			var mArray = _month.split("-");
// 			var idxMonth = mArray[0] + mArray[1];
// 			$.ajax({
// 				url : "/wMemo/list/listMonth",
// 				type : "post",
// 				dataType : "text",
// 				data : {"id":uId, "idxMonth":idxMonth},
// 				success : function(result) {
// 					$('#aside_box').html(result);
// 				}
// 			});
// 		});
// 		$('#listClear').click(function() {
// 			$.ajax({
// 				url : "/wMemo/list/listOption",
// 				success : function(result) {
// 					$('#aside_option').html(result);
// 				}
// 			});
// 			$.ajax({
// 				url : "/wMemo/list/listAll",
// 				type : "post",
// 				dataType : "text",
// 				data : {"id":uId},
// 				success : function(result) {
// 					$('#aside_box').html(result);
// 				}
// 			});
// 		});
	});
</script>

<select id="speech">
<option value="ko">한글</option>
<option value="en">English</option>
</select>
>>
<select id="text">
<option value="ko">한글</option>
<option value="en">English</option>
</select>

<button id="listMonth">검색</button>
<button id="listClear">초기화</button>
