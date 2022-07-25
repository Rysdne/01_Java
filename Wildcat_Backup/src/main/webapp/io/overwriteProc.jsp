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
	// 2) 사용자 이름
	String id = request.getParameter("id");
	// 3) 폴더 이름
	String subFolderName = request.getParameter("subFolderName");
	// 4) 타이틀
	// 4-1) 기존 하위폴더
	// String preTitle = request.getParameter("preTitle");
	String preSubFolderName = request.getParameter("preSubFolderName");
	// 이제는 파일을 idx로만 관리하기 때문에 이게 필요 없음
	
	// 4-2) 변경 타이틀
	String title = request.getParameter("title");
	// 5) 메모
	String memo = request.getParameter("memo");
	if (memo.equals(null)) memo = "";
	// 6) 파일 이름
	// parsing을 통해 검색은 idx로 하고 title은 보여줄 때 사용
	// 6-1) 기존 타이틀
	// String preFileName = idx + "_" + preTitle;
	// 이제는 파일을 idx로만 사용하기 때문에 필요 없음
	// 6-2) 변경 타이틀
	String fileName = idx;
	// 7) 파일 경로
	// 폴더를 만들어야 함
	// 폴더명 : 입력받은 id로 자동 설정
	// 경로 설정
	// 	// 일반적인 경로로 선택
	// 	String filePath = "C:/Users/Rysdne/Desktop/Rysdne/Document/00_Documents/" + id;
	// 프로젝트 내부에 저장
	// 저장 경로 : C:\Users\Rysdne\Desktop\Rysdne\Document\01. Java\work\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\Wildcat_Mk01\WEB-INF
	String folderPath = application.getRealPath("/WEB-INF/" + id);
	String subFolderPath=folderPath + "/" + subFolderName;
	String preSubFolderPath=folderPath + "/" + preSubFolderName;
	String filePath = subFolderPath + "/" + fileName;
	
	// 기존 파일 삭제를 위한 경로 설정 
	String preFilePath = preSubFolderPath + "/" + fileName; 

	// 폴더명 설정
	File folder = new File(folderPath);
	// 경로 폴더 확인
	if (!folder.exists()) {
		// 폴더 생성
		folder.mkdir();
		System.out.println("계정 폴더 생성됨");
	}
	File subFolder=new File(subFolderPath);
	if(!subFolder.exists()){
		subFolder.mkdir();
		System.out.println("하위 폴더 생성");
	}
	

	// 이전 파일 존재 확인
	// 이젠 idx로만 파일을 확인하기 때문에 그냥 덮어쓰면 됨
	File preFile = new File(preFilePath);
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

	System.out.println("파일 수정됨");
	System.out.println(filePath);

	bw.close();
	fos.close();
	// =============================================================================
	// 테이블 수정
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "rysdne", "3882");
	PreparedStatement pstmt;
	
	String sql = "update Wildcat_Mk01 set subfolder=?, title=?, cdate=?, ctime=? where idx=?";
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, subFolderName);
	pstmt.setString(2, title);
	pstmt.setString(3, cdate);
	pstmt.setString(4, ctime);
	pstmt.setString(5, idx);
	int rs = pstmt.executeUpdate();

	System.out.println("DB 수정됨");

	pstmt.close();
	conn.close();

	// =============================================================================
	%>
	메모가 수정되었습니다
	<br>
	<button onclick="location.href='/Wildcat_Mk01/index.jsp'">돌아가기</button>
</body>
</html>