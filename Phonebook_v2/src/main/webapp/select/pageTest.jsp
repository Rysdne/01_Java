<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%
// 페이지 번호 확인
// 전체 게시글 수, 페이지당 글의 수, 전체 페이지 수, 시작페이지, 끝 페이지
int totalCount = 0;
int countPerPage = 10;
int totalPage = 0;
int startPage = 0;
int endPage = 0;

//현재 글번호 = rownum 기준
int currentNum = 30;
System.out.println("현재 글번호 : "+currentNum);
//현재 글번호를 이용하여 현재 페이지를 구함
int currentPage = 1;

// 글번호가 10의 배수인 경우를 처리하는 조건식 생성
if (currentNum % countPerPage == 0) {
	currentPage = (currentNum / countPerPage);
} else {
	currentPage = (currentNum / countPerPage) + 1;
}
System.out.println("현재 페이지 번호 : "+ currentPage);


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
if((totalCount%countPerPage)==0)totalPage=(totalCount/countPerPage);
System.out.println("전체 페이지 수 : " + totalPage);

// 페이지 네비게이터를 표시하기 위해 아래가 필요함
// 표시할 시작페이지
startPage=currentPage;
// 전체 페이지가 표현하려는 페이지보다 작을 경우 1부터 모두 표시
if(totalPage<5)startPage=1;

// 표시할 끝페이지
endPage=startPage+4;
// 전체 페이지가 표현하려는 페이지보다 클 경우 전체 페이지 수까지 표시
if(endPage>totalPage) endPage=totalPage;

System.out.println("네비게이터 페이지 시작 번호 : "+ startPage);
System.out.println("네비게이터 페이지 끝 번호 : "+ endPage);


// 글의 범위
int startRow=(currentPage-1)*countPerPage+1;
int endRow=startRow+countPerPage-1;

System.out.println("글페이지 시작 범위 : "+startRow);
System.out.println("글페이지 끝 범위 : "+endRow);


%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>