package basic220607;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// ===================================================

// # 오라클 DB 접속 여부 확인용
public class OracleDBConnection {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// @ 오라클 DB에 접속하기 위해서는 라이브러리 필요
		// 1) 경로 : C:\app\Rysdne\product\21c\dbhomeXE\jdbc\lib
		// 2) Jar 파일 등록(라이브러리 등록)
		// - Project 우클릭 > Build Path > Config Buildpath > libraries > Classpath > Add
		// JARs > DB(프로젝트) > lib > ojdbc8.jar
		// - Referenced Libraries 등록되었는지 확인

		// @ 접속하기 위해 필요한 내용이 무엇인지 확인
		// url 주소, 사용자id, 패스워드
		// url 주소 : jdbc:oracle:thin:@localhost:1521:xe
		// 사용자id : system / password : 1234
		// ...............................................

//		// 1. 드라이버 로딩
//		// ojdo로 외우기
//		Class.forName("oracle.jdbc.driver.OracleDriver");
//		// ...............................................
//
//		// 2. 오라클 접속 작업
//		// 의존관계 설정
//		// getConnection( URL, ID, PW )
//		// (중요!!)
		// static 함수에 있기 때문에 객체화 없이 사용 가능
//		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
//		// 접속 완료
//		// ...............................................
//
//		// 3. 설정 확인
//		// Connection 함수의 경우 오류가 날 때 null 값을 부여받음
//		if (conn == null) {
//			System.out.println("URL, ID, 패스워드를 확인하세요");
//		} else {
//			System.out.println(conn);
//		}
//		// ...............................................
//
//		// 4. sql 구문 사용법
//
//		// 1) table 생성
//		String sql = "create table member(id varchar2(14),password varchar2(10))";
//		// 중간에 엔터 치면 내용 변경 없이 자동으로 줄이 나눠짐
//
//		// *참조 명령어
//		// create table member(id varchar2(14),password varchar2(10))
//		// desc member;
//		// select * from member;
//		// insert into member values('test','1234');
//		// drop table member;
//
//		// 1-1) 문장을 넣을 수 있는 객체가 필요 (but 이미 등록되어있기 때문에 new를 할 필요가 없음(?))
//		// ㄴ> statement 인터페이스 불러오기(statement -java.sql)
//		// createStatement() : 스테이트먼트 객체를 반환, 추상객체
//		Statement stat = conn.createStatement();
//
//		// 1-2) 실행
//		// execute(sql) : 실행, boolean형
//		// 문장을 실행하기 위한 함수
//		boolean result = stat.execute(sql);
//		// 에러 : 기존의 객체가 이름을 사용하고 있습니다
//		// ??? sqlplus에서 drop한 뒤에 해보니 되던데??
//
//		// 위의 대체재
//		// ResultSet result=stat.executeQuery(sql);
//		// 되긴 함
//
//		System.out.println(sql);
//
//		// 원래는 커밋이 있어야 하지만 자동 커밋이 설정되어있어 필요 없음
//		// conn.commit();
//		stat.close();
//		conn.close();
//		// ...............................................
//
////		// 2) table 삭제
////		String sql="drop table member";
////		Statement stat=conn.createStatement();
////		ResultSet result=stat.executeQuery(sql);
////		// conn.commit();
////		stat.close();
////		conn.close();
////		// ...............................................

		// 10. 정리
		// 중복된 것을 밖으로 빼서 문장이 길어지는 걸 방지
		String sql = "create table member(id varchar2(14),password varchar2(10))";
		// String
		Boolean result = sqlcommand(sql);

		if (result) {
			// 이렇게만 넣어도 참일 경우 if문 실행, 거짓일 경우 else 문 실행
			System.out.println("DB 수행 성공");
		} else {
			System.out.println("DB 수행 실패");
		}
	}

	// main 함수랑 같이 있기 때문에 static 함수로 정의해야 함, 아닐 경우 static 빼야 함
	// 내일부터는 나눠서 해야 함
	public static Boolean sqlcommand(String sql) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
		Statement stat = conn.createStatement();
		ResultSet result = stat.executeQuery(sql);
		stat.close();
		conn.close();
		if (result == null) {
			return false;
		} else {
			return true;
		}
	}

	// ===================================================
}
