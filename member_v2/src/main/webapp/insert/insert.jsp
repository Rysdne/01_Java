<%@ page import="javax.script.ScriptContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!-- 에러 페이지로 연결하기 위해 에러페이지 위치를 표시 -->
<!-- try catch문과는 같이 사용할 수 없음 -->
<!-- ㄴ> 이때 단순 선언만 하면 안되고 null로 값을 초기화해줘야 함 -->
<%@ page errorPage="/error/error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String id = null;
	String password = null;
	Connection conn = null;
	PreparedStatement pstmt = null;

	// 입력값 받아오기
	id = request.getParameter("id");
	password = request.getParameter("password");

	// 드라이버 불러오기(ojdbc8.jar 파일을 lib 폴더에 복사)
	Class.forName("oracle.jdbc.driver.OracleDriver");

	// DB와의 커넥션 생성
	conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "test", "1111");

	// SQL Developer에서 테이블을 백업하고 변경함
	// 시퀀스를 앞에 놓을 예정
	// create table backup as select idx,id,password from member;
	// drop table member;
	// alter table member_back rename to member;

	// SQL문 생성
	// SQL Developer 통해서 member_idx_seq 생성함
	// 시퀀스를 추가하였기 때문에 시퀀스를 시작하는 구문이 들어가야 함
	String sql = "insert into member values(member_idx_seq.nextval,?,?)";

	// SQL문 보충 설명
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, id);
	pstmt.setString(2, password);

	// 기입한 내용을 바탕으로 데이터 입력
	int result = pstmt.executeUpdate();

	// 입력한 데이터 여부를 확인 후 결과값 출력
	if (result > 0) {
		// response.sendRedirect("insertSuccess.jsp");
	%>
	<!-- 자바 스크립트 사용 -->
	<!-- 페이지로 이동하는 것이 아니라 전체 페이지 수가 줄어들음 -->
	<script>
		alert("회원 등록 완료");
		location.href = "/index.html";
	</script>
	<%
	} else {
	// response.sendRedirect("insertFail.jsp");
	%>
	<script>
		alert("회원 등록 실패");
		location.href = "insert.html";
	</script>

	<%
	}
	pstmt.close();
	conn.close();
	%>

</body>
</html>