package basic220608;

import java.sql.SQLException;

public class DBMain2 {

// ===================================================

	// 함수 사용 클래스 생성
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// ...............................................

		// 1. 객체화 선언 (함수에 static이 선언되지 않은 경우)
		// static : 메모리에 미리 올라가는 상태, 이탤릭 형태로 표시됨
		// ㄴ> 나중에 main 함수에서 부를 땐 CreateDB.함수(); 형태로 사용 가능

		// 1) 객체화
		CreateDB2 db = new CreateDB2();
		// CreateDB 내 함수 createTable, dropTable이 static형이면 객체화하지 않아도 됨

		// 2-1) 테이블 생성 함수 사용
		db.createTable();

		// 2-2) 테이블 제거 함수 사용
		// db.dropTable();
		// ...............................................

//		// 2. static 선언 (함수에 static이 선언된 경우)
//		// CreateDB2의 경우 static 함수가 아니기 때문에 이걸 사용할 수 없음
//
//		// 1) 객체화 (x)
//
//		// 2-1) 테이블 생성 함수 사용
//		CreateDB2.createTable();
//
//		// 2-2) 테이블 제거 함수 사용
//		CreateDB2.dropTable();
//
//		// * 함수에 close를 하지 않는 이유
//		// ㄴ> 생성된 변수의 Connection, Statement 객체가 null값이 됨
//		// 다음에 사용하는 함수에서 사용할 수 없게 됨
//
//		// ===================================================

	}

}
