<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="org.apache.tomcat.jni.Local"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- io포트 기능 포함 -->
<%@ page import="java.io.*"%>
<%@ page import="java.sql.*"%>
<%
request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	// =============================================================================
	// 1) 현재 시간
	LocalDateTime _time = LocalDateTime.now();
	// 일련번호로 사용할 예정
	// 이런 일련번호가 있어야 title을 자유롭게 사용 가능
	// String idx = _time.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
	String cdate = _time.format(DateTimeFormatter.ofPattern("yyyy.MM.dd"));
	String ctime = _time.format(DateTimeFormatter.ofPattern("HH:mm:ss"));

	String idx = request.getParameter("idx");
	System.out.println(idx);

	// 2) 사용자 이름
	// 나중엔 이걸 아이디로 사용할 예정
	String id = request.getParameter("id");
	// 3) 타이틀
	// 3-1) 기존 타이틀
	String preTitle = request.getParameter("preTitle");
	// 3-2) 변경 타이틀
	String title = request.getParameter("title");
	// 4) 메모
	String memo = request.getParameter("memo");
	if (memo.equals(null))
		memo = "";
	// 5) 파일 이름
	// parsing을 통해 검색은 idx로 하고 title은 보여줄 때 사용
	// 5-1) 기존 타이틀
	String preFileName = idx + "_" + preTitle;
	// 5-2) 변경 타이틀
	String fileName = idx + "_" + title;
	// 6) 파일 경로
	// 폴더를 만들어야 함
	// 폴더명 : 입력받은 id로 자동 설정
	// 경로 설정
	// 	// 일반적인 경로로 선택
	// 	String filePath = "C:/Users/Rysdne/Desktop/Rysdne/Document/00_Documents/" + id;
	// 프로젝트 내부에 저장
	String folderPath = application.getRealPath("/WEB-INF/" + id);
	// 저장 경로 : C:\Users\Rysdne\Desktop\Rysdne\Document\01. Java\work\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\Wildcat_Mk01\WEB-INF
	String filePath = folderPath + "/" + fileName;

	// 폴더명 설정
	File folder = new File(folderPath);
	// 경로 폴더 확인
	if (!folder.exists()) {
		// 폴더 생성
		folder.mkdir();
		System.out.println("새 폴더 생성됨");
	}

	// 이전 파일 존재 확인
	File preFile = new File(folderPath + "/" + preFileName);

	System.out.println(preFile);
	// 파일 삭제
	if (preFile.exists()) {
		preFile.delete();
		System.out.println("기존 파일 삭제됨");
	}

	// 6) 파일 저장 위치
	// fos의 마지막에 false인 것은 파일을 새로 교체하기 위한 것
	// ㄴ> 사실 필요 없음, 기존 파일을 이미 지웠기 때문에 덮어쓰기든 뭐든 상관 없음 
	// FileOutputStream fos = new FileOutputStream(filePath, false);
	FileOutputStream fos = new FileOutputStream(filePath, false);
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos, "utf-8"));

	// 	// 7) 작성한 메모를 txt 파일로 저장
	bw.write(memo);

	System.out.println("새 파일 저장됨");

	bw.close();
	fos.close();

	// =============================================================================
	// 테이블 등록
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "rysdne", "3882");
	PreparedStatement pstmt;
	String sql;

// 	ResultSet rs;
// 	// 기존 목록 삭제
// 	sql = "delete from find where idx=?";
// 	pstmt = conn.prepareStatement(sql);
// 	pstmt.setString(1, idx);
// 	rs = pstmt.executeQuery();
// 	// table에 새로운 내용 저장
// 	sql = "insert into find values(?,?,?,?,?)";
// 	pstmt = conn.prepareStatement(sql);
// 	pstmt.setString(1, idx);
// 	pstmt.setString(2, id);
// 	pstmt.setString(3, title);
// 	pstmt.setString(4, cdate);
// 	pstmt.setString(5, ctime);
// 	rs = pstmt.executeQuery();

	// 굳이 이걸 삭제하고 만들어야하나 싶어서 수정으로 변경
	int rs;
	sql = "update find set title=?, cdate=?, ctime=? where idx=?";
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, title);
	pstmt.setString(2, cdate);
	pstmt.setString(3, ctime);
	pstmt.setString(4, idx);
	rs = pstmt.executeUpdate();

	System.out.println("DB 수정됨");

	pstmt.close();
	conn.close();

	// =============================================================================
	%>
	파일이 저장되었습니다
	<br>
	<button onclick="location.href='/Wildcat_Mk01/index.jsp'">돌아가기</button>
</body>
</html>