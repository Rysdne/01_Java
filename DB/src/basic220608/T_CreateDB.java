package basic220608;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class T_CreateDB {

	Connection conn;
	Statement stat;
	String sql;
	ResultSet result;

	// 1. 생성자 함수 선언
	public T_CreateDB() throws ClassNotFoundException, SQLException {

		// 2. 드라이버 로드
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// 3. 오라클 연결
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
		// 4. 인터페이스 선언
		stat = conn.createStatement();

	}

	public void createTable() throws SQLException {
		sql = "create table member(id varchar2(10),pw varchar2(14))";
		result = stat.executeQuery(sql);
		
	}
}
