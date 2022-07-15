package basic220608;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDB {

	// table 생성 함수 생성
	// static : 메모리에 미리 올라가는 상태, 이탤릭 형태로 표시됨
	// ㄴ> 나중에 main 함수에서 부를 땐 CreateDB.함수(); 형태로 사용 가능
	public static void createTable() throws ClassNotFoundException, SQLException {

		// 1. 드라이버 로딩(ojdo)
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// 2. 오라클 접속
		// getConnection( URL, ID, PW )
		// url 부분이 기억나지 않으면 Database Connections 우클릭 > new 해서 확인해도 됨
		// ㄴ> 변경할 내용 : @localhost, xe
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");

		// 3. SQL 구문 사용
		// 1) 인터페이스 생성
		Statement stat = conn.createStatement();
		// 2) table 생성
		String sql = "create table member(id varchar2(14), password varchar2(10))";
		// 3) 실행
		ResultSet rs = stat.executeQuery(sql);
		// 4) 함수 닫기

		stat.close();
		conn.close();

	}

	// 2. table 삭제 함수 생성
	public static void dropTable() throws ClassNotFoundException, SQLException {
		// 1) 드라이버 로딩(ojdo)
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// 2) 오라클 접속
		// getConnection( URL, ID, PW )
		// url 부분이 기억나지 않으면 Database Connections 우클릭 > new 해서 확인해도 됨
		// ㄴ> 변경할 내용 : @localhost, xe
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");

		// 3) SQL 구문 사용
		// 3-1) 인터페이스 생성
		Statement stat = conn.createStatement();
		// 3-2) table 삭제
		String sql = "drop table member";
		// 3-3) 실행
		ResultSet rs = stat.executeQuery(sql);
		// 3-4) 함수 닫기
		stat.close();
		conn.close();

	}

}
