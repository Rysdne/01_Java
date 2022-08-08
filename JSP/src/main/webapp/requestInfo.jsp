<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
클라이언트 IP = <%=request.getRemoteAddr() %><br>
요청정보 길이 = <%=request.getContentLength() %><br>
요청정보 인코딩 = <%=request.getCharacterEncoding() %><br>
요청정보 컨텐트타입 = <%=request.getContentType() %><br>
요청정보 프로토콜 = <%=request.getProtocol() %><br>
요청정보 전송방식 = <%=request.getMethod() %><br>
요청 URI = <%=request.getRequestURI() %><br>
컨텍스트 경로 = <%=request.getContextPath() %><br>
서버 이름 = <%=request.getServerName() %><br>
서버 포트 = <%=request.getServerPort() %><br>

================================================<br>
<!-- 실제 저장 경로,  -->
하드웨어 경로(시스템 경로 : 실제 폴더 경로) = <%=request.getRealPath("/test") %><br>
<!-- 주소 접근할 때의 경로 -->
인터넷상 경로(메인 주소 : 최상위 경로) = <%=request.getContextPath() %><br>
인터넷상 경로(전체 주소 : 파일 이름까지) = <%=request.getRequestURI() %><br>

================================================
</body>
</html>